create table Note (
	noteId LONG not null primary key,
	userId LONG,
	hasCheck BOOLEAN,
	hasReminder BOOLEAN,
	hasTODO BOOLEAN,
	hasRepeat BOOLEAN,
	text_ VARCHAR(75) null,
	isDone BOOLEAN,
	eventTime DATE null,
	color VARCHAR(75) null,
	createdDate DATE null,
	modifiedDate DATE null
);

create table RemindInfo (
	remindInfoId LONG not null primary key,
	remindDate DATE null,
	remindSubject VARCHAR(75) null,
	recipientEmails VARCHAR(75) null,
	noteId LONG
);

create table TodoNote (
	todoNoteId LONG not null primary key,
	isDone BOOLEAN,
	text_ VARCHAR(75) null,
	modifiedDate DATE null,
	noteId LONG
);