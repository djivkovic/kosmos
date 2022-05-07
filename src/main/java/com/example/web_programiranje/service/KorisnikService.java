package com.example.web_programiranje.service;



import com.example.web_programiranje.entity.Korisnik;
import com.example.web_programiranje.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService
{
    @Autowired
    private static KorisnikRepository korisnikRepository;


    public static Korisnik findOne(Long id)
    {
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if(foundKorisnik.isPresent())
        {
            return foundKorisnik.get();
        }
        return null;
    }

    public List<Korisnik> findAll()
    {
        return (List<Korisnik>) korisnikRepository.findAll();
    }

    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }

    public static Korisnik login(String username, String password)
    {
        Korisnik korisnik = korisnikRepository.getByUsername(username);
        if(korisnik == null || !korisnik.getLozinka().equals(password))
        {
            return null;
        }
        return korisnik;
    }




}
