SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
  id int PRIMARY KEY auto_increment,
  name  VARCHAR,
  description VARCHAR,
  employees_total integer,
  created timestamp,
);
CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY auto_increment,
    staff_name  VARCHAR,
    staff_role VARCHAR,
    staff_position integer,
    department VARCHAR,

);


