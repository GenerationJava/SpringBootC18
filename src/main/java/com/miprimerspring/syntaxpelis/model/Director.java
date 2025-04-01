package com.miprimerspring.syntaxpelis.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "directores")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long directorId;

    @Column(name = "director_nombre", unique = true, nullable = false, length = 50)
    private String directorNombre;

    @Column(name = "director_fecha")
    private Date directorFechaNacimiento;

    //Esto puede generar problemas de recursividad, porque cuando consulto por un director este trae la información de todas las películas
    @JsonIgnore//Esta anotación va a ignorar la lista de películas cuando se consulte por director
    @OneToMany(mappedBy = "peliculaDirector")//En la relación OneToMany indicamos el atributo de la otra tabla, que mapea la relación
    private List<Pelicula> directorPeliculas;

    @ManyToOne
    @JoinColumn(name = "director_nacionalidad")
    private Pais directorNacionalidad;
    

    public Director() {
    }

    public Director(long directorId, String directorNombre, Date directorFechaNacimiento) {
        this.directorId = directorId;
        this.directorNombre = directorNombre;
        this.directorFechaNacimiento = directorFechaNacimiento;
    }

    public long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(long directorId) {
        this.directorId = directorId;
    }

    public String getDirectorNombre() {
        return directorNombre;
    }

    public void setDirectorNombre(String directorNombre) {
        this.directorNombre = directorNombre;
    }

    public Date getDirectorFechaNacimiento() {
        return directorFechaNacimiento;
    }

    public void setDirectorFechaNacimiento(Date directorFechaNacimiento) {
        this.directorFechaNacimiento = directorFechaNacimiento;
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorId=" + directorId +
                ", directorNombre='" + directorNombre + '\'' +
                ", directorFechaNacimiento=" + directorFechaNacimiento +
                '}';
    }
}
