package model;

public class Admin extends EntityWithId implements User {
    public Admin() {
        setDefaultId();
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
