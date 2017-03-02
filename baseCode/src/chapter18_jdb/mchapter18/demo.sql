drop table teacher;
create table teacher(tid  number(6), name char(20), salary number(7,2));
insert into teacher values(1001,'张三',1800.2);
insert into teacher values(1002,'李四',2540);
insert into teacher values(1003,'王五',4587.25);  
commit;
