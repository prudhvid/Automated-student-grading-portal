Automated-student-grading-portal
================================

This is an automated software for student-teacher portal.The following are the main features of the software:
 Entering of the details of courses that a student has to do in each semester.
 Initial Student registration
 Student registration for a semester
 Grade entry by a teacher
 Semester tailoring by faculty adviser
 Display of grade sheet

It uses JPA with JavaDB for the database. I have created a localDb in my computer . If you have to create DB and run
the program then create a DB in your local system with the following specifications


//Database name is DEP
//and u can change this name from ur persistence.xml file
//Table for various Department storage
create table "DEP".DEPARTMENT
(
	NAME VARCHAR(50) not null,
	CODE CHAR(2) not null primary key,
	TOTALCOURSES INTEGER default 0 not null,
	PRES_YEAR INTEGER default 2009,
	STUD_NO INTEGER default 0,
	TOTALTEACHERS INTEGER default 1 not null
)


//Table for storing Courses
create table "DEP".COURSE
(
	NAME VARCHAR(50) not null,
	DEP CHAR(2) not null,
	TYPE CHAR(1) default 'true' not null,
	TEACHER_ID CHAR(6) not null,
	INSEM INTEGER,
	CREDIT INTEGER default 3 not null,
	CODE CHAR(5) default 'AAAAA' not null primary key
)

//Table for Electives
create table "DEP".ELECTIVES
(
	DEP CHAR(2) not null,
	NUM_ELECTIVES INTEGER default 0,
	SEM_NO INTEGER,
	SNO INTEGER default 1 not null primary key
)

create table "DEP".STUDENT
(
	NAME VARCHAR(50) not null,
	ROLL_NO CHAR(7) not null primary key,
	DEP CHAR(2) not null,
	PHONE NUMERIC(10) not null,
	ADDRESS LONG VARCHAR,
	PASSWORD VARCHAR(20) not null,
	INSEM INTEGER default 1 not null
)

create table "DEP".TEACHER
(
	ID CHAR(6) not null primary key,
	PASSWORD VARCHAR(20) not null,
	DEP CHAR(2) not null,
	NAME VARCHAR(30)
)

create table "DEP".GRADESHEET
(
	ROLL_NO CHAR(7) not null,
	GRADE INTEGER not null,
	TEACHERID CHAR(6) not null,
	COURSECODE CHAR(5) default '11111' not null,
	PRIM INTEGER default 1 not null primary key
)


create these tables and runnn :)
