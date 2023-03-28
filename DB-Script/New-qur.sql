DROP SCHEMA IF EXISTS `Query`;

CREATE SCHEMA `Query`;
USE `Query` ;

-------------------------------------------------------
-- Table `Query`.`product_category`
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Query`.`product_category` (
 `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
 `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-------------------------------------------------------
-- Table `full-stack-ecommerce`.`product`
-------------------------------------------------------
CREATE TABLE IF NOT EXISTS `Query`.`product` (
 `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(255) DEFAULT NULL,
 `TextBody` VARCHAR(255) DEFAULT NULL,
 `Catergory` BIGINT(255) NOT NULL,
  PRIMARY KEY (`id`),
   KEY `fk_category` (`Catergory`),
  CONSTRAINT `fk_category` FOREIGN KEY (`Catergory`) REFERENCES `product_category` (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;


INSERT INTO product_category(category_name) VALUES ('PETS');

INSERT INTO product(name , TextBody , Catergory)
values( 'Dog', 'assets/images/products/placeholder.png' ,  '1');

INSERT INTO product(name , TextBody , Catergory)
values('Cat','/images/products/placeholder.png' ,  '1');

INSERT INTO product(name , TextBody , Catergory)
values('Rat','/products/placeholder.png' ,  '1');

INSERT INTO product(name , TextBody , Catergory)
values('Cow','/placeholder.png' ,  '1');


