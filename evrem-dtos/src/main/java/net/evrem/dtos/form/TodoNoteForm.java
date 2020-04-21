package net.evrem.dtos.form;

import java.util.Date;

public class TodoNoteForm {

	private Long todoNoteId;
	private Boolean isTodoDone;
	private String todoText;
	private Date todoModifiedDate;
	private Integer sortNo;

	public Long getTodoNoteId() {
		return todoNoteId;
	}

	public void setTodoNoteId(Long todoNoteId) {
		this.todoNoteId = todoNoteId;
	}

	public Boolean getIsTodoDone() {
		return isTodoDone;
	}

	public void setIsTodoDone(Boolean isTodoDone) {
		this.isTodoDone = isTodoDone;
	}

	public String getTodoText() {
		return todoText;
	}

	public void setTodoText(String todoText) {
		this.todoText = todoText;
	}

	public Date getTodoModifiedDate() {
		return todoModifiedDate;
	}

	public void setTodoModifiedDate(Date todoModifiedDate) {
		this.todoModifiedDate = todoModifiedDate;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

}
