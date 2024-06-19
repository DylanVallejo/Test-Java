-- MySQL Script generated by MySQL Workbench
-- Wed Jun 19 12:22:17 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tcs_operaciones
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tcs_operaciones
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tcs_operaciones` DEFAULT CHARACTER SET utf8 ;
USE `tcs_operaciones` ;

-- -----------------------------------------------------
-- Table `tcs_operaciones`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_operaciones`.`person` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `person_name` VARCHAR(45) NOT NULL,
  `gender` ENUM('MASCULINO', 'FEMENINO') NOT NULL,
  `age` INT NOT NULL,
  `identification` VARCHAR(14) NOT NULL,
  `address` VARCHAR(150) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE INDEX `identification_UNIQUE` (`identification` ASC) VISIBLE,
  UNIQUE INDEX `person_id_UNIQUE` (`person_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tcs_operaciones`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_operaciones`.`client` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`client_id`, `person_id`),
  UNIQUE INDEX `cliente_id_UNIQUE` (`client_id` ASC) VISIBLE,
  INDEX `fk_person_id_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `fk_person_id`
    FOREIGN KEY (`person_id`)
    REFERENCES `tcs_operaciones`.`person` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tcs_operaciones`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_operaciones`.`account` (
  `account_id` INT NOT NULL AUTO_INCREMENT,
  `account_number` VARCHAR(45) NOT NULL,
  `account_type` ENUM('SAVING', 'CURRENT') NULL,
  `initial_balance` DOUBLE NULL,
  `account_status` TINYINT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE INDEX `cuenta_id_UNIQUE` (`account_id` ASC) VISIBLE,
  UNIQUE INDEX `account_number_UNIQUE` (`account_number` ASC) VISIBLE,
  CONSTRAINT `fk_client_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `tcs_operaciones`.`client` (`client_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tcs_operaciones`.`movement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tcs_operaciones`.`movement` (
  `movement_id` INT NOT NULL,
  `movement_date` DATETIME NOT NULL,
  `movement_type` ENUM('CREDIT', 'DEBIT') NOT NULL,
  `amount` DOUBLE NOT NULL,
  `balance` DOUBLE NOT NULL,
  PRIMARY KEY (`movement_id`),
  CONSTRAINT `fk_account_id`
    FOREIGN KEY (`movement_id`)
    REFERENCES `tcs_operaciones`.`account` (`account_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
