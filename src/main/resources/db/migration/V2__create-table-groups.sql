create table groups (
	"id" serial primary key,
	"name" varchar(255) unique not null,
	"number" bigint  not null
);