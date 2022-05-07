package com.example.web_programiranje.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Porudzbina implements Serializable
{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", updatable = false, nullable = false)
    private Long UUID;


    @ManyToMany
    @JoinTable(name = "sadrzi", joinColumns = @JoinColumn(name = "porudzbina_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "artikal_id", referencedColumnName = "id"))
    private Set<Artikal>artikli = new HashSet<>();



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Restoran restoran_poruceno;

    @Column(name = " vreme_porudzbine")
    private Date vreme_porudzbine;

    @Column(name = "korisnicko_ime")
    private String korisnicko_ime;

    @Column(name = "status")
    private String status;

    @Column(name = "cena")
    private double Cena;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Kupac kupac;

    @ManyToOne
    @JoinColumn(name = "dostavljac_id")
    private Dostavljac dostavljac;

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public Porudzbina(Long UUID, Set<Artikal> artikli, Restoran restoran_poruceno, Date vreme_porudzbine, String korisnicko_ime, String status) {
        this.UUID = UUID;
        this.artikli = artikli;
        this.restoran_poruceno = restoran_poruceno;
        this.vreme_porudzbine = vreme_porudzbine;
        this.korisnicko_ime = korisnicko_ime;
        this.status = status;
    }

    public Porudzbina() {
    }
}
