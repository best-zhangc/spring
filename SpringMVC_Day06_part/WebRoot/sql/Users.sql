create database db_user; -- 建库

create table Users(
id int not null auto_increment,
name varchar(50) not null unique ,
pwd varchar(50) null ,
phone varchar(50) null ,
primary key ('id')
); -- 建表
-- select * from Users;
INSERT INTO users (name , pwd , phone ) values ('Tom' , '123' , '110') ;
INSERT INTO users (name , pwd , phone ) VALUES ('Jerry' , 'abc' , '119');
INSERT INTO users (name , pwd , phone ) VALUES ('Andy' , '456' , '112'); -- 添加