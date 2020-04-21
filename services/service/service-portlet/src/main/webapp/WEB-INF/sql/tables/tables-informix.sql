create table Note (
	noteId int8 not null primary key,
	userId int8,
	hasCheck boolean,
	hasReminder boolean,
	hasTODO boolean,
	hasRepeat boolean,
	text_ varchar(75),
	isDone boolean,
	eventTime datetime YEAR TO FRACTION,
	color varchar(75),
	createdDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION
)
extent size 16 next size 16
lock mode row;

create table RemindInfo (
	remindInfoId int8 not null primary key,
	remindDate datetime YEAR TO FRACTION,
	remindSubject varchar(75),
	recipientEmails varchar(75),
	noteId int8
)
extent size 16 next size 16
lock mode row;

create table TodoNote (
	todoNoteId int8 not null primary key,
	isDone boolean,
	text_ varchar(75),
	modifiedDate datetime YEAR TO FRACTION,
	noteId int8
)
extent size 16 next size 16
lock mode row;
