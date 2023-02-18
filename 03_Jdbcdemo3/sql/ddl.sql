create table student(rollno number primary key,
name varchar2(20) not null,
gender char 
);

create sequence seq_user start with 1000;

create table users(
userid number primary key,
user_name varchar2(20) unique,
first_name varchar2(20) not null,
last_name varchar2(20),
email varchar2(30) unique,
password varchar2(50),
password_expiry_date date,
created_date date default sysdate
);

create table emp(
id number primary key,
name varchar2(20),
salary number
);

create sequence emp_seq1
start with 100;