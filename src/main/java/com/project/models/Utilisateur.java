package com.project.models;

public class Utilisateur {
    private Long Id;
    private String Nom;
    private String Prenom;
    private String Email;
    private String MotDePasse;

    public Utilisateur(){

    }
    public Utilisateur(String nom, String prenom, String email, String motDePasse ) {
        Nom = nom;
        Prenom = prenom;
        Email = email;
        MotDePasse = motDePasse;
    }
    public Utilisateur(Long id,String nom, String prenom, String email, String motDePasse ) {
        Nom = nom;
        Prenom = prenom;
        Email = email;
        MotDePasse = motDePasse;
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        MotDePasse = motDePasse;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}