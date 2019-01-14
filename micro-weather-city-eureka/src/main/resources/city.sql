create table city(
 id int(11) not null AUTO_INCREMENT,
 pid int(11) not null ,
 city_code varchar(20) not null,
 city_name varchar(20) not null,
 cr_user varchar(20) not null default 'sys',
 cr_date TIMESTAMP not null default CURRENT_TIMESTAMP,
 up_user varchar(20) not null default 'sys',
 up_date TIMESTAMP not null default CURRENT_TIMESTAMP,
 delete_flag varchar(1) not null default '1',
 primary key(id)
)