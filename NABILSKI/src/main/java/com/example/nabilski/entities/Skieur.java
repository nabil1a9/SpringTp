package com.example.nabilski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;
    @OneToMany(mappedBy = "skieur")
    private Set<Inscription> inscriptions;
    @ManyToMany(mappedBy = "skieurs")
    @JsonIgnore
    private Set<Piste> pistes;
    @OneToOne(cascade = CascadeType.REMOVE)
    private Abonnement abonnement;
}
