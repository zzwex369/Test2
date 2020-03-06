<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.*"%>

<%@ include file = "../GenDataBase.jsp" %>
<%!//方法简要说明
	//1. XML_GenMultiRecordset：产生多个记录集的XML数据
	//2. XML_GenOneRecordset：产生一个记录集的XML数据

	public static void XML_GenMultiRecordset(HttpServletResponse response,ArrayList<ReportQueryItem> QueryItems, ResponseDataType DataType) {
		try {
			Class.forName(jdbc_param.driver); // Class.forName 装载驱动程序 
			Connection con = DriverManager.getConnection(jdbc_param.url,
					jdbc_param.user, jdbc_param.password); //用适当的驱动程序类与 DBMS 建立一个连接
			Statement stmt = con.createStatement(); //用于发送简单的SQL语句

			StringBuffer XmlText = new StringBuffer("<xml>\n");
			for (ReportQueryItem QueryItem : QueryItems) {
				DoGenOneRecordsetText(XmlText, QueryItem.QuerySQL,
						QueryItem.RecordsetName, stmt);
			}
			XmlText.append("</xml>\n");

			stmt.close();
			con.close();

			ResponseText(response, XmlText.toString(), DataType);
		} catch (Exception e) {
			try {
				//output error message
				PrintWriter pw = response.getWriter();
				pw.print(e.toString());
			} catch (Exception e2) {
			}
		}
	}

	public static void XML_GenMultiRecordset(HttpServletResponse response,ArrayList<ReportQueryItem> QueryItems) {
		XML_GenMultiRecordset(response, QueryItems, DefaultReportDataType);
	}

	public static void XML_GenOneRecordset(HttpServletResponse response,String QuerySQL, ResponseDataType DataType) {
		try {
			Class.forName(jdbc_param.driver); // Class.forName 装载驱动程序 
			Connection con = DriverManager.getConnection(jdbc_param.url,
					jdbc_param.user, jdbc_param.password); //用适当的驱动程序类与 DBMS 建立一个连接
			Statement stmt = con.createStatement(); //用于发送简单的SQL语句

			//System.out.println(QuerySQL+"===========1==============");
			StringBuffer XmlText = new StringBuffer("<xml>\n");
			DoGenOneRecordsetText(XmlText, QuerySQL, "row", stmt);
			XmlText.append("</xml>\n");
			stmt.close();
			con.close();

			ResponseText(response, XmlText.toString(), DataType);
		} catch (Exception e) {
			try {
				//output error message
				PrintWriter pw = response.getWriter();
				pw.print(e.toString());
			} catch (Exception e2) {
			}
		}
	}

	public static void XML_GenOneRecordset(HttpServletResponse response,String QuerySQL) {
		XML_GenOneRecordset(response, QuerySQL, DefaultReportDataType);
	}

	private static void DoGenOneRecordsetText(StringBuffer XmlText,String QuerySQL, String RecordsetName, Statement stmt) {
		try {
			ResultSet rs = stmt.executeQuery(QuerySQL);
			ResultSetMetaData rsmd = rs.getMetaData();
			int ColCount = rsmd.getColumnCount();
			String year = null;
			String month = null;
			String day = null;
			while (rs.next()) {
				//XmlText.append("<row>");
				XmlText.append('<');
				XmlText.append(RecordsetName);
				XmlText.append('>');
				//System.out.println("<" + RecordsetName + ">");//注释.....
				for (int i = 1; i <= ColCount; i++) {
										
					if(rsmd.getColumnType(i)==93){
						
						formatDate(XmlText,rs,rsmd.getColumnLabel(i),i);					
					}else if (rsmd.getColumnLabel(i).equals("F601_22")){ 
						validateOne(XmlText, rs, "F601_22", i);//异常妊娠史
					}else if (rsmd.getColumnLabel(i).equals("F601_53")){ 
						validateMore(XmlText, rs, "F601_53", i);//异常妊娠史
					}else if (rsmd.getColumnLabel(i).equals("F601_54")){ 
						validateMore(XmlText, rs, "F601_54", i);//异常妊娠史
					}else {
						recycle(XmlText, rsmd, rs, i);
					}
				}
				//XmlText.append("</row>\n");
				XmlText.append("</");
				XmlText.append(RecordsetName);
				XmlText.append(">\n");
			}
			rs.close();
			//stmt.close();
		} catch (Exception e) {
		}
	}

	//装配XML
	private static void recycle(StringBuffer XmlText, ResultSetMetaData rsmd,ResultSet rs, int i) {
		try {
			XmlText.append('<');
			XmlText.append(rsmd.getColumnLabel(i)); //getColumnName
			XmlText.append('>');
			//System.out.print("<" + rsmd.getColumnLabel(i) + ">");//注释.....

			int ColType = rsmd.getColumnType(i);
			if (ColType == Types.LONGVARBINARY || ColType == Types.VARBINARY
					|| ColType == Types.BINARY || ColType == Types.BLOB) {
				byte[] BinData = rs.getBytes(i);
				if (!rs.wasNull())
					XmlText.append((new sun.misc.BASE64Encoder()).encode(BinData));
			} else {
				String Val = rs.getString(i);
				if (!rs.wasNull()) {
					if (HasSpecialChar(Val)) {
						XmlText.append(HTMLEncode(Val));
						//System.out.print(HTMLEncode(Val) + " ");//注释.....
					} else {
						XmlText.append(Val);
						//System.out.print(Val + " ");//注释.....
					}
				}
			}
			XmlText.append("</");
			XmlText.append(rsmd.getColumnLabel(i)); //getColumnName
			XmlText.append('>');
			//System.out.println("</" + rsmd.getColumnLabel(i) + ">");//注释.....
			///System.out.print(XmlText + " ");//注释.....

		} catch (Exception e) {

		}

	}
	
	

	//判断是哪个字段，是单选的情况
	private static void validateOne(StringBuffer XmlText, ResultSet rs,String F601_22, int i) {
		try {
			String Val = rs.getString(i);
			String[] f60122 = Val.split(",");
			for (int j = 0; j < f60122.length; j++) {
				if (f60122[j].equals("1")) {
					XmlText.append("<" + F601_22 + "_1>√</" + F601_22 + "_1>");
				} else if (f60122[j].equals("2")) {
					XmlText.append("<" + F601_22 + "_2>√</" + F601_22 + "_2>");
				} else if (f60122[j].equals("3")) {
					XmlText.append("<" + F601_22 + "_3>√</" + F601_22 + "_3>");
				} else if (f60122[j].equals("4")) {
					XmlText.append("<" + F601_22 + "_4>√</" + F601_22 + "_4>");
				} else if (f60122[j].equals("5")) {
					XmlText.append("<" + F601_22 + "_5>√</" + F601_22 + "_5>");
				} else if (f60122[j].equals("6")) {
					XmlText.append("<" + F601_22 + "_6>√</" + F601_22 + "_6>");
				} else if (f60122[j].equals("7")) {
					XmlText.append("<" + F601_22 + "_7>√</" + F601_22 + "_7>");
				}else if (f60122[j].equals("9")) {
					XmlText.append("<" + F601_22 + "_8>√</" + F601_22 + "_8>");
				}
			}
		
		} catch (Exception e) {

		}

	}

	// 转换Date
	private static void formatDate(StringBuffer XmlText, ResultSet rs,String colName, int i) {
	
		try {
		Date val =rs.getDate(i);
		if(val!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			XmlText.append("<"+colName+"_ZH>"+sdf.format(val)+"</"+colName+"_ZH>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//判断是哪个字段,是多选的情况
	private static void validateMore(StringBuffer XmlText, ResultSet rs,String colName, int i) {
		try {
			String Val = rs.getString(i);
			if (Val.equals("1")) 
				XmlText.append("<" + colName + ">√</" + colName + ">");

		} catch (Exception e) {

		}

	}

	//获取 Count(*) SQL 查询到的数据行数
	//参数 QuerySQL 指定获取报表数据的查询SQL
	public static int BatchGetDataCount(String QuerySQL) {
		int Total = 0;
		try {
			Class.forName(jdbc_param.driver); // Class.forName 装载驱动程序 
			Connection con = DriverManager.getConnection(jdbc_param.url,
					jdbc_param.user, jdbc_param.password); //用适当的驱动程序类与 DBMS 建立一个连接
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(QuerySQL);

			if (rs.next())
				Total = rs.getInt(1);

			rs.close();
			con.close();
		} catch (Exception e) {
		}
		return Total;
	}

	//特别提示：以下函数为兼容以前版本而保留，请勿再用之，无须兼容考虑可删除之
	//<<保留前面版本的函数，兼容以前版本所写程序
	//方法简要说明
	//1. XML_GenDetailData：产生报表明细记录数据，数据将被加载到明细网格的记录集中
	//3. XML_GenParameterData：产生报表参数数据，数据将加载到报表参数、非明细网格中的部件框中 
	//2. XML_GenEntireData：同时产生报表明细记录数据与报表参数数据

	/////////////////////////////////////////////////////////////////////////////////////////
	//产生报表明细记录数据，数据将被加载到明细网格的记录集中
	public static void XML_GenDetailData(HttpServletResponse response,
			String QuerySQL, ResponseDataType DataType) {
		XML_GenOneRecordset(response, QuerySQL, DataType);
	}

	public static void XML_GenDetailData(HttpServletResponse response,
			String QuerySQL) {
		XML_GenOneRecordset(response, QuerySQL, DefaultReportDataType);
	}

	//根据RecordsetQuerySQL获取报表明细数据，对应数据加载到报表的明细网格的记录集中
	//并同时将ParameterPart中的报表参数数据一起打包，对应数据加载到报表参数、非明细网格中的部件框中
	public static void XML_GenEntireData(HttpServletResponse response,
			String QuerySQL, String ParameterPart, ResponseDataType DataType) {
		//ArrayList<ReportQueryItem> QueryItems = new ArrayList<ReportQueryItem>();
		//QueryItems.add( new ReportQueryItem(QuerySQL, "Master") );
		//QueryItems.add( new ReportQueryItem(..QuerySQL, "Detail") );
		//XML_GenMultiRecordset(response, QueryItems, DefaultReportDataType);

		try {
			Class.forName(jdbc_param.driver); // Class.forName 装载驱动程序 
			Connection con = DriverManager.getConnection(jdbc_param.url,
					jdbc_param.user, jdbc_param.password); //用适当的驱动程序类与 DBMS 建立一个连接

			Statement stmt = con.createStatement(); //用于发送简单的SQL语句
			ResultSet rs = stmt.executeQuery(QuerySQL);

			ResultSetMetaData rsmd = rs.getMetaData();
			int ColCount = rsmd.getColumnCount();

			//StringBuffer XmlText = new StringBuffer ("<xml>\n");
			StringBuffer XmlText = new StringBuffer("<report>\n<xml>\n");

			while (rs.next()) {
				XmlText.append("<row>");
				for (int i = 1; i <= ColCount; i++) {
					XmlText.append("<");
					XmlText.append(rsmd.getColumnLabel(i)); //getColumnName
					XmlText.append(">");

					int ColType = rsmd.getColumnType(i);
					if (ColType == Types.LONGVARBINARY
							|| ColType == Types.VARBINARY
							|| ColType == Types.BINARY || ColType == Types.BLOB) {
						byte[] BinData = rs.getBytes(i);
						if (!rs.wasNull())
							XmlText.append((new sun.misc.BASE64Encoder())
									.encode(BinData));
					} else {
						String Val = rs.getString(i);
						if (!rs.wasNull()) {
							if (HasSpecialChar(Val))
								XmlText.append(HTMLEncode(Val));
							else
								XmlText.append(Val);
						}
					}

					XmlText.append("</");
					XmlText.append(rsmd.getColumnLabel(i)); //getColumnName
					XmlText.append(">");
				}
				XmlText.append("</row>\n");
			}
			rs.close();
			stmt.close();
			con.close();

			XmlText.append("</xml>\n");
			XmlText.append(ParameterPart);
			XmlText.append("</report>");

			ResponseText(response, XmlText.toString(), DataType);
		} catch (Exception e) {
			try {
				//output error message
				PrintWriter pw = response.getWriter();
				pw.print(e.toString());
			} catch (Exception e2) {
			}
		}
	}

	public static void XML_GenEntireData(HttpServletResponse response,
			String QuerySQL, String ParameterPart) {
		XML_GenEntireData(response, QuerySQL, ParameterPart,
				DefaultReportDataType);
	}

	//这里只产生报表参数数据，数据将加载到报表参数、非明细网格中的部件框中
	//当报表没有明细时，调用本方法生成数据，查询SQL应该只能查询出一条记录
	public static void XML_GenParameterData(HttpServletResponse response,
			String QuerySQL, ResponseDataType DataType) {
		try {
			StringBuffer XmlText = new StringBuffer("<report>\n");
			String ParameterPart = GenReportParameterData(QuerySQL);
			XmlText.append(ParameterPart);
			XmlText.append("</report>");

			ResponseText(response, XmlText.toString(), DataType);
		} catch (Exception e) {
		}
	}

	public static void XML_GenParameterData(HttpServletResponse response,
			String QuerySQL) {
		XML_GenOneRecordset(response, QuerySQL, DefaultReportDataType);
	}

	//根据ParameterQuerySQL获取的报表参数数据一起打包
	public static String GenReportParameterData(String ParameterQuerySQL) {
		StringBuffer XmlText = new StringBuffer("<_grparam>\n");

		try {
			Class.forName(jdbc_param.driver); // Class.forName 装载驱动程序 
			Connection con = DriverManager.getConnection(jdbc_param.url,
					jdbc_param.user, jdbc_param.password); //用适当的驱动程序类与 DBMS 建立一个连接

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(ParameterQuerySQL);

			ResultSetMetaData rsmd = rs.getMetaData();
			rs.next();

			int ColCount = rsmd.getColumnCount();
			for (int i = 1; i <= ColCount; i++) {
				XmlText.append("<");
				XmlText.append(rsmd.getColumnLabel(i)); //getColumnName
				XmlText.append(">");

				int ColType = rsmd.getColumnType(i);
				if (ColType == Types.LONGVARBINARY
						|| ColType == Types.VARBINARY
						|| ColType == Types.BINARY || ColType == Types.BLOB) {
					byte[] BinData = rs.getBytes(i);
					if (!rs.wasNull())
						XmlText.append((new sun.misc.BASE64Encoder())
								.encode(BinData));
				} else {
					String Val = rs.getString(i);
					if (!rs.wasNull()) {
						if (HasSpecialChar(Val))
							XmlText.append(HTMLEncode(Val));
						else
							XmlText.append(Val);
					}
				}

				XmlText.append("</");
				XmlText.append(rsmd.getColumnLabel(i)); //getColumnName
				XmlText.append(">\n");
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			//output error message
			XmlText.append(e.toString());
		}

		XmlText.append("</_grparam>\n");

		return XmlText.toString();
	}

	public static void GenNodeXmlData(HttpServletResponse response,
			String QuerySQL, boolean ToCompress) {
		XML_GenOneRecordset(response, QuerySQL,
				ToCompress ? ResponseDataType.ZipBinary
						: ResponseDataType.PlainText);
	}

	public static void GenFullReportData(HttpServletResponse response,
			String QuerySQL, String ParameterPart, boolean ToCompress) {
		XML_GenEntireData(response, QuerySQL, ParameterPart,
				ToCompress ? ResponseDataType.ZipBinary
						: ResponseDataType.PlainText);
	}

	public static void GenParameterXmlData(HttpServletResponse response,
			String QuerySQL) {
		XML_GenOneRecordset(response, QuerySQL, ResponseDataType.PlainText);
	}

	//>>保留前面版本的函数，兼容以前版本所写程序%>