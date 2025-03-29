--https://bcrypt-generator.com/

-- Insert international holidays into the holidays table
INSERT INTO `holidays` (`holidays_day`, `reason`, `type`, `created_at`, `created_by`)
VALUES
  -- New Year and Major Global Holidays
  ('Jan 1', 'New Year’s Day', 'FESTIVAL', CURDATE(), 'DBA'),
  ('Feb 14', 'Valentine’s Day', 'FESTIVAL', CURDATE(), 'DBA'),
  ('Oct 31', 'Halloween', 'FESTIVAL', CURDATE(), 'DBA'),
  ('Dec 25', 'Christmas Day', 'FESTIVAL', CURDATE(), 'DBA'),

  -- United States Federal Holidays
  ('Jan 15', 'Martin Luther King Jr. Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('Feb 19', 'Presidents’ Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('May 27', 'Memorial Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('July 4', 'Independence Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('Sep 2', 'Labor Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('Nov 11', 'Veterans Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('Nov 28', 'Thanksgiving Day', 'FEDERAL', CURDATE(), 'DBA'),

  -- Major International Holidays
  ('Apr 1', 'April Fool’s Day', 'CULTURAL', CURDATE(), 'DBA'),
  ('May 1', 'International Workers’ Day', 'CULTURAL', CURDATE(), 'DBA'),
  ('Nov 1', 'All Saints’ Day', 'RELIGIOUS', CURDATE(), 'DBA'),

  -- Islamic Holidays (Dates vary yearly)
  ('Varies', 'Eid al-Fitr', 'RELIGIOUS', CURDATE(), 'DBA'),
  ('Varies', 'Eid al-Adha', 'RELIGIOUS', CURDATE(), 'DBA'),

  -- Chinese Holidays
  ('Jan 22', 'Chinese New Year', 'CULTURAL', CURDATE(), 'DBA'),
  ('Apr 4', 'Qingming Festival', 'CULTURAL', CURDATE(), 'DBA'),
  ('Oct 1', 'National Day of China', 'FEDERAL', CURDATE(), 'DBA'),

  -- Indian Holidays
  ('Aug 15', 'Independence Day of India', 'FEDERAL', CURDATE(), 'DBA'),
  ('Oct 2', 'Gandhi Jayanti', 'FEDERAL', CURDATE(), 'DBA'),
  ('Varies', 'Diwali', 'RELIGIOUS', CURDATE(), 'DBA'),

  -- European Holidays
  ('Jul 14', 'Bastille Day (France)', 'FEDERAL', CURDATE(), 'DBA'),
  ('Oct 3', 'German Unity Day', 'FEDERAL', CURDATE(), 'DBA'),

  -- Other National Holidays
  ('Jul 1', 'Canada Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('Jan 26', 'Australia Day', 'FEDERAL', CURDATE(), 'DBA'),
  ('Jun 12', 'Russia Day', 'FEDERAL', CURDATE(), 'DBA');

-- Ensure roles exist
INSERT INTO `roles` (`role_name`, `created_at`, `created_by`)
VALUES ('ADMIN', CURDATE(), 'DBA'),
       ('STUDENT', CURDATE(), 'DBA');

-- Generate 1 million users with 10 admins and the rest as students
INSERT INTO `person` (`name`, `email`, `mobile_number`, `pwd`, `role_id`, `created_at`, `created_by`)
SELECT
    CONCAT('User', ROW_NUMBER() OVER()) AS name,
    CONCAT('user', FLOOR(RAND() * 1000000), '@eazyschool.com') AS email,
    LPAD(FLOOR(RAND() * 10000000000), 10, '0') AS mobile_number, -- Random 10-digit number
    'password123' AS pwd,
    CASE WHEN ROW_NUMBER() OVER() <= 10 THEN 1 ELSE 2 END AS role_id, -- First 10 are ADMIN (1), rest are STUDENT (2)
    CURDATE() AS created_at,
    'DBA' AS created_by
FROM (
  SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
  SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
  SELECT 9 UNION ALL SELECT 10
) AS A
CROSS JOIN (
  SELECT 1 AS n FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) B
  CROSS JOIN
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) C
  CROSS JOIN
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) D
  CROSS JOIN
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) E
) AS F;

-- Insert 1 million records efficiently
INSERT INTO `contact` (`status`, `name`, `mobile_num`, `email`, `subject`, `message`, `created_at`, `created_by`)
SELECT 'Open',
       'tuyen',
       '0123456789',
       CONCAT(FLOOR(RAND() * 1000000), 'jeremy@jeremyluong.com'),
       'Complain',
       'Karens complain',
       CURDATE(),
       'DBA'
FROM (
  SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
  SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
  SELECT 9 UNION ALL SELECT 10
) AS A
CROSS JOIN (
  SELECT 1 AS n FROM
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) B
  CROSS JOIN
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) C
  CROSS JOIN
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) D
  CROSS JOIN
  (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL
   SELECT 5 UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL
   SELECT 9 UNION ALL SELECT 10) E
) AS F;

