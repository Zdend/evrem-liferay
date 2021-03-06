<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />
<%@page import="com.liferay.portal.util.PortalUtil"%>

<% 
String path = PortalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay);
%>

<portlet:resourceURL var="saveCoordinates" id="saveCoordinates" />
<div id="data-wall-grid" class="hide">
{
"urls":
	{
	"saveCoordinates":"<%= saveCoordinates %>", 
	"checkNote":"<%=path%>/-/common/checkNote",
	"checkTodoNote":"<%=path%>/-/common/checkTodoNote"
	},
"notes":${notesJSON}
}
</div>
<div id="wall-grid-container">

</div>



