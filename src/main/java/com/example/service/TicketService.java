package com.example.service;

import com.example.repository.TicketRepository;

public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService() {
        this.ticketRepository = new TicketRepository();
    }

    public void add(int userId, model.enums.TicketType ticketType) {
        ticketRepository.add(userId, ticketType);
    }

    public String getById(int userId, int id) {
        return ticketRepository.getById(userId, id);
    }

    public void update(int id, model.enums.TicketType ticketType) {
        ticketRepository.update(id, ticketType);
    }
}
