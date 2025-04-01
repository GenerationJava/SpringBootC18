package com.miprimerspring.syntaxpelis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paisId;

    @Column(name = "pais_nombre", length = 50, unique = true, nullable = false)
    private String paisNombre;

    @Column(name = "pais_capital", length = 50)
    private String paisCapital;

    /** Constructores **/
    public Pais() {
    }

    public Pais(long paisId, String paisNombre, String paisCapital) {
        this.paisId = paisId;
        this.paisNombre = paisNombre;
        this.paisCapital = paisCapital;
    }

    /*** Getter y Setter ***/
    public long getPaisId() {
        return paisId;
    }

    public void setPaisId(long paisId) {
        this.paisId = paisId;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }

    public String getPaisCapital() {
        return paisCapital;
    }

    public void setPaisCapital(String paisCapital) {
        this.paisCapital = paisCapital;
    }

    /** To String **/
    @Override
    public String toString() {
        return "Pais{" +
                "paisId=" + paisId +
                ", paisNombre='" + paisNombre + '\'' +
                ", paisCapital='" + paisCapital + '\'' +
                '}';
    }
}
