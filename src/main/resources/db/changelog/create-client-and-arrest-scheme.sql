DROP TABLE IF EXISTS arrest, client, client_arrest_list, client_doc;
--CREATE SEQUENCE client_seq START WITH 100000;
--CREATE SEQUENCE arrest_seq START WITH 100000;
--CREATE SEQUENCE doc_seq START WITH 100000;
--CREATE SEQUENCE list_arrest_seq START WITH 100000;

CREATE TABLE client(
--    'id'         INTEGER PRIMARY KEY DEFAULT nextval('client_seq'),
    client_id       INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    last_name       VARCHAR(100)                 NOT NULL,
    first_name      VARCHAR(100)                 NOT NULL,
    date_of_birth   DATE                         NOT NULL,
    place_of_birth  VARCHAR(1000)                NOT NULL,
    type_doc        INT             NOT NULL,
    number_doc      VARCHAR         NOT NULL,
    series_doc      VARCHAR         NOT NULL,
    issue_date_doc  DATE            ,
    arrest_list     INT
);

CREATE TABLE arrest(
--    'id'         INTEGER PRIMARY KEY DEFAULT nextval('arrest_seq'),
    arrest_id       INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    organ_code      INT      NOT NULL,
    doc_date        DATE         NOT NULL,
    doc_num         VARCHAR      NOT NULL,
    purpose         VARCHAR      NOT NULL,
    amount          INT       NOT NULL,
    ref_doc_num     VARCHAR      NOT NULL,
    operation       INT      NOT NULL
);

CREATE TABLE client_arrest_list(
--    'id'         INTEGER PRIMARY KEY DEFAULT nextval('list_arrest_seq'),
    arrest_list_id  INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_client       INT         REFERENCES client (client_id),
    id_arrest       INT         REFERENCES arrest (arrest_id)
);

--CREATE TABLE client_doc (
----    'id'       INTEGER PRIMARY KEY DEFAULT nextval('doc_seq'),
--    doc_id      INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--    type_doc        INT             NOT NULL,
--    number_doc      VARCHAR         NOT NULL,
--    series_doc      VARCHAR         NOT NULL,
--    issue_date      DATE            NOT NULL
--);
