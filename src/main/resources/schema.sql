CREATE TABLE ingredient (
    id varchar(4) NOT NULL,
    name varchar(25) NOT NULL,
    type varchar(25) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE taco_order (
    id bigint NOT NULL,
    delivery_name varchar(50) NOT NULL,
    delivery_street varchar(50) NOT NULL,
    delivery_city varchar(50) NOT NULL,
    delivery_state varchar(50) NOT NULL,
    delivery_zip varchar(10) NOT NULL,
    cc_number varchar(16) NOT NULL,
    cc_expiration varchar(10) NOT NULL,
    cc_cvv varchar(10) NOT NULL,
    placed_at timestamp NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE taco (
    id bigint NOT NULL,
    name varchar(50) NOT NULL,
    taco_order bigint NOT NULL,
    taco_order_key bigint NOT NULL,
    created_at timestamp NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (taco_order) REFERENCES taco_order(id)
);

CREATE TABLE taco_ingredient (
    id bigint NOT NULL,
    ingredient varchar(4) NOT NULL,
    taco bigint NOT NULL,
    taco_key bigint NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (taco) REFERENCES taco(id)
);