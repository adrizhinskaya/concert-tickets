package model;

import model.enums.User;

public class Client extends User implements Printable {
    public Client() {
        super();
    }

    @Override
    public void printRole() {
        System.out.println("CLIENT printRole() method");
    }

    public void getTicket() {
        System.out.println("CLIENT getTicket() method");
    }
}
