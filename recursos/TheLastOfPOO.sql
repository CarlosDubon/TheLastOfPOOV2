-- Database: "TheLastOfPOO"

-- DROP DATABASE "TheLastOfPOO";

CREATE DATABASE "TheLastOfPOO"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_El Salvador.1252'
       LC_CTYPE = 'Spanish_El Salvador.1252'
       CONNECTION LIMIT = -1;


CREATE TABLE Jugador(
	idJugador SERIAL primary key,
	nick varchar(30) not null,
	puntaje int not null
)

delete from jugador

