--CREATE TYPE rack_status_enum AS ENUM ('ACTIVE', 'RETURNED', 'REPAIR', 'OUTDATED', 'BRICKED');

CREATE TABLE T_TEAM(
                       id BIGINT DEFAULT random() PRIMARY KEY,
                       name varchar(50) NOT NULL,
                       product varchar(50),
                       created_at timestamp DEFAULT current_timestamp NOT NULL,
                       modified_at timestamp DEFAULT current_timestamp NOT NULL,
                       default_location varchar(50)
);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_ID;

CREATE TABLE T_TEAM_MEMBER(
                              id BIGINT DEFAULT random() PRIMARY KEY,
                              team_id BIGINT REFERENCES T_TEAM,
                              ctw_id varchar(50),
                              name varchar(50),
                              created_at timestamp DEFAULT current_timestamp NOT NULL,
                              modified_at timestamp DEFAULT current_timestamp NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS SEQ_TEAM_MEMBER_ID;

CREATE TABLE T_RACK(
    id BIGINT DEFAULT random() PRIMARY KEY,
    serial_number varchar(50) not null constraint serial_number unique constraint unic_serial_number unique,
    team_id BIGINT not null references t_team,
    created_at timestamp default CURRENT_TIMESTAMP not null,
    modified_at timestamp DEFAULT current_timestamp NOT NULL,
    default_location text,
    status varchar(12) DEFAULT 'ACTIVE' NOT NULL

);
CREATE SEQUENCE IF NOT EXISTS SEQ_RACK_ID;

CREATE TABLE T_RACK_ASSET(
    id BIGINT DEFAULT random() PRIMARY KEY,
    asset_tag varchar(50) not null,
    rack_id BIGINT references t_rack
);
CREATE SEQUENCE IF NOT EXISTS SEQ_RACk_ASSET_ID;

CREATE TABLE T_BOOKING(
                          id BIGINT DEFAULT random() PRIMARY KEY,
                          rack_id BIGINT REFERENCES t_rack,
                          requester_id BIGINT REFERENCES T_TEAM_MEMBER NOT NULL,
                          book_from date NOT NULL,
                          book_to date NOT NULL,
                          created_at timestamp DEFAULT current_timestamp NOT NULL,
                          modified_at timestamp DEFAULT current_timestamp NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS SEQ_BOOKING_ID;
