drop database if exists manufacturing;
drop user 'manufacturing'@'127.0.0.1';
-- 支持emoji：需要mysql数据库参数： character_set_server=utf8mb4
create database manufacturing default character set utf8mb4 collate utf8mb4_unicode_ci;
use manufacturing;
create user 'manufacturing'@'127.0.0.1' identified by 'manufacturing123456';
grant all privileges on manufacturing.* to 'manufacturing'@'127.0.0.1';
flush privileges;