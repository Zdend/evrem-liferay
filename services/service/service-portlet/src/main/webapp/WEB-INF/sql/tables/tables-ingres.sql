create table Note (
	noteId bigint not null primary key,
	userId bigint,
	hasCheck tinyint,
	hasReminder tinyint,
	hasTODO tinyint,
	hasRepeat tinyint,
	text_ varchar(75) null,
	isDone tinyint,
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
	isDone tinyint,
	text_ varchar(75) null,
	modifiedDate timestamp null,
	noteId bigint
);
