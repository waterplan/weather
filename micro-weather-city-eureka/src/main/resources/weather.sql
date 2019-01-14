create table weather_data(
id BIGINT(20) NOT NULL AUTO_INCREMENT,
weather_data varchar(255) not null comment '数据',
cr_user varchar(20) not null default 'sys',
cr_date TIMESTAMP not null default CURRENT_TIMESTAMP,
up_user varchar(20) not null default 'sys',
up_date TIMESTAMP not null default CURRENT_TIMESTAMP,
primary key(id)

)