DROP TABLE IF EXISTS bsm_books CASCADE;
DROP SEQUENCE IF EXISTS  bsm_books_seq;


CREATE SEQUENCE bsm_books_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE bsm_books (id integer not null, page_count integer, published_date timestamp(6) with time zone, isbn varchar(255), short_description varchar2(500), thumbnail_url varchar(255), title varchar(255), authors varchar(255) array, categories varchar(255) array, primary key (id))