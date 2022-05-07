package com.example.web_programiranje.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Lokacija implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column
    private String geografska_duzina;

    @Column
    private String geografska_sirina;

    @Column
    private String adresa;

    public Lokacija(String geografska_duzina, String geografska_sirina, String adresa)
    {
        this.geografska_duzina = geografska_duzina;
        this.geografska_sirina = geografska_sirina;
        this.adresa = adresa;
    }

    public Lokacija() {
    }

    public String getGeografska_duzina()
    {
        return geografska_duzina;
    }

    public void setGeografska_duzina(String geografska_duzina)
    {
        this.geografska_duzina = geografska_duzina;
    }

    public String getGeografska_sirina()
    {
        return geografska_sirina;
    }

    public void setGeografska_sirina(String geografska_sirina)
    {
        this.geografska_sirina = geografska_sirina;
    }

    public String getAdresa()
    {
        return adresa;
    }

    public void setAdresa(String adresa)
    {
        this.adresa = adresa;
    }
}

