package net.suaree.meetup.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a venue from/for the Meetup APIs.
 *
 * @author roger
 */
public class Venue {
    private Long id;

    private String name;

    private String phone;

    @SerializedName("address_1")
    private String address1;

    @SerializedName("address_2")
    private String address2;

    @SerializedName("address_3")
    private String address3;

    private String city;

    private String zip;

    private String state;

    private String country;

    private Double lat;

    @SerializedName("lon")
    private Double lng;

    private boolean repinned;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public boolean isRepinned() {
        return repinned;
    }
}
