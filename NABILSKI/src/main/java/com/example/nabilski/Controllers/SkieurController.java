package com.example.nabilski.Controllers;

import com.example.nabilski.Services.ISkieurService;
import com.example.nabilski.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/skieur")
public class SkieurController {
    @Autowired
    ISkieurService iSkieurService;
    //localhost:9090/retrieveAllSkieurs


    public List<Skieur> getAll(){
        return iSkieurService.retrieveAllSkieurs();
    }
    @GetMapping("{numSkieur}")
    public Skieur retrieveSkieur(@PathVariable Long numSkieur) {
        return iSkieurService.retrieveSkieur(numSkieur);
    }
    @PostMapping(/*path ="addSkieur"*/) //ena aandi post barka edheka aaleh ma nesthakhech, wahdou bech yaarfou li ena bech naamel add
    public Skieur addSkieur(@RequestBody Skieur skieur){

        return iSkieurService.addSkieur(skieur);
    }
    @PutMapping
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return iSkieurService.updateSkieur(skieur);
    }
    @DeleteMapping("{numSkieur}")
    public void removeSkieur(@PathVariable Long numSkieur) {
        iSkieurService.removeSkieur(numSkieur);
    }
    @PutMapping("/assignSkierToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable long numSkieur, @PathVariable long numPiste){
        return iSkieurService.assignSkierToPiste(numSkieur, numPiste);
    }
    @PutMapping("/{numSkieur}/{numAbon}")
    public Skieur AssignSkierToSubscription(long numSkieur, long numAbon){
        return iSkieurService.AssignSkierToSubscription(numSkieur, numAbon);
    }
    @PutMapping("{numSkieur}/{numInscription}")

    public Skieur AssignSkierToInscription(@PathVariable long numSkieur, @PathVariable long numInscription) {

        return iSkieurService.assignSkierToInscription(numSkieur, numInscription);
    }
    @GetMapping("getSkieurParTypeAbon/{typeAbonnement}")
    public List<Skieur> getSkieurParTypeAbon(@PathVariable TypeAbonnement typeAbonnement){
        return  iSkieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }
    @GetMapping("getby/{inscriptions_cours_typeCours}/{inscriptions_cours_support}/{pistes_couleur}")
    public List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(@PathVariable("inscriptions_cours_typeCours") TypeCours inscriptions_cours_typeCours, @PathVariable("inscriptions_cours_support") Support inscriptions_cours_support, @PathVariable("pistes_couleur") Couleur pistes_couleur){
        return iSkieurService.findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(inscriptions_cours_typeCours, inscriptions_cours_support, pistes_couleur);
    }
    @GetMapping("find/{support}/{nom}")
    public List<Skieur> findByMoniteurNameAndSupportTypeJPQL(@PathVariable("support") Support support, @PathVariable("nom") String nom)
    {
        log.info(""+support);
        return iSkieurService.findByMoniteurNameAndSupportTypeJPQL(support, nom);
    }
    @PostMapping("addSkierAndAssignToCourse")
    Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur){
        return iSkieurService.addSkierAndAssignToCourse(skieur);
    }

    @GetMapping("fi/{couleur}")
    public List<Skieur> findSkieursByPisteCouleur(@PathVariable("couleur") Couleur couleur) {
        return iSkieurService.findSkieursByPisteCouleur(couleur);
    }


}

