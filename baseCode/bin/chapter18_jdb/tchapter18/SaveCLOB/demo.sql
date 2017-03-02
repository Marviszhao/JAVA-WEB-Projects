drop table book_list;
create table book_list(
    bid varchar2(20) primary key,
    name varchar2(40) not null,
    content CLOB
);