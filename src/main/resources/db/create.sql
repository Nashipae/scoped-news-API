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
    staffName  VARCHAR,
    staffRole VARCHAR,
    staffPosition INTEGER,
    department VARCHAR,

);
CREATE TABLE IF NOT EXISTS news (
    id int PRIMARY KEY auto_increment,
    content  VARCHAR,
    departmentContent VARCHAR,
    departmentId INTEGER,


);



