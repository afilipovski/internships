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
    ('comp001', 'Sample Company', '123-456-7890', 'info@samplecompany.com', 'This is a sample company for testing purposes.', 'http://www.samplecompany.com', TRUE, 'samplepassword', 'sampletoken', '2025-12-31 23:59:59');

INSERT INTO internship_supervisor (id, company_id) VALUES
    ('supervisor', 'comp001');


