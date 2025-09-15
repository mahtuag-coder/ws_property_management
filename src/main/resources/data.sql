-- Insert tenants
INSERT INTO tenant (first_name, last_name, email, phone, status)
VALUES ('Alice', 'Johnson', 'alice.johnson@example.com', '2145551001', 'ACTIVE'),
       ('Bob', 'Smith', 'bob.smith@example.com', '2145551002', 'ACTIVE'),
       ('Charlie', 'Davis', 'charlie.davis@example.com', '2145551003', 'INACTIVE'),
       ('Diana', 'Lopez', 'diana.lopez@example.com', '2145551004', 'ACTIVE'),
       ('Ethan', 'Brown', 'ethan.brown@example.com', '2145551005', 'BLACKLISTED'),
       ('Fiona', 'Wilson', 'fiona.wilson@example.com', '2145551006', 'ACTIVE'),
       ('George', 'Miller', 'george.miller@example.com', '2145551007', 'ACTIVE'),
       ('Hannah', 'Garcia', 'hannah.garcia@example.com', '2145551008', 'INACTIVE'),
       ('Ian', 'Martinez', 'ian.martinez@example.com', '2145551009', 'ACTIVE'),
       ('Julia', 'Taylor', 'julia.taylor@example.com', '2145551010', 'ACTIVE');

-- Insert 20 addresses (DFW cities only)
INSERT INTO address (door_num, street, city, state, zip_code)
VALUES ('101A', 'Main Street', 'Dallas', 'TX', '75201'),
       ('202B', 'Elm Street', 'Fort Worth', 'TX', '76102'),
       ('303C', 'Maple Ave', 'Plano', 'TX', '75023'),
       ('404D', 'Cedar Lane', 'Frisco', 'TX', '75034'),
       ('505E', 'Oak Drive', 'McKinney', 'TX', '75069'),
       ('606F', 'Birch Road', 'Irving', 'TX', '75062'),
       ('707G', 'Walnut Blvd', 'Arlington', 'TX', '76010'),
       ('808H', 'Sycamore St', 'Garland', 'TX', '75040'),
       ('909I', 'Pecan Way', 'Richardson', 'TX', '75080'),
       ('111J', 'Ash Court', 'Allen', 'TX', '75002'),
       ('112K', 'Willow Drive', 'Mesquite', 'TX', '75150'),
       ('113L', 'Spruce Street', 'Carrollton', 'TX', '75007'),
       ('114M', 'Poplar Road', 'Lewisville', 'TX', '75067'),
       ('115N', 'Magnolia Lane', 'Flower Mound', 'TX', '75028'),
       ('116O', 'Chestnut Blvd', 'Denton', 'TX', '76201'),
       ('117P', 'Redwood Drive', 'The Colony', 'TX', '75056'),
       ('118Q', 'Cypress Ave', 'Grand Prairie', 'TX', '75052'),
       ('119R', 'Palm Street', 'Euless', 'TX', '76039'),
       ('120S', 'Hickory Ct', 'Grapevine', 'TX', '76051'),
       ('121T', 'Beech Way', 'Southlake', 'TX', '76092');

-- Insert 20 properties (linked to addresses by door_num)
INSERT INTO property (status, address_id)
VALUES ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '101A')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '202B')),
       ('UNDER_MAINTENANCE', (SELECT address_id FROM address WHERE door_num = '303C')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '404D')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '505E')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '606F')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '707G')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '808H')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '909I')),
       ('UNDER_MAINTENANCE', (SELECT address_id FROM address WHERE door_num = '111J')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '112K')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '113L')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '114M')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '115N')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '116O')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '117P')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '118Q')),
       ('UNDER_MAINTENANCE', (SELECT address_id FROM address WHERE door_num = '119R')),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '120S')),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '121T'));
