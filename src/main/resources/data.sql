INSERT INTO users (username, password, enabled, email, first_name, last_name, news_letter,country)
    VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE, 'user@user.nl', 'user', 'usersson', FALSE, 'england');
INSERT INTO users (username, password, enabled, email, first_name, last_name, news_letter, country)
    VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE, 'admin@admin.nl', 'admin', 'adminson', FALSE, 'england');
INSERT INTO users (username, password, enabled, email, first_name, last_name, news_letter,country)
    VALUES ('levi', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE, 'levi@broeksma.nl', 'levi', 'broeksma', FALSE, 'england');

INSERT INTO authorities (username, authority) VALUES ('user', 'USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ADMIN');
INSERT INTO authorities (username, authority) VALUES ('levi', 'USER');