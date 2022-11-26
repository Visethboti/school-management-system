CREATE DATABASE IF NOT EXISTS school_management_system_db;

USE school_management_system_db;


DROP TABLE IF EXISTS Submission;
DROP TABLE IF EXISTS Assignment;
DROP TABLE IF EXISTS Teaching;
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
    foreign key (adminID) references User(userID)
);

CREATE TABLE Faculty (
    facultyID int,
    primary key (facultyID),
    foreign key (facultyID) references User(userID)
);

CREATE TABLE Student (
    studentID int,
    primary key (studentID),
    foreign key (studentID) references User(userID)
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
    acamedicYear int,
    primary key (sectionID),
    foreign key (courseID) references Course(courseID)
);

CREATE TABLE Enroll (
	studentID int,
	sectionID int,
    enrollDate date,
    enrollGrade char(1),
    primary key (studentID, sectionID),
    foreign key (studentID) references Student(studentID),
    foreign key (sectionID) references Section(sectionID)
);

CREATE TABLE Teaching (
	facultyID int,
	sectionID int,
    primary key (facultyID, sectionID),
    foreign key (facultyID) references Faculty(facultyID),
    foreign key (sectionID) references Section(sectionID)
);

CREATE TABLE Assignment (
	assignmentID int NOT NULL AUTO_INCREMENT,
    sectionID int,
    assignmentFile varchar(255),
     primary key (assignmentID),
    foreign key (sectionID) references Section(sectionID)
);

CREATE TABLE Submission (
	studentID int,
    sectionID int,
    assignmentID int,
    assignmentSubmission varchar(255),
    primary key (studentID, sectionID, assignmentID),
    foreign key (studentID) references Student(studentID),
    foreign key (sectionID) references Section(sectionID),
    foreign key (assignmentID) references Assignment(assignmentID)
);