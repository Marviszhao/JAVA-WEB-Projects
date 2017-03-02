drop table student;
create table student(sid  char(10), name char(20), age number(3));
insert into student values('J001','张三',18);
insert into student values('J002','李四',20);
insert into student values('J003','王五',19);  
commit;
