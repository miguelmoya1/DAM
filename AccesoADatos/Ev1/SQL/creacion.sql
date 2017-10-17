-- MIGUEL MOYA ORTEGA
-- REPASO

INSERT INTO muebles VALUES (200111413, 'Mesa LACK', 10, 'Conglomerado');
INSERT INTO muebles VALUES (70261150, 'Silla MARKUS', 159, 'Varios');
INSERT INTO muebles VALUES (791229203, 'Sofá EKTOPP', 249, 'Tela beige');

-- Todos los datos
SELECT * FROM muebles;

-- Nombre de los artículos de más de 100 euros ordenado (por nombre, ascendente)
SELECT nombre FROM muebles WHERE precio > 100;

-- Sillas de menos de 200 euros ordenadas por precio descendente
SELECT * FROM muebles WHERE nombre LIKE '%SILLA%' AND precio > 200 ORDER BY precio DESC;

-- Cambiar a 269 el precio de los muebles Ektorp
UPDATE muebles SET precio = 269 WHERE nombre LIKE '%EKTORP%';

-- Añadir el campo "unidades" a la tabla (podrá tener valores de 0 a 99.999)
ALTER TABLE MUEBLES ADD unidades integer;
