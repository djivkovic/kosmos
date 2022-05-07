package com.example.web_programiranje.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Dostavljac extends Korisnik implements Serializable
{
    @OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL)
    @JoinColumn(name = "porudzbina", referencedColumnName = "id")
    private Set<Porudzbina> porudzbine = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    public Dostavljac(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja)
    {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja);
        porudzbine = new HashSet<>();
        setUloga(Uloga.dostavljac);
    }

    public Dostavljac() {
    }

    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }
}