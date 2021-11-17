create table nodes ( id varchar(20) primary key);
create table titles ( node varchar(20), lan varchar(10), text varchar(1000) );
create table inlinks ( node varchar(20), lan varchar(10), title varchar(1000), mention varchar(10000));

