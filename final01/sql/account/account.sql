/**
 *  ACCOUNT 스키마
 */


 CREATE TABLE ACCOUNT (
              ACCOUNTID VARCHAR2(50) PRIMARY KEY
             ,PASSWORD  VARCHAR2(50) NOT NULL
             ,NAME      VARCHAR2(50) NOT NULL
             ,EMAIL     VARCHAR2(50) NOT NULL
             ,ADDRESS   VARCHAR2(100)
             ,PHONE     VARCHAR2(15)
             ,BIRTH     DATE
             ,ADMIN     VARCHAR2(1) CHECK(ADMIN IN('Y', 'N'))
             ,FILENAME  VARCHAR2(200)
             ,LOCATION  VARCHAR2(500)
             ,URL       VARCHAR2(500)  
 );
 
SELECT * FROM ACCOUNT;
DROP TABLE ACCOUNT;