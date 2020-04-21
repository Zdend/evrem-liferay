<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:resourceURL var="reloadNotes" id="reloadNotes" />
<portlet:resourceURL var="deleteNote" id="deleteNote" />
<portlet:resourceURL var="exportAll" id="exportAll" />
<portlet:resourceURL var="getExportAllFile" id="getExportAllFile" />
<portlet:resourceURL var="emptyTrash" id="emptyTrash" />

<div id="data-filter" class="hide">
{
"notes": ${notesJSON},
"urls":
	{
	"deleteNote":"<%= deleteNote %>",
	"exportAll":"<%= exportAll %>",
	"getExportAllFile":"<%= getExportAllFile %>",
	"emptyTrash":"<%= emptyTrash %>"
	}
}
</div>
<div id="filter-container">
</div>