
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint(3) unsigned NOT NULL COMMENT '性别, 说明: 1 男, 2 女',
  `image` varchar(300) DEFAULT NULL COMMENT '图像',
  `job` tinyint(3) unsigned DEFAULT NULL COMMENT '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
  `entrydate` date DEFAULT NULL COMMENT '入职时间',
  `dept_id` int(10) unsigned DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT='员工表';

-- ----------------------------
-- Records of emp
-- ----------------------------
BEGIN;
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (1, 'jinyong', '123456', '金庸', 1, 'https://springweb-tlias-dlei-file.oss-cn-shanghai.aliyuncs.com/ce3f63b0-0358-41ba-9d5f-471b22e17063.jpeg', 4, '2000-01-01', 2, '2024-09-04 09:12:37', '2024-09-06 21:23:53');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (2, 'zhangwuji', '123456', '张无忌', 1, 'https://springboo-zoe.oss-cn-shanghai.aliyuncs.com/0c7b3e8f-3c14-4854-b866-4f6ca2f979d0.jpeg', 2, '2015-01-01', 2, '2024-09-04 09:12:37', '2024-09-06 21:34:30');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (3, 'yangxiao1', '123456', '杨逍1', 1, 'https://springboo-zoe.oss-cn-shanghai.aliyuncs.com/06bfd40c-c3a9-4626-81d6-6d4eea7a956f.jpeg', 1, '2008-05-01', 2, '2024-09-04 09:12:37', '2024-09-06 21:35:29');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (4, 'weiyixiao', '123456', '韦一笑', 1, 'https://springboo-zoe.oss-cn-shanghai.aliyuncs.com/ae403227-ccd8-4405-a87d-e5fb94ca0413.jpeg', 2, '2007-01-01', 2, '2024-09-04 09:12:37', '2024-09-06 21:42:03');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (5, 'changyuchun', '123456', '常遇春', 1, 'https://springboo-zoe.oss-cn-shanghai.aliyuncs.com/bc51636d-14e1-4330-9014-bad4d982a4e4.jpeg', 3, '2012-12-05', 2, '2024-09-04 09:12:37', '2024-09-06 21:45:49');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 4, '2005-08-01', 1, '2024-09-04 09:12:37', '2024-09-04 21:43:18');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 2, '2014-11-09', 1, '2024-09-04 09:12:37', '2024-09-04 21:43:12');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 5, '2007-02-01', 3, '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (16, 'songyuanqiao', '123456', '宋远桥', 1, '16.jpg', 2, '2007-01-01', 2, '2024-09-04 09:12:37', '2024-09-04 09:12:37');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (18, '9993312', NULL, '213', 1, '', 1, NULL, NULL, '2024-09-04 21:38:02', '2024-09-06 20:08:33');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (19, 'xiaolongnv', NULL, '小龙女', 2, 'https://springboo-zoe.oss-cn-shanghai.aliyuncs.com/d112478a-856f-48b3-bab3-4215123f75e3.jpeg', 1, '2024-08-14', 9, '2024-09-07 19:55:08', '2024-09-07 19:55:08');
INSERT INTO `emp` (`id`, `username`, `password`, `name`, `gender`, `image`, `job`, `entrydate`, `dept_id`, `create_time`, `update_time`) VALUES (20, 'meimei', NULL, '梅妹', 2, 'https://springboo-zoe.oss-cn-shanghai.aliyuncs.com/03cfecd1-5572-479a-88d4-bed41141f51b.jpeg', 1, '2024-09-01', 9, '2024-09-07 20:40:51', '2024-09-07 20:40:51');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
