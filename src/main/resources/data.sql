
--Insert tenants
INSERT INTO tenant (first_name, last_name, email, phone, status, create_date_time, update_date_time, created_by, last_modified_by)
VALUES ('Alice', 'Johnson', 'alice.johnson@example.com', '2145551001', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Bob', 'Smith', 'bob.smith@example.com', '2145551002', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Charlie', 'Davis', 'charlie.davis@example.com', '2145551003', 'INACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Diana', 'Lopez', 'diana.lopez@example.com', '2145551004', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Ethan', 'Brown', 'ethan.brown@example.com', '2145551005', 'BLACKLISTED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Fiona', 'Wilson', 'fiona.wilson@example.com', '2145551006', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('George', 'Miller', 'george.miller@example.com', '2145551007', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Hannah', 'Garcia', 'hannah.garcia@example.com', '2145551008', 'INACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Ian', 'Martinez', 'ian.martinez@example.com', '2145551009', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('Julia', 'Taylor', 'julia.taylor@example.com', '2145551010', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM');


-- Insert 20 addresses (DFW cities only)
INSERT INTO address (door_num, street, city, state, zip_code, create_date_time, update_date_time, created_by, last_modified_by)
VALUES ('101A', 'Main Street', 'Dallas', 'TX', '75201', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('202B', 'Elm Street', 'Fort Worth', 'TX', '76102', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('303C', 'Maple Ave', 'Plano', 'TX', '75023', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('404D', 'Cedar Lane', 'Frisco', 'TX', '75034', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('505E', 'Oak Drive', 'McKinney', 'TX', '75069', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('606F', 'Birch Road', 'Irving', 'TX', '75062', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('707G', 'Walnut Blvd', 'Arlington', 'TX', '76010', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('808H', 'Sycamore St', 'Garland', 'TX', '75040', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('909I', 'Pecan Way', 'Richardson', 'TX', '75080', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('111J', 'Ash Court', 'Allen', 'TX', '75002', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('112K', 'Willow Drive', 'Mesquite', 'TX', '75150', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('113L', 'Spruce Street', 'Carrollton', 'TX', '75007', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('114M', 'Poplar Road', 'Lewisville', 'TX', '75067', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('115N', 'Magnolia Lane', 'Flower Mound', 'TX', '75028', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('116O', 'Chestnut Blvd', 'Denton', 'TX', '76201', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('117P', 'Redwood Drive', 'The Colony', 'TX', '75056', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('118Q', 'Cypress Ave', 'Grand Prairie', 'TX', '75052', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('119R', 'Palm Street', 'Euless', 'TX', '76039', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('120S', 'Hickory Ct', 'Grapevine', 'TX', '76051', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('121T', 'Beech Way', 'Southlake', 'TX', '76092', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM');

-- Insert 20 properties (linked to addresses by door_num)
INSERT INTO property (status, address_id, create_date_time, update_date_time, created_by, last_modified_by)
VALUES ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '101A'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '202B'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('UNDER_MAINTENANCE', (SELECT address_id FROM address WHERE door_num = '303C'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '404D'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '505E'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '606F'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '707G'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '808H'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '909I'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('UNDER_MAINTENANCE', (SELECT address_id FROM address WHERE door_num = '111J'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '112K'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '113L'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '114M'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '115N'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '116O'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '117P'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '118Q'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('UNDER_MAINTENANCE', (SELECT address_id FROM address WHERE door_num = '119R'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('AVAILABLE', (SELECT address_id FROM address WHERE door_num = '120S'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM'),
       ('RENTED', (SELECT address_id FROM address WHERE door_num = '121T'), CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'SYSTEM', 'SYSTEM');
