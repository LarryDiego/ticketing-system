CREATE TABLE venue (
                       id_venue BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       address VARCHAR(255) NOT NULL,
                       total_capacity BIGINT NOT NULL
);

CREATE TABLE event (
                       id_event BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       id_venue BIGINT NOT NULL,
                       total_capacity BIGINT NOT NULL,
                       left_capacity BIGINT NOT NULL,
                       CONSTRAINT fk_event_venue FOREIGN KEY (id_venue) REFERENCES venue(id_venue) ON DELETE CASCADE
);