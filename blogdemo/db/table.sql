drop database if exists shop;
create database if not exists shop character set utf8mb4;

use shop;

create table goods (
    goods_id int primary key auto_increment,
    goods_name varchar(50),
    unitprice decimal(7, 2),
    category varchar(50),
    provider varchar(50)
);

create table customer (
    cusomer_id int primary key auto_increment,
    name varchar(50),
    address varchar(250),
    email varchar(50),
    sex varchar(10),
    card_id varchar(20)
);

create table purchase (
    order_id int primary key auto_increment,
    customer_id int,
    goods_id int,
    nums int,
    foreign key(customer_id) references customer(cusomer_id),
    foreign key(goods_id) references goods(goods_id)
);

insert into customer(name) value ('人');
insert into customer(cusomer_id, name) value (3, '啦啦啦');