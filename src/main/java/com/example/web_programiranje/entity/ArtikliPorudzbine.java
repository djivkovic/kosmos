package com.example.web_programiranje.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ArtikliPorudzbine extends Artikal implements Serializable
{

    @Column
    private Integer broj;

    @ManyToOne
    @JoinColumn(name = "artikal_id")
    private Artikal artikal;

    @ManyToOne
    @JoinColumn(name = "porudzbina_id")
    private Porudzbina porudzbina;





    public ArtikliPorudzbine() {

    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public Artikal getArtikal() {
        return artikal;
    }


    public ArtikliPorudzbine(String naziv, Double cena, Tip tip, Integer kolicina, String opis, Integer broj, Artikal artikal, Porudzbina porudzbina) {
        super(naziv, cena, tip, kolicina, opis);
        this.broj = broj;
        this.artikal = artikal;
        this.porudzbina = porudzbina;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }
}