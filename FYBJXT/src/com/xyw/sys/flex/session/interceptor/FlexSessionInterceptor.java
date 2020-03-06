package com.xyw.sys.flex.session.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class FlexSessionInterceptor implements MethodInterceptor {
	private static final Logger log = LoggerFactory
			.getLogger(FlexSessionInterceptor.class);

	/**
	 * 在所有的flex请求中都会先执行FlexSessionInterceptor类中的invoke方法 java类中获取
	 * session的话，使用AMFContext.getCurrentContext().getSession()即可
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		boolean isVerifySession = true;
		Class clazz=invocation.getThis().getClass();
		Method method =invocation.getMethod();
		method = clazz.getDeclaredMethod(
					 method.getName(),method.getParameterTypes());
		//if (AnnotationUtils.findAnnotation(method,VerifySession.class) != null)
			//isVerifySession = method.getAnnotation(VerifySession.class).isverifySession();
		String fullPath =clazz.getName() + "."+invocation.getMethod().getName();
		
	//	if (isVerifySession) {
//			AMFContext amfContext = AMFContext.getCurrentAMFContext();
//			HttpServletRequest request = amfContext.getHttpServletRequest();
//			HttpSession httpSession = request.getSession();
//			SystemUser systemUser = (SystemUser) httpSession.getAttribute(SystemConstant.LOGIN_USER_INFO);
//			if(systemUser==null){
//				log.error("systemUser为空！" + fullPath);
//				throw new SessionException(SystemConstant.LOGIN_USER_INFO_IS_NULL,
//						"Session 超时, 请重新登录!");
//			}
			
	//	}
		return catchEx(fullPath,invocation);
		
	}

	private Object catchEx(String fullPath,MethodInvocation invocation)throws Throwable {
		Object result =null;
		try {
			 //long start=System.currentTimeMillis();
			 result = invocation.proceed();
			 //String diff=System.currentTimeMillis()-start+"ms ";
			// log.error(" 时间差  "+diff+"{}", fullPath);
		} catch (RuntimeException e) {
			saveLogError(e,fullPath,invocation);
			throw new RuntimeException();
		}catch (Exception e) {
			saveLogError(e,fullPath,invocation);
			throw new Exception();
		}catch (Throwable e) {
			saveLogError(e,fullPath,invocation);
			throw new Throwable();
		}
		return result;
	}
	
	private void saveLogError(Object e ,String fullPath,MethodInvocation invocation){
		log.error("异常路径\n" + fullPath);
		log.error("传入的参数\n"+JSONObject.toJSON(invocation.getArguments()).toString());
		log.error("异常信息", e);
		// log.error("异常结果", JSON.toJSONString(result));

	}
}