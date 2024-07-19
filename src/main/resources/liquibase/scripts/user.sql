-- liquibase formatted sql

-- changeset distrog:1

create table titanic (
id serial,
survived boolean,
class varchar (10),
name varchar(25),
sex boolean,
siblings_spouses smallserial,
parents_children smallserial,
fare numeric
)