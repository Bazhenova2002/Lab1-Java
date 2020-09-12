package ua.bazhenova.lab1;

public class Address {
    @Override
    public String toString() {
        return "\n\tCity: " + city + "\n"+
                "\tStreet: " + street + "\n"+
                "\tBuilding: " + building +"\n"+
                "\tFlat: " + flat ;
    }

    String city;
    String street;
    int building;
    byte flat;

    //Constructor

    public Address() {
        this.city = "Unknown";
        this.street = "Unknown";
        this.building = 0;
        this.flat = 0;
    }

    //Setters

    public void setCity(String city) {
        String s = city.substring(0,1).toUpperCase() + city.substring(1);
        this.city = s;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public void setFlat(byte flat) {
        this.flat = flat;
    }
}
