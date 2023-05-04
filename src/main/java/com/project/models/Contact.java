package com.project.models;

public class Contact {
    private String Id;
    private String Objet;
    private String Message;

    public Contact (){

    }
    public Contact(String id,String objet, String message ) {
        Objet = objet;
        Message = message;
        Id = id;
    }

    public String getObjet() {
        return Objet;
    }

    public void setObjet(String objet) {
        Objet = objet;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
