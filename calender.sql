create schema calender;

create table calender(
   ID int primary key,
   Date timestamp,
   Title varchar(30),
   Content varchar(250)
)