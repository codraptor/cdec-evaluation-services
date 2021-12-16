create table wikidata ( node varchar(20), language varchar(10), wikipedia_title text, wikipedia_description text);
create table links ( id varchar(50), node varchar(20), language varchar(10), inlink_title text, context text, updated_by varchar(50), updated_time timestamp,
response varchar(10));
create table user_languages( user_id varchar(50), language varchar(10), created_time timestamp, created_by varchar(50));
create table user_details ( user_id varchar(50), first_name varchar(100), last_name varchar(100), username varchar(100),
 password varchar(100), updated_time timestamp );