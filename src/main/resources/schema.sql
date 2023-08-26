create table if not exists brands
(
    id         uuid primary key default uuid_generate_v4(),
    name       varchar(45) unique not null,
    country    varchar(45)        not null,
    image_link varchar(255)       not null
);

create table if not exists vehicles
(
    id                   uuid primary key        default uuid_generate_v4(),
    owner_id             uuid           not null,
    brand_id             uuid references brands (id),
    model                varchar(45)    not null,
    year                 varchar(45)    not null,
    address              varchar(255)   not null,
    registration_number  varchar(45)    not null,
    color                varchar(45)    not null,
    number_of_doors      int2           not null default 4,
    number_of_seats      int2           not null default 4,
    vehicle_type         varchar(45)    not null,
    engine_type          varchar(45)    not null,
    fuel_type            varchar(45)    not null,
    transmission_type    varchar(45)    not null,
    vehicle_status       varchar(45)    not null,
    price_per_day        NUMERIC(11, 2) not null,


    image_link           varchar(255),
    successful_rentals   int            not null default 0,
    unsuccessful_rentals int            not null default 0,
    last_requested_at    timestamp,
    last_rented_at       timestamp
);

create table if not exists vehicle_settings
(
    id              uuid primary key default uuid_generate_v4(),
    vehicle_id      uuid references vehicles (id),
    is_visible      boolean not null default true,
    is_out_of_order boolean not null default false
);