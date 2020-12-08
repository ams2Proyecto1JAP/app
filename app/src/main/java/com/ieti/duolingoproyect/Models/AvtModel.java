package com.ieti.duolingoproyect.Models;

import java.io.Serializable;

public class AvtModel implements Serializable {
    // Da error porque no implementa Serializable, diciendo que los objetos con clave compuesta
    // deben implementarla, pero este modelo no tiene clave compuesta (solo tiene una etiqueta @Id)
    // y el modelo al que hace referencia (UsersModel), tampoco tiene clave compuesta.
    // Implementandola se soluciona el error, pero no tiene sentido.
    private UsersModel user;

    private String image;

    public AvtModel(){}
    public AvtModel (UsersModel user, String imagePath)
    {
        this.image = imagePath;
        this.user = user;
    }
    public UsersModel getUser() {
        return user;
    }
    public void setUser(UsersModel user) {
        this.user = user;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}

