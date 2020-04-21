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
