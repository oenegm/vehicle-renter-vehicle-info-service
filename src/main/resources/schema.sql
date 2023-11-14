create extension if not exists "uuid-ossp";

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
    model                varchar(45)    null,
    year                 varchar(45)    null,
    address              varchar(255)   null,
    registration_number  varchar(45)    null,
    color                varchar(45)    null,
    number_of_doors      int2           null     default 4,
    number_of_seats      int2           null     default 4,
    vehicle_status       varchar(45)    null,
    price_per_day        numeric(11, 2) null,
    image_link           varchar(255)   null,
    successful_rentals   int            null     default 0,
    unsuccessful_rentals int            null     default 0,
    last_requested_at    timestamp      null,
    last_rented_at       timestamp      null,
    deleted              boolean        not null default false
);

create table if not exists vehicle_settings
(
    id             uuid primary key default uuid_generate_v4(),
    vehicle_id     uuid references vehicles (id),
    visible        boolean not null default true,
    out_of_service boolean not null default false
);