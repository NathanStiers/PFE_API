DROP SCHEMA public
CREATE SCHEMA public

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

ALTER TABLE public."Categories"
    OWNER to smgnrtsxjzzkks;
	
CREATE TABLE public."Users"
(
    "Name" character varying COLLATE pg_catalog."default" NOT NULL,
    "Surname" character varying COLLATE pg_catalog."default" NOT NULL,
    "Code" character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Users_pkey" PRIMARY KEY ("Code")
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."Users"
    OWNER to smgnrtsxjzzkks;
	
CREATE TABLE public."Items"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Category" integer NOT NULL,
    "Image" character varying COLLATE pg_catalog."default" NOT NULL,
    "Name" character varying COLLATE pg_catalog."default" NOT NULL,
    "Favorite" boolean NOT NULL DEFAULT false,
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
	
	
CREATE TABLE public."Sheets_items"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Sheet_id" integer NOT NULL,
    "Item_id" integer NOT NULL,
    "Love_it" boolean,
    "Need_help" boolean,
    "Wanna_change" boolean,
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