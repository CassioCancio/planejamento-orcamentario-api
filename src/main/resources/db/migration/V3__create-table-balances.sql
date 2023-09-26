create table units (
	"id" serial primary key,
	"startDate" timestamp not null,
	"endDate" timestamp not null,
	"year" bigint not null
);