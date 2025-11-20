CREATE TABLE rechnungsstatus_enum (
    status VARCHAR(20) PRIMARY KEY
);

INSERT INTO rechnungsstatus_enum VALUES
('OFFEN'), ('BEZAHLT'), ('STORNIERT'), ('GEMAHNT');


CREATE TABLE zahlungsart_enum (
    art VARCHAR(20) PRIMARY KEY
);

INSERT INTO zahlungsart_enum VALUES
('PAYPAL'), ('UEBERWEISUNG'), ('KREDITKARTE'), ('BAR');


CREATE TABLE adresse (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    strasse VARCHAR(255),
    hausnummer VARCHAR(50),
    plz VARCHAR(20),
    stadt VARCHAR(255)
);


CREATE TABLE kreditkarteninformation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nummer VARCHAR(50),
    inhaber VARCHAR(255),
    karten_typ VARCHAR(20),
    FOREIGN KEY (karten_typ) REFERENCES zahlungsart_enum(art)
);


CREATE TABLE kunde (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255),
    telefon VARCHAR(100),
    adresse_id BIGINT,
    kreditkarte_id BIGINT,
    FOREIGN KEY (adresse_id) REFERENCES adresse(id),
    FOREIGN KEY (kreditkarte_id) REFERENCES kreditkarteninformation(id)
);


CREATE TABLE privatkunde (
    id BIGINT PRIMARY KEY,
    vorname VARCHAR(255),
    nachname VARCHAR(255),
    FOREIGN KEY (id) REFERENCES kunde(id)
);


CREATE TABLE geschaeftskunde (
    id BIGINT PRIMARY KEY,
    firmenname VARCHAR(255),
    ust_id VARCHAR(255),
    FOREIGN KEY (id) REFERENCES kunde(id)
);


CREATE TABLE vipkunde (
    id BIGINT PRIMARY KEY,
    rabatt_satz DOUBLE,
    personal_account_manager VARCHAR(255),
    FOREIGN KEY (id) REFERENCES geschaeftskunde(id)
);


CREATE TABLE produkt (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    bezeichnung VARCHAR(255),
    preis DOUBLE
);


CREATE TABLE lieferant (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    adresse_id BIGINT,
    FOREIGN KEY (adresse_id) REFERENCES adresse(id)
);


CREATE TABLE produkt_lieferant (
    produkt_id BIGINT,
    lieferant_id BIGINT,
    PRIMARY KEY (produkt_id, lieferant_id),
    FOREIGN KEY (produkt_id) REFERENCES produkt(id),
    FOREIGN KEY (lieferant_id) REFERENCES lieferant(id)
);


CREATE TABLE rechnung (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    rechnungs_datum DATE,
    rechnungs_nummer VARCHAR(255),
    status VARCHAR(20),
    zahlungsart VARCHAR(20),
    kunde_id BIGINT NOT NULL,
    FOREIGN KEY (status) REFERENCES rechnungsstatus_enum(status),
    FOREIGN KEY (zahlungsart) REFERENCES zahlungsart_enum(art),
    FOREIGN KEY (kunde_id) REFERENCES kunde(id)
);


CREATE TABLE rechnungsposition (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    menge INT,
    einzel_preis DOUBLE,
    rechnung_id BIGINT,
    produkt_id BIGINT,
    FOREIGN KEY (rechnung_id) REFERENCES rechnung(id) ON DELETE CASCADE,
    FOREIGN KEY (produkt_id) REFERENCES produkt(id)
);
