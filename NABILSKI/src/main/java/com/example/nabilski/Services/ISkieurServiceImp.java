package com.example.nabilski.Services;

import com.example.nabilski.Repositories.*;
import com.example.nabilski.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ISkieurServiceImp implements ISkieurService{
    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;
    private final AbonnementRepository abonnementRepository;
    private final InscriptionRepository inscriptionRepository;
    private final CoursRepository coursRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
    skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElse(null);
    }

    // When many to many
        @Override
        public Skieur assignSkierToPiste(long numSkieur, long numPiste) {
        //RECUPERATION ID
            Skieur skieur=skieurRepository.findById(numSkieur).orElse(null) ;
            Assert.notNull(skieur,"skieur not found!!!");
            Piste piste=pisteRepository.findById(numPiste).orElse(null);
            Assert.notNull(piste,"piste not found!!!");
            //verrificationnon null
//            if(skieur!=null && piste!=null){
            //traitement
            // skieur.getPistes().add(piste);
            Set<Piste>pistes=skieur.getPistes();
            pistes.add(piste);
            skieur.setPistes(pistes);
            return  skieurRepository.save(skieur);

            }
//            return null;
//        }

    // When one to one
        @Override
        public Skieur AssignSkierToSubscription(long numSkieur, long numAbon) {
        //RECUPERATION ID
            Skieur skieur=skieurRepository.findById(numSkieur).orElse(null) ;
            Assert.notNull(skieur,"skieur not found!!!");
            Abonnement abonnement=abonnementRepository.findById(numAbon).orElse(null);
            Assert.notNull(abonnement,"abonnement not found!!!");
            //verrificationnon null
//            if(skieur!=null && abonnement!=null){
            //traitement
            // skieur.getPistes().add(piste);

            skieur.setAbonnement(abonnement); //o2o

            return  skieurRepository.save(skieur);

        }
//        return null;}

    //when one to many
    @Override
    public Skieur assignSkierToInscription(long numSkieur, long numInscription) {
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null) ;
        Inscription inscription=inscriptionRepository.findById(numInscription).orElse(null);
        //verrification non null
        if(skieur!=null && inscription!=null){
            //traitement
            // skieur.getPistes().add(piste);
            Set<Inscription> inscriptions=skieur.getInscriptions();
            inscriptions.add(inscription);
            skieur.setInscriptions(inscriptions);
            return  skieurRepository.save(skieur);

        }
        return null;    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findSkieurByAbonnement_TypeAbon(typeAbonnement);
    }

    @Override
    public List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours inscriptions_cours_typeCours, Support inscriptions_cours_support, Couleur pistes_couleur) {
        return skieurRepository.findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(inscriptions_cours_typeCours, inscriptions_cours_support, pistes_couleur);
    }

    @Override
    public List<Skieur> findByMoniteurNameAndSupportTypeJPQL(Support support, String nom) {
        return skieurRepository.findByMoniteurNameAndSupportTypeJPQL(support,nom);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {
        Assert.notNull(skieur.getAbonnement(),"Abonnement must be entered!!!"); //vérifier si l'objet abonn existe
        Assert.notNull(skieur.getInscriptions(),"Inscription must be entered!!!!");
        Set<Inscription> inscriptions=skieur.getInscriptions();
        inscriptions.forEach(inscription -> {   //nparcouri liste taa inscrip w netfaked ken kol inscri aandha cours
            Assert.notNull(inscription.getCours().getNumCours(),"Cours must be entered!!!");
            Cours cours= coursRepository.findById(inscription.getCours().getNumCours()).orElse(null);
            Assert.notNull(cours,"No cours found with this id!!!");
            inscription.setCours(cours); //inscription aandou cours barka donc l inscrip houa li bech ygéri l relation et il va affecter inscrip lel cours
            //taw ki bech ntestiw , exception handler
        });
        skieurRepository.saveAndFlush(skieur); //ken bech nhotha dekhel l for mch bech ysajel les controles de saisie donc nhotha l bara w naawed naamel for lel skieur
        skieur.getInscriptions().forEach(inscription ->{
                inscription.setSkieur(skieur);
                inscriptionRepository.saveAndFlush(inscription);
        });
        return skieur;
    }

    @Override
    public List<Skieur> findSkieursByPisteCouleur(Couleur couleur) {
        return skieurRepository.findSkieursByPisteCouleur(couleur);
    }

}



