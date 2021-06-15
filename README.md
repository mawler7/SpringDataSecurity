"# SpringDataSecurity" 

To run app create MySQL server, paste and run below commands: 
1)
-- MySQL Script generated by MySQL Workbench
-- Tue May 26 17:42:50 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema spring
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema spring
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spring` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `spring` ;

-- -----------------------------------------------------
-- Table `spring`.`portal_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring`.`portal_user` (
  `PU_ID` INT NOT NULL AUTO_INCREMENT,
  `PU_LOGIN` VARCHAR(45) NULL DEFAULT NULL,
  `PU_FIRSTNAME` VARCHAR(45) NOT NULL,
  `PU_LASTNAME` VARCHAR(45) NOT NULL,
  `PU_EMAIL` VARCHAR(45) NOT NULL,
  `PU_PASSWORD` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`PU_ID`),
  UNIQUE INDEX `PU_LOGIN_UNIQUE` (`PU_LOGIN` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `spring`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring`.`role` (
  `RO_ID` INT NOT NULL AUTO_INCREMENT,
  `RO_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RO_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `spring`.`portal_user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spring`.`portal_user_roles` (
  `PUR_PU_ID` INT NOT NULL,
  `PUR_RO_ID` INT NOT NULL,
  INDEX `PUR_PU_ID_idx` (`PUR_PU_ID` ASC),
  INDEX `PUR_RO_ID_idx` (`PUR_RO_ID` ASC),
  CONSTRAINT `PUR_PU_ID`
    FOREIGN KEY (`PUR_PU_ID`)
    REFERENCES `spring`.`portal_user` (`PU_ID`),
  CONSTRAINT `PUR_RO_ID`
    FOREIGN KEY (`PUR_RO_ID`)
    REFERENCES `spring`.`role` (`RO_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


CREATE TABLE `spring`.`order` (
  `ORD_ID` INT NOT NULL AUTO_INCREMENT,
  `ORD_PRICE` DECIMAL NOT NULL,
  `ORD_TITLE` VARCHAR(45) NOT NULL,
  `ORD_PU_ID` INT NOT NULL,
  PRIMARY KEY (`ORD_ID`),
  INDEX `ord_pu_idx` (`ORD_PU_ID` ASC) VISIBLE,
  CONSTRAINT `ORDER_PORTAL_USER`
    FOREIGN KEY (`ORD_PU_ID`)
    REFERENCES `spring`.`portal_user` (`PU_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

2)
INSERT INTO portal_user
values (null,'jakow','Jan', 'Kowalski','jan.kow@test.pl','$2y$12$DMdnsKiGR5ITG.Ay0vltrO021zwZfPtF6qiWqJsSVtDZTX1nG6cxy');

INSERT INTO portal_user
values (null,'manow','Maria','Nowak','maria.nowak@test.pl','$2y$12$1MXtjYDpR.q93byo2GNfjuUcOQwPgbgSkP/0JisNESoqsjNdG.xzu');

insert into portal_user
values (null, "pruser","Przykladowy","User","przykladowy.user@test.pl","$2y$12$1MXtjYDpR.q93byo2GNfjuUcOQwPgbgSkP/0JisNESoqsjNdG.xzu");
insert into portal_user
values (null, "stjaki","Stefan","Jakistam","stefan.jakistam@test.pl","$2y$12$1MXtjYDpR.q93byo2GNfjuUcOQwPgbgSkP/0JisNESoqsjNdG.xzu");
insert into portal_user
values (null, "wynazw","Wymyslam","Nazwisko","wymyslam.nazwisko@test.pl","$2y$12$1MXtjYDpR.q93byo2GNfjuUcOQwPgbgSkP/0JisNESoqsjNdG.xzu");

INSERT INTO role
values (null,'ADMIN');

INSERT INTO role
values (null,'USER');

INSERT INTO portal_user_roles
values (4,3);
INSERT INTO portal_user_roles
values (3,4);
INSERT INTO portal_user_roles
values (4,4);
INSERT INTO portal_user_roles
values (5,4);
INSERT INTO portal_user_roles
values (6,4);
INSERT INTO portal_user_roles
values (7,4);

insert into `order`
values (null, 100, "zamowienie 1", 6);
insert into `order`
values (null, 299, "zamowienie 2", 7);
insert into `order`
values (null, 332, "zamowienie 3", 6);
insert into `order`
values (null, 120, "zamowienie 4", 4);
insert into `order`
values (null, 12, "zamowienie 5", 3);
insert into `order`
values (null, 55, "zamowienie 6", 7);
insert into `order`
values (null, 1235, "zamowienie 7", 6);
insert into `order`
values (null, 15, "zamowienie 8", 3);
insert into `order`
values (null, 100, "zamowienie 9", 7);
insert into `order`
values (null, 166, "zamowienie 10", 6);
insert into `order`
values (null, 32, "zamowienie 11", 3);
insert into `order`
values (null, 65, "zamowienie 12", 4);
insert into `order`
values (null, 72, "zamowienie 13", 5);
insert into `order`
values (null, 87, "zamowienie 14", 5);
insert into `order`
values (null, 987, "zamowienie 15", 7);
insert into `order`
values (null, 654, "zamowienie 16", 3);



