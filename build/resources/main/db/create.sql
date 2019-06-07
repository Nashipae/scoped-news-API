SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
  id int PRIMARY KEY auto_increment,
  name  VARCHAR,
  description VARCHAR,
  employeeCount INTEGER,
  createdAt BIGINT,
);
CREATE TABLE IF NOT EXISTS users (
    id int PRIMARY KEY auto_increment,
    staff_name  VARCHAR,
    staff_role VARCHAR,
    staff_position INTEGER,
    department VARCHAR,

);


