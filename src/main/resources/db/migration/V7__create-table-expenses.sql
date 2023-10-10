create table expenses (
	"id" serial primary key,
	"name" varchar(255) unique not null,
	"observation" text,
	"requested_value" float not null,
	"paid_value" float default 0 not null,
	"provisioned_value" float,
	"creation_date" date not null,
	"expected_payment_date" date,
	"requester" varchar(255),
	"group_id" int not null,
	"category_id" int not null,
	"balance_id" int,
	"declarant_id" int not null,
	foreign key ("group_id")
		references groups ("id"),
	foreign key ("category_id")
		references categories ("id"),
	foreign key ("balance_id")
		references balances ("id"),
	foreign key ("declarant_id")
		references users ("id")
);