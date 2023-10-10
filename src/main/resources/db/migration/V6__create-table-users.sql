create table users (
	"id" serial primary key,
	"name" varchar(255) not null,
	"nusp" varchar(255) unique not null,
	"profile_id" int not null,
	foreign key ("profile_id") 
		references profiles ("id")
);