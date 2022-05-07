package com.example.web_programiranje.entity;

import javax.persistence.*;
import java.io.Serializable;
enum Tip {jelo, pice};

@Entity
public class Artikal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ID;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "cena")
    private Double cena;

    @Column(name = "tip")
    @Enumerated
    private Tip tip;

    @Column(name = "kolicina")
    private Integer kolicina;

    @Column(name = "opis")
    private String opis;

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    private Restoran restoran;

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }


    public Artikal(String naziv, Double cena, Tip tip, Integer kolicina, String opis) {
        this.naziv = naziv;
        this.cena = cena;
        this.tip = tip;
        this.kolicina = kolicina;
        this.opis = opis;
    }

    public Artikal() {

    }

    public String getNaziv() {

        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
