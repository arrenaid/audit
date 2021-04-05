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
    ident_doc       INTEGER                      NOT NULL,
    date_of_birth   DATE                         NOT NULL,
    place_of_birth  VARCHAR(1000)                NOT NULL,
    arrest_list     INTEGER
);

CREATE TABLE arrest(
--    'id'         INTEGER PRIMARY KEY DEFAULT nextval('arrest_seq'),
    arrest_id       INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    organe_code     INTEGER      NOT NULL,
    doc_date        DATE         NOT NULL,
    doc_num         VARCHAR      NOT NULL,
    purpose         VARCHAR      NOT NULL,
    amount          INTEGER       NOT NULL,
    ref_doc_num     VARCHAR      NOT NULL,
    operation       INTEGER      NOT NULL
);

CREATE TABLE client_arrest_list(
--    'id'         INTEGER PRIMARY KEY DEFAULT nextval('list_arrest_seq'),
    arrest_list_id INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_client       INTEGER         REFERENCES client (client_id),
    id_arrest       INTEGER         REFERENCES arrest (arrest_id)
);

CREATE TABLE client_doc (
--    'id'       INTEGER PRIMARY KEY DEFAULT nextval('doc_seq'),
    doc_id      INT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    type_doc          INTEGER         NOT NULL,
    number_series   VARCHAR         NOT NULL,
    issue_date      DATE            NOT NULL
);
