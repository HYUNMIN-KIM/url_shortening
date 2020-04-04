create table urlTable
(
	shortening_url varchar(40) not null,
	url varchar(1000) primary key,
  request_num int(20) default 0
);



