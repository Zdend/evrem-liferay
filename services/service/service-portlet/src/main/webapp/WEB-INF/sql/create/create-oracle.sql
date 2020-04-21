drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table Note (
	noteId number(30,0) not null primary key,
	userId number(30,0),
	hasCheck number(1, 0),
	hasReminder number(1, 0),
	hasTODO number(1, 0),
	hasRepeat number(1, 0),
	text_ VARCHAR2(75 CHAR) null,
	isDone number(1, 0),
	eventTime timestamp null,
	color VARCHAR2(75 CHAR) null,
	createdDate timestamp null,
	modifiedDate timestamp null
);

create table RemindInfo (
	remindInfoId number(30,0) not null primary key,
	remindDate timestamp null,
	remindSubject VARCHAR2(75 CHAR) null,
	recipientEmails VARCHAR2(75 CHAR) null,
	noteId number(30,0)
);

create table TodoNote (
	todoNoteId number(30,0) not null primary key,
	isDone number(1, 0),
	text_ VARCHAR2(75 CHAR) null,
	modifiedDate timestamp null,
	noteId number(30,0)
);


create index IX_89354439 on Note (noteId);
create index IX_1B14EB92 on Note (userId);

create index IX_6E59DC85 on TodoNote (todoNoteId);



quit