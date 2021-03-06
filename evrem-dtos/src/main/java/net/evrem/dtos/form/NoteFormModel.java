package net.evrem.dtos.form;

import java.util.Date;
import java.util.List;

public class NoteFormModel {

	// Note
	private Long noteId;
	private Long userId;
	private String text;
	private Boolean hasColor;
	private Boolean hasCheck;
	private Boolean hasReminder;
	private Boolean hasTodo;
	private Boolean hasTime;
	private Boolean hasRepeat;
	private Boolean hasWall;
	private Boolean isDone;
	private Date eventTime;
	private Date createdDate;
	private Date modifiedDate;
	private ColorForm color;
	private Boolean isDeleted;

	// Repeat - period
	private PeriodForm period;

	// RemindInfo
	private RemindInfoForm remindInfo;

	// TODONote
	private List<TodoNoteForm> todos;

	// GridItem
	private GridItemForm gridItem;

	public NoteFormModel() {
		hasCheck = false;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getHasCheck() {
		return hasCheck;
	}

	public void setHasCheck(Boolean hasCheck) {
		this.hasCheck = hasCheck;
	}

	public Boolean getHasReminder() {
		return hasReminder;
	}

	public void setHasReminder(Boolean hasReminder) {
		this.hasReminder = hasReminder;
	}

	public Boolean getHasTodo() {
		return hasTodo;
	}

	public void setHasTodo(Boolean hasTodo) {
		this.hasTodo = hasTodo;
	}

	public Boolean getHasRepeat() {
		return hasRepeat;
	}

	public void setHasRepeat(Boolean hasRepeat) {
		this.hasRepeat = hasRepeat;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public List<TodoNoteForm> getTodos() {
		return todos;
	}

	public void setTodos(List<TodoNoteForm> todos) {
		this.todos = todos;
	}

	public Boolean getHasTime() {
		return hasTime;
	}

	public void setHasTime(Boolean hasTime) {
		this.hasTime = hasTime;
	}

	public Boolean getHasColor() {
		return hasColor;
	}

	public void setHasColor(Boolean hasColor) {
		this.hasColor = hasColor;
	}

	public ColorForm getColor() {
		return color;
	}

	public void setColor(ColorForm color) {
		this.color = color;
	}

	public PeriodForm getPeriod() {
		return period;
	}

	public void setPeriod(PeriodForm period) {
		this.period = period;
	}

	public GridItemForm getGridItem() {
		return gridItem;
	}

	public void setGridItem(GridItemForm gridItem) {
		this.gridItem = gridItem;
	}

	public RemindInfoForm getRemindInfo() {
		return remindInfo;
	}

	public void setRemindInfo(RemindInfoForm remindInfo) {
		this.remindInfo = remindInfo;
	}

	public Boolean getHasWall() {
		return hasWall;
	}

	public void setHasWall(Boolean hasWall) {
		this.hasWall = hasWall;
	}

}
