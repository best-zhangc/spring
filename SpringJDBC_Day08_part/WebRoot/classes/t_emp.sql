/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : emp

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-11-13 10:34:56
*/
create database emp ;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_emp`
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `empno` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `job` varchar(10) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `comm` double DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES ('1', 'Smith', 'clerk', '3', '1980-05-12', '800', null, '20');
INSERT INTO `t_emp` VALUES ('2', 'Allen', 'salesman', '3', '1981-06-03', '1600', '300', '30');
INSERT INTO `t_emp` VALUES ('3', 'Ward', 'salesman', '4', '1990-03-15', '1250', '500', '30');
INSERT INTO `t_emp` VALUES ('4', 'Jones', 'manager', '5', '1985-04-08', '2975', null, '20');
INSERT INTO `t_emp` VALUES ('5', 'Martin', 'salesman', '7', '1986-03-08', '1250', '1400', '30');
INSERT INTO `t_emp` VALUES ('6', 'Blake', 'manager', '9', '1989-06-01', '2850', null, '30');
INSERT INTO `t_emp` VALUES ('7', 'Clark', 'manager', '9', '1995-10-01', '2450', null, '30');
INSERT INTO `t_emp` VALUES ('8', 'Scott', 'analyst', '9', '1993-05-01', '3000', null, '20');
INSERT INTO `t_emp` VALUES ('9', 'King', 'president', null, '1988-08-08', '5000', null, '10');
INSERT INTO `t_emp` VALUES ('10', 'Turner', 'salesman', '5', '1983-02-01', '1500', '0', '30');
INSERT INTO `t_emp` VALUES ('11', 'Adams', 'clerk', '5', '1992-07-03', '1100', null, '20');
INSERT INTO `t_emp` VALUES ('12', 'James', 'clerk', '1', '1996-09-10', '950', null, '30');
INSERT INTO `t_emp` VALUES ('13', 'Ford', 'analyst', '1', '1993-01-01', '3000', null, '20');
INSERT INTO `t_emp` VALUES ('14', 'Miller', 'clerk', '3', '1983-10-09', '1300', null, '10');
