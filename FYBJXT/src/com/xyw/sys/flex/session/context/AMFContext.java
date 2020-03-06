package com.xyw.sys.flex.session.context;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AMFContext {
	private static ThreadLocal<AMFContext> threadLocal = new ThreadLocal<AMFContext>();

	private HttpServletRequest httpServletRequest = null;
	private HttpServletResponse httpServletResponse = null;

	public AMFContext() {
	}

	private AMFContext(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		this.httpServletRequest = httpServletRequest;
		this.httpServletResponse = httpServletResponse;
	}

	public static void setCurrentAMFContext(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		AMFContext amfContext = AMFContext.getCurrentAMFContext();
		if (amfContext == null) {
			amfContext = new AMFContext(httpServletRequest, httpServletResponse);
			threadLocal.set(amfContext);
		} else {
			amfContext.setHttpServletRequest(httpServletRequest);
			amfContext.setHttpServletResponse(httpServletResponse);
		}
	}

	public static AMFContext getCurrentAMFContext() {
		return threadLocal.get();
	}

	public ServletContext getServletContext() {
		HttpSession httpSession = this.getHttpSession();
		return httpSession.getServletContext();
	}

	public HttpSession getHttpSession() {
		return this.httpServletRequest.getSession();
	}

	public Object getHttpSessionAttribute(String attributeName) {
		HttpSession httpSession = this.getHttpSession();
		return httpSession.getAttribute(attributeName);
	}

	public void setHttpSessionAttribute(String attributeName,
			String attributeValue) {
		HttpSession httpSession = this.getHttpSession();
		httpSession.setAttribute(attributeName, attributeValue);
	}

	public Object getServletContextAttribute(String attributeName) {
		ServletContext servletContext = this.getServletContext();
		return servletContext.getAttribute(attributeName);
	}

	public void setServletContextAttriubte(String attributeName,
			String attributeValue) {
		ServletContext servletContext = this.getServletContext();
		servletContext.setAttribute(attributeName, attributeValue);
	}

	public Object getHttpServletRequestAttribute(String attributeName) {
		return this.httpServletRequest.getAttribute(attributeName);
	}

	public void setHttpServletRequestAttribute(String attributeName,
			String attributeValue) {
		this.httpServletRequest.setAttribute(attributeName, attributeValue);
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}
}