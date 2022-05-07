package com.example.web_programiranje.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "restoran", referencedColumnName = "id")
    private Restoran restoran;


    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja)
    {
        super(korisnicko_ime, lozinka, ime, prezime, pol, datum_rodjenja);
        setUloga(Uloga.menadzer);
    }

    public Menadzer() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}

