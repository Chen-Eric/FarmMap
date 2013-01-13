SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 ;
DROP SCHEMA IF EXISTS `FMDB` ;
CREATE SCHEMA IF NOT EXISTS `FMDB` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
USE `FMDB` ;

-- -----------------------------------------------------
-- Table `FMDB`.`Stock_Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`Stock_Type` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`Stock_Type` (
  `S_ID` SMALLINT NOT NULL AUTO_INCREMENT ,
  `S_Type` CHAR(10) NOT NULL ,
  `Stock_Units` INT NOT NULL ,
  PRIMARY KEY (`S_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FMDB`.`Farm`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`Farm` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`Farm` (
  `F_ID` SMALLINT NOT NULL AUTO_INCREMENT ,
  `F_Name` CHAR(10) NOT NULL ,
  `F_Description` LONGTEXT NULL DEFAULT NULL ,
  `F_Center_Lat` DOUBLE NULL ,
  `F_Center_Lon` DOUBLE NULL ,
  PRIMARY KEY (`F_ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FMDB`.`Block`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`Block` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`Block` (
  `B_ID` SMALLINT NOT NULL ,
  `Farm_F_ID` SMALLINT NOT NULL ,
  `B_Name` CHAR(10) NOT NULL ,
  `B_Type` CHAR(10) NOT NULL ,
  `B_Description` LONGTEXT NULL DEFAULT NULL ,
  `B_Data` LONGTEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`B_ID`, `Farm_F_ID`) ,
  INDEX `fk_Block_Farm1_idx` (`Farm_F_ID` ASC) ,
  CONSTRAINT `fk_Block_Farm1`
    FOREIGN KEY (`Farm_F_ID` )
    REFERENCES `FMDB`.`Farm` (`F_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FMDB`.`Paddock`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`Paddock` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`Paddock` (
  `P_ID` SMALLINT NOT NULL ,
  `Farm_F_ID` SMALLINT NOT NULL ,
  `Block_B_ID` SMALLINT NULL DEFAULT NULL ,
  `Block_Farm_F_ID` SMALLINT NULL DEFAULT NULL ,
  `P_Name` CHAR(10) NOT NULL ,
  `P_Center_Lat` DOUBLE NULL DEFAULT NULL ,
  `P_Center_Lon` DOUBLE NULL DEFAULT NULL ,
  `P_Description` LONGTEXT NULL DEFAULT NULL ,
  `P_FeedCapacity` SMALLINT NULL DEFAULT NULL ,
  `P_Area` DOUBLE NULL ,
  PRIMARY KEY (`P_ID`, `Farm_F_ID`) ,
  INDEX `fk_Paddock_Farm1` (`Farm_F_ID` ASC) ,
  INDEX `fk_Paddock_Block1` (`Block_B_ID` ASC, `Block_Farm_F_ID` ASC) ,
  CONSTRAINT `fk_Paddock_Farm1`
    FOREIGN KEY (`Farm_F_ID` )
    REFERENCES `FMDB`.`Farm` (`F_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Paddock_Block1`
    FOREIGN KEY (`Block_B_ID` , `Block_Farm_F_ID` )
    REFERENCES `FMDB`.`Block` (`B_ID` , `Farm_F_ID` )
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FMDB`.`Grazing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`Grazing` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`Grazing` (
  `G_ID` INT NOT NULL AUTO_INCREMENT ,
  `Paddock_P_ID` SMALLINT NOT NULL ,
  `Paddock_Farm_F_ID` SMALLINT NOT NULL ,
  `G_Date_In` DATE NOT NULL COMMENT 'The amount of animal in the specific polygon.' ,
  `G_Date_Out` DATE NULL DEFAULT NULL ,
  `G_Note` LONGTEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`G_ID`) ,
  INDEX `fk_Grazing_Paddock1_idx` (`Paddock_P_ID` ASC, `Paddock_Farm_F_ID` ASC) ,
  CONSTRAINT `fk_Grazing_Paddock1`
    FOREIGN KEY (`Paddock_P_ID` , `Paddock_Farm_F_ID` )
    REFERENCES `FMDB`.`Paddock` (`P_ID` , `Farm_F_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FMDB`.`StockCount`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`StockCount` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`StockCount` (
  `Stock_Type_S_ID` SMALLINT NOT NULL ,
  `Grazing_G_ID` INT NOT NULL ,
  `SC_Count` CHAR(10) NOT NULL ,
  PRIMARY KEY (`Stock_Type_S_ID`, `Grazing_G_ID`) ,
  INDEX `fk_StockCount_Grazing1` (`Grazing_G_ID` ASC) ,
  INDEX `fk_StockCount_Stock_Type1_idx` (`Stock_Type_S_ID` ASC) ,
  CONSTRAINT `fk_StockCount_Stock_Type1`
    FOREIGN KEY (`Stock_Type_S_ID` )
    REFERENCES `FMDB`.`Stock_Type` (`S_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_StockCount_Grazing1`
    FOREIGN KEY (`Grazing_G_ID` )
    REFERENCES `FMDB`.`Grazing` (`G_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FMDB`.`Corner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`Corner` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`Corner` (
  `C_ID` INT NOT NULL AUTO_INCREMENT ,
  `Paddock_P_ID` SMALLINT NOT NULL ,
  `Paddock_Farm_F_ID` SMALLINT NOT NULL ,
  `C_Lat` DOUBLE NULL DEFAULT NULL ,
  `C_Lon` DOUBLE NULL DEFAULT NULL ,
  `C_Ele` FLOAT NULL ,
  PRIMARY KEY (`C_ID`, `Paddock_P_ID`, `Paddock_Farm_F_ID`) ,
  INDEX `fk_Corner_Paddock1` (`Paddock_P_ID` ASC, `Paddock_Farm_F_ID` ASC) ,
  CONSTRAINT `fk_Corner_Paddock1`
    FOREIGN KEY (`Paddock_P_ID` , `Paddock_Farm_F_ID` )
    REFERENCES `FMDB`.`Paddock` (`P_ID` , `Farm_F_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FMDB`.`TODO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FMDB`.`TODO` ;

CREATE  TABLE IF NOT EXISTS `FMDB`.`TODO` (
  `T_ID` SMALLINT NOT NULL AUTO_INCREMENT ,
  `Paddock_P_ID` SMALLINT NOT NULL ,
  `Paddock_Farm_F_ID` SMALLINT NOT NULL ,
  `T_Date_Entered` DATE NOT NULL ,
  `T_Date_Due` DATE NULL DEFAULT NULL ,
  `T_Description` LONGTEXT NULL DEFAULT NULL ,
  PRIMARY KEY (`T_ID`) ,
  INDEX `fk_TODO_Paddock1_idx` (`Paddock_P_ID` ASC, `Paddock_Farm_F_ID` ASC) ,
  CONSTRAINT `fk_TODO_Paddock1`
    FOREIGN KEY (`Paddock_P_ID` , `Paddock_Farm_F_ID` )
    REFERENCES `FMDB`.`Paddock` (`P_ID` , `Farm_F_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
