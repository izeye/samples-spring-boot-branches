create table customers (
  id integer GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  first_name varchar(255),
  last_name varchar(255)
);