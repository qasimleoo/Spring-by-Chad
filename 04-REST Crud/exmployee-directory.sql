CREATE database if not exists `employee_directory`;
use `employee_directory`;

--

drop table if exists `employee`;

create table `employee`(
	`id` int not null auto_increment,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null, 
    primary key (`id`)
) Engine=InnoDB auto_increment= 3 default charset=latin1;

-- Data for table `employee`

insert into `employee` values
	(1,'Qasim', 'Ali' ,'qasim@jfreaks.com'),
    (5,'Nimal', 'Yuvi' ,'yuvi@jfreaks.com'),
    (43,'Hajra', 'Singh' ,'singh@jfreaks.com'),
    (2,'Tayyab', 'Ujal' ,'ujal@jfreaks.com'),
    (14,'Ram', 'Shinal' ,'ram@jfreaks.com');
    
    
    