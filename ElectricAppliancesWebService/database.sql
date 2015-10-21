-- Electric Appliances Database TDED

DROP TABLE IF EXISTS `bookProduct`;
DROP TABLE IF EXISTS `Orders`;
DROP TABLE IF EXISTS `product_available_on_warehouse`;
DROP TABLE IF EXISTS `product_exists_store`;
DROP TABLE IF EXISTS `WareHouse`;
DROP TABLE IF EXISTS `Store`;
DROP TABLE IF EXISTS `Cart`;
DROP TABLE IF EXISTS `Product`;
DROP TABLE IF EXISTS `CreditCard`;
DROP TABLE IF EXISTS `Users`;

CREATE TABLE `Users` (
	`userId` VARCHAR(50) NOT NULL PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL,
	`address` VARCHAR(50),
	`address2` VARCHAR(50),
	`phoneNumber` VARCHAR(50), 
	`email` VARCHAR(50),
	`role` ENUM('CUSTOMER', 'OWNER') NOT NULL
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `Users` (`userId`, `name`, `address`, `address2`, `phoneNumber`, `email`, `role`) VALUES 
					('12345', 'Kostas', 'Vouliagmenhs 10', '' ,'6979876541', 'kostas@example.org', 'CUSTOMER'),
					('54321', 'Yiannis', 'Kalamakiou 50', '' ,'6971234567', 'yiannis@yahoo.gr', 'CUSTOMER'),
					('55321', 'Petros', 'Kwstantikoupolews 44', '' ,'6971158567', 'petros@gmail.com', 'CUSTOMER'),
					('54521', 'Pavlos', 'Ilisiwn 2', 'newAddress' ,'6972034567', 'test2@example.org', 'CUSTOMER'),
					('54351', 'Nikos', 'Ionias 5', 'newAddress' ,'6971234987', 'test2@example.org', 'CUSTOMER'),
					('56789', 'Labis', 'Perikokladwn 8', '' ,'6970000000', 'labisp@di.uoa.gr', 'OWNER'),
					('98523', 'George', 'Athens', '' ,'69714702589', 'gstam@di.uoa.gr', 'OWNER');

CREATE TABLE `CreditCard` (
	`creditId` VARCHAR(50) NOT NULL PRIMARY KEY,
	`userId` VARCHAR(50) NOT NULL,
	`amount` DOUBLE,
	FOREIGN KEY (`userId`) REFERENCES `Users` (`userId`) ON UPDATE CASCADE ON DELETE CASCADE
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `CreditCard` (`creditId`, `userId`, `amount`) VALUES 
						('qwerty', '12345', '10000'), 
						('rtyqwe', '12345', '5000'), 
						('yqrtwe', '12345', '30000'), 
						('ytqwwq', '54321', '20000'), 
						('ytrefg', '55321', '2000'), 
						('iurewq', '54521', '20500'), 
						('ytcvwq', '54351', '80000'), 
						('1qazxs', '56789', '500'),
						('2wsxza', '98523', '1000');

CREATE TABLE `Product` (
	`productId` VARCHAR(50) NOT NULL PRIMARY KEY,
	`name` VARCHAR(50) NOT NULL,
	`category` VARCHAR(50) NOT NULL,
	`price` DOUBLE,
	`description` VARCHAR(50),
	`availability` BOOLEAN
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `Product` (`productId`, `name`, `category`, `price`, `description`, `availability`) VALUES 
					  ('2025356', 'Iphone 6 White', 'mobile', '550', 'Good', true), 
					  ('3024896', 'Iphine 6 Plus', 'mobile', '700', 'Expensive', true), 
					  ('2125894', 'Samsung Galaxy S3 mini', 'mobile', '150', 'Good', true), 
					  ('2856710', 'Samsung Galaxy S5', 'mobile', '400', 'Excellent', true), 
					  ('8050410', 'Ipad 3', 'Tablet', '450', 'Good', true), 
					  ('5624017', 'Samsung Tab II', 'Tablet', '300', 'Good', true);

CREATE TABLE `Cart` (
	`userId` VARCHAR(50) NOT NULL,
	`productId` VARCHAR(50) NOT NULL,
	`productCount` INT,
	`paymentMethod` ENUM('CASH', 'BANK_PAY', 'CREDIT_CARD', 'PAYPAL') NOT NULL,
	`shippingAddress` VARCHAR(50),
	`date` TIMESTAMP,
	PRIMARY KEY (`userId`, `productId`, `date`),
	FOREIGN KEY (`userId`) REFERENCES `Users` (`userId`) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`) ON UPDATE CASCADE ON DELETE CASCADE
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `Cart` (`userId`, `productId`, `productCount`, `paymentMethod`,  `shippingAddress`, `date`) VALUES 
				   ('12345', '2025356', '1', 'CASH', 'Vouliagmenhs 12', '2015-08-30 22:30:10'), 
				   ('54321', '2856710', '1', 'CREDIT_CARD', 'Vlaxernwn 45', '2015-08-01 10:40:50'), 
				   ('54321', '3024896', '1', 'CREDIT_CARD', 'Vlaxernwn 45', '2015-08-01 10:40:50'),
				   ('54321', '2025356', '1', 'CASH', 'Vouliagmenhs 12', '2015-08-01 12:20:30'),
				   ('55321', '2125894', '1', 'PAYPAL', 'Papamixelh 30', '2015-08-01 15:10:40'), 
				   ('54521', '5624017', '2', 'BANK_PAY', 'Vouliagmenhs 2', '2015-08-12 18:30:02'),
				   ('54321', '5624017', '1', 'CASH', 'Vouliagmenhs 12', '2015-08-05 09:15:30'),
				   ('54351', '5624017', '1', 'CREDIT_CARD', 'Kavouri 5', '2015-07-30 22:30:10');

CREATE TABLE `Store` (
	`storeId` VARCHAR(50) NOT NULL PRIMARY KEY,
	`address` VARCHAR(50) NOT NULL,
	`latitude` DOUBLE,
	`longitude` DOUBLE,
	`phone` VARCHAR(50)
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `Store` (`storeId`, `address`, `latitude`, `longitude`, `phone`) VALUES 
					('510', 'Suntagma', '0.0', '0.0', '2100000000'), 
					('450', 'Patisia', '0.0', '0.0', '2109700000'), 
					('250', 'Nea Smurni', '0.0', '0.0', '2111478526'), 
					('120', 'Ilisia', '0.0', '0.0', '2109785264');

CREATE TABLE `WareHouse` (
	`warehouseId` VARCHAR(50) NOT NULL PRIMARY KEY,
	`address` VARCHAR(50) NOT NULL,
	`country` VARCHAR(50) NOT NULL,
	`latitude` DOUBLE,
	`longitude` DOUBLE
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `WareHouse` (`warehouseId`, `address`, `country`, `latitude`, `longitude`) VALUES
						('123', 'Aspropurgos', 'Greece', '0.0', '0.0'),
						('321', 'Paiania', 'Greece', '0.0', '0.0'),
						('567', 'Metamorfwsh', 'Greece', '0.0', '0.0'),
						('854', 'Tripolh', 'Greece', '0.0', '0.0'),
						('412', 'Thesalonikh', 'Greece', '0.0', '0.0'),
						('258', 'Alexandroupoli', 'Greece', '0.0', '0.0');

CREATE TABLE `product_exists_store` (
	`productId` VARCHAR(50) NOT NULL,
	`storeId` VARCHAR(50) NOT NULL,
	`date` TIMESTAMP,
	PRIMARY KEY (`productId`, `storeId`),
	FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (`storeId`) REFERENCES `Store` (`storeId`) ON UPDATE CASCADE ON DELETE CASCADE
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `product_exists_store` (`productId`, `storeId`) VALUES 
									('2025356', '510'), 
									('3024896', '450'), 
									('2125894', '250'), 
									('2856710', '250'), 
									('8050410', '120'), 
									('5624017', '510');

CREATE TABLE `product_available_on_warehouse` (
	`productId` VARCHAR(50) NOT NULL,
	`warehouseId` VARCHAR(50) NOT NULL,
	`productAvailability` BOOLEAN,
	`date` TIMESTAMP,
	PRIMARY KEY (`productId`, `warehouseId`),
	FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (`warehouseId`) REFERENCES `WareHouse` (`warehouseId`) ON UPDATE CASCADE ON DELETE CASCADE
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `product_available_on_warehouse` (`productId`, `warehouseId`, `productAvailability`, `date`) VALUES 
											('2025356', '123', true, '2015-01-01 08:15:40'), 
											('3024896', '321', true, '2015-01-01 08:15:40'), 
											('2125894', '567', true, '2015-01-01 08:15:40'), 
											('2856710', '567', true, '2015-01-01 08:15:40'), 
											('8050410', '321', true, '2015-01-01 08:15:40'), 
											('5624017', '321', true, '2015-01-01 08:15:40');

CREATE TABLE `Orders` (
	`orderId` VARCHAR(50) NOT NULL,
	`userId` VARCHAR(50) NOT NULL,
	`warehouseId` VARCHAR(50) NOT NULL,
	`orderStatus` ENUM('SUBMITTED', 'PENDING', 'CANCELED') NOT NULL,
	`paymentMethod` ENUM('CASH', 'BANK_PAY', 'CREDIT_CARD', 'PAYPAL') NOT NULL,
	`shippingMethod` ENUM('COURIER', 'FROM_STORE') NOT NULL, 
	`date` TIMESTAMP,
	PRIMARY KEY (`orderId`, `userId`, `warehouseId`, `date`),
	FOREIGN KEY (`userId`) REFERENCES `Users` (`userId`) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (`warehouseId`) REFERENCES `WareHouse` (`warehouseId`) ON UPDATE CASCADE ON DELETE CASCADE
) CHARACTER SET utf8, ENGINE InnoDB;

INSERT INTO `Orders` (`orderId`, `userId`, `warehouseId`, `orderStatus`, `paymentMethod`, `shippingMethod`, `date`) VALUES 
					 ('o12345', '54321', '567', 'SUBMITTED', 'CASH', 'FROM_STORE', '2015-08-01 10:40:50'), 
					 ('o34125', '54321', '567', 'SUBMITTED', 'CASH', 'FROM_STORE', '2015-08-01 12:20:30'), 
					 ('o17545', '55321', '567', 'PENDING', 'PAYPAL', 'COURIER', '2015-08-01 15:10:40'), 
					 ('o25345', '54321', '321', 'SUBMITTED', 'BANK_PAY', 'FROM_STORE', '2015-08-05 09:15:30'), 
					 ('o19635', '54521', '321', 'PENDING', 'CREDIT_CARD', 'COURIER', '2015-08-12 18:30:02'), 
					 ('o96325', '12345', '123', 'SUBMITTED', 'CASH', 'COURIER', '2015-08-30 22:30:10'),
					 ('o56325', '54351', '123', 'CANCELED', 'CASH', 'COURIER', '2015-07-30 22:30:10');
					 
CREATE TABLE `bookProduct` (
	`productId` VARCHAR(50) NOT NULL,
	`warehouseId` VARCHAR(50) NOT NULL,
	`date` TIMESTAMP,
	`isBooked` BOOLEAN,
	PRIMARY KEY (`productId`, `warehouseId`, `date`),
	FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`) ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY (`warehouseId`) REFERENCES `WareHouse` (`warehouseId`) ON UPDATE CASCADE ON DELETE CASCADE
);
