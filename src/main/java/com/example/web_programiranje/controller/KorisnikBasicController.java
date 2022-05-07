package com.example.web_programiranje.controller;



import com.example.web_programiranje.dto.LoginDto;
import com.example.web_programiranje.entity.Korisnik;
import com.example.web_programiranje.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Controller
public class KorisnikBasicController
{

    @Autowired
    private KorisnikService korisnikService;


    @GetMapping("/hello")
    public String welcome()
    {
        return "index.html";
    }

    @GetMapping("/login-form")
    public String login(Model model)
    {
        LoginDto loginDto =  new LoginDto();
        model.addAttribute("login", loginDto);
        return "login-form.html";
    }



    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session){
        // proverimo da li su podaci validni
        if(loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty())
            return "redirect:/login-form";

        Korisnik korisnik = korisnikService.login(loginDto.getUsername(), loginDto.getPassword());
        if (korisnik == null)
            return "redirect:/login-form";

        session.setAttribute("korisnik", korisnik);
        return "redirect:/hello";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login-form";
    }

    @GetMapping("/korisnici")
    public String getKorisnik(Model model, HttpSession session){
        List<Korisnik> korisnikList = korisnikService.findAll();
        model.addAttribute("korisnici", korisnikList);

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null) {
            System.out.println("Nema sesije");
        } else {
            System.out.println(loggedKorisnik);
        }

        return "korisnici.html";
    }

    @GetMapping("/korisnici/{id}")
    public String getKorisnikById(@PathVariable(name = "id") Long id, Model model, HttpSession session){
        Korisnik korisnik = korisnikService.findOne(id);
        model.addAttribute("korisnik", korisnik);
        return "korisnici.html";
    }

    @GetMapping("/add-korisnik")
    public String addKorisnik(Model model) {
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "korisnik.html";
    }

    @PostMapping("/save-korisnik")
    public String saveKorisnik(@ModelAttribute Korisnik korisnik) {
        this.korisnikService.save(korisnik);
        return "redirect:/korisnici.html";
    }
}