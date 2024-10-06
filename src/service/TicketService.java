package service;

import model.Admin;
import model.Client;
import model.Ticket;

public class TicketService {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Admin admin = new Admin();
        Client client = new Client();

        ticket.print(); // override print()
        admin.print(); // override print()
        client.print(); // base print()

        ticket.shared("+375(25)987-54-32");
        ticket.shared("+375(25)987-54-32", "someEmail@mail.ru.");

        admin.printRole();
        admin.checkTicket();
        client.printRole();
        client.getTicket();
    }
}
