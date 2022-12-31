DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;

CREATE TABLE `customer` (
  `id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `create_on` date DEFAULT NULL
);

CREATE TABLE `account` (
  `account_number` int AUTO_INCREMENT  PRIMARY KEY,
  `customer_id` int NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `create_on` date DEFAULT NULL
);

INSERT INTO `customer` (`name`,`email`,`mobile_number`,`create_on`)
 VALUES ('Mohamed Aymen Charrada','anchtun@gmail.com','00966541832634',CURDATE());
 
INSERT INTO `account` (`account_number`, `customer_id`, `account_type`, `branch_address`, `create_on`)
 VALUES (186576453, 1, 'SAVINGS', '123  Street 6, Riyadh', CURDATE());