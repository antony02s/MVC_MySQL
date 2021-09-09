CREATE TABLE escuderia(
	cod_escuderia int NOT NULL,
	nombre varchar(40) NOT NULL, 
	patrocinador varchar(40) NOT NULL, 
	carreras_ganadas int NOT NULL, 
	fecha_ingreso date NOT NULL, 
	PRIMARY KEY(cod_escuderia)
);
INSERT INTO escuderia(cod_escuderia, nombre, patrocinador, carreras_ganadas, fecha_ingreso) VALUES (232, 'Viejo Willy', 'Doña Cecilia', 38, '2001-12-12');
INSERT INTO escuderia(cod_escuderia, nombre, patrocinador, carreras_ganadas, fecha_ingreso) VALUES (345, 'Severo Fierrari', 'Guión Burger', 45, '1998-03-07');
INSERT INTO escuderia(cod_escuderia, nombre, patrocinador, carreras_ganadas, fecha_ingreso) VALUES (876, 'Mechas Plateadas', 'Corredor Gourmet', 42, '1999-08-30');
CREATE TABLE carreras(
	id_carrera int NOT NULL,
	nombre varchar(30) NOT NULL, 
	capacidad_asistentes numeric(10,2) default 0,
    nivel_dificultad numeric(2,1) NOT NULL,/*BUSCAR COMO PONER ESTO OARA QUE QUEDE ENTRE 0 Y 10)*/
	bajo_techo boolean default false NOT NULL,
    primary key(id_carrera)
);
INSERT INTO carreras(id_carrera, nombre,capacidad_asistentes,nivel_dificultad,bajo_techo) values(1,'Zipotacan',8473,8.9,true);
INSERT INTO carreras(id_carrera, nombre,capacidad_asistentes,nivel_dificultad,bajo_techo) values(2,'Quirachiquin',12332,7.3,true);
INSERT INTO carreras(id_carrera, nombre,nivel_dificultad) values(3,'Vitaguata',1.9);
CREATE TABLE pilotos(
	codigo_piloto int NOT NULL,
	nombre varchar(30) NOT NULL, 
	millas_recorridas numeric(9,2) NULL, 
	combustible_usado int NULL,
    codigo_escuderia int NOT NULL,
	PRIMARY KEY(codigo_piloto),
    foreign key (codigo_escuderia) references escuderia(cod_escuderia)
);
INSERT INTO pilotos(codigo_piloto,nombre,millas_recorridas,combustible_usado,codigo_escuderia) values(12,'JuanPis',27833.8,9876456,232);
INSERT INTO pilotos(codigo_piloto,nombre,codigo_escuderia) values(872,'Chumajer',345);
CREATE TABLE participaciones(
	id_participacion int auto_increment NOT NULL,
    fecha_hora timestamp default CURRENT_TIMESTAMP,
    posicion_piloto int NOT NULL,
    codigo_piloto int NOT NULL,
    id_carrera int NOT NULL,
    primary key(id_participacion),
    foreign key(codigo_piloto) references pilotos(codigo_piloto),
    foreign key(id_carrera) references carreras(id_carrera)
);
INSERT INTO participaciones(id_participacion,fecha_hora,posicion_piloto,codigo_piloto,id_carrera) values(1,'2019-02-12 18:56:45',1,12,1);
INSERT INTO participaciones(id_participacion,fecha_hora,posicion_piloto,codigo_piloto,id_carrera) values(2,'2019-02-12 18:56:45',2,872,1);
INSERT INTO participaciones(id_participacion,fecha_hora,posicion_piloto,codigo_piloto,id_carrera) values(3,current_timestamp(),2,12,2);
INSERT INTO participaciones(id_participacion,fecha_hora,posicion_piloto,codigo_piloto,id_carrera) values(4,current_timestamp(),1,872,2);