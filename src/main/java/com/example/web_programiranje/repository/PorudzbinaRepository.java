package com.example.web_programiranje.repository;


import com.example.web_programiranje.entity.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long>
{
}

