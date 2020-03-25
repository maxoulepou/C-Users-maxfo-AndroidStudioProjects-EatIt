package com.example.eatit.Model;

import java.util.Date;

/**
 * Gestion des objets de type Intervention.
 */
public class Intervention {

    private String type;
    private Date date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
