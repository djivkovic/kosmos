package com.example.web_programiranje.controller;


import com.example.web_programiranje.dto.KorisnikDto;
import com.example.web_programiranje.dto.LoginDto;
import com.example.web_programiranje.entity.Korisnik;
import com.example.web_programiranje.repository.KorisnikRepository;
import com.example.web_programiranje.service.KorisnikService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class KorisnikRestController
{

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KorisnikService korisnikService;

    public class findByUsername {
        @GetMapping("api/korisnici/{username}")
        public Korisnik getKorisnikByUsername(@PathParam("username") String username) {
            List<Korisnik> korisnici = korisnikService.findAll();
            for (Korisnik k : korisnici) {
                if (k.getKorisnicko_ime().equals(username))
                    return k;
            }
            return null;
        }
    }

    @RequestMapping(value = "api", method = RequestMethod.GET)
    //@GetMapping("/api/")
    public String welcome()
    {
        return "Hello from api!";
    }

    @PostMapping("api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session)
    {
        //MORA DA SE VRATI KORISNIK DA BI ZNALI KO POSLE UPUCUJE ZAHTEVE

        // proverimo da li su podaci validni
        if(loginDto.getUsername().isEmpty() || loginDto.getPassword().isEmpty())
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getUsername(), loginDto.getPassword());
        if (loggedKorisnik == null)
            return new ResponseEntity<>("User does not exist!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Successfully logged in!");
    }

    @PostMapping("/api/logout")
    public ResponseEntity logout(HttpSession session)
    {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);
    }


    @GetMapping("api/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnik(HttpSession session)
    {
        List<Korisnik> korisnikList = korisnikService.findAll();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null)
        {
            System.out.println("Nema sesije");
        } else {
            System.out.println(loggedKorisnik);
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : korisnikList){
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/api/korisnici/{id}")
    public Korisnik getKorisnikById(@PathVariable(name = "id") Long id, HttpSession session)
    {
        Korisnik korisnik = (Korisnik) session.getAttribute("user");
        System.out.println(korisnik.getIme());
        session.invalidate();
        return korisnikService.findOne(id);
    }

    @PostMapping("/api/save-korisnik")
    public String saveKorisnik(@RequestBody Korisnik korisnik) {
        this.korisnikService.save(korisnik);
        return "Successfully saved an korisnik!";
    }




}








