DROP TABLE IF EXISTS card;

CREATE TABLE `card` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(100) NOT NULL,
  `customer_id` int NOT NULL,
  `type` varchar(100) NOT NULL,
  `total_limit` int NOT NULL,
  `amount_used` int NOT NULL,
  `available_amount` int NOT NULL,
  `create_on` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `card` (`number`, `customer_id`, `type`, `total_limit`, `amount_used`, `available_amount`, `create_on`)
 VALUES ('4565XXXX4656', 1, 'CREDIT', 10000, 500, 9500, CURDATE());

INSERT INTO `card` (`number`, `customer_id`, `type`, `total_limit`, `amount_used`, `available_amount`, `create_on`)
 VALUES ('3455XXXX8673', 1, 'CREDIT', 7500, 600, 6900, CURDATE());
 
INSERT INTO `card` (`number`, `customer_id`, `type`, `total_limit`, `amount_used`, `available_amount`, `create_on`)
 VALUES ('2359XXXX9346', 1, 'CREDIT', 20000, 4000, 16000, CURDATE());