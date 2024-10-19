package model;

public class Client extends User implements Printable {
    public Client() {
        super();
    }

    public void getTicket() {
        System.out.println("CLIENT getTicket() method");
    }
}