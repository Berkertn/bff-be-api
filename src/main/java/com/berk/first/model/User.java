package com.berk.first.model;

import lombok.Data;


//Asıl Database Tablosu burası db olan proje için entity gibi düşünebilirsin
@Data
public class User {
    private String userId;
    private String name;
    private String surname;
    private String email;
}
