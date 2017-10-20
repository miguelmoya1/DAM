CREATE TABLE portatiles (
    id SERIAL PRIMARY KEY,
    marca CHAR(3),
    modelo VARCHAR(50),
    procesador VARCHAR(50),
    ram VARCHAR(50)
);

CREATE TABLE  marcas (
    id CHAR(3) PRIMARY KEY,
    nombre VARCHAR(50)
);

ALTER TABLE portatiles ADD CONSTRAINT marca FOREIGN KEY marca REFERENCES marca(id);


