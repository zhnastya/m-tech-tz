CREATE TABLE IF NOT EXISTS wheels
(
    id         int not null AUTO_INCREMENT,
    type_wheel ENUM ('R15', 'R16', 'R17') unique,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS bodies
(
    id        int not null AUTO_INCREMENT,
    type_body ENUM ('Hatchback', 'Sedan', 'Sports') unique,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS cars
(
    id              int          not null AUTO_INCREMENT,
    name            varchar(250) NOT NULL,
    count_wheel     bigint       NOT NULL,
    date_of_created TIMESTAMP    NOT NULL,
    body_type_id    int          NOT NULL,
    wheel_type_id   int          NOT NULL,
    primary key (id),
    FOREIGN KEY (body_type_id) REFERENCES bodies (id),
    FOREIGN KEY (wheel_type_id) REFERENCES wheels (id)
);