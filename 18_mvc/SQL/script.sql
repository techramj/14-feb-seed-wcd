drop table users;

CREATE TABLE USERS
(user_id VARCHAR2(20) PRIMARY KEY,
 first_name VARCHAR2(20),
 last_name VARCHAR2(20),
 email VARCHAR2(30),
 PASSWORD VARCHAR2(20),
 password_exp_date DATE,
 created DATE DEFAULT SYSDATE,
 last_update DATE
 );
 
 INSERT INTO USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD_EXP_DATE)
 VALUES ('gaurim','Gauri','Majumdar','g1@gmail.com','123',SYSDATE-2);
  
  INSERT INTO USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD_EXP_DATE)
 VALUES ('gaurig','Gauri','Majumdar','g2@gmail.com','123',SYSDATE+2);
 
  INSERT INTO USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD_EXP_DATE)
 VALUES ('jessica','Jessica','J','g3@gmail.com','123',SYSDATE+2);
  
  INSERT INTO USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD_EXP_DATE)
 VALUES ('john','Jackson','John','g4@gmail.com','123',SYSDATE-20);
 
 
 commit;