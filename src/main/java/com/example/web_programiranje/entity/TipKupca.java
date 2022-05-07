package com.example.web_programiranje.entity;

import javax.persistence.*;
import java.io.Serializable;

enum Ime {zlatni, srebrni, bronzani};

@Entity
public class TipKupca implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "ime")
    @Enumerated
    private Ime ime;

    @Column(name = "popust")
    private Double popust;

    @Column(name = "trazeni_broj_bodova")
    private Integer trazeni_broj_bodova;


    public TipKupca(Ime ime, Double popust, Integer trazeni_broj_bodova) {
        super();
        this.ime = ime;
        this.popust = popust;
        this.trazeni_broj_bodova = trazeni_broj_bodova;
    }

    public TipKupca() {
    }

    public Ime getIme() {
        return ime;
    }

    public void setIme(Ime ime) {
        this.ime = ime;
    }

    public Double getPopust() {
        return popust;
    }

    public void setPopust(Double popust) {
        this.popust = popust;
    }

    public Integer getTrazeni_broj_bodova() {
        return trazeni_broj_bodova;
    }

    public void setTrazeni_broj_bodova(Integer trazeni_broj_bodova) {
        this.trazeni_broj_bodova = trazeni_broj_bodova;
    }
}
