package com.betrybe.museumfinder.model;

public class Museum {
    Long id;
    String name;
    String description;
    String address;
    String collectionType;
    String subject;
    String url;
    Coordinate coordinate;
    Long legacyId;

    /*Getters -------*/
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getAddress() {
        return address;
    }
    public String getCollectionType() {
        return collectionType;
    }
    public String getSubject() {
        return subject;
    }
    public String getUrl() {
        return url;
    }
    public Coordinate getCoordinate() {
        return coordinate;
    }
    public Long getLegacyId() {
        return legacyId;
    }

    /*Setters -------*/
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLegacyId(Long legacyId) {
        this.legacyId = legacyId;
    }
}
