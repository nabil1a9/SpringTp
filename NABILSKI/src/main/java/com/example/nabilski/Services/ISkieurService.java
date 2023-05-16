package com.example.nabilski.Services;

import com.example.nabilski.entities.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISkieurService {
    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur(Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
    Skieur assignSkierToPiste(long numSkieur, long numPiste);
    Skieur AssignSkierToSubscription(long numSkieur, long numAbon);
    Skieur assignSkierToInscription(long numSkieur, long numInscription);
   List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
   List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours inscriptions_cours_typeCours, Support inscriptions_cours_support, Couleur pistes_couleur);
   List<Skieur> findByMoniteurNameAndSupportTypeJPQL(@Param("support") Support support, @Param("nom") String nom);
    Skieur addSkierAndAssignToCourse(Skieur skieur);
    List<Skieur> findSkieursByPisteCouleur(Couleur couleur);
}
