create table games(
    pk_game        bigint auto_increment primary key,
    title          varchar(200)   not null,
    genre          varchar(200)   not null,
    getreleasedate varchar(100)   not null,
    agerating      varchar(10)    not null,
    price          decimal(10, 2) not null,
    stock_quantity int default 0
);

create table customer(
    id        bigint auto_increment primary key,
    name      varchar(100) not null,
    email     varchar(100) not null,
    cpf       varchar(11)  not null,
    telephone varchar(15)
);

create table address(
    pk_address   bigint auto_increment primary key,
    street       varchar(100),
    neighborhood varchar(100),
    city         varchar(100),
    state        varchar(2),
    zip          varchar(10),
    fk_customer  bigint
);

alter table address add constraint fk_address_customer
    foreign key (fk_customer) references customer(id);
