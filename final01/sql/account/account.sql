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
 
 INSERT INTO ACCOUNT(ACCOUNTID, PASSWORD, NAME, EMAIL, ADDRESS,PHONE,BIRTH,ADMIN,FILENAME,LOCATION,URL)
     VALUES('user', 'user', 'steven', 'kh@com.kr','경기도 ','010-1234-1234','19921204','N','HONG','경기도 ','XXX' );
 
     
SELECT * FROM ACCOUNT;
DROP TABLE ACCOUNT;