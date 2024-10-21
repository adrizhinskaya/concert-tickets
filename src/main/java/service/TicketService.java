package service;

import lombok.extern.slf4j.Slf4j;
import model.Ticket;
import model.enums.TicketType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TicketRepository;

@Service
@Slf4j
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public long addTicket(Long userId, TicketType ticketType) {
        long id = ticketRepository.addAndReturnId(userId, ticketType);
        log.info(String.format("Create ticket id=[%s]", id));
        return id;
    }

    public Ticket getById(Long userId, Long ticketId) {
        Ticket ticket = ticketRepository.getById(userId, ticketId);
        log.info(String.format("Get ticket [ %s ]", ticket));
        return ticket;
    }

    public void update(Long ticketId, String ticketType) {
        ticketExistsCheck(ticketId);
        ticketRepository.update(ticketId, ticketType);
        log.info("Delete ticket id = " + ticketId);
    }

    public void ticketExistsCheck(Long ticketId) {
        if (!ticketRepository.ticketExists(ticketId)) {
            log.info(String.format("Ticket with с id[%s] doesn`t exist", ticketId));
            throw new RuntimeException(String.format("Ticket with с id[%s] doesn`t exist", ticketId));
        }
    }

}