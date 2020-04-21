create database 'lportal.gdb' page_size 8192 user 'sysdba' password 'masterkey';
connect 'lportal.gdb' user 'sysdba' password 'masterkey';
create table Note (noteId int64 not null primary key,userId int64,hasCheck smallint,hasReminder smallint,hasTODO smallint,hasRepeat smallint,text_ varchar(75),isDone smallint,eventTime timestamp,color varchar(75),createdDate timestamp,modifiedDate timestamp);
create table RemindInfo (remindInfoId int64 not null primary key,remindDate timestamp,remindSubject varchar(75),recipientEmails varchar(75),noteId int64);
create table TodoNote (todoNoteId int64 not null primary key,isDone smallint,text_ varchar(75),modifiedDate timestamp,noteId int64);
