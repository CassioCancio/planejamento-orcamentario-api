create table profiles (
	"id" serial primary key,
	"type" varchar(255) check ("type" in ('DECLARANT', 'GRS', 'OTHER')) not null unique
);