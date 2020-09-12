package ua.bazhenova.lab1;

import java.util.ArrayList;

public class Ticket {

    String fullname;
    int number;
    Address address;
    int amount;
    String time;

    //Constructor
    public void setFullname(ArrayList<String> fullname) {
        String s="";
        for(int i =0; i<3;i++)
        {
            String tmp = fullname.get(i).substring(0,1).toUpperCase() + fullname.get(i).substring(1);
            s += tmp + " ";
        }
        this.fullname = s;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setTime(int months) {
        this.time = months+"months";
    }

    @Override
    public String toString() {
        return  "\n  Fullname: " + fullname + '\n' +
                "  Number: " + number +'\n'+
                "  Address: " + address +'\n'+
                "  Amount: " + amount +'\n'+
                "  Time: " + time + '\n';
    }
}
