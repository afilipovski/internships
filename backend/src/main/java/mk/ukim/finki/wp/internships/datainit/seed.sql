INSERT INTO auth_user (id, name, email, role) VALUES
                                                  ('vasil.strezov', 'Васил Стрезов', 'vasil.strezov@students.finki.ukim.mk', 'STUDENT'),
                                                  ('luka.krstikj', 'Лука Крстиќ', 'luka.krstikj@students.finki.ukim.mk', 'STUDENT'),
                                                  ('dimitrij.krstev', 'Димитриј Крстев', 'dimitrij.krstev@students.finki.ukim.mk', 'STUDENT'),
                                                  ('supervisor', 'supervisor', 'supervisor@company.mk', 'SUPERVISOR');

INSERT INTO student (student_index, email, last_name, name, parent_name, study_program_code) VALUES
                                                                                                 ('211999', 'aleksandar.filipovski@students.finki.ukim.mk', 'Филиповски', 'Александар', 'pn1', 'PIT23'),
                                                                                                 ('213999', 'vasil.strezov@students.finki.ukim.mk', 'Стрезов', 'Васил', 'pn2', 'PIT23'),
                                                                                                 ('214999', 'luka.krstikj@students.finki.ukim.mk', 'Крстиќ', 'Лука', 'pn3', 'PIT23'),
                                                                                                 ('216999', 'dimitrij.krstev@students.finki.ukim.mk', 'Крстев', 'Димитриј', 'pn4', 'PIT23');

INSERT INTO company (id, name, phone, email, company_description, website_url, active, password, token, valid_to) VALUES
    ('comp1', 'Sample Company', '123-456-7890', 'info@samplecompany.com', 'This is a sample company for testing purposes.', 'http://www.samplecompany.com', TRUE, 'samplepassword', 'sampletoken', '2025-12-31 23:59:59');

INSERT INTO internship_supervisor (id, company_id) VALUES
    ('supervisor', 'comp1');

INSERT INTO internship_coordinator (id, professor_id) VALUES
    ('coordinator1', 'vesna.dimitrievska'),
    ('coordinator2', 'andreja.naumoski'),
    ('coordinator3', 'georgina.mirceva');

INSERT INTO internship_posting (id, description, planned_weeks, position, company_id) VALUES
    ('posting1', 'PostgreSQL, Spring, React', 12, 'Software Engineer', 'comp1');

INSERT INTO internship(id, status, company_id, coordinator_id, posting_id, student_student_index, supervisor_id) VALUES
     ('internship1', 'ONGOING', 'comp1', 'coordinator1', 'posting1', '211999', 'supervisor');

INSERT INTO internship_week(id, description, end_date, start_date, internship_id) VALUES
                                                                                       ('week1', 'Seeded a PostgreSQL database', '2024-06-21', '2024-06-17', 'internship1'),
                                                                                       ('week2', 'Developed a REST API with Flask', '2024-06-28', '2024-06-24', 'internship1'),
                                                                                       ('week3', 'Implemented user authentication', '2024-07-05', '2024-07-01', 'internship1'),
                                                                                       ('week4', 'Designed frontend components with React', '2024-07-12', '2024-07-08', 'internship1'),
                                                                                       ('week5', 'Conducted unit testing for the backend', '2024-07-19', '2024-07-15', 'internship1'),
                                                                                       ('week6', 'Optimized SQL queries for performance', '2024-07-26', '2024-07-22', 'internship1'),
                                                                                       ('week7', 'Integrated third-party APIs', '2024-08-02', '2024-07-29', 'internship1'),
                                                                                       ('week8', 'Deployed application to AWS', '2024-08-09', '2024-08-05', 'internship1'),
                                                                                       ('week9', 'Implemented CI/CD pipeline', '2024-08-16', '2024-08-12', 'internship1'),
                                                                                       ('week10', 'Conducted code reviews and refactoring', '2024-08-23', '2024-08-19', 'internship1'),
                                                                                       ('week11', 'Worked on bug fixes and improvements', '2024-08-30', '2024-08-26', 'internship1'),
                                                                                       ('week12', 'Created project documentation', '2024-09-06', '2024-09-02', 'internship1');


