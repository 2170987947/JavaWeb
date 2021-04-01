drop database if exists blogdemo;
create database blogdemo character set utf8mb4;
use blogdemo;
create table user (
    id int primary key auto_increment,
    username varchar(20) not null unique comment '账号',
    password varchar(20) not null,
    nickname varchar(20),
    sex bit,
    birthday date,
    head varchar(50)
);

create table article (
    id int primary key auto_increment,
    title varchar(20) not null,
    content mediumtext not null,
    create_time timestamp default now(),
    view_count int default 0,
    user_id int,
    foreign key(user_id) references user(id)
);

insert into user(username, password) values ('a', '1');
insert into user(username, password) values ('b', '2');
insert into user(username, password) values ('c', '3');

insert into article(title, content, user_id) value ('快速排序', 'public ...', '1');
insert into article(title, content, user_id) value ('冒泡排序', 'public ...', '1');
insert into article(title, content, user_id) value ('选择排序', 'public ...', '1');
insert into article(title, content, user_id) value ('归并排序', 'public ...', '2');
insert into article(title, content, user_id) value ('插入排序', 'public ...', '2');

-- 主外键关联的表, 默认创建的主外键约束是 restrict 严格模式
-- 比如从表有数据关联到主表某一行数据 X, 那 X 不能删.
-- 真是的设计上是不删除物理数据, 在每一张表上设计一个字段, 表示是否有效.
select id, username, password, nickname, sex, birthday, head from user;
select id, title, content, create_time, view_count, user_id from article where user_id = 1;
insert into article(title, content, user_id) value (? , ?, ?);
update article set title = ?, content = ? where id = ?