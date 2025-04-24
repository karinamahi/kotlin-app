-- public.book definition

-- Drop table

-- DROP TABLE public.book;

CREATE TABLE public.book (
	id bigserial NOT NULL,
	title varchar(255) NOT NULL,
	subtitle varchar(255) NOT NULL,
	publisher varchar(255) NOT NULL,
	CONSTRAINT book_pkey PRIMARY KEY (id)
);