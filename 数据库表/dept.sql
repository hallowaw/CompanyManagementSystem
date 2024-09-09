
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
BEGIN;
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (1, '学工部', '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (2, '教研部', '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (3, '咨询部5', '2024-09-04 09:12:37', '2024-09-06 20:16:05');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (7, '67646', '2024-09-06 20:16:30', '2024-09-06 20:16:30');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (8, '帅哥部', '2024-09-06 20:51:05', '2024-09-06 20:51:05');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (9, '美女部', '2024-09-07 19:54:11', '2024-09-07 19:54:11');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (10, '董事会', '2024-09-07 20:18:09', '2024-09-07 20:18:09');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (11, '1', '2024-09-07 20:42:46', '2024-09-07 20:42:46');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (12, '2', '2024-09-07 20:43:09', '2024-09-07 20:43:09');
INSERT INTO `dept` (`id`, `name`, `create_time`, `update_time`) VALUES (13, '3', '2024-09-07 20:51:59', '2024-09-07 20:51:59');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
