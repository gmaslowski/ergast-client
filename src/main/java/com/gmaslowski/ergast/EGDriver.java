package com.gmaslowski.ergast;

class EGDriver {

    private String driverId;
    private String driverUrl;
    private String givenName;
    private String familyName;
    private String dateOfBirth;
    private String nationality;

    public String getDriverId() {
        return driverId;
    }

    public String getDriverUrl() {
        return driverUrl;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
