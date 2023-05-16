package com.example.nabilski.Services;


import com.example.nabilski.entities.Piste;

import java.util.List;
import java.util.Optional;

public interface IPisteService {
    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste (Piste piste);
    Optional<Piste>  retrievePiste (Long numPiste);
    void removePiste(Long numPiste);
}
