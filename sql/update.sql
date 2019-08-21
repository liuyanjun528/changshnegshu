-- 2019-08-14 肖长坤
-- 增加用户是否推送白名单到卫计委字段
alter table `examdb`.`user_basic`
   add column `is_push` int(2) DEFAULT '1' NULL COMMENT '是否已推送白名单到卫计委(1:未推送/2:已推送)'