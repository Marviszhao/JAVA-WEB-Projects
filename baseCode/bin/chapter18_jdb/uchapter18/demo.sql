drop sequence seq_id;
create sequence seq_id increment by 1 start with 1001 nomaxvalue nocycle;
drop table records;
create table recods(id number, name char(20),sex char(2),age number(3));