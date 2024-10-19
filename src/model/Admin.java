package model;

public class Admin extends User implements Printable {
    public Admin() {
        super();
    }

    @Override
    public void print() {
        System.out.println("ADMIN print() method");
    }

    @Override
    public void printRole() {
        System.out.println("ADMIN printRole() method");
    }

    public void checkTicket() {
        System.out.println("ADMIN checkTicket() method");
    }
}