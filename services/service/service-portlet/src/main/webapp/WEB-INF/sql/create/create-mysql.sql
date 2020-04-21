drop database if exists lportal;
create database lportal character set utf8;
use lportal;

create table Note (
	noteId bigint not null primary key,
	userId bigint,
	hasCheck tinyint,
	hasReminder tinyint,
	hasTODO tinyint,
	hasRepeat tinyint,
	text_ varchar(75) null,
	isDone tinyint,
	eventTime datetime null,
	color varchar(75) null,
	createdDate datetime null,
	modifiedDate datetime null
) engine InnoDB;

create table RemindInfo (
	remindInfoId bigint not null primary key,
	remindDate datetime null,
	remindSubject varchar(75) null,
	recipientEmails varchar(75) null,
	noteId bigint
) engine InnoDB;

create table TodoNote (
	todoNoteId bigint not null primary key,
	isDone tinyint,
	text_ varchar(75) null,
	modifiedDate datetime null,
	noteId bigint
) engine InnoDB;


create index IX_89354439 on Note (noteId);
create index IX_1B14EB92 on Note (userId);

create index IX_6E59DC85 on TodoNote (todoNoteId);


