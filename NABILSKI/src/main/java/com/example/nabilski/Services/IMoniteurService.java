package com.example.nabilski.Services;


import com.example.nabilski.entities.Moniteur;

import java.util.List;
import java.util.Optional;

public interface IMoniteurService {


    List<Moniteur> retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Optional<Moniteur> retrieveMoniteur (Long numMoniteur);
    void removeMoniteur  (Long numMoniteur);
    void test();
}
