CREATE TABLE IF NOT EXISTS product (
                                       id SERIAL PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    article VARCHAR(255) UNIQUE NOT NULL,
    description TEXT,
    category VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    last_quantity_update TIMESTAMP,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
