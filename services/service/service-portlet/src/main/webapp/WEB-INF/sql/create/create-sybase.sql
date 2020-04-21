use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table Note (
	noteId decimal(20,0) not null primary key,
	userId decimal(20,0),
	hasCheck int,
	hasReminder int,
	hasTODO int,
	hasRepeat int,
	text_ varchar(75) null,
	isDone int,
	eventTime datetime null,
	color varchar(75) null,
	createdDate datetime null,
	modifiedDate datetime null
)
go

create table RemindInfo (
	remindInfoId decimal(20,0) not null primary key,
	remindDate datetime null,
	remindSubject varchar(75) null,
	recipientEmails varchar(75) null,
	noteId decimal(20,0)
)
go

create table TodoNote (
	todoNoteId decimal(20,0) not null primary key,
	isDone int,
	text_ varchar(75) null,
	modifiedDate datetime null,
	noteId decimal(20,0)
)
go




