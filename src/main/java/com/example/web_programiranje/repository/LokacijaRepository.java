package com.example.web_programiranje.repository;



import com.example.web_programiranje.entity.Lokacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Long>
{
}

