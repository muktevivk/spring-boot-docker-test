create schema test
CREATE TABLE test.names (
	id serial NOT NULL,
	first_name varchar(30) NOT NULL,
	last_name varchar(20) NOT NULL,
	CONSTRAINT names_pk PRIMARY KEY (id)
)
WITH (
	OIDS=FALSE
) ;


