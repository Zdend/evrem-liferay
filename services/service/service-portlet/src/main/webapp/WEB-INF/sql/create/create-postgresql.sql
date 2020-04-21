drop database lportal;
create database lportal encoding = 'UNICODE';
\c lportal;

create table Note (
	noteId bigint not null primary key,
	userId bigint,
	hasCheck bool,
	hasReminder bool,
	hasTODO bool,
	hasRepeat bool,
	text_ varchar(75) null,
	isDone bool,
	eventTime timestamp null,
	color varchar(75) null,
	createdDate timestamp null,
	modifiedDate timestamp null
);

create table RemindInfo (
	remindInfoId bigint not null primary key,
	remindDate timestamp null,
	remindSubject varchar(75) null,
	recipientEmails varchar(75) null,
	noteId bigint
);

create table TodoNote (
	todoNoteId bigint not null primary key,
	isDone bool,
	text_ varchar(75) null,
	modifiedDate timestamp null,
	noteId bigint
);


create index IX_89354439 on Note (noteId);
create index IX_1B14EB92 on Note (userId);

create index IX_6E59DC85 on TodoNote (todoNoteId);


