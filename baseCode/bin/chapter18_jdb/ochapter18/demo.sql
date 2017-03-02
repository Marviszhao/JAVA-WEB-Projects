drop procedure MyProcedure;
drop table person;
create table person(id  number primary key, name char(20), age number);
create or replace procedure MyProcedure (pid in number,name in char,age in char) 
as 
	begin 
		insert into person values(pid,name,age); 
	end;
/
