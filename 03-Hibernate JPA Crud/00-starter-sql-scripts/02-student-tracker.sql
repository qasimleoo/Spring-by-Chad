CREATE DATABASE IF NOT EXISTS `student_tracker`;
USE `student_tracker`;

-- Here's the table structure for student

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student`(
	`id` INT NOT NULL auto_increment,
	`first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
	`email` varchar(45) default null,
    primary key (`id`)
)
engine=InnoDB auto_increment=1 default charset=latin5;