package com.example.nabilski.Services;


import com.example.nabilski.entities.Abonnement;
import com.example.nabilski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IAbonnementService {

    List<Abonnement> retrieveAllAbonnement();
    Abonnement addAbonnement(Abonnement abonnement);
    Abonnement updateAbonnement (Abonnement abonnement);
    Optional<Abonnement> retrieveAbonnement (Long numAbon);

    void removeAbonnement(Long numAbon);
    List<Abonnement> getSubscriptionByType(TypeAbonnement type);
    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
