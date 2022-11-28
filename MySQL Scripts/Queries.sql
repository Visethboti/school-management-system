#select * from Teach, Section where Teach.facultyID = 2 && Teach.sectionID = Section.sectionID

# get all from teach where the specific facultyID is, and this teach exist in the table Section
#select * from Teach where Teach.facultyID = 2 and exists (select * from Section);

# get all from section, condition same as above
#select * from Section where Section.sectionID IN  (select Teach.sectionID from Teach where Teach.facultyID = 2);

#select count(Enroll.studentID) from Enroll where Enroll.sectionID = 101;

select * from User where User.userID in (select Enroll.studentID from Enroll where Enroll.sectionID = 100)