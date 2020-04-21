drop database lportal;
create database lportal;

go

use lportal;

create table Note (
	noteId bigint not null primary key,
	userId bigint,
	hasCheck bit,
	hasReminder bit,
	hasTODO bit,
	hasRepeat bit,
	text_ nvarchar(75) null,
	isDone bit,
	eventTime datetime null,
	color nvarchar(75) null,
	createdDate datetime null,
	modifiedDate datetime null
);

create table RemindInfo (
	remindInfoId bigint not null primary key,
	remindDate datetime null,
	remindSubject nvarchar(75) null,
	recipientEmails nvarchar(75) null,
	noteId bigint
);

create table TodoNote (
	todoNoteId bigint not null primary key,
	isDone bit,
	text_ nvarchar(75) null,
	modifiedDate datetime null,
	noteId bigint
);


create index IX_89354439 on Note (noteId);
create index IX_1B14EB92 on Note (userId);

create index IX_6E59DC85 on TodoNote (todoNoteId);


