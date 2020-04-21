<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<portlet:resourceURL var="saveNote" id="saveNote" />
<portlet:resourceURL var="deleteNote" id="deleteNote" />

<div id="data-new-note" class="hide">
{
"colors": ${colors},
"periods": ${periods},
"urls":
	{
	"saveNote":"<%= saveNote %>",
	"deleteNote":"<%= deleteNote %>"
	}
}
</div>
<div id="new-note-container">


</div>
