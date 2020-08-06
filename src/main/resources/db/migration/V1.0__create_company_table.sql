create table  todo(
    id int not null auto_increment,
    content varchar(10000),
    status boolean default false,
    create_time date
)