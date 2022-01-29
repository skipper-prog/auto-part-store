INSERT INTO USERS (EMAIL, FIRSTNAME, LASTNAME, PASSWORD)
VALUES ('user@gmail.com', 'User_First', 'User_Last', 'password'),
       ('admin@javaops.ru', 'Admin_First', 'Admin_Last', 'admin') ON CONFLICT DO NOTHING;

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('ROLE_USER', 1),
       ('ROLE_ADMIN', 2),
       ('ROLE_USER', 2) ON CONFLICT DO NOTHING;