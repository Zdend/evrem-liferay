<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.MethodKey" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.model.Company" %>
<%@ page import="com.liferay.portal.kernel.util.ClassResolverUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalClassInvoker" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%
MethodKey methodKey = new MethodKey(ClassResolverUtil.resolveByPortalClassLoader("com.liferay.portlet.login.util.LoginUtil"), "getLogin", HttpServletRequest.class, String.class, Company.class);
String login = GetterUtil.getString((String)PortalClassInvoker.invoke(false, methodKey, request, "login", company));
boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

String path = PortalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay);
%>

<portlet:actionURL var="loginURL" />
<portlet:resourceURL var="signUp" id="signUp" />

<div id="data-login" class="hide">
{"urls":
	{
	"logIn":"<%= loginURL %>", 
	"signUp":"<%= signUp %>",
	"loadTimeZones":"<%=path%>/-/common/loadTimeZones"
	},
	"email":"<%= login %>","rememberMe":"<%= rememberMe %>"
}
</div>
<div id="login-container">
</div>



