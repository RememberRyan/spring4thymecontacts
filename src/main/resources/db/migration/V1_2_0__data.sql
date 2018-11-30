INSERT INTO sda_contacts.contact (id, name, last_name, creation_time, status, description) VALUES (1, 'James', 'Brown', '2018-11-30 19:07:29', 'ACTIVE', 'Godfather of funk');
INSERT INTO sda_contacts.contact (id, name, last_name, creation_time, status, description) VALUES (2, 'Jill', 'Valentine', '2018-11-30 19:11:21', 'ACTIVE', null);
INSERT INTO sda_contacts.contact (id, name, last_name, creation_time, status, description) VALUES (3, 'Anna', 'Autumn', '2018-11-30 19:11:33', 'ACTIVE', null);
INSERT INTO sda_contacts.contact (id, name, last_name, creation_time, status, description) VALUES (4, 'Emma', 'Bailey', '2018-11-30 19:11:40', 'ACTIVE', null);

INSERT INTO sda_contacts.phone (id, contact_id, country_code, phone_number, description, type) VALUES (1, 1, 372, 56333666, 'Little Black Book', 'OTHER');