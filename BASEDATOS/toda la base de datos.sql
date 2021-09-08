CREATE SCHEMA banco_online;
USE banco_online;
CREATE TABLE campania(
	cmp_id INTEGER  AUTO_INCREMENT PRIMARY KEY,
	cmp_descripcion VARCHAR(100)
);
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (1 , "Toma tú crédito de consumo al 0.72% mensual y compra lo que quieras");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (2, "Crédito de libre destino al 12% efectivo anual");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES ( 3, "Realizando tus sueños con crédito de consumo al 2.5% mensual");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (4 , "Tú crédito de consumo amigo con tasa de 0.9 mensual");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (5 , "1, 2 y 3, tú crédito de consumo otra vez con el 0.7 efectivo anual");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (6, "Crédito de libranza para invertir en lo que quieras al 12% efectivo anual");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (7, "Libranza para descuento directo de tu nómina Colsubsidio");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (8, "Toma tú libranza al 0.5% mensual para descuento directo por nómina");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (9, "Crédito de libranza para conductores SITP al 9% efectivo anual");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (10, "Trabaja y cumple tus sueños con una libranza por descuento de nómina");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (11, "Crédito de libranza para empleados de nómina");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (12, "Para lo que quieras, tú crédito de libranza ya");
INSERT INTO campania (cmp_id, cmp_descripcion) VALUES (13, "1,2 y 3, tú libranza está cerca otra vez");

CREATE TABLE asesor_comercial(
	asr_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    asr_nombres VARCHAR(60),
    asr_apellidos VARCHAR(60),
    asr_surcusal_bancaria VARCHAR(60) 
);
INSERT INTO asesor_comercial(asr_id, asr_nombres, asr_apellidos, asr_surcusal_bancaria) VALUES (1, "Juanquini", "Takebuchi", "Centro Mayor");
INSERT INTO asesor_comercial(asr_id, asr_nombres, asr_apellidos, asr_surcusal_bancaria) VALUES (2, "Mariana", "Blandón", "Ensueño");
INSERT INTO asesor_comercial(asr_id, asr_nombres, asr_apellidos, asr_surcusal_bancaria) VALUES (3, "Farceliza", "De la Hoz", "Unicentro");
INSERT INTO asesor_comercial(asr_id, asr_nombres, asr_apellidos, asr_surcusal_bancaria) VALUES (4, "Cupertino", "Lions", "Gran Estación");
INSERT INTO asesor_comercial(asr_id, asr_nombres, asr_apellidos, asr_surcusal_bancaria) VALUES (5, "Mariano", "Cívico", "Américas");
CREATE TABLE usuario(
	usr_alias VARCHAR(30) PRIMARY KEY NOT NULL,
    usr_nombres VARCHAR(30),
    usr_apellidos VARCHAR(30),
	usr_email VARCHAR(30),
    usr_celular VARCHAR(15),
    usr_clave VARCHAR(30),
    usr_fecha_nto VARCHAR(15)
);
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("diva", "Ana", "Diaz","adiaz@gmail.com", 3124578905, "76$3&gg", "20/09/1978");
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("dreamer", "Luis", "Rojas", "lrojas@gmail.com", 3185241967, "nsbdnbs", "11/10/1995");
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("green", "Jorge", "Rodriguez","jorgeGreen@gmail.com", 3208956726, "1234%$#", "20/12/2000");
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("lucky", "Pedro", "Perez","pp@gmail.com", 3221589161, "x1y2z3", "25/10/2000");
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("malopez", "Maria", "Lopez","malopez@gmail.com", 3501531561, "98774n", "4/03/1980");
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("neon", "Nelson", "Ruiz","nelson2@gmail.com", 3201643458, "45&$%", "25/08/1992");
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("ninja", "Andres", "Cruz","acninja@gmail.com", 3181513313, "pass123", "30/10/1990");
INSERT INTO usuario(usr_alias, usr_nombres, usr_apellidos, usr_email, usr_celular, usr_clave, usr_fecha_nto) VALUES ("rose", "Claudia", "Mendez","florm@gmail.com", 3108972635, "flor121", "25/01/1990");
CREATE TABLE consumo(
	csm_idprimary INTEGER AUTO_INCREMENT PRIMARY KEY, 
    csm_id INTEGER NOT NULL,
	csm_asesor INTEGER NOT NULL,
    csm_cuotas INTEGER,
    csm_tasa_interes FLOAT(3,2),
    FOREIGN KEY (csm_id) REFERENCES campania(cmp_id) on delete cascade on update cascade,
    FOREIGN KEY (csm_asesor) REFERENCES asesor_comercial(asr_id) on delete cascade on update cascade    
);
INSERT INTO consumo(csm_idprimary, csm_id, csm_asesor, csm_cuotas, csm_tasa_interes) VALUES (1, 1, 2, 60, 0.72);
INSERT INTO consumo(csm_idprimary, csm_id, csm_asesor, csm_cuotas, csm_tasa_interes) VALUES (2, 2, 3, 72, 1.00);
INSERT INTO consumo(csm_idprimary, csm_id, csm_asesor, csm_cuotas, csm_tasa_interes) VALUES (3, 3, 1, 48, 2.50);
INSERT INTO consumo(csm_idprimary, csm_id, csm_asesor, csm_cuotas, csm_tasa_interes) VALUES (4, 4, 4, 60, 0.90);
INSERT INTO consumo(csm_idprimary, csm_id, csm_asesor, csm_cuotas, csm_tasa_interes) VALUES (5, 5, 5, 60, 0.70);
CREATE TABLE libranza(
	lbr_id_PRIMARY INTEGER  AUTO_INCREMENT PRIMARY KEY,
    lbr_id INTEGER NOT NULL,
    lbr_empresa VARCHAR(30),
    lbr_meses_plazo INTEGER,
    lbr_tasa_interes FLOAT(3,2),
    FOREIGN KEY (lbr_id) REFERENCES campania(cmp_id) on delete cascade on update cascade
);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (6, 6, "La Cuncia S.A", 60, 1.00);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (7, 7, "Colsubsidio", 48, 0.50);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (8, 8, "Los Recuerdos Ltda.", 36, 0.50);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (9, 9, "Conductores S.A", 60, 0.75);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (10, 10, "Pardo Rojo Ltda.", 60, 0.50);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (11, 11, "Manaure S.A.S", 36, 0.75);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (12, 12, "Rio Frío Ltda.", 24, 0.90);
INSERT INTO libranza(lbr_id_PRIMARY, lbr_id, lbr_empresa, lbr_meses_plazo, lbr_tasa_interes) VALUES (13, 13, "Río Bravo S.A.S", 48, 0.85);
CREATE TABLE campania_aplicada(
	cpa_app_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    cpa_usuario VARCHAR(30),
    cpa_campania INTEGER,
    cpa_app_fecha DATETIME,
    FOREIGN KEY(cpa_usuario) REFERENCES usuario(usr_alias) on delete cascade on update cascade,
    FOREIGN KEY (cpa_campania) REFERENCES campania(cmp_id) on delete cascade on update cascade
);
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(1, "lucky",1 ,"2017-10-25 20:00:00");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(2, "malopez", 1, "2018-05-20 20:30:00");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(3, "diva", 2, "2019-05-20 20:30:00");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(4, "green", 2, "2020-01-10 17:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(5, "diva", 3, "2018-06-22 21:30:00");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(6, "lucky", 4, "2019-03-15 18:30:00");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(7, "green", 4, "2020-02-15 20:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(8, "green", 5,"2020-03-17 18:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(9, "diva", 6, "2020-03-17 15:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(10, "dreamer", 6, "2020-03-17 15:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(11, "dreamer" , 7, "2020-04-10 18:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(12, "ninja", 8, "2020-02-17 20:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(13, "lucky", 9, "2019-05-20 20:30:00");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(14, "malopez", 9, "2020-01-20 20:30:00");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(15, "ninja", 9, "2020-02-20 16:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(16, "rose", 10, "2020-03-20 21:30:20");
INSERT INTO campania_aplicada(cpa_app_id, cpa_usuario ,cpa_campania, cpa_app_fecha) VALUES(17, "ninja", 11, "2020-03-27 18:30:20");
