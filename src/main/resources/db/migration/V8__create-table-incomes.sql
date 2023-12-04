create table incomes (
	"id" serial primary key,
	"name" varchar(255) unique not null,
	"observation" text,
	"value" float default 0 not null,
	"creation_date" date not null,
	"group_id" int not null,
	"balance_id" int not null,
	"declarant_id" int not null,
	foreign key ("group_id")
		references groups ("id"),
	foreign key ("balance_id")
		references balances ("id"),
	foreign key ("declarant_id")
		references users ("id")
);