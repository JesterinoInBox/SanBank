
CREATE TABLE IF NOT EXISTS clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    country_of_residence VARCHAR(32) NOT NULL,
    city_of_residence VARCHAR(32) NOT NULL,
    street_of_residence VARCHAR(32) NOT NULL,
    year_of_birth SMALLINT NOT NULL,
    created_date TIMESTAMP,
    updated_date TIMESTAMP,
    created_by VARCHAR(32),
    updated_by VARCHAR(32)
);