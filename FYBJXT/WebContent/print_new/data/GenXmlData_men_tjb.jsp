<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenDataBase.jsp" %>
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
					if (rsmd.getColumnLabel(i).equals("F401_17")) {
						validateOne(XmlText, rs, "F401_17", i);//血缘关系
					} else if (rsmd.getColumnLabel(i).equals("F401_19")) {
						validateMore(XmlText, rs, "F401_19", i);//既往病史
					} else if (rsmd.getColumnLabel(i).equals("F401_21")) {
						validateOne(XmlText, rs, "F401_21", i);//手术史
					} else if (rsmd.getColumnLabel(i).equals("F401_23")) {
						validateOne(XmlText, rs, "F401_23", i);//现病史
					} else if (rsmd.getColumnLabel(i).equals("F401_25")) {
						validateOne(XmlText, rs, "F401_25", i);//既往婚育史
					} else if (rsmd.getColumnLabel(i).equals("F401_27")) {
						validateMore(XmlText, rs, "F401_27", i);//与遗传有关的家族史
					} else if (rsmd.getColumnLabel(i).equals("F401_30")) {
						validateOne(XmlText, rs, "F401_30", i);//家族近亲婚配
					} else if (rsmd.getColumnLabel(i).equals("F401_36")) {
						validateOne(XmlText, rs, "F401_36", i);//特殊体态
					} else if (rsmd.getColumnLabel(i).equals("F401_34")) {
						validateOne(XmlText, rs, "F401_34", i);//精神状态
					} else if (rsmd.getColumnLabel(i).equals("F401_38")) {
						validateOne(XmlText, rs, "F401_38", i);//皮肤毛发
					} else if (rsmd.getColumnLabel(i).equals("F401_40")) {
						validateOne(XmlText, rs, "F401_40", i);//甲状腺
					} else if (rsmd.getColumnLabel(i).equals("F401_43")) {
						validateOne(XmlText, rs, "F401_43", i);//辨色力
					} else if (rsmd.getColumnLabel(i).equals("F401_44")) {
						validateOne(XmlText, rs, "F401_44", i);//听力左
					} else if (rsmd.getColumnLabel(i).equals("F401_45")) {
						validateOne(XmlText, rs, "F401_45", i);//听力右
					} else if (rsmd.getColumnLabel(i).equals("F401_46")) {
						validateOne(XmlText, rs, "F401_46", i);//胸廓
					} else if (rsmd.getColumnLabel(i).equals("F401_48")) {
						validateOne(XmlText, rs, "F401_48", i);//肺
					} else if (rsmd.getColumnLabel(i).equals("F401_52")) {
						validateOne(XmlText, rs, "F401_52", i);//杂音
					} else if (rsmd.getColumnLabel(i).equals("F401_54")) {
						validateOne(XmlText, rs, "F401_54", i);//肝
					} else if (rsmd.getColumnLabel(i).equals("F401_56")) {
						validateOne(XmlText, rs, "F401_56", i);//脾
					} else if (rsmd.getColumnLabel(i).equals("F401_58")) {
						validateOne(XmlText, rs, "F401_58", i);//四肢
					} else if (rsmd.getColumnLabel(i).equals("F401_59")) {
						validateOne(XmlText, rs, "F401_59", i);//脊柱
					} else if (rsmd.getColumnLabel(i).equals("F401_61")) {
						validateOne(XmlText, rs, "F401_61", i);//喉结
					} else if (rsmd.getColumnLabel(i).equals("F401_62")) {
						validateOne(XmlText, rs, "F401_62", i);//阴毛
					} else if (rsmd.getColumnLabel(i).equals("F401_65")) {
						validateOne(XmlText, rs, "F401_65", i);//阴茎
					} else if (rsmd.getColumnLabel(i).equals("F401_67")) {
						validateOne(XmlText, rs, "F401_67", i);//包皮
					} else if (rsmd.getColumnLabel(i).equals("F401_70")) {
						validateOne(XmlText, rs, "F401_70", i);//未扪及
					} else if (rsmd.getColumnLabel(i).equals("F401_71")) {
						validateOne(XmlText, rs, "F401_71", i);//附睾
					} else if (rsmd.getColumnLabel(i).equals("F401_74")) {
						validateOne(XmlText, rs, "F401_74", i);//精索静脉曲张
					} else if (rsmd.getColumnLabel(i).equals("F401_86")) {
						validateOne(XmlText, rs, "F401_86", i);//检查结果
					} else if (rsmd.getColumnLabel(i).equals("F401_89")) {
						validateOne(XmlText, rs, "F401_89", i);//医学意见
					} else if (rsmd.getColumnLabel(i).equals("F401_91")) {
						validateOne(XmlText, rs, "F401_91", i);//咨询指导结果
					}else {
						recycle(XmlText, rsmd, rs, i);
					}
				}
				//XmlText.append("</row>\n");
				XmlText.append("</");
				XmlText.append(RecordsetName);
				XmlText.append(">\n");
				//System.out.println("</" + RecordsetName + ">");//注释.....
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

		} catch (Exception e) {

		}

	}

	//判断是哪个字段，是单选的情况
	private static void validateOne(StringBuffer XmlText, ResultSet rs,String F401_17, int i) {
		try {
			String Val = rs.getString(i);
			if (Val.equals("0")) {
				XmlText.append("<" + F401_17 + "_0>√</" + F401_17 + "_0>");
			} else if (Val.equals("1")) {
				XmlText.append("<" + F401_17 + "_1>√</" + F401_17 + "_1>");
			} else if (Val.equals("2")) {
				XmlText.append("<" + F401_17 + "_2>√</" + F401_17 + "_2>");
			} else if (Val.equals("3")) {
				XmlText.append("<" + F401_17 + "_3>√</" + F401_17 + "_3>");
			} else if (Val.equals("4")) {
				XmlText.append("<" + F401_17 + "_4>√</" + F401_17 + "_4>");
			} else if (Val.equals("5")) {
				XmlText.append("<" + F401_17 + "_5>√</" + F401_17 + "_5>");
			} else if (Val.equals("9")) {
				XmlText.append("<" + F401_17 + "_9>√</" + F401_17 + "_9>");
			}
		} catch (Exception e) {

		}

	}

	//判断是哪个字段,是多选的情况
	private static void validateMore(StringBuffer XmlText, ResultSet rs,String F401_19, int i) {
		try {
			String Val = rs.getString(i);
			String[] aa = Val.split(",");
			for (int j = 0; j < aa.length; j++) {
				if (aa[j].equals("1")) {
					XmlText.append("<" + F401_19 + "_1>√</" + F401_19 + "_1>");
				} else if (aa[j].equals("2")) {
					XmlText.append("<" + F401_19 + "_2>√</" + F401_19 + "_2>");
				} else if (aa[j].equals("3")) {
					XmlText.append("<" + F401_19 + "_3>√</" + F401_19 + "_3>");
				} else if (aa[j].equals("4")) {
					XmlText.append("<" + F401_19 + "_4>√</" + F401_19 + "_4>");
				} else if (aa[j].equals("5")) {
					XmlText.append("<" + F401_19 + "_5>√</" + F401_19 + "_5>");
				} else if (aa[j].equals("6")) {
					XmlText.append("<" + F401_19 + "_6>√</" + F401_19 + "_6>");
				} else if (aa[j].equals("7")) {
					XmlText.append("<" + F401_19 + "_7>√</" + F401_19 + "_7>");
				} else if (aa[j].equals("8")) {
					XmlText.append("<" + F401_19 + "_8>√</" + F401_19 + "_8>");
				} else if (aa[j].equals("9")) {
					XmlText.append("<" + F401_19 + "_9>√</" + F401_19 + "_9>");
				} else if (aa[j].equals("10")) {
					XmlText.append("<" + F401_19 + "_10>√</" + F401_19 + "_10>");
				} else if (aa[j].equals("11")) {
					XmlText.append("<" + F401_19 + "_11>√</" + F401_19 + "_11>");
				} else if (aa[j].equals("12")) {
					XmlText.append("<" + F401_19 + "_12>√</" + F401_19 + "_12>");
				} else if (aa[j].equals("99")) {
					XmlText.append("<" + F401_19 + "_99>√</" + F401_19 + "_99>");
				}
			}

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