DROP TABLE IF EXISTS loan;

CREATE TABLE `loan` (
  `number` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `start_on` date NOT NULL,
  `type` varchar(100) NOT NULL,
  `total_loan` int NOT NULL,
  `amount_paid` int NOT NULL,
  `outstanding_amount` int NOT NULL,
  `create_on` date DEFAULT NULL,
  PRIMARY KEY (`number`)
);

INSERT INTO `loan` ( `customer_id`, `start_on`, `type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_on`)
 VALUES ( 1, CURDATE()-250, 'HOME', 200000, 50000, 150000, CURDATE()-250);
 
INSERT INTO `loan` ( `customer_id`, `start_on`, `type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_on`)
 VALUES ( 1, CURDATE()-376, 'VEHICLE', 40000, 10000, 30000, CURDATE()-376);
 
INSERT INTO `loan` ( `customer_id`, `start_on`, `type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_on`)
 VALUES ( 1, CURDATE()-549, 'HOME', 50000, 10000, 40000, CURDATE()-549);

INSERT INTO `loan` ( `customer_id`, `start_on`, `type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_on`)
 VALUES ( 1, CURDATE()-122, 'PERSONAL', 10000, 3500, 6500, CURDATE()-122);