USE school_management_system_db;

INSERT INTO User (userID, password, firstName, lastName, address, age, sex, role, enabled)
VALUES (11, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Visethboti", "Sin", "127 14th AVE S Suite 3A", 22, "M", "ROLE_ADMIN", 1),
		(12, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Robert", "Duncan", "127 14th AVE S Suite 3A", 28, "M", "ROLE_ADMIN", 1),
        (13, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Sarah", "Scarlett", "127 14th AVE S Suite 3A", 30, "F", "ROLE_ADMIN", 1),
		(101, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Freddy", "Tillery", "127 14th AVE S Suite 3A", 45, "M", "ROLE_FACULTY", 1),
        (102, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Leon", "Hopkins", "127 14th AVE S Suite 3A", 41, "M", "ROLE_FACULTY", 1),
        (103, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Jose", "Mora", "127 14th AVE S Suite 3A", 48, "M", "ROLE_FACULTY", 1),
        (104, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Zhiko", "Nedev", "127 14th AVE S Suite 3A", 55, "M", "ROLE_FACULTY", 1),
        (105, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Thomas", "Caraham", "127 14th AVE S Suite 3A", 49, "M", "ROLE_FACULTY", 1),
		(201, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Erin", "Wood", "127 14th AVE S Suite 3A", 20, "F", "ROLE_STUDENT", 1),
        (202, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Emma", "Watt", "127 14th AVE S Suite 3A", 21, "F", "ROLE_STUDENT", 1),
        (203, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Matthew", "Murphy", "127 14th AVE S Suite 3A", 24, "M", "ROLE_STUDENT", 1),
        (204, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Cody", "Luna", "127 14th AVE S Suite 3A", 25, "M", "ROLE_STUDENT", 1),
        (205, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Edward", "Simpson", "127 14th AVE S Suite 3A", 19, "M", "ROLE_STUDENT", 1),
        (206, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Oliver", "Decker", "127 14th AVE S Suite 3A", 20, "M", "ROLE_STUDENT", 1),
        (207, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Kale", "Barlow", "127 14th AVE S Suite 3A", 25, "M", "ROLE_STUDENT", 1),
        (208, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Zara", "Kelly", "127 14th AVE S Suite 3A", 21, "f", "ROLE_STUDENT", 1),
        (209, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Alicia", "Berg", "127 14th AVE S Suite 3A", 26, "F", "ROLE_STUDENT", 1),
        (210, "{bcrypt}$2a$10$VtqsdHpo9UjpHa6JDkNSuOXMqruBKfyKBvD3i2sAE1twdTdFPyqee", "Lucas", "Booth", "127 14th AVE S Suite 3A", 28, "M", "ROLE_STUDENT", 1);

INSERT INTO Admin (adminID)
values (11),
		(12),
        (13);
        
INSERT INTO Faculty (facultyID)
values (101),
		(102),
        (103),
        (104),
        (105);
        
INSERT INTO Student (studentID)
values (201),
		(202),
        (203),
        (204),
        (205),
        (206),
        (207),
        (208),
        (209),
        (210);
        
INSERT INTO Course (courseID, courseName, courseCredit, courseDescription)
values (610, "Advanced Operating Systems", 3, "Theory of distributed operating system, process synchronization and security."),
		(260, "Programming in C", 3, "Study of the C programming language and it applications."),
        (543, "Evolutionary Computation", 3, "Search heuristics using population-based. The study of the theories, strategies and parameters."),
        (504, "Design and Analysis of Algorithms", 3, "Computation time complexsity; the study of time complexsity growth of various algorithms"),
        (511, "Database Theory and Design", 3, "Princples of relational database system, the design, theory and application"),
        (530, "Object-Oriented Software Development", 3, "Princples and techniques in designing object oriented softwater. Study of design patterns and the development of a project"),
        (262, "Programming in Java", 3, "Study of the Java programming language features.");
        
INSERT INTO Section (sectionID, courseID, academicYear)
values (61001, 610, 2021),
		(61002, 610, 2022),
        (26001, 260, 2021),
        (54301, 543, 2018),
        (50401, 504, 2019),
        (51101, 511, 2021),
        (53001, 530, 2020),
        (53002, 530, 2022);

INSERT INTO Enroll (studentID, sectionID, enrollDate, enrollGrade)
values (201, 61001, NOW(), 'A'),
		(202, 61001, NOW(), 'B'),
        (203, 61001, NOW(), 'B'),
        (204, 61001, NOW(), 'B'),
        (205, 61002, NOW(), 'A'),
        (206, 61002, NOW(), 'C'),
        (207, 61002, NOW(), 'A'),
        (201, 53001, NOW(), 'A'),
        (202, 53001, NOW(), 'A'),
        (203, 53001, NOW(), 'A'),
        (204, 53002, NOW(), 'A'),
        (205, 53002, NOW(), 'A'),
        (201, 50401, NOW(), 'A'),
        (202, 50401, NOW(), 'A'),
        (203, 50401, NOW(), 'B'),
		(204, 50401, NOW(), 'A'),
		(205, 50401, NOW(), 'A'),
		(206, 50401, NOW(), 'A'),
		(207, 50401, NOW(), 'A'),
		(201, 26001, NOW(), 'A'),
        (202, 26001, NOW(), 'B'),
        (203, 26001, NOW(), 'B'),
        (206, 51101, NOW(), 'A'),
        (207, 51101, NOW(), 'C'),
        (208, 51101, NOW(), 'C'),
        (209, 51101, NOW(), 'B');
        
INSERT INTO Teach (facultyID, sectionID, assignedDate)
values (101, 61001, NOW()),
		(101, 61002, NOW()),
        (101, 53001, NOW()),
        (101, 53002, NOW()),
        (102, 50401, NOW()),
        (103, 26001, NOW()),
        (103, 51101, NOW());

INSERT INTO Assignment (assignmentID, sectionID, assignmentGrade, assignmentName, assignmentDescription)
values (1, 61001, 50, "Assignment 1", "What time is it?"),
	(2, 61001, 50, "Assignment 2", "What is your name?"),
	(3, 61001, 100, "Assignment 3", "What is kernel?"),
    (4, 61001, 100, "Assignment 4", "What are the benefits of a multiprocessor system?"),
    (5, 61002, 100, "Assignment 1", "What time is it?"),
    (6, 61002, 100, "Assignment 2", "How old are you?"),
    (7, 53001, 100, "Assignment 1", "Describe the Layered Architecture Pattern."),
    (8, 53001, 100, "Assignment 2", "What is the different between a behavorial and a structural design pattern?"),
    (9, 53001, 100, "Assignment 3", "Describe the SOLID principles."),
    (10, 53002, 100, "Assignment 1", "Describe the Layered Architecture Pattern.");
    
INSERT INTO assignmentstudentgrade (assignmentID, studentID, assignmentStudentGrade)
values (1, 201, 0),
		(1, 202, 0),
        (1, 203, 0),
        (1, 204, 0),
        (2, 201, 0),
		(2, 202, 0),
        (2, 203, 0),
        (2, 204, 0),
        (3, 201, 0),
		(3, 202, 0),
        (3, 203, 0),
        (3, 204, 0),
        (4, 201, 0),
		(4, 202, 0),
        (4, 203, 0),
        (4, 204, 0),
        (5, 205, 0),
        (5, 206, 0),
        (5, 207, 0),
        (6, 205, 0),
        (6, 206, 0),
        (6, 207, 0),
        (7, 201, 0),
        (7, 202, 0),
        (7, 203, 0),
        (8, 201, 0),
        (8, 202, 0),
        (8, 203, 0),
        (9, 201, 0),
        (9, 202, 0),
        (9, 203, 0),
        (10, 204, 0),
        (10, 205, 0);
        
INSERT INTO Submission (submissionID, studentID, assignmentID, submissionGrade, submissionText, submissionDate)
values (1, 201, 1, 0, "It is time to go home.", NOW()),
		(2, 201, 1, 0, "It's 4 PM.", NOW()),
        (3, 201, 1, 0, "It's 4:30 PM Tuesday 10th of Jan 2023.", NOW()),
        (4, 202, 1, 0, "The time is 3:50 PM", NOW()),
        (5, 203, 1, 0, "The time is 3:50 PM", NOW());
        