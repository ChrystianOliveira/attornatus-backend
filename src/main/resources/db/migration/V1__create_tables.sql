CREATE SCHEMA IF NOT EXISTS attornatus;

CREATE TABLE attornatus.tb_person
(
    id_person uuid not null,
    name character varying(100),
    birth_date date,
    id_address_main uuid,
    primary key (id_person)
);

CREATE TABLE attornatus.tb_address
(
    id_address uuid not null,
    street_name character varying(100),
    zip_code character varying(8),
    number character varying(10),
    city character varying(50),
    id_person uuid,
    primary key (id_address),
    constraint tb_address_id_person_fk foreign key (id_person) references attornatus.tb_person (id_person)
);

ALTER TABLE attornatus.tb_person ADD constraint tb_person_id_address_main_fk foreign key (id_address_main) references attornatus.tb_address (id_address);