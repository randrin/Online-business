/*
 * Table Category
 */

CREATE TABLE category (
	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(225),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category (name, description, image_url, is_active)
VALUES ('TV', 'Télevision de Marque', 'cat_1.png', true);

INSERT INTO category (name, description, image_url, is_active)
VALUES ('SMARPHONE', 'Smarphone de Marque', 'cat_2.png', true);

INSERT INTO category (name, description, image_url, is_active)
VALUES ('LAPTOP', 'Laptop de Marque', 'cat_3.png', true);

/*
 * Table User
 */
CREATE TABLE user_detail (
	id IDENTITY,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	role VARCHAR(50),
	gender VARCHAR(1),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),	
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail (first_name, last_name, gender, role, enabled, password, email, contact_number)
VALUES ('Randrino', 'Nzeukang', 'M', 'ADMIN', true, '$2y$12$Bk3VFSBDX4g65on5nIInyuvqkW.ZQVmmJxcvzMAffcc3eJimj80QC', 'nzeukangrandrin@gmail.com', '3296187465');

INSERT INTO user_detail (first_name, last_name, gender, role, enabled, password, email, contact_number)
VALUES ('Vanessa', 'Takou', 'F', 'SUPPLIER', true, '$2y$12$sZXpnzGB4cUs.5V1lvjW1uPYB5B3.4wvaN/6ki5rUYzK3Lh8jdXjG', 'vtakou7@gmail.com', '7852569812');

INSERT INTO user_detail (first_name, last_name, gender, role, enabled, password, email, contact_number)
VALUES ('Aurel', 'Tchoffo', 'M', 'SUPPLIER', true, '$2y$12$Bk3VFSBDX4g65on5nIInyuvqkW.ZQVmmJxcvzMAffcc3eJimj80QC', 'tchoffo@gmail.com', '7777777777');

/*
 * Table Product
 */
CREATE TABLE product (
	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),	
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDQUQISJ458DGF', 'Samsung S7', 'Samsung', 'The new samsung s7 available in the OnlineShopping Store',32000, 5, true, 2, 2, 1, 3);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDJAUSIS89WQ4', 'Lenovo', 'Laptop', 'The new lenovo Pc available in the OnlineShopping Store',897000, 10, true, 3, 3, 1, 13);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDQUQISJ458DGF', 'Akkai', 'Tv', 'The new Akkai Tv available in the OnlineShopping Store',897000, 3, true, 1, 1, 11, 33);

/*
 * Table Cart Line
 */
CREATE TABLE cart_line (
	id IDENTITY,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);