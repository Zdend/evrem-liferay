<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<portlet:resourceURL var="saveUser" id="saveUser" />
<div id="data-profile" class="hide">
{
"urls":
	{
		"saveUser": "<%= saveUser %>"
	},
"user":${user},
"timeZones":${timeZones}
}
</div>
<div id="profile-container">

</div>



