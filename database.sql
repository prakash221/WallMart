DROP SCHEMA IF EXISTS `wallmart_db` ;
CREATE SCHEMA IF NOT EXISTS `wallmart_db` ;
CREATE TABLE IF NOT EXISTS `wallmart_db`.`customers` (
  `CustomerID` INT NOT NULL AUTO_INCREMENT,
  `CustomerName` VARCHAR(50) NOT NULL,
  `Phone` VARCHAR(50) NULL DEFAULT NULL,
  `Email` VARCHAR(100) NULL DEFAULT NULL,
  `Address` VARCHAR(100) NULL DEFAULT NULL,
  `PANNumber` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`CustomerID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`product` (
  `ProductID` INT NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(50) NOT NULL,
  `PricePerKgUnit` DECIMAL(12,2) NULL DEFAULT NULL,
  `AvailableQuantity` DOUBLE NOT NULL,
  `IsDiscontinued` TINYINT UNSIGNED NULL DEFAULT NULL,
  `CategoryID` INT NOT NULL,
  PRIMARY KEY (`ProductID`),
  INDEX `Product_categoryFK_idx` (`CategoryID` ASC) VISIBLE,
  CONSTRAINT `Product_categoryFK`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `wallmart_db`.`productcategory` (`CategoryID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`productcategory` (
  `CategoryID` INT NOT NULL AUTO_INCREMENT,
  `CategoryName` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`CategoryID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`purchaseitems` (
  `PurchaseItemID` INT NOT NULL AUTO_INCREMENT,
  `PurchaseID` INT NOT NULL,
  `ProductID` INT NOT NULL,
  `UnitPrice` DECIMAL(12,2) NULL DEFAULT NULL,
  `Quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`PurchaseItemID`),
  INDEX `PurchaseFK_idx` (`PurchaseID` ASC) VISIBLE,
  INDEX `ProductFK_idx` (`ProductID` ASC) VISIBLE,
  CONSTRAINT `ProductFK`
    FOREIGN KEY (`ProductID`)
    REFERENCES `wallmart_db`.`product` (`ProductID`),
  CONSTRAINT `PurchaseFK`
    FOREIGN KEY (`PurchaseID`)
    REFERENCES `wallmart_db`.`purchases` (`PurchaseID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`purchases` (
  `PurchaseID` INT NOT NULL AUTO_INCREMENT,
  `PurchaseDate` DATETIME(3) NOT NULL,
  `SupplierID` INT NOT NULL,
  `TotalAmount` DECIMAL(12,2) NOT NULL,
  `InvoiceNumber` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`PurchaseID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`sales` (
  `SalesID` INT NOT NULL AUTO_INCREMENT,
  `SalesDate` DATETIME(3) NOT NULL,
  `CustomerID` INT NOT NULL,
  `Amount` DECIMAL(12,2) NULL DEFAULT NULL,
  `TAXAmount` DECIMAL(12,2) NULL DEFAULT NULL,
  `InvoiceNumber` BIGINT NOT NULL,
  PRIMARY KEY (`SalesID`),
  INDEX `CustomerFK_idx` (`CustomerID` ASC) VISIBLE,
  CONSTRAINT `CustomerFK`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `wallmart_db`.`customers` (`CustomerID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`salesitem` (
  `SalesItemID` INT NOT NULL AUTO_INCREMENT,
  `SalesID` INT NOT NULL,
  `ProductID` INT NOT NULL,
  `UnitPrice` DECIMAL(12,2) NULL DEFAULT NULL,
  `Quantity` DOUBLE NOT NULL,
  PRIMARY KEY (`SalesItemID`),
  INDEX `salseFK_idx` (`SalesID` ASC) VISIBLE,
  INDEX `ProductFK_idx` (`ProductID` ASC) VISIBLE,
  CONSTRAINT `nbdsnbf`
    FOREIGN KEY (`ProductID`)
    REFERENCES `wallmart_db`.`product` (`ProductID`),
  CONSTRAINT `nkdsbfkj`
    FOREIGN KEY (`SalesID`)
    REFERENCES `wallmart_db`.`sales` (`SalesID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`supplier` (
  `SupplierID` INT NOT NULL AUTO_INCREMENT,
  `CompanyName` VARCHAR(100) NOT NULL,
  `ContactPerson` VARCHAR(100) NULL DEFAULT NULL,
  `Address` VARCHAR(50) NULL DEFAULT NULL,
  `Phone` VARCHAR(50) NULL DEFAULT NULL,
  `Email` VARCHAR(100) NULL DEFAULT NULL,
  `VATNumber` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`SupplierID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `wallmart_db`.`user` (
  `UserID` INT NOT NULL AUTO_INCREMENT,
  `FullName` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `UserName` VARCHAR(50) NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `IsAdmin` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`UserID`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci