/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : admin-system

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-10-23 14:53:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ddic_category`
-- ----------------------------
DROP TABLE IF EXISTS `ddic_category`;
CREATE TABLE `ddic_category` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `category` varchar(32) NOT NULL COMMENT '类别',
  `cn_name` varchar(64) NOT NULL COMMENT '中文名',
  `memo` varchar(128) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典分类表';

-- ----------------------------
-- Records of ddic_category
-- ----------------------------

-- ----------------------------
-- Table structure for `ddic_item`
-- ----------------------------
DROP TABLE IF EXISTS `ddic_item`;
CREATE TABLE `ddic_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` mediumint(9) NOT NULL COMMENT '所属分类',
  `key` varchar(32) NOT NULL COMMENT '数据字典编码',
  `value` varchar(64) NOT NULL COMMENT '数据字典值',
  `sort_no` smallint(6) NOT NULL COMMENT '数据字典排序位置',
  `enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可以',
  `memo` varchar(256) DEFAULT NULL COMMENT '描述信息',
  `attribute1` varchar(256) DEFAULT NULL COMMENT '扩展属性1',
  `attribute2` varchar(256) DEFAULT NULL COMMENT '扩展属性2',
  `attribute3` varchar(256) DEFAULT NULL COMMENT '扩展属性3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典明细表';

-- ----------------------------
-- Records of ddic_item
-- ----------------------------

-- ----------------------------
-- Table structure for `metadata`
-- ----------------------------
DROP TABLE IF EXISTS `metadata`;
CREATE TABLE `metadata` (
  `module` varchar(32) NOT NULL COMMENT '模块',
  `cn_name` varchar(64) NOT NULL COMMENT '中文名称',
  `table_name` varchar(32) NOT NULL COMMENT '表名称',
  `sort_no` smallint(6) NOT NULL COMMENT '排序号',
  `switch` int(11) NOT NULL DEFAULT '1' COMMENT '开关位(启停, 日志开关等)',
  PRIMARY KEY (`module`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of metadata
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(30) NOT NULL,
  `mode` varchar(10) NOT NULL COMMENT '操作模式',
  `operator` varchar(32) NOT NULL COMMENT '操作人',
  `log_time` datetime NOT NULL,
  `pre_persist` varchar(1024) DEFAULT NULL COMMENT '持久化前数据',
  `post_persist` varchar(1024) DEFAULT NULL COMMENT '持久化后数据',
  `memo` varchar(256) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统操作日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
