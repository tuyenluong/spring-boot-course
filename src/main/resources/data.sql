INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES ('Jan 1','New Year''s Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES ('Oct 31','Halloween','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES ('Nov 24','Thanksgiving Day','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES ('Dec 25','Christmas','FESTIVAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES ('Jan 17','Martin Luther King Jr. Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES ('July 4','Independence Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
 VALUES ('Sep 5','Labor Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `holidays` (`holidays_day`,`reason`,`type`,`created_at`, `created_by`)
  VALUES ('Nov 11','Veterans Day','FEDERAL',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
  VALUES ('STUDENT',CURDATE(),'DBA');

INSERT INTO `person` (`name`,`email`,`mobile_number`,`pwd`,`role_id`,`created_at`, `created_by`)
  VALUES ('Admin','admin@eazyschool.com','3443434343','admin', 1 ,CURDATE(),'DBA');

INSERT INTO `contact` (`status`, `name`,`mobile_num`,`email`,`subject`, `message`, `created_at`, `created_by`)
  VALUES ('Open', 'tuyen','0123456789','1jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`,`name`,`mobile_num`,`email`, `subject`, `message`,`created_at`, `created_by`)
  VALUES ( 'Open', 'tuyen','0123456789','2jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`, `name`,`mobile_num`,`email`,`subject`, `message`, `created_at`, `created_by`)
  VALUES ('Open', 'tuyen','0123456789','3jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`,`name`,`mobile_num`,`email`, `subject`, `message`,`created_at`, `created_by`)
  VALUES ( 'Open', 'tuyen','0123456789','4jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`, `name`,`mobile_num`,`email`,`subject`, `message`, `created_at`, `created_by`)
  VALUES ('Open', 'tuyen','0123456789','5jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`,`name`,`mobile_num`,`email`, `subject`, `message`,`created_at`, `created_by`)
  VALUES ( 'Open', 'tuyen','0123456789','6jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`, `name`,`mobile_num`,`email`,`subject`, `message`, `created_at`, `created_by`)
  VALUES ('Open', 'tuyen','0123456789','7jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`,`name`,`mobile_num`,`email`, `subject`, `message`,`created_at`, `created_by`)
  VALUES ( 'Open', 'tuyen','0123456789','8jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`, `name`,`mobile_num`,`email`,`subject`, `message`, `created_at`, `created_by`)
  VALUES ('Open', 'tuyen','0123456789','9jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');

INSERT INTO `contact` (`status`,`name`,`mobile_num`,`email`, `subject`, `message`,`created_at`, `created_by`)
  VALUES ( 'Open', 'tuyen','0123456789','10jeremy@jeremyluong.com','Complain','Karens complain', CURDATE(),'DBA');
