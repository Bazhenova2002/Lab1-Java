package ua.bazhenova.lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static Address newAddress(Address address){
        Scanner sc = new Scanner(System.in);
        System.out.println("City: ");
        address.setCity(sc.nextLine());
        System.out.println("Street: ");
        address.setStreet(sc.nextLine());
        System.out.println("Bulding: ");
        Inputator(address,true);
        System.out.println("Flat: ");
        Inputator(address,false);
        return address;
    }

    private static void remove(ArrayList<Ticket> arr) throws IOException {
        do {
            Scanner ssc = new Scanner(System.in);
            if(ssc.hasNextInt()) {
                int _tmp = ssc.nextInt();
                if(_tmp>0) {
                    if (_tmp <= arr.size()) {
                        arr.remove(_tmp-1);
                        Clear();
                        System.out.println("Succes!");
                        break;
                    }
                    else {
                        Clear();
                        System.out.println("We dont have this ticket");
                        break;
                    }
                }
                else if(_tmp==0) {
                    Clear();
                    System.out.println("Abording...");
                    break;
                }
            }
            else {
                Clear();
                System.out.println("Unknown number");
            }

        }while (true);
    }




    private static void Menu() {
        System.out.println("1.Add new Ticket\n2.Show All\n3.Remove\n4.Exit");
    }

    private static void Clear() throws IOException {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("/-----------------------------------------/");
    }

    private static void Inputator(Ticket ticket, char type) {
        boolean done = false;
        do {
            Scanner ssc = new Scanner(System.in);
            if (ssc.hasNextInt()) {
                int _tmp = ssc.nextInt();
                switch (type) {
                    case ('n'):
                        ticket.setNumber(_tmp);
                        done = true;
                        break;
                    case('a'):
                        ticket.setAmount(_tmp);
                        done = true;
                        break;

                    case('t'):
                        ticket.setTime(_tmp);
                        done = true;
                        break;
                }
            } else
                System.out.println("ERROR");

        } while (!done);
    }

    private static void Inputator(Address address, boolean type) {
        boolean done = false;
        do {
            Scanner ssc = new Scanner(System.in);
            if (ssc.hasNextInt()) {
                int _tmp = ssc.nextInt();
                if (type) {
                    address.setBuilding(_tmp);
                    done = true;
                } else if (!(type)) {
                    address.setFlat((byte)_tmp);
                    done = true;
                }
            } else
                System.out.println("ERROR");

        } while (!done);
    }

    private static void Input(Ticket ticket){
        Scanner keyboard = new Scanner(System.in);
        //full name
        ArrayList<String> fullname = new ArrayList<>(3);
        System.out.println("Name: ");
        fullname.add(keyboard.nextLine());
        System.out.println("Secondname: ");
        fullname.add(keyboard.nextLine());
        System.out.println("Futhername: ");
        fullname.add(keyboard.nextLine());
        ticket.setFullname(fullname);
        //
        System.out.println("Number: ");
        Inputator(ticket, 'n');
        System.out.println("Amount: ");
        Inputator(ticket, 'a');
        Address address = new Address();
        ticket.address = newAddress(address);
        System.out.println("Time (ex '12' - 12 months): ");
        Inputator(ticket,'t');

    }

    /*~~~~~~~~~~~~~~~~~Main Method~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args) throws IOException {
        ArrayList<Ticket> tickets = new ArrayList<>();

        Menu();
        do {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                Clear();
                switch (sc.nextInt()) {
                    case (1):
                        Ticket ticket = new Ticket();
                        Input(ticket);
                        tickets.add(ticket);
                        Clear();
                        Menu();
                        break;
                    case (2):
                        for (int i = 0; i < tickets.size(); i++) {
                            System.out.println(i+1 +". " + tickets.get(i).toString());
                        }
                        System.out.println("");
                        Menu();
                        break;
                    case (3):
                        System.out.println("Please input number of element (0 - abord)");
                        remove(tickets);
                        Menu();
                        break;
                    case (4):
                        System.out.println("BYE");
                        System.exit(0);
                    default:
                        System.out.println("Unknown command");
                }
            }
            else
                System.out.println("Unknown command");
        }while (true);

    }
}
