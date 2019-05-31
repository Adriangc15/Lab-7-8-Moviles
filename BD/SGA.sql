--------------------------------------------------------
-- Archivo creado  - viernes-mayo-31-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ALUMNOS
--------------------------------------------------------

  CREATE TABLE "SGA"."ALUMNOS" 
   (	"CEDULA" VARCHAR2(20 BYTE), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"TELEFONO" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"FECHA_NACIMIENTO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table CARRERAS
--------------------------------------------------------

  CREATE TABLE "SGA"."CARRERAS" 
   (	"COD_CARRERA" VARCHAR2(10 BYTE), 
	"NOMBRE_CARRERA" VARCHAR2(100 BYTE), 
	"TITULO" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table CICLOS
--------------------------------------------------------

  CREATE TABLE "SGA"."CICLOS" 
   (	"COD_CICLO" VARCHAR2(10 BYTE), 
	"ANO" VARCHAR2(4 BYTE), 
	"ESTADO" CHAR(1 BYTE), 
	"NUMERO" CHAR(1 BYTE), 
	"FECHA_INICIO" VARCHAR2(20 BYTE), 
	"FECHA_FINALIZACION" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table CURSOS
--------------------------------------------------------

  CREATE TABLE "SGA"."CURSOS" 
   (	"CODIGO" VARCHAR2(10 BYTE), 
	"CODIGO_CICLO" VARCHAR2(10 BYTE), 
	"CODIGO_CARRERA" VARCHAR2(10 BYTE), 
	"NOMBRE" VARCHAR2(100 BYTE), 
	"CREDITOS" NUMBER(3,0), 
	"HORAS" VARCHAR2(3 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table GRUPOS
--------------------------------------------------------

  CREATE TABLE "SGA"."GRUPOS" 
   (	"COD_GRUPO" VARCHAR2(10 BYTE), 
	"CODIGO_CURSO" VARCHAR2(10 BYTE), 
	"CEDULA_PROFESOR" VARCHAR2(20 BYTE), 
	"HORARIO" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table MATRICULAS
--------------------------------------------------------

  CREATE TABLE "SGA"."MATRICULAS" 
   (	"CODIGO_GRUPO" VARCHAR2(10 BYTE), 
	"CEDULA_ALUMNO" VARCHAR2(20 BYTE), 
	"NOTA" NUMBER(3,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table PROFESORES
--------------------------------------------------------

  CREATE TABLE "SGA"."PROFESORES" 
   (	"CEDULA" VARCHAR2(20 BYTE), 
	"NOMBRE_PROFESOR" VARCHAR2(100 BYTE), 
	"TELEFONO" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table ROLES
--------------------------------------------------------

  CREATE TABLE "SGA"."ROLES" 
   (	"CODIGO" VARCHAR2(10 BYTE), 
	"DESCRIPCION" VARCHAR2(25 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Table USUARIOS
--------------------------------------------------------

  CREATE TABLE "SGA"."USUARIOS" 
   (	"USUARIO" VARCHAR2(20 BYTE), 
	"CLAVE" VARCHAR2(25 BYTE), 
	"CODIGO_ROLES" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
REM INSERTING into SGA.ALUMNOS
SET DEFINE OFF;
Insert into SGA.ALUMNOS (CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO) values ('207680548','David Guzman','24307589','david@gmail.com','11/06/97');
Insert into SGA.ALUMNOS (CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO) values ('201980315','Maria Jesus Rodriguez ','62325689','maria@hotmail.com',null);
Insert into SGA.ALUMNOS (CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO) values ('209870765','Mario Diaz  Perez ','24308529','dars@gmail.com','11/06/1997');
Insert into SGA.ALUMNOS (CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO) values ('208660986','Miguel Jimenez','62895389','migue@gmail.com','11/06/1998');
Insert into SGA.ALUMNOS (CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO) values ('208970217','David Rodriguez  Zamora ','65493295','xxxdarsxxx0@gmail.com','11/06/1997');
REM INSERTING into SGA.CARRERAS
SET DEFINE OFF;
Insert into SGA.CARRERAS (COD_CARRERA,NOMBRE_CARRERA,TITULO) values ('ADM','Administracion de Empresas ','Bachillerato');
Insert into SGA.CARRERAS (COD_CARRERA,NOMBRE_CARRERA,TITULO) values ('DG','Diseno Grafico ','Bachillerato');
Insert into SGA.CARRERAS (COD_CARRERA,NOMBRE_CARRERA,TITULO) values ('INF','Ingenieria en Sistemas','Bachillerato');
Insert into SGA.CARRERAS (COD_CARRERA,NOMBRE_CARRERA,TITULO) values ('ING','Ingles','Bachillerato');
REM INSERTING into SGA.CICLOS
SET DEFINE OFF;
Insert into SGA.CICLOS (COD_CICLO,ANO,ESTADO,NUMERO,FECHA_INICIO,FECHA_FINALIZACION) values ('C1-2019','2019','1','1','12/02/19','13/06/19');
Insert into SGA.CICLOS (COD_CICLO,ANO,ESTADO,NUMERO,FECHA_INICIO,FECHA_FINALIZACION) values ('C2-2020','2020','0','2','20/06/20','14/11/20');
Insert into SGA.CICLOS (COD_CICLO,ANO,ESTADO,NUMERO,FECHA_INICIO,FECHA_FINALIZACION) values ('C1-2018','2018','0','1','17/02/18','15/06/18');
REM INSERTING into SGA.CURSOS
SET DEFINE OFF;
Insert into SGA.CURSOS (CODIGO,CODIGO_CICLO,CODIGO_CARRERA,NOMBRE,CREDITOS,HORAS) values ('EIN-566','C1-2019','ING','INGLES l','4','8');
Insert into SGA.CURSOS (CODIGO,CODIGO_CICLO,CODIGO_CARRERA,NOMBRE,CREDITOS,HORAS) values ('EIF-412','C1-2019','INF','Desarrollo de Aplicaciones Moviles','4','25');
Insert into SGA.CURSOS (CODIGO,CODIGO_CICLO,CODIGO_CARRERA,NOMBRE,CREDITOS,HORAS) values ('C1','C1-2019','ADM','Nom','8','7');
Insert into SGA.CURSOS (CODIGO,CODIGO_CICLO,CODIGO_CARRERA,NOMBRE,CREDITOS,HORAS) values ('EVS','C1-2019','INF','Estilos De Vida Saludable','3','4');
REM INSERTING into SGA.GRUPOS
SET DEFINE OFF;
Insert into SGA.GRUPOS (COD_GRUPO,CODIGO_CURSO,CEDULA_PROFESOR,HORARIO) values ('PR','EIN-566','207680219','PR');
Insert into SGA.GRUPOS (COD_GRUPO,CODIGO_CURSO,CEDULA_PROFESOR,HORARIO) values ('G-29','EIN-566','207680219','Tardes');
Insert into SGA.GRUPOS (COD_GRUPO,CODIGO_CURSO,CEDULA_PROFESOR,HORARIO) values ('F','EIN-566','201890656','R');
Insert into SGA.GRUPOS (COD_GRUPO,CODIGO_CURSO,CEDULA_PROFESOR,HORARIO) values ('Kk','EIN-566','201890656','77');
Insert into SGA.GRUPOS (COD_GRUPO,CODIGO_CURSO,CEDULA_PROFESOR,HORARIO) values ('G-21','EIN-566','201890656','Yarde');
REM INSERTING into SGA.MATRICULAS
SET DEFINE OFF;
REM INSERTING into SGA.PROFESORES
SET DEFINE OFF;
Insert into SGA.PROFESORES (CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL) values ('201890656','Joshua Montero B','88888888','jos@gmail.com');
Insert into SGA.PROFESORES (CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL) values ('89898989','david guzman','24307769','dars@gmail.com');
Insert into SGA.PROFESORES (CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL) values ('207680219','David Guzman','62638336','davidguzmanlml72@gmail.com');
Insert into SGA.PROFESORES (CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL) values ('888888','juan murillo morera','25469875','david@gmail.com');
REM INSERTING into SGA.ROLES
SET DEFINE OFF;
REM INSERTING into SGA.USUARIOS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index PK_ALUMNO
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_ALUMNO" ON "SGA"."ALUMNOS" ("CEDULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Index PK_CARRERA
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_CARRERA" ON "SGA"."CARRERAS" ("COD_CARRERA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Index PK_USUARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_USUARIO" ON "SGA"."USUARIOS" ("USUARIO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Index PK_PROFESORE
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_PROFESORE" ON "SGA"."PROFESORES" ("CEDULA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Index PK_CICLO
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_CICLO" ON "SGA"."CICLOS" ("COD_CICLO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Index PK_GRUPOS
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_GRUPOS" ON "SGA"."GRUPOS" ("COD_GRUPO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Index PK_ROLES
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_ROLES" ON "SGA"."ROLES" ("CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Index PK_CURSO
--------------------------------------------------------

  CREATE UNIQUE INDEX "SGA"."PK_CURSO" ON "SGA"."CURSOS" ("CODIGO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA" ;
--------------------------------------------------------
--  DDL for Procedure ELIMINARALUMNO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."ELIMINARALUMNO" (cedulain IN ALUMNOS.cedula%TYPE)
as
begin
    delete from ALUMNOS where cedula=cedulain;
end;


/
--------------------------------------------------------
--  DDL for Procedure ELIMINARCARRERA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."ELIMINARCARRERA" (codigoin IN CARRERAS.COD_CARRERA%TYPE)
AS
BEGIN
    DELETE FROM CARRERAS WHERE COD_CARRERA=codigoin;
END;


/
--------------------------------------------------------
--  DDL for Procedure ELIMINARCICLO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."ELIMINARCICLO" (codigoin IN CICLOS.COD_CICLO%TYPE)
AS
BEGIN
    DELETE FROM CICLOS WHERE COD_CICLO=codigoin;
END;


/
--------------------------------------------------------
--  DDL for Procedure ELIMINARCURSO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."ELIMINARCURSO" (codigoin IN CURSOS.CODIGO%TYPE)
AS
BEGIN
    DELETE FROM CURSOS WHERE CODIGO=codigoin;
END;


/
--------------------------------------------------------
--  DDL for Procedure ELIMINARGRUPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."ELIMINARGRUPO" (codigoin IN GRUPOS.COD_GRUPO%TYPE)
AS
BEGIN
    DELETE FROM Grupos WHERE COD_GRUPO=codigoin;
END;


/
--------------------------------------------------------
--  DDL for Procedure ELIMINARPROFESOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."ELIMINARPROFESOR" (cedulain IN Profesores.cedula%TYPE)
AS
BEGIN
    DELETE FROM PROFESORES WHERE cedula=cedulain;
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARALUMNO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARALUMNO" (cedula IN ALUMNOS.CEDULA%TYPE,nombre IN ALUMNOS.NOMBRE%TYPE,telefono IN ALUMNOS.TELEFONO%TYPE,
email IN ALUMNOS.EMAIL%TYPE,fecha_nacimiento IN ALUMNOS.FECHA_NACIMIENTO%TYPE)
AS
BEGIN
	INSERT INTO ALUMNOS VALUES(cedula,nombre,telefono,email,fecha_nacimiento);
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARALUMNOS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARALUMNOS" (cedula IN ALUMNOS.CEDULA%TYPE,nombre IN ALUMNOS.NOMBRE%TYPE,telefono IN ALUMNOS.TELEFONO%TYPE,
email IN ALUMNOS.EMAIL%TYPE,fecha_nacimiento IN ALUMNOS.FECHA_NACIMIENTO%TYPE)
AS
BEGIN
	INSERT INTO ALUMNOS VALUES(cedula,nombre,telefono,email,fecha_nacimiento);
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARCARRERA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARCARRERA" (CODIGO IN CARRERAS.COD_CARRERA%TYPE, NOMBRE IN CARRERAS.NOMBRE_CARRERA%TYPE, TITULO IN CARRERAS.TITULO%TYPE)
AS
BEGIN
    INSERT INTO CARRERAS VALUES(CODIGO, NOMBRE, TITULO);
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARCICLO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARCICLO" (codigo IN CICLOS.COD_CICLO%TYPE,ano IN CICLOS.ANO%TYPE,estado IN CICLOS.ESTADO%TYPE,
numero IN CICLOS.NUMERO%TYPE,fecha_inicio IN CICLOS.FECHA_INICIO%TYPE, fecha_finalizacion in CICLOS.FECHA_FINALIZACION%TYPE)
AS
BEGIN
	INSERT INTO CICLOS VALUES(codigo,ano,estado,numero,fecha_inicio, fecha_finalizacion);
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARCURSO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARCURSO" (codigo IN CURSOS.CODIGO%TYPE,codigo_ciclo IN CURSOS.CODIGO_CICLO%TYPE,codigo_carrera IN CURSOS.CODIGO_CARRERA%TYPE,
nombre IN CURSOS.NOMBRE%TYPE,creditos IN CURSOS.CREDITOS%TYPE, horas in CURSOS.HORAS%TYPE)
AS
BEGIN
	INSERT INTO CURSOS VALUES(codigo,codigo_ciclo,codigo_carrera,nombre,creditos,horas);
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARCURSOS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARCURSOS" (codigo IN CURSOS.CODIGO%TYPE,codigo_ciclo IN CURSOS.CODIGO_CICLO%TYPE,codigo_carrera IN CURSOS.CODIGO_CARRERA%TYPE,
nombre IN CURSOS.NOMBRE%TYPE,creditos IN CURSOS.CREDITOS%TYPE, horas in CURSOS.HORAS%TYPE)
AS
BEGIN
	INSERT INTO CURSOS VALUES(codigo,codigo_ciclo,codigo_carrera,nombre,creditos,horas);
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARGRUPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARGRUPO" (vCOD_GRUPO IN GRUPOS.COD_GRUPO%TYPE,
                                        vCODIGO_CURSO IN GRUPOS.CODIGO_CURSO%TYPE,
                                        vCEDULA_PROFESOR IN GRUPOS.CEDULA_PROFESOR%TYPE,
                                        vHORARIO IN GRUPOS.HORARIO%TYPE)
AS
BEGIN
	INSERT INTO GRUPOS(COD_GRUPO,CODIGO_CURSO,CEDULA_PROFESOR,HORARIO) VALUES(vCOD_GRUPO, vCODIGO_CURSO, vCEDULA_PROFESOR, vHORARIO);
END;


/
--------------------------------------------------------
--  DDL for Procedure INSERTARPROFESOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."INSERTARPROFESOR" (cedula IN PROFESORES.CEDULA%TYPE,nombre IN PROFESORES.NOMBRE_PROFESOR%TYPE,telefono IN PROFESORES.TELEFONO%TYPE,
email IN PROFESORES.EMAIL%TYPE)
AS
BEGIN
	INSERT INTO PROFESORES VALUES(cedula,nombre,telefono,email);
END;


/
--------------------------------------------------------
--  DDL for Procedure MODIFICARALUMNO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."MODIFICARALUMNO" (cedulain IN ALUMNOS.CEDULA%TYPE,nombrein IN ALUMNOS.NOMBRE%TYPE,telefonoin IN ALUMNOS.TELEFONO%TYPE,
emailin IN ALUMNOS.EMAIL%TYPE,fecha_nacimientoin IN ALUMNOS.FECHA_NACIMIENTO%TYPE)
AS
BEGIN
UPDATE ALUMNOS SET nombre=nombrein,telefono=telefonoin,email=emailin,fecha_nacimiento=fecha_nacimientoin WHERE cedula=cedulain;
END;


/
--------------------------------------------------------
--  DDL for Procedure MODIFICARCARRERA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."MODIFICARCARRERA" (CODIGOIN IN CARRERAS.COD_CARRERA%TYPE, NOMBREIN IN CARRERAS.NOMBRE_CARRERA%TYPE, TITULOIN IN CARRERAS.TITULO%TYPE)
AS

BEGIN
    UPDATE CARRERAS SET NOMBRE_CARRERA=NOMBREIN, TITULO=TITULOIN WHERE COD_CARRERA=CODIGOIN;
END;


/
--------------------------------------------------------
--  DDL for Procedure MODIFICARCICLO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."MODIFICARCICLO" (codigoin IN CICLOS.COD_CICLO%TYPE,anoin IN CICLOS.ANO%TYPE,estadoin IN CICLOS.ESTADO%TYPE,
numeroin IN CICLOS.NUMERO%TYPE,fecha_inicioin IN CICLOS.FECHA_INICIO%TYPE, fecha_finalizacionin in CICLOS.FECHA_FINALIZACION%TYPE)
AS
BEGIN
UPDATE CICLOS SET ano=anoin,estado=estadoin,numero=numeroin,fecha_inicio=fecha_inicioin, fecha_finalizacion=fecha_finalizacionin WHERE COD_CICLO=codigoin;
END;


/
--------------------------------------------------------
--  DDL for Procedure MODIFICARCURSO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."MODIFICARCURSO" (codigoin IN CURSOS.CODIGO%TYPE,codigo_cicloin IN CURSOS.CODIGO_CICLO%TYPE,codigo_carrerain IN CURSOS.CODIGO_CARRERA%TYPE,
nombrein IN CURSOS.NOMBRE%TYPE,creditosin IN CURSOS.CREDITOS%TYPE,horasin in CURSOS.HORAS%TYPE)
AS
BEGIN
    UPDATE CURSOS SET codigo_ciclo=codigo_cicloin,codigo_carrera=codigo_carrerain,nombre=nombrein, creditos=creditosin, horas=horasin WHERE codigo=codigoin;
END;


/
--------------------------------------------------------
--  DDL for Procedure MODIFICARCURSOU
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."MODIFICARCURSOU" (codigoin IN CURSOS.CODIGO%TYPE,codigo_cicloin IN CURSOS.CODIGO_CICLO%TYPE,codigo_carrerain IN CURSOS.CODIGO_CARRERA%TYPE,
nombrein IN CURSOS.NOMBRE%TYPE,creditosin IN CURSOS.CREDITOS%TYPE,horasin in CURSOS.HORAS%TYPE)
AS
BEGIN
UPDATE CURSOS SET codigo_ciclo=codigo_cicloin,codigo_carrera=codigo_carrerain,nombre=nombrein, creditos=creditosin, horas=horasin WHERE codigo=codigoin;
END;


/
--------------------------------------------------------
--  DDL for Procedure MODIFICARGRUPO
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."MODIFICARGRUPO" (COD_GRUPOIN IN GRUPOS.COD_GRUPO%TYPE,
                                            CODIGO_CURSOIN IN GRUPOS.CODIGO_CURSO%TYPE,
                                            CEDULA_PROFESORIN IN GRUPOS.CEDULA_PROFESOR%TYPE,
                                            HORARIOIN IN GRUPOS.HORARIO%TYPE)
AS
BEGIN
UPDATE GRUPOS SET CODIGO_CURSO=CODIGO_CURSOIN, CEDULA_PROFESOR=CEDULA_PROFESORIN, HORARIO=HORARIOIN WHERE COD_GRUPO=COD_GRUPOIN;
END;


/
--------------------------------------------------------
--  DDL for Procedure MODIFICARPROFESOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE "SGA"."MODIFICARPROFESOR" (cedulain IN PROFESORES.CEDULA%TYPE,nombrein IN PROFESORES.NOMBRE_PROFESOR%TYPE,telefonoin IN PROFESORES.TELEFONO%TYPE,
emailin IN PROFESORES.EMAIL%TYPE)
AS
BEGIN
UPDATE PROFESORES SET NOMBRE_PROFESOR=nombrein,telefono=telefonoin,email=emailin WHERE cedula=cedulain;
END;


/
--------------------------------------------------------
--  DDL for Package TYPES
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "SGA"."TYPES" 
AS
     TYPE ref_cursor IS REF CURSOR;
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARALUMNO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARALUMNO" (cedulabuscar IN ALUMNOS.CEDULA%TYPE)
RETURN Types.ref_cursor 
AS 
        alumno_cursor types.ref_cursor; 
BEGIN 
  OPEN alumno_cursor FOR 
       SELECT CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO FROM ALUMNOS WHERE CEDULA=cedulabuscar; 
RETURN alumno_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARALUMNOCEDULA
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARALUMNOCEDULA" (codigoBuscar IN ALUMNOS.CEDULA%TYPE)
RETURN Types.ref_cursor 
AS 
        alumno_cursor types.ref_cursor; 
BEGIN 
  OPEN alumno_cursor FOR 
       SELECT CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO FROM ALUMNOS WHERE cedula LIKE codigoBuscar||'%'; 
RETURN alumno_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARALUMNONOMBRE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARALUMNONOMBRE" (nombreBuscar IN ALUMNOS.NOMBRE%TYPE)
RETURN Types.ref_cursor 
AS 
        alumno_cursor types.ref_cursor; 
BEGIN  
  OPEN alumno_cursor FOR 
       SELECT CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO FROM ALUMNOS WHERE NOMBRE LIKE nombreBuscar||'%'; 
RETURN alumno_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARANOCICLO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARANOCICLO" (anobuscar IN CICLOS.ANO%TYPE)
RETURN Types.ref_cursor 
AS 
        ciclo_cursor types.ref_cursor; 
BEGIN 
  OPEN ciclo_cursor FOR 
       SELECT COD_CICLO, ANO,ESTADO,NUMERO,FECHA_INICIO,FECHA_FINALIZACION FROM CICLOS WHERE ano LIKE anobuscar||'%'; 
RETURN ciclo_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCARRERA
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCARRERA" (CODIGOBUSCAR IN CARRERAS.COD_CARRERA%TYPE)

RETURN Types.ref_cursor 
AS 
        carrera_cursor types.ref_cursor; 
BEGIN 
  OPEN carrera_cursor FOR 
       SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS WHERE COD_CARRERA=CODIGOBUSCAR; 
RETURN carrera_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCARRERACODIGO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCARRERACODIGO" (NombreCarrera IN CARRERAS.NOMBRE_CARRERA%TYPE)
RETURN Types.ref_cursor 
AS 
        curso_cursor types.ref_cursor; 
BEGIN 
  OPEN curso_cursor FOR 
SELECT COD_CARRERA FROM CARRERAS WHERE NOMBRE_CARRERA=NombreCarrera;
RETURN curso_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCARRERACODIGOPORNOMBRE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCARRERACODIGOPORNOMBRE" (NombreCarrera IN CARRERAS.NOMBRE_CARRERA%TYPE)
RETURN Types.ref_cursor 
AS 
        curso_cursor types.ref_cursor; 
BEGIN 
  OPEN curso_cursor FOR 
SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS WHERE NOMBRE_CARRERA=NombreCarrera;
RETURN curso_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCARRERACURSO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCARRERACURSO" (CARRERABUSCAR IN CURSOS.CODIGO_CARRERA%TYPE)

RETURN Types.ref_cursor 
AS 
        curso_cursor types.ref_cursor; 
BEGIN 
  OPEN curso_cursor FOR 
       SELECT CU.CODIGO, CU.CODIGO_CICLO,CU.CODIGO_CARRERA, CU.NOMBRE, CU.CREDITOS, CU.HORAS, CA.COD_CARRERA,
       CA.NOMBRE_CARRERA, CA.TITULO, CI.COD_CICLO, CI.ANO, CI.ESTADO, CI.NUMERO,CI.FECHA_INICIO, CI.FECHA_FINALIZACION
       FROM CURSOS  CU INNER JOIN CARRERAS  CA ON CU.CODIGO_CARRERA = CA.COD_CARRERA
       INNER JOIN CICLOS CI ON CU.CODIGO_CICLO = CI.COD_CICLO WHERE CU.CODIGO_CARRERA LIKE CARRERABUSCAR||'%'; 
RETURN curso_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCICLO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCICLO" (codigobuscar IN CICLOS.COD_CICLO%TYPE)
RETURN Types.ref_cursor 
AS 
        ciclo_cursor types.ref_cursor; 
BEGIN 
  OPEN ciclo_cursor FOR 
       SELECT COD_CICLO,ANO,ESTADO,NUMERO,FECHA_INICIO,FECHA_FINALIZACION FROM CICLOS WHERE COD_CICLO = codigobuscar; 
RETURN ciclo_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCODIGOCARRERA
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCODIGOCARRERA" (CODIGOBUSCAR IN CARRERAS.COD_CARRERA%TYPE)

RETURN Types.ref_cursor 
AS 
        carrera_cursor types.ref_cursor; 
BEGIN 
  OPEN carrera_cursor FOR 
       SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS WHERE COD_CARRERA=CODIGOBUSCAR; 
RETURN carrera_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCODIGOCARRERAOP
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCODIGOCARRERAOP" (CODIGOBUSCAR IN CARRERAS.COD_CARRERA%TYPE)

RETURN Types.ref_cursor 
AS 
        carrera_cursor types.ref_cursor; 
BEGIN 
  OPEN carrera_cursor FOR 
       SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS WHERE COD_CARRERA LIKE CODIGOBUSCAR||'%'; 
RETURN carrera_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCODIGOCICLO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCODIGOCICLO" (codigobuscar IN CICLOS.COD_CICLO%TYPE)
RETURN Types.ref_cursor 
AS 
        ciclo_cursor types.ref_cursor; 
BEGIN 
  OPEN ciclo_cursor FOR 
       SELECT COD_CICLO,ANO,ESTADO,NUMERO,FECHA_INICIO,FECHA_FINALIZACION FROM CICLOS WHERE COD_CICLO LIKE codigobuscar||'%'; 
RETURN ciclo_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCODIGOCURSO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCODIGOCURSO" (CODIGOBUSCAR IN CURSOS.CODIGO%TYPE)

RETURN Types.ref_cursor 
AS 
        curso_cursor types.ref_cursor; 
BEGIN 
  OPEN curso_cursor FOR 
       SELECT CU.CODIGO, CU.CODIGO_CICLO,CU.CODIGO_CARRERA, CU.NOMBRE, CU.CREDITOS, CU.HORAS, CA.COD_CARRERA,
       CA.NOMBRE_CARRERA, CA.TITULO, CI.COD_CICLO, CI.ANO, CI.ESTADO, CI.NUMERO,CI.FECHA_INICIO, CI.FECHA_FINALIZACION
       FROM CURSOS  CU INNER JOIN CARRERAS  CA ON CU.CODIGO_CARRERA = CA.COD_CARRERA
       INNER JOIN CICLOS CI ON CU.CODIGO_CICLO = CI.COD_CICLO WHERE CU.CODIGO LIKE CODIGOBUSCAR||'%'; 
RETURN curso_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARCURSO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARCURSO" (codigobuscar IN CURSOS.CODIGO%TYPE)
RETURN Types.ref_cursor 
AS 
        curso_cursor types.ref_cursor; 
BEGIN 
  OPEN curso_cursor FOR 
      SELECT CU.CODIGO, CU.CODIGO_CICLO,CU.CODIGO_CARRERA, CU.NOMBRE, CU.CREDITOS, CU.HORAS, CA.COD_CARRERA,
       CA.NOMBRE_CARRERA, CA.TITULO, CI.COD_CICLO, CI.ANO, CI.ESTADO, CI.NUMERO,CI.FECHA_INICIO, CI.FECHA_FINALIZACION
       FROM CURSOS  CU INNER JOIN CARRERAS  CA ON CU.CODIGO_CARRERA = CA.COD_CARRERA
       INNER JOIN CICLOS CI ON CU.CODIGO_CICLO = CI.COD_CICLO WHERE CU.CODIGO = CODIGOBUSCAR; 
RETURN curso_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARGRUPO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARGRUPO" (IDCOD_GRUPO IN GRUPOS.COD_GRUPO%TYPE)
RETURN Types.ref_cursor 
AS 
        GRUPO_cursor types.ref_cursor; 
BEGIN 
  OPEN GRUPO_cursor FOR 
       SELECT COD_GRUPO, CODIGO_CURSO, CEDULA_PROFESOR, HORARIO FROM GRUPOS WHERE COD_GRUPO LIKE IDCOD_GRUPO||'%'; 
RETURN GRUPO_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARNOMBRECARRERA
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARNOMBRECARRERA" (NOMBREBUSCAR IN CARRERAS.NOMBRE_CARRERA%TYPE)

RETURN Types.ref_cursor 
AS 
        carrera_cursor types.ref_cursor; 
BEGIN 
  OPEN carrera_cursor FOR 
       SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS WHERE NOMBRE_CARRERA=NOMBREBUSCAR; 
RETURN carrera_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARNOMBRECARRERAOP
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARNOMBRECARRERAOP" (NOMBREBUSCAR IN CARRERAS.NOMBRE_CARRERA%TYPE)

RETURN Types.ref_cursor 
AS 
        carrera_cursor types.ref_cursor; 
BEGIN 
  OPEN carrera_cursor FOR 
       SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS WHERE NOMBRE_CARRERA LIKE NOMBREBUSCAR||'%'; 
RETURN carrera_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARNOMBRECURSO
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARNOMBRECURSO" (NOMBREBUSCAR IN CURSOS.NOMBRE%TYPE)

RETURN Types.ref_cursor 
AS 
        curso_cursor types.ref_cursor; 
BEGIN 
  OPEN curso_cursor FOR 
       SELECT CU.CODIGO, CU.CODIGO_CICLO,CU.CODIGO_CARRERA, CU.NOMBRE, CU.CREDITOS, CU.HORAS, CA.COD_CARRERA,
       CA.NOMBRE_CARRERA, CA.TITULO, CI.COD_CICLO, CI.ANO, CI.ESTADO, CI.NUMERO,CI.FECHA_INICIO, CI.FECHA_FINALIZACION
       FROM CURSOS  CU INNER JOIN CARRERAS  CA ON CU.CODIGO_CARRERA = CA.COD_CARRERA
       INNER JOIN CICLOS CI ON CU.CODIGO_CICLO = CI.COD_CICLO WHERE CU.NOMBRE LIKE NOMBREBUSCAR||'%'; 
RETURN curso_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARPROFESOR
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARPROFESOR" (cedulabuscar IN PROFESORES.CEDULA%TYPE)
RETURN Types.ref_cursor 
AS 
        profesor_cursor types.ref_cursor; 
BEGIN 
  OPEN profesor_cursor FOR 
      SELECT  CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL FROM PROFESORES WHERE CEDULA = cedulabuscar; 
RETURN profesor_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARPROFESORCEDULA
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARPROFESORCEDULA" (codigoBuscar IN PROFESORES.CEDULA%TYPE)
RETURN Types.ref_cursor 
AS 
        profesor_cursor types.ref_cursor; 
BEGIN 
  OPEN profesor_cursor FOR 
       SELECT CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL  FROM PROFESORES WHERE cedula LIKE codigoBuscar||'%'; 
RETURN profesor_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARPROFESORNOMBRE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARPROFESORNOMBRE" (nombreBuscar IN PROFESORES.NOMBRE_PROFESOR%TYPE)
RETURN Types.ref_cursor 
AS 
        profesor_cursor types.ref_cursor; 
BEGIN  
  OPEN profesor_cursor FOR 
       SELECT  CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL  FROM PROFESORES WHERE NOMBRE_PROFESOR LIKE nombreBuscar||'%'; 
RETURN profesor_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function BUSCARTITULOCARRERA
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."BUSCARTITULOCARRERA" (TITULOBUSCAR IN CARRERAS.TITULO%TYPE)

RETURN Types.ref_cursor 
AS 
        carrera_cursor types.ref_cursor; 
BEGIN 
  OPEN carrera_cursor FOR 
       SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS WHERE TITULO=TITULOBUSCAR; 
RETURN carrera_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function LISTARALUMNOS
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."LISTARALUMNOS" 
RETURN Types.ref_cursor 
AS 
       alumno_cursor types.ref_cursor; 
BEGIN 
  OPEN alumno_cursor FOR 
       SELECT CEDULA,NOMBRE,TELEFONO,EMAIL,FECHA_NACIMIENTO from ALUMNOS; 
RETURN alumno_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function LISTARCARRERAS
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."LISTARCARRERAS" 
RETURN Types.ref_cursor 
AS 
        carrera_cursor types.ref_cursor; 
BEGIN 
  OPEN carrera_cursor FOR 
       SELECT COD_CARRERA,NOMBRE_CARRERA,TITULO FROM CARRERAS; 
RETURN carrera_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function LISTARCICLOS
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."LISTARCICLOS" 
RETURN Types.ref_cursor 
AS 
        ciclo_cursor types.ref_cursor; 
BEGIN 
  OPEN ciclo_cursor FOR 
       SELECT COD_CICLO,ANO,ESTADO,NUMERO,FECHA_INICIO,FECHA_FINALIZACION FROM CICLOS; 
RETURN ciclo_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function LISTARCURSOS
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."LISTARCURSOS" 
RETURN Types.ref_cursor 
AS 
        curso_cursor types.ref_cursor; 
BEGIN 
  OPEN curso_cursor FOR 

       SELECT CU.CODIGO, CU.CODIGO_CICLO,CU.CODIGO_CARRERA, CU.NOMBRE, CU.CREDITOS, CU.HORAS, CA.COD_CARRERA,
       CA.NOMBRE_CARRERA, CA.TITULO, CI.COD_CICLO, CI.ANO, CI.ESTADO, CI.NUMERO,CI.FECHA_INICIO, CI.FECHA_FINALIZACION
       FROM CURSOS  CU INNER JOIN CARRERAS  CA ON CU.CODIGO_CARRERA = CA.COD_CARRERA
       INNER JOIN CICLOS CI ON CU.CODIGO_CICLO = CI.COD_CICLO;

RETURN curso_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function LISTARGRUPOS
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."LISTARGRUPOS" 
RETURN Types.ref_cursor 
AS 
        GRUPO_cursor types.ref_cursor; 
BEGIN 
  OPEN GRUPO_cursor FOR 
        SELECT GRU.COD_GRUPO, GRU.CODIGO_CURSO, GRU.CEDULA_PROFESOR, GRU.HORARIO,
                CUR.CODIGO, CUR.CODIGO_CICLO, CUR.CODIGO_CARRERA, CUR.NOMBRE, CUR.CREDITOS, CUR.HORAS,
                CIC.COD_CICLO, CIC.ANO, CIC.ESTADO, CIC.NUMERO, CIC.FECHA_INICIO, CIC.FECHA_FINALIZACION,
                CAR.COD_CARRERA, CAR.NOMBRE_CARRERA, CAR.TITULO,
                PRO.CEDULA, PRO.NOMBRE_PROFESOR, PRO.TELEFONO, PRO.EMAIL
        FROM GRUPOS GRU
        INNER JOIN SGA.CURSOS CUR ON GRU.CODIGO_CURSO = CUR.CODIGO
        INNER JOIN SGA.CICLOS CIC ON CUR.CODIGO_CICLO = CIC.COD_CICLO
        INNER JOIN SGA.CARRERAS CAR ON CUR.CODIGO_CARRERA = CAR.COD_CARRERA
        INNER JOIN SGA.PROFESORES PRO ON GRU.CEDULA_PROFESOR = PRO.CEDULA; 
RETURN GRUPO_cursor; 
END;


/
--------------------------------------------------------
--  DDL for Function LISTARPROFESOR
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "SGA"."LISTARPROFESOR" 
RETURN Types.ref_cursor 
AS 
        profesor_cursor types.ref_cursor; 
BEGIN 
  OPEN profesor_cursor FOR 
       SELECT CEDULA,NOMBRE_PROFESOR,TELEFONO,EMAIL FROM PROFESORES; 
       --SELECT * FROM CICLOS;
RETURN profesor_cursor; 
END;


/
--------------------------------------------------------
--  Constraints for Table GRUPOS
--------------------------------------------------------

  ALTER TABLE "SGA"."GRUPOS" MODIFY ("COD_GRUPO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."GRUPOS" MODIFY ("CODIGO_CURSO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."GRUPOS" MODIFY ("CEDULA_PROFESOR" NOT NULL ENABLE);
  ALTER TABLE "SGA"."GRUPOS" ADD CONSTRAINT "PK_GRUPOS" PRIMARY KEY ("COD_GRUPO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ROLES
--------------------------------------------------------

  ALTER TABLE "SGA"."ROLES" MODIFY ("CODIGO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."ROLES" ADD CONSTRAINT "PK_ROLES" PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CURSOS
--------------------------------------------------------

  ALTER TABLE "SGA"."CURSOS" MODIFY ("CODIGO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."CURSOS" MODIFY ("CODIGO_CICLO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."CURSOS" MODIFY ("CODIGO_CARRERA" NOT NULL ENABLE);
  ALTER TABLE "SGA"."CURSOS" ADD CONSTRAINT "PK_CURSO" PRIMARY KEY ("CODIGO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "SGA"."USUARIOS" MODIFY ("USUARIO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."USUARIOS" MODIFY ("CODIGO_ROLES" NOT NULL ENABLE);
  ALTER TABLE "SGA"."USUARIOS" ADD CONSTRAINT "PK_USUARIO" PRIMARY KEY ("USUARIO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PROFESORES
--------------------------------------------------------

  ALTER TABLE "SGA"."PROFESORES" MODIFY ("CEDULA" NOT NULL ENABLE);
  ALTER TABLE "SGA"."PROFESORES" ADD CONSTRAINT "PK_PROFESORE" PRIMARY KEY ("CEDULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MATRICULAS
--------------------------------------------------------

  ALTER TABLE "SGA"."MATRICULAS" MODIFY ("CODIGO_GRUPO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."MATRICULAS" MODIFY ("CEDULA_ALUMNO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ALUMNOS
--------------------------------------------------------

  ALTER TABLE "SGA"."ALUMNOS" MODIFY ("CEDULA" NOT NULL ENABLE);
  ALTER TABLE "SGA"."ALUMNOS" ADD CONSTRAINT "PK_ALUMNO" PRIMARY KEY ("CEDULA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CARRERAS
--------------------------------------------------------

  ALTER TABLE "SGA"."CARRERAS" MODIFY ("COD_CARRERA" NOT NULL ENABLE);
  ALTER TABLE "SGA"."CARRERAS" ADD CONSTRAINT "PK_CARRERA" PRIMARY KEY ("COD_CARRERA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CICLOS
--------------------------------------------------------

  ALTER TABLE "SGA"."CICLOS" MODIFY ("COD_CICLO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."CICLOS" MODIFY ("ANO" NOT NULL ENABLE);
  ALTER TABLE "SGA"."CICLOS" ADD CONSTRAINT "PK_CICLO" PRIMARY KEY ("COD_CICLO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SGA_DATA"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CURSOS
--------------------------------------------------------

  ALTER TABLE "SGA"."CURSOS" ADD CONSTRAINT "FK_CURSO_CARRERA" FOREIGN KEY ("CODIGO_CARRERA")
	  REFERENCES "SGA"."CARRERAS" ("COD_CARRERA") ON DELETE CASCADE ENABLE;
  ALTER TABLE "SGA"."CURSOS" ADD CONSTRAINT "FK_CURSO_CICLO" FOREIGN KEY ("CODIGO_CICLO")
	  REFERENCES "SGA"."CICLOS" ("COD_CICLO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table GRUPOS
--------------------------------------------------------

  ALTER TABLE "SGA"."GRUPOS" ADD CONSTRAINT "FK_GRUPO_CURSO" FOREIGN KEY ("CODIGO_CURSO")
	  REFERENCES "SGA"."CURSOS" ("CODIGO") ON DELETE CASCADE ENABLE;
  ALTER TABLE "SGA"."GRUPOS" ADD CONSTRAINT "FK_GRUPO_PROFESOR" FOREIGN KEY ("CEDULA_PROFESOR")
	  REFERENCES "SGA"."PROFESORES" ("CEDULA") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MATRICULAS
--------------------------------------------------------

  ALTER TABLE "SGA"."MATRICULAS" ADD CONSTRAINT "FK_MATRICULA_ALUMNO" FOREIGN KEY ("CEDULA_ALUMNO")
	  REFERENCES "SGA"."ALUMNOS" ("CEDULA") ON DELETE CASCADE ENABLE;
  ALTER TABLE "SGA"."MATRICULAS" ADD CONSTRAINT "FK_MATRICULA_GRUPO" FOREIGN KEY ("CODIGO_GRUPO")
	  REFERENCES "SGA"."GRUPOS" ("COD_GRUPO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "SGA"."USUARIOS" ADD CONSTRAINT "FK_USUARIO_ROL" FOREIGN KEY ("CODIGO_ROLES")
	  REFERENCES "SGA"."ROLES" ("CODIGO") ON DELETE CASCADE ENABLE;
