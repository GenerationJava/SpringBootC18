package com.miprimerspring.syntaxpelis.model;


import jakarta.persistence.*;

import java.util.Date;

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
