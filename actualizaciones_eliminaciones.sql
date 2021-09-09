DELETE FROM escuderia WHERE nombre='Mechas Plateadas';

UPDATE pilotos
SET millas_recorridas=124009.2,combustible_usado=98737372
WHERE nombre='Chumajer';

INSERT INTO participaciones(fecha_hora,posicion_piloto,codigo_piloto,id_carrera) values(current_timestamp(),1,12,3);

UPDATE carreras
SET capacidad_asistentes=10284,nivel_dificultad=6.3
WHERE nombre='Vitaguata';
