package cl.ucn.disc.dam.discnews.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

/**
 * Representa una Noticia en un instante de tiempo
 * para el sistema de DISC News.
 *
 * @author Kevin Araya Reygada
 */
@Builder
public final class Noticia {

    /**
     * Descripcion en una linea del titulo de la noticia
     */
    @Getter
    private String titulo;

    /**
     * Descripcion en 2 lineas y con un maximo de 140 caracteres
     */
    @Getter
    private String resumen;

    /**
     * Contenido completo de la Noticia
     */
    @Getter
    private String contenido;

    /**
     * Fecha de la noticia
     */
    @Getter
    private LocalDateTime fecha;

    /**
     * Icono de la noticia de 64x64 pixels
     */
    @Getter
    private String icono;

    /**
     * Autor de la noticia en formato: "Kevin Araya <kevxar@gmail.com>"
     */
    @Getter
    private String autor;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
