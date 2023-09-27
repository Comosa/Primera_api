create table producto(

id bigint not null  auto_increment,
nombre varchar(150) not null,
descripcion varchar(300) not null,
precio int not null,
cantidad int not null,
primary key(id)
);