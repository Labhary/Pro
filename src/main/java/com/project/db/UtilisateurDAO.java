package com.project.db;

import com.project.db.DBConnection;
import com.project.models.Utilisateur;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {

    public UtilisateurDAO() {

    }

    public void ajouterUtilisateur(Utilisateur utilisateur) throws Exception {
        Connection conn = DBConnection.getInstance();
        String query = "INSERT INTO utilisateur (nom, prenom, email, motdepasse) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            pstmt.setString(4, utilisateur.getMotDePasse());
            pstmt.executeUpdate();
        }
    }

    public void supprimerUtilisateur(int id) throws Exception {
        Connection conn = DBConnection.getInstance();
        String query = "DELETE FROM utilisateur WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) throws Exception {
        Connection conn = DBConnection.getInstance();
        String query = "UPDATE utilisateur SET nom=?, prenom=?, email=?, motdepasse=? WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getEmail());
            pstmt.setString(4, utilisateur.getMotDePasse());
            pstmt.setLong(5, utilisateur.getId());
            pstmt.executeUpdate();
        }
    }

    public Utilisateur recupererUtilisateur(int id) throws Exception {
        Connection conn = DBConnection.getInstance();
        Utilisateur utilisateur = null;
        String query = "SELECT * FROM utilisateur WHERE id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                utilisateur = new Utilisateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("motDePasse"));
            }
        }
        return utilisateur;
    }
    public Utilisateur recupererUtilisateurParEmail(String email) throws Exception {
        Connection conn = DBConnection.getInstance();
        Utilisateur utilisateur = null;
        String query = "SELECT * FROM utilisateur WHERE email=?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                utilisateur = new Utilisateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("motDePasse"));
            }
        }
        return utilisateur;
    }

    public List<Utilisateur> recupererTousLesUtilisateurs() throws Exception {
        Connection conn = DBConnection.getInstance();
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT * FROM utilisateur";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("motDePasse"));
                utilisateurs.add(utilisateur);
            }
        }
        return utilisateurs;
    }
    public boolean checkAuthentification(String email, String password) throws IOException {
        boolean authenticated = false;
        try {

            Connection conn = DBConnection.getInstance();
            String sql = "SELECT * FROM utilisateur WHERE email =? AND motdepasse =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            authenticated = rs.next();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return authenticated;
    }

}

