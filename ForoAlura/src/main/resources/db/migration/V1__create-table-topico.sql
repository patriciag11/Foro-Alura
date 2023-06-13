create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null unique,
    fecha_creacion date not null ,
    estatus varchar(100) not null,
    nombre_autor varchar(100) not null,
    email varchar(100) not null unique,
    contrasena varchar(100) not null,
    nombre_curso varchar(100) not null,
    categoria varchar(100) not null,

    primary key (id)

);