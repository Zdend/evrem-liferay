create table Note (
	noteId bigint not null primary key,
	userId bigint,
	hasCheck boolean,
	hasReminder boolean,
	hasTODO boolean,
	hasRepeat boolean,
	text_ varchar(75) null,
	isDone boolean,
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
	isDone boolean,
	text_ varchar(75) null,
	modifiedDate timestamp null,
	noteId bigint
);
