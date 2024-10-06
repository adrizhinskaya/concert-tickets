package model;

public class Client extends EntityWithId implements User {
    public Client() {
        setDefaultId();
    }

    @Override
    public void printRole() {
        System.out.println("CLIENT printRole() method");
    }

    public void getTicket() {
        System.out.println("CLIENT getTicket() method");
    }
}
