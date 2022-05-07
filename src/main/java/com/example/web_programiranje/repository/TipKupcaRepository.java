package com.example.web_programiranje.repository;


import com.example.web_programiranje.entity.TipKupca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipKupcaRepository extends JpaRepository<TipKupca, Long>
{
}
