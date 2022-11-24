USE school_management_system_db;

#INSERT INTO User (password, firstName, lastName, address, age, sex, role, enabled)
#VALUES ("{noop}12345", "John", "Legend", "127 14th AVE S Suite 3A", 25, "M", "ROLE_STUDENT", 1);

INSERT INTO User (password, firstName, lastName, address, age, sex, role, enabled)
VALUES ("{noop}12345", "Admin", "Admin Last Name", "127 14th AVE S Suite 3A", 25, "M", "ROLE_ADMIN", 1),
		("{noop}12345", "Faculty", "Faculty Last Name", "127 14th AVE S Suite 3A", 25, "M", "ROLE_FACULTY", 1),
		("{noop}12345", "Student", "Student Last Name", "127 14th AVE S Suite 3A", 25, "M", "ROLE_STUDENT", 1);