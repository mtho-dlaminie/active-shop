DROP TABLE IF EXISTS customer CASCADE;
CREATE TABLE customer
(
    id      serial PRIMARY KEY NOT NULL,
    name            character varying,
    active_days_points smallint

);

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
    code          serial PRIMARY KEY NOT NULL,
    name          character varying  NOT NULL,
    cost          smallint           NOT NULL


);

insert into customer
values (1, 'Erlic Bachman',200),
       (2, 'Jin Yang',0);

insert into product
values (1, 'Burger',40),
(2, 'Chicken fillet',40),
(3, 'Sippy Sherbet',20),
(4, 'Sparkling Water',5);