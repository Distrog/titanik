-- liquibase formatted sql

-- changeset distrog:1

create table titanic (
id serial,
survived boolean,
class varchar (10),
name varchar(100),
sex boolean,
age integer,
siblings_spouses smallserial,
parents_children smallserial,
fare numeric
)