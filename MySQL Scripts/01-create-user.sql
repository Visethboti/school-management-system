CREATE USER 'schoolmanagementsystem'@'localhost' IDENTIFIED BY 'schoolmanagementsystem';

GRANT ALL PRIVILEGES ON * . * TO 'schoolmanagementsystem'@'schoolmanagementsystem';

#
# Starting with MySQL 8.0.4, the MySQL team changed the 
# default authentication plugin for MySQL server 
# from mysql_native_password to caching_sha2_password.
#
# The command below will make the appropriate updates for your user account.
#
# See the MySQL Reference Manual for details: 
# https://dev.mysql.com/doc/refman/8.0/en/caching-sha2-pluggable-authentication.html
#
ALTER USER 'schoolmanagementsystem'@'schoolmanagementsystem' IDENTIFIED WITH mysql_native_password BY 'schoolmanagementsystem2022'; #this is for changing password to "hbstudent"