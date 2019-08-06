CREATE DATABASE scoped_news_api;
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
    departmentId VARCHAR,
);


CREATE TABLE IF NOT EXISTS news (
    id int PRIMARY KEY auto_increment,
    content  VARCHAR,
    departmentId INTEGER,

);
CREATE TABLE IF NOT EXISTS departmentUsers (
    id int PRIMARY KEY auto_increment,
    userid INTEGER,
    departmentid INTEGER,

);


-- CREATE DATABASE scoped_news_api_test WITH TEMPLATE scoped_news_api;
