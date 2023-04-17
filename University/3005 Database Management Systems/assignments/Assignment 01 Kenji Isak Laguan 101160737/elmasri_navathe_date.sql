PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;

DROP TABLE IF EXISTS EMPLOYEE;
DROP TABLE IF EXISTS DEPARTMENT;
DROP TABLE IF EXISTS DEPT_LOCATIONS;
DROP TABLE IF EXISTS PROJECT;
DROP TABLE IF EXISTS WORKS_ON;
DROP TABLE IF EXISTS DEPENDENT;

CREATE TABLE EMPLOYEE(
      fname text NOT NULL, --first name
      minit text NOT NULL, --middle initial 
      lname text NOT NULL, --last name
      ssn text primary key not null, --employee social security number PRIMARY KEY
      bdate text NOT NULL, --birthday 
      address text NOT NULL, --address
      sex text NOT NULL, --gender
      salary integer NOT NULL, --money u make
      superssn integer default NULL, --manager social security number 
      dno integer NOT NULL --department number
      );

INSERT INTO EMPLOYEE VALUES('John','B','Smith',123456789,'9-Jan-55','731 Fondern','M',30000,333445555,5);
INSERT INTO EMPLOYEE VALUES('Franklin','T','Wong',333445555,'8-Dec-45','638 Voss','M',40000,888665555,5);
INSERT INTO EMPLOYEE VALUES('Alicia','J','Zelaya',999887777,'19-Jul-58','3321 Castle','F',25000,987987987,4);
INSERT INTO EMPLOYEE VALUES('Jennifer','S','Wallace',987654321,'20-Jun-31','291 Berry','F',43000,888665555,4);
INSERT INTO EMPLOYEE VALUES('Ramesh','K','Narayan',666884444,'15-Sep-52','975 Fire Oak','M',38000,333445555,5);
INSERT INTO EMPLOYEE VALUES('Joyce','A','English',453453453,'31-Jul-62','5631 Rice','F',25000,333445555,5);
INSERT INTO EMPLOYEE VALUES('Ahmad','V','Jabber',987987987,'29-Mar-59','980 Dallas','M',25000,987654321,4);
INSERT INTO EMPLOYEE (fname,minit,lname,ssn,bdate,address,sex,salary,dno) VALUES('James','E','Borg',888665555,'10-Nov-27','450 Stone','M',55000,1);

CREATE TABLE DEPARTMENT(
      dname text primary key not null, --department name PRIMARY KEY
      dnumber integer NOT NULL, --department number
      mgrssn integer default NULL, --manager social security number 
      mgrstartdate text NOT NULL --manager start date
      );

INSERT INTO DEPARTMENT VALUES('Research',5,333445555,'22-May-78');
INSERT INTO DEPARTMENT VALUES('Administration',4,987654321,'1-Jan-85');
INSERT INTO DEPARTMENT VALUES('Headquarters',1,888665555,'19-Jun-71');

CREATE TABLE DEPT_LOCATIONS(
      dnumber integer NOT NULL, --department number
      dlocation text NOT NULL, --department location
      PRIMARY KEY (dnumber, dlocation) --compound key department number and department location
      );

INSERT INTO DEPT_LOCATIONS VALUES(1,'Houston');
INSERT INTO DEPT_LOCATIONS VALUES(4,'Stafford');
INSERT INTO DEPT_LOCATIONS VALUES(5,'Bellaire');
INSERT INTO DEPT_LOCATIONS VALUES(5,'Sugarland');
INSERT INTO DEPT_LOCATIONS VALUES(5,'Houston');

CREATE TABLE PROJECT(
      pname text NOT NULL, --project name
      pnumber integer primary key not null, --project number PRIMARY KEY 
      plocation text NOT NULL, --project location
      dnum integer NOT NULL --department number
      ); 

INSERT INTO PROJECT VALUES('ProductX',1,'Bellaire',5);
INSERT INTO PROJECT VALUES('ProductY',2,'Sugarland',5);
INSERT INTO PROJECT VALUES('ProductZ',3,'Houston',5);
INSERT INTO PROJECT VALUES('Computerization',10,'Stafford',4);
INSERT INTO PROJECT VALUES('Reorganization',20,'Houston',1);
INSERT INTO PROJECT VALUES('NewBenefits',30,'Stafford',4);

CREATE TABLE WORKS_ON(
      essn integer NOT NULL, --employee social security number
      pno integer NOT NULL, --project number
      hours text default NULL, --hours worked 
      PRIMARY KEY (essn, pno) --coumpound key employee social security number and project number
      ); 

INSERT INTO WORKS_ON VALUES(123456789,1,32.50);
INSERT INTO WORKS_ON VALUES(123456789,2,7.50);
INSERT INTO WORKS_ON VALUES(666884444,3,40.00);
INSERT INTO WORKS_ON VALUES(453453453,1,20.00);
INSERT INTO WORKS_ON VALUES(453453453,2,20.00);
INSERT INTO WORKS_ON VALUES(333445555,2,10.00);
INSERT INTO WORKS_ON VALUES(333445555,3,10.00);
INSERT INTO WORKS_ON VALUES(333445555,10,10.00);
INSERT INTO WORKS_ON VALUES(333445555,20,10.00);
INSERT INTO WORKS_ON VALUES(999887777,30,30.00);
INSERT INTO WORKS_ON VALUES(999887777,10,10.00);
INSERT INTO WORKS_ON VALUES(987987987,10,35.00);
INSERT INTO WORKS_ON VALUES(987987987,30,5.00);
INSERT INTO WORKS_ON VALUES(987654321,30,20.00);
INSERT INTO WORKS_ON VALUES(987654321,20,15.00);
INSERT INTO WORKS_ON (essn,pno) VALUES(888665555,20);

CREATE TABLE DEPENDENT(
      essn integer NOT NULL, --employee social security number
      dpendent_name text NOT NULL, --dependent name
      sex text NOT NULL, --gender
      bdate text NOT NULL, --birthday 
      relationship text NOT NULL, --family relation
      PRIMARY KEY (essn, dpendent_name) --compound key employee social security number and dependent name
      );

INSERT INTO DEPENDENT VALUES(333445555,'Alice','F','5-April-76','DAUGHTER');
INSERT INTO DEPENDENT VALUES(333445555,'Theodore','M','25-Oct-73','SON');
INSERT INTO DEPENDENT VALUES(333445555,'Joy','F','3-May-48','SPOUSE');
INSERT INTO DEPENDENT VALUES(987654321,'Abner','M','29-Feb-32','SPOUSE');
INSERT INTO DEPENDENT VALUES(123456789,'Michael','M','1-Jan-78','SON');
INSERT INTO DEPENDENT VALUES(123456789,'Alice','F','31-Jan-78','DAUGHTER');
INSERT INTO DEPENDENT VALUES(123456789,'Elizabeth','F','5-May-57','SPOUSE');

COMMIT;
