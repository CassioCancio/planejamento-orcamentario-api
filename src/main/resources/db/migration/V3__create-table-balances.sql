create table balances (
	"id" serial primary key,
	"start_date" timestamp not null,
	"end_date" timestamp not null,
	"year" bigint not null
);