import model.Ticket;
import service.TicketService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        ticketService.fillRepository();

        Ticket ticket = ticketService.createTicket(new Ticket(
                "Hall 10", 101, LocalDateTime.now().plusDays(10)));
        ticket = ticketService.getById(ticket.getId());
        System.out.println(ticket.getId());
    }
}
