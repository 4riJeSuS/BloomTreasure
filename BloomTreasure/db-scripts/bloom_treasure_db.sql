CREATE TABLE CLIENT
(
    id_clt INT NOT NULL auto_increment,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    address VARCHAR(100) NOT NULL,
    nif VARCHAR(20) NOT NULL,
    active VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_clt)
);

CREATE TABLE CATEGORY
(
    id_cat INT NOT NULL auto_increment,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL,
    PRIMARY KEY (id_cat)
);

CREATE TABLE STOCK
(
    id_stk INT NOT NULL auto_increment,
    quantity INT NOT NULL,
    state VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_stk)
);

CREATE TABLE PRODUCT
(
    id_prod INT NOT NULL,
    name VARCHAR(100) NOT NULL auto_increment,
    description VARCHAR(200) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    id_cat INT NOT NULL,
    id_stk INT NOT NULL,
    PRIMARY KEY (id_prod),
    FOREIGN KEY (id_cat) REFERENCES CATEGORY(id_cat),
    FOREIGN KEY (id_stk) REFERENCES STOCK(id_stk)
);

CREATE TABLE ORDER_SALE
(
    id_order INT NOT NULL auto_increment,
    date DATE NOT NULL,
    total_price NUMERIC(10, 2) NOT NULL,
    state VARCHAR(30) NOT NULL,
    payment_method VARCHAR(30) NOT NULL,
    id_clt INT NOT NULL,
    PRIMARY KEY (id_order),
    FOREIGN KEY (id_clt) REFERENCES CLIENT(id_clt)
);

CREATE TABLE ITEM_ORDER
(
    id_itord INT NOT NULL auto_increment,
    quantity INT NOT NULL,
    unit_price NUMERIC(10, 2) NOT NULL,
    id_order INT NOT NULL,
    PRIMARY KEY (id_itord),
    FOREIGN KEY (id_order) REFERENCES ORDER_SALE(id_order)
);

CREATE TABLE RECEIPT
(
    id_rct INT NOT NULL auto_increment,
    emi_date DATE NOT NULL,
    client_nif VARCHAR(20) NOT NULL,
    receipt_info VARCHAR(1000) NOT NULL,
    total NUMERIC(10, 2) NOT NULL,
    id_order INT NOT NULL,
    PRIMARY KEY (id_rct),
    FOREIGN KEY (id_order) REFERENCES ORDER_SALE(id_order)
);

CREATE TABLE REFERENCE
(
    id_prod INT NOT NULL,
    id_itord INT NOT NULL,
    PRIMARY KEY (id_prod, id_itord),
    FOREIGN KEY (id_prod) REFERENCES PRODUCT(id_prod),
    FOREIGN KEY (id_itord) REFERENCES ITEM_ORDER(id_itord)
);