drop database lportal;
create database lportal;
connect to lportal;
create table Note (
	noteId bigint not null primary key,
	userId bigint,
	hasCheck smallint,
	hasReminder smallint,
	hasTODO smallint,
	hasRepeat smallint,
	text_ varchar(75),
	isDone smallint,
	eventTime timestamp,
	color varchar(75),
	createdDate timestamp,
	modifiedDate timestamp
);

create table RemindInfo (
	remindInfoId bigint not null primary key,
	remindDate timestamp,
	remindSubject varchar(75),
	recipientEmails varchar(75),
	noteId bigint
);

create table TodoNote (
	todoNoteId bigint not null primary key,
	isDone smallint,
	text_ varchar(75),
	modifiedDate timestamp,
	noteId bigint
);


create index IX_89354439 on Note (noteId);
create index IX_1B14EB92 on Note (userId);

create index IX_6E59DC85 on TodoNote (todoNoteId);


