CREATE DATABASE IF NOT EXISTS school_management_system_db;

USE school_management_system_db;


DROP TABLE IF EXISTS Submission;
DROP TABLE IF EXISTS Assignment;
DROP TABLE IF EXISTS Teach;
DROP TABLE IF EXISTS Enroll;
DROP TABLE IF EXISTS Section;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Faculty;
DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS User;

CREATE TABLE User (
    userID int NOT NULL,
    password char(68),
    firstName varchar(50),
    lastName varchar(50),
    address varchar(255),
    age int,
    sex char(1),
    role varchar(50),
    enabled tinyint(4) DEFAULT NULL,
    primary key (userID)
);

CREATE TABLE Admin (
    adminID int,
    primary key (adminID),
    foreign key (adminID) references User(userID) on delete cascade
);

CREATE TABLE Faculty (
    facultyID int,
    primary key (facultyID),
    foreign key (facultyID) references User(userID) on delete cascade
);

CREATE TABLE Student (
    studentID int,
    primary key (studentID),
    foreign key (studentID) references User(userID) on delete cascade
);

CREATE TABLE Course (
	courseID int,
    courseName varchar(255),
    courseCredit int,
    courseDescription text, 
    primary key (courseID)
);

CREATE TABLE Section (
	sectionID int,
    courseID int,
    academicYear int,
    primary key (sectionID),
    foreign key (courseID) references Course(courseID) on delete cascade
);

CREATE TABLE Enroll (
	studentID int,
	sectionID int,
    enrollDate datetime,
    enrollGrade char(1),
    primary key (studentID, sectionID),
    foreign key (studentID) references Student(studentID) on delete cascade,
    foreign key (sectionID) references Section(sectionID) on delete cascade
);

CREATE TABLE Teach (
	facultyID int,
	sectionID int,
    assignedDate datetime,
    primary key (facultyID, sectionID),
    foreign key (facultyID) references Faculty(facultyID) on delete cascade,
    foreign key (sectionID) references Section(sectionID) on delete cascade
);

CREATE TABLE Assignment (
	assignmentID int NOT NULL AUTO_INCREMENT,
    sectionID int,
    assignmentGrade int,
    assignmentName varchar(255),
    assignmentDescription varchar(255),
	primary key (assignmentID),
    foreign key (sectionID) references Section(sectionID) on delete cascade
);

CREATE TABLE AssignmentStudentGrade (
	assignmentID int,
    studentID int,
    assignmentStudentGrade int,
	primary key (assignmentID, studentID),
    foreign key (assignmentID) references Assignment(assignmentID) on delete cascade,
    foreign key (studentID) references Enroll(studentID) on delete cascade
);

CREATE TABLE Submission (
	submissionID int NOT NULL AUTO_INCREMENT,
	studentID int,
    assignmentID int,
    submissionGrade int,
    submissionText varchar(255),
    submissionDate datetime,
    primary key (submissionID),
    foreign key (studentID) references Student(studentID) on delete cascade,
    foreign key (assignmentID) references Assignment(assignmentID) on delete cascade
);