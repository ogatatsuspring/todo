drop table if exists todos;
drop table if exists authentications;
drop type if exists role;



create type role as enum( 'ADMIN', 'USER' );



create table todos(
	id serial primary key,
	todo varchar( 255 ) not null,
	detail text,
	created_at timestamp without time zone,
	updated_at timestamp without time zone
);



create table authentications (
	username varchar( 50 ) primary key,
	password varchar( 255 ) not null,
	authority role not null
);
