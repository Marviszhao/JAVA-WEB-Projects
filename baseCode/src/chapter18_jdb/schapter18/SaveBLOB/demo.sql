drop table Student_List;
create table Student_List(
    Student_ID varchar2(20) primary key,
    Student_Name varchar2(20) not null,
    Student_Pic BLOB
);