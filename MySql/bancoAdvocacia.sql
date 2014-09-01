SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`pessoa` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`pessoa` (
  `id` INT NOT NULL ,
  `nome` VARCHAR(45) NULL ,
  `telefone` VARCHAR(45) NULL ,
  `endereco` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`andamento_processo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`andamento_processo` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`andamento_processo` (
  `id` INT NOT NULL ,
  `tipo` VARCHAR(45) NULL ,
  `descricao` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`processo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`processo` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`processo` (
  `id` INT NOT NULL ,
  `data` DATE NULL ,
  `descricao` VARCHAR(45) NULL ,
  `observacao` VARCHAR(45) NULL ,
  `desembargador` VARCHAR(45) NULL COMMENT '				' ,
  `numero_processo` VARCHAR(45) NULL ,
  `requerente` VARCHAR(45) NULL ,
  `requirido` VARCHAR(45) NULL ,
  `andamento_processo_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_processo_andamento_processo1` (`andamento_processo_id` ASC) ,
  CONSTRAINT `fk_processo_andamento_processo1`
    FOREIGN KEY (`andamento_processo_id` )
    REFERENCES `mydb`.`andamento_processo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id` INT NOT NULL ,
  `tipo` CHAR NULL ,
  `login` VARCHAR(45) NULL ,
  `senha` VARCHAR(45) NULL ,
  `pessoa_id` INT NOT NULL ,
  `processo_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_usuario_pessoa1` (`pessoa_id` ASC) ,
  INDEX `fk_usuario_processo1` (`processo_id` ASC) ,
  CONSTRAINT `fk_usuario_pessoa1`
    FOREIGN KEY (`pessoa_id` )
    REFERENCES `mydb`.`pessoa` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_processo1`
    FOREIGN KEY (`processo_id` )
    REFERENCES `mydb`.`processo` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
