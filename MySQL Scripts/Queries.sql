USE school_management_system_db;

#select * from Teach, Section where Teach.facultyID = 2 && Teach.sectionID = Section.sectionID

# get all from teach where the specific facultyID is, and this teach exist in the table Section
#select * from Teach where Teach.facultyID = 2 and exists (select * from Section);

# get all from section, condition same as above
#select * from Section where Section.sectionID IN  (select Teach.sectionID from Teach where Teach.facultyID = 2);

#select count(Enroll.studentID) from Enroll where Enroll.sectionID = 101;

#select * from User where User.userID in (select Enroll.studentID from Enroll where Enroll.sectionID = 100)

# select Enroll.studentID 
# from Enroll, Section, Assignment 
# where Enroll.sectionID = Section.sectionID and 
# Section.sectionID = Assignment.sectionID and 
# Assignment.assignmentID = 1;

# select * from AssignmentStudentGrade where AssignmentStudentGrade.assignmentID = 7 order by AssignmentStudentGrade.studentID

# select * from AssignmentStudentGrade where AssignmentStudentGrade.studentID = 201 and AssignmentStudentGrade.assignmentID in (select Assignment.assignmentID from Assignment where Assignment.sectionID = 53001)

# SELECT * FROM User ORDER BY User.userID LIMIT 0,5; 

# select * from User where  User.userID = 5 or User.firstName like "%seth%" or User.lastName like "%seth%" order by User.userID limit 0,5

select * from Section where Section.sectionID like "%530%";