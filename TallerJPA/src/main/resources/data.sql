-- Users
INSERT INTO users (id, name, email, password, register_date, state) VALUES (1, 'Admin', 'admin@example.com', 'admin123', 1640995200000, 'active');
INSERT INTO users (id, name, email, password, register_date, state) VALUES (2, 'Trainer', 'trainer@example.com', 'trainer123', 1641081600000, 'active');
INSERT INTO users (id, name, email, password, register_date, state) VALUES (3, 'User1', 'user1@example.com', 'user123', 1641168000000, 'active');

-- Roles
INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'TRAINER');
INSERT INTO role (id, name) VALUES (3, 'USER');

-- Permissions
INSERT INTO permission (id, name) VALUES (1, 'READ_ALL');
INSERT INTO permission (id, name) VALUES (2, 'WRITE_ALL');
INSERT INTO permission (id, name) VALUES (3, 'READ_PROGRESS');

-- User Roles
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);

-- Role Permissions
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 2);
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (3, 3);

