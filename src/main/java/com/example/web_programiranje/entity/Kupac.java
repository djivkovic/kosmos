package com.example.web_programiranje.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kupac extends  Korisnik implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @OneToMany(mappedBy =  "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Porudzbina> porudzbine = new HashSet<>();

    @Column(name = "bodovi")
    private Integer bodovi;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tip_kupca", referencedColumnName = "id")
    private TipKupca tip_kupca;


    public Kupac(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja, Integer bodovi, TipKupca tip_kupca) {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja);
        this.bodovi = bodovi;
        this.tip_kupca = tip_kupca;
    }

    public Kupac() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }


    public Integer getBodovi() {
        return bodovi;
    }

    public void setBodovi(Integer bodovi) {
        this.bodovi = bodovi;
    }

    public TipKupca getTip_kupca() {
        return tip_kupca;
    }

    public void setTip_kupca(TipKupca tip_kupca) {
        this.tip_kupca = tip_kupca;
    }
}

