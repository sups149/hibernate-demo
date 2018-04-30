package com.spnd;

import javax.persistence.*;
import javax.xml.soap.Name;

@Entity
@Table(name = "COUNTRY")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="COUNTRY_ID")
    private int countryId;
    @Column(name="COUNTRY_NAME")
    private String countryName;

    public Country() {

    }

    /*public Country(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }*/

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
