insert into user_details(id, date_of_birth, name)
values
(1, current_date(), 'Preetham'),
(2, current_date(), 'Kishan'),
(3, current_date(), 'Ranga'),
(4, current_date(), 'Krishna');


insert into post(id, description, user_id)
values
(1, 'I want to learn Spring Boot', 1),
(2, 'I want to learn AWS', 1),
(3, 'I want to learn Devops', 2),
(4, 'I want to learn Kubernetes', 4);