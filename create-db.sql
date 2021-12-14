create table wikidata ( node varchar(20), language varchar(10), label text, description text, wikipedia_title text, wikipedia_description text);
create table links ( node varchar(20), language varchar(10), inlink_title text, context text, updated_by varchar(50), updated_time timestamp,
response varchar(10));