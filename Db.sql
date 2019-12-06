DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

------------------ TABLE CATEGORIE ------------------

CREATE TABLE public."Categories"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Label" character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Categories_pkey" PRIMARY KEY ("Id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Categories" OWNER to smgnrtsxjzzkks;
	
------------------ TABLE PERSONNE_CONTACT ------------------
	
CREATE TABLE public."Contact_persons"
(
	"Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Name" character varying COLLATE pg_catalog."default" NOT NULL,
    "Surname" character varying COLLATE pg_catalog."default" NOT NULL,
    "Phone" character varying COLLATE pg_catalog."default" NOT NULL,
	"Email" character varying COLLATE pg_catalog."default" NOT NULL,
	"Relationship" character varying COLLATE pg_catalog."default" NOT NULL,
	
	
    CONSTRAINT "Contact_persons_pkey" PRIMARY KEY ("Id")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Contact_persons"
    OWNER to smgnrtsxjzzkks;

------------------ TABLE USERS ------------------

CREATE TABLE public."Users"
(
    "Name" character varying COLLATE pg_catalog."default" NOT NULL,
    "Surname" character varying COLLATE pg_catalog."default" NOT NULL,
    "Code" character varying COLLATE pg_catalog."default" NOT NULL,
	"Birthdate" date NOT NULL,
	"Language" character varying COLLATE pg_catalog."default" NOT NULL,
	"Dominance" character varying COLLATE pg_catalog."default" NOT NULL,
	"Schooling" character varying COLLATE pg_catalog."default" NOT NULL,
	"Schooling_type" character varying COLLATE pg_catalog."default" NULL,
	"Schooling_level" character varying COLLATE pg_catalog."default" NOT NULL,
	"Contact_one" integer NULL DEFAULT NULL,
	"Contact_two" integer NULL DEFAULT NULL,	
	"Contact_three" integer NULL DEFAULT NULL,
	
	
	
    CONSTRAINT "Users_pkey" PRIMARY KEY ("Code"),
	CONSTRAINT "Contact_one" FOREIGN KEY ("Contact_one") 
		REFERENCES public."Contact_persons" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "Contact_two" FOREIGN KEY ("Contact_two")
        REFERENCES public."Contact_persons" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "Contact_three" FOREIGN KEY ("Contact_three")
        REFERENCES public."Contact_persons" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
	
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Users"
    OWNER to smgnrtsxjzzkks;
	
------------------ TABLE BESOINS ------------------
	
CREATE TABLE public."Needs"
(
	"Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Child" character varying NOT NULL,
    "Need" character varying COLLATE pg_catalog."default" NOT NULL,
    
	
	
    CONSTRAINT "Needs_pkey" PRIMARY KEY ("Id"),
	CONSTRAINT "Child" FOREIGN KEY ("Child")
        REFERENCES public."Users" ("Code") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Needs"
    OWNER to smgnrtsxjzzkks;
	
------------------ TABLE PROFESSIONALS ------------------
	
CREATE TABLE public."Professionals"
(
	"Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Name" character varying COLLATE pg_catalog."default" NOT NULL,
    "Surname" character varying COLLATE pg_catalog."default" NOT NULL,
	"Profession" character varying COLLATE pg_catalog."default" NOT NULL,
	"Phone" character varying COLLATE pg_catalog."default" NOT NULL,
	"Email" character varying COLLATE pg_catalog."default" NOT NULL,
    "Mandate" character varying COLLATE pg_catalog."default" NOT NULL,
	"Mandate_date" date,
	"Initial_ask" character varying COLLATE pg_catalog."default" NOT NULL,
	
	CONSTRAINT "Professionals_pkey" PRIMARY KEY ("Id")
	
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Professionals"
    OWNER to smgnrtsxjzzkks;
	
------------------ TABLE USERS_PROFESSIONALS ------------------ 


CREATE TABLE public."Users_professionals"
(
	"Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "User" character varying NOT NULL,
    "Professional" integer NOT NULL,
    
	
	
    CONSTRAINT "Users_professionals_pkey" PRIMARY KEY ("Id"),
	CONSTRAINT "User" FOREIGN KEY ("User")
        REFERENCES public."Users" ("Code") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT "Professional" FOREIGN KEY ("Professional")
        REFERENCES public."Professionals" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Users_professionals"
    OWNER to smgnrtsxjzzkks;	
	
------------------ TABLE ITEMS ------------------
	
CREATE TABLE public."Items"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Category" integer NOT NULL,
    "Image" character varying COLLATE pg_catalog."default" NOT NULL,
    "Name" character varying COLLATE pg_catalog."default" NOT NULL,
	
    CONSTRAINT "Items_pkey" PRIMARY KEY ("Id"),
    CONSTRAINT "Category" FOREIGN KEY ("Category")
        REFERENCES public."Categories" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Items"
    OWNER to smgnrtsxjzzkks;
	
------------------ TABLE SHEETS ------------------

CREATE TABLE public."Sheets"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "User" character varying COLLATE pg_catalog."default" NOT NULL,
    "Date" date NOT NULL,
    CONSTRAINT "Sheets_pkey" PRIMARY KEY ("Id"),
    CONSTRAINT "User" FOREIGN KEY ("User")
        REFERENCES public."Users" ("Code") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Sheets"
    OWNER to smgnrtsxjzzkks;
	
------------------ TABLE SHEETS_ITEMS ------------------
	
CREATE TABLE public."Sheets_items"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Sheet_id" integer NOT NULL,
    "Item_id" integer NOT NULL,
    "Love_it" boolean,
    "Need_help" boolean,
    "Wanna_change" boolean,
	"Favorite" boolean NOT NULL DEFAULT false,

    CONSTRAINT "Sheets_items_pkey" PRIMARY KEY ("Id"),
    CONSTRAINT "Item_id" FOREIGN KEY ("Item_id")
        REFERENCES public."Items" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "Sheet_id" FOREIGN KEY ("Sheet_id")
        REFERENCES public."Sheets" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Sheets_items"
    OWNER to smgnrtsxjzzkks;