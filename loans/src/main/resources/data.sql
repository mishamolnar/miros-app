DROP TABLE IF EXISTS loan;

CREATE TABLE `loan` (
                         `loan_id` int NOT NULL,
                         `customer_id` int NOT NULL,
                         `start_dt` date NOT NULL,
                         `loan_type` varchar(100) NOT NULL,
                         `total_loan` int NOT NULL,
                         `amount_paid` int NOT NULL,
                         `outstanding_amount` int NOT NULL,
                         `create_dt` date DEFAULT NULL,
                         PRIMARY KEY (`loan_id`)
);

create index c_id on `loan`(`customer_id`);

INSERT INTO `loan` (`loan_id`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES (1, 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');

INSERT INTO `loan` (`loan_id`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES (2, 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');

INSERT INTO `loan` (`loan_id`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES (3, 1, '2021-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO `loan` (`loan_id`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`)
VALUES (4, 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');