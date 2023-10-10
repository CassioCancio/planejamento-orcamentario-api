create table units (
	"id" serial primary key,
	"name" varchar(255) unique not null,
	"code" varchar(255) unique not null
);