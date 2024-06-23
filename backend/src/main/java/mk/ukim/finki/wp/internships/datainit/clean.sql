DROP TABLE internship_week;
DROP TABLE internship;
DROP TABLE internship_coordinator;
DROP TABLE internship_supervisor;
DROP TABLE internship_posting;
DELETE FROM auth_user WHERE role='STUDENT' or role='SUPERVISOR';
DELETE FROM student WHERE student_index LIKE '%999';
DELETE FROM company WHERE id='company1';