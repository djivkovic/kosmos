package com.example.web_programiranje.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

enum Pol {musko, zensko};
enum Uloga{admin, menadzer, dostavljac, kupac};
@Entity
public  class Korisnik implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "username", unique = true)
    private String username ;

    @Column(name = "password", unique = true)
    private String password;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "pol")
    @Enumerated
    private Pol pol;

    @Column(name = "datum_rodjenja")
    private Date datum_rodjenja;

    @Column(name = "uloga")
    @Enumerated
    protected Uloga uloga;

    @Column(name = "pol2")
    private String pol2;

    @Column(name = "datum_rodjenja2")
    private String  datum_rodjenja2;


    public String getKorisnicko_ime()
    {
        return username;
    }

    public void setKorisnicko_ime(String korisnicko_ime)
    {
        this.username = korisnicko_ime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getLozinka()
    {
        return password;
    }

    public void setLozinka(String lozinka)
    {
        this.password = lozinka;
    }

    public String getIme()
    {
        return ime;
    }

    public void setIme(String ime)
    {
        this.ime = ime;
    }

    public String getPrezime()
    {
        return prezime;
    }

    public void setPrezime(String prezime)
    {
        this.prezime = prezime;
    }


    public Date getDatum_rodjenja()
    {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja)
    {
        this.datum_rodjenja = datum_rodjenja;
    }

    public Uloga getUloga()
    {
        return uloga;
    }

    public void setUloga(Uloga uloga)
    {
        this.uloga = uloga;
    }

    public Korisnik(String korisnicko_ime, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja)
    {
        this.username = korisnicko_ime;
        this.password = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datum_rodjenja = datum_rodjenja;

    }

    public Korisnik(String korisnicko_ime, String lozinka, String ime, String prezime, String pol2, String datum_rodjenja2)
    {
        this.username = korisnicko_ime;
        this.password = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol2 = pol2;
        this.datum_rodjenja2 = datum_rodjenja2;

    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Korisnik() {
        username = "Djole";
        password = "djole";
    }
}