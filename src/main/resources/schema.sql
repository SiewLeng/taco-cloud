CREATE TABLE ingredient (
    id varchar(4) NOT NULL,
    name varchar(25) NOT NULL,
    type varchar(25) NOT NULL
);

CREATE TABLE taco_order (
    id int NOT NULL,
    delivery_Name varchar(50) NOT NULL,
    delivery_Street varchar(50) NOT NULL,
    delivery_City varchar(50) NOT NULL,
    delivery_State varchar(50) NOT NULL,
    delivery_Zip varchar(10) NOT NULL,
    cc_number varchar(16) NOT NULL,
    cc_expiration varchar(10) NOT NULL,
    cc_cvv varchar(10) NOT NULL,
    placed_at timestamp NOT NULL,
    PRIMARY KEY (id)
);