SELECT 'Consulta 1';
SELECT *
FROM escuderia;
SELECT 'Consulta 2';
Select pilotos.codigo_piloto,pilotos.nombre,pilotos.combustible_usado,pilotos.millas_recorridas,escuderia.nombre,escuderia.patrocinador
from pilotos,escuderia
where pilotos.codigo_escuderia=escuderia.cod_escuderia;
SELECT 'Consulta 3';
select carreras.nombre,carreras.bajo_techo,carreras.nivel_dificultad,pilotos.nombre,participaciones.posicion_piloto
from carreras,participaciones,pilotos
where carreras.id_carrera=participaciones.id_carrera AND participaciones.codigo_piloto=pilotos.codigo_piloto AND pilotos.nombre='JuanPis';