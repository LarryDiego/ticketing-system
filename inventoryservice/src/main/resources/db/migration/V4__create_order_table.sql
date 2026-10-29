CREATE TABLE `order` (
    id_order BIGINT AUTO_INCREMENT PRIMARY KEY,
    total DECIMAL(10, 2) NOT NULL,
    quantity BIGINT NOT NULL,
    placed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_customer BIGINT,
    id_event BIGINT,
    CONSTRAINT fk_order_customer FOREIGN KEY (id_customer) REFERENCES customer(id_customer) ON DELETE SET NULL,
    CONSTRAINT fk_order_event FOREIGN KEY (id_event) REFERENCES event(id_event) ON DELETE SET NULL
);