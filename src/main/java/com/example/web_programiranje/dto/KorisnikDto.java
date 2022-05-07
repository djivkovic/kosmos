package com.example.web_programiranje.dto;


import com.example.web_programiranje.entity.Korisnik;

public class KorisnikDto
{
    private Long id;

    private String ime;

    private String prezime;


    public KorisnikDto(Long id, String ime, String prezime)
    {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public KorisnikDto(Korisnik korisnik)
    {
        this.id = korisnik.getID();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
}
