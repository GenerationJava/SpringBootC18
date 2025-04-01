package com.miprimerspring.syntaxpelis.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

//Para indicar a Spring que esto es una entidad usamos la anotación @Entity
@Entity
//Para modificar el nombre de la tabla, usamos la anotación @Table y le pasamos el name
@Table(name = "peliculas")
public class Pelicula {

    /** ATRIBUTOS **/
    @Id//Esta anotación indica que el atributo siguiente, va a ser el ID o primary key de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Esta anotación le indica al atributo que se va a generar de manera auto incrementable
    private long peliculaId;

    //Las restricciones que agregamos en la anotación @Column se verán reflejadas en la tabla
    @Column(name = "pelicula_titulo", nullable = false)
    private String peliculaTitulo;

    @Column(name = "pelicula_anio", length = 4)
    private Integer peliculaAnio;

    @Column(name = "pelicula_duracion")
    private Integer peliculaDuracion;

    @Column(name = "pelicula_presupuesto")
    private BigDecimal peliculaPresupuesto;

    /** RELACIONES DE LA ENTIDAD **/
    //Relación n-1 con director
    @ManyToOne
    @JoinColumn(name = "pelicula_director", nullable = false)
    private Director peliculaDirector;

    //Relación n-1 con país
    @ManyToOne
    @JoinColumn(name = "pelicula_pais", nullable = true)
    private Pais peliculaPais;

    //Relacion n-n con generos
    @ManyToMany
    @JoinTable(
            name = "peliculas_generos",//Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "pelicula_id"),//Nombre de la columna que lleva la llave foránea en la entidad actual
            inverseJoinColumns = @JoinColumn(name = "genero_id")//Nombre de la columna que lleva la llave foránea de la otra tabla
    )
    private List<Genero> peliculasGeneros;


    /** CONSTRUCTORES **/
    public Pelicula() {

    }

    public Pelicula(long peliculaId, String peliculaTitulo, Integer peliculaAnio, Integer peliculaDuracion, BigDecimal peliculaPresupuesto) {
        this.peliculaId = peliculaId;
        this.peliculaTitulo = peliculaTitulo;
        this.peliculaAnio = peliculaAnio;
        this.peliculaDuracion = peliculaDuracion;
        this.peliculaPresupuesto = peliculaPresupuesto;
    }

    /** Getter & Setter **/
    public long getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(long peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getPeliculaTitulo() {
        return peliculaTitulo;
    }

    public void setPeliculaTitulo(String peliculaTitulo) {
        this.peliculaTitulo = peliculaTitulo;
    }

    public Integer getPeliculaAnio() {
        return peliculaAnio;
    }

    public void setPeliculaAnio(Integer peliculaAnio) {
        this.peliculaAnio = peliculaAnio;
    }

    public Integer getPeliculaDuracion() {
        return peliculaDuracion;
    }

    public void setPeliculaDuracion(Integer peliculaDuracion) {
        this.peliculaDuracion = peliculaDuracion;
    }

    public BigDecimal getPeliculaPresupuesto() {
        return peliculaPresupuesto;
    }

    public void setPeliculaPresupuesto(BigDecimal peliculaPresupuesto) {
        this.peliculaPresupuesto = peliculaPresupuesto;
    }

    public Director getPeliculaDirector() {
        return peliculaDirector;
    }

    public void setPeliculaDirector(Director peliculaDirector) {
        this.peliculaDirector = peliculaDirector;
    }

    public Pais getPeliculaPais() {
        return peliculaPais;
    }

    public void setPeliculaPais(Pais peliculaPais) {
        this.peliculaPais = peliculaPais;
    }

    public List<Genero> getPeliculasGeneros() {
        return peliculasGeneros;
    }

    public void setPeliculasGeneros(List<Genero> peliculasGeneros) {
        this.peliculasGeneros = peliculasGeneros;
    }

    /** ToString **/
    @Override
    public String toString() {
        return "Pelicula{" +
                "peliculaId=" + peliculaId +
                ", peliculaTitulo='" + peliculaTitulo + '\'' +
                ", peliculaAnio=" + peliculaAnio +
                ", peliculaDuracion=" + peliculaDuracion +
                ", peliculaPresupuesto=" + peliculaPresupuesto +
                '}';
    }

}
