-- Drop user first if they exist 
DROP USER if exists 'springstudent'@'localhost';

-- Now create user with prop previliges
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

GRANT ALL privileges on * . * TO 'springstudent'@'localhost';