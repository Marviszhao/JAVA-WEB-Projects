create table user(
u_id int primary key auto_increment,
u_user char(20) not null,
u_password char(20) not null

);

select * from user;

insert user values(null, 'admin','admin');
insert user values(null,'marvis','123');
insert user values(null,'john','123');

select * from user where u_user = 'admin';

desc user;