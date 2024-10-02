package model;

import model.Sector;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    UUID id;
    String concertHall;
    Integer eventCode;
    LocalDateTime time;
    LocalDateTime ticketCreationTime;
    Boolean isPromo;
    Sector stadiumSector;
    Double maxWeightInKg;
    BigDecimal price;

    public Ticket(UUID id, String concertHall, Integer eventCode, LocalDateTime time, Boolean isPromo,
                  Sector stadiumSector, Double maxWeightInKg, BigDecimal price) {
        this.id = id;
        setConcertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
        this.ticketCreationTime = LocalDateTime.now();
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        setMaxWeightInKg(maxWeightInKg);
        this.price = price;
    }

    public Ticket(String concertHall, Integer eventCode, LocalDateTime time) {
        setConcertHall(concertHall);
        setEventCode(eventCode);
        this.time = time;
        this.ticketCreationTime = LocalDateTime.now();
    }

    public Ticket() {
        this.ticketCreationTime = LocalDateTime.now();
    }

    public void setConcertHall(String concertHall) {
        if (concertHall.length() > 10) {
            throw new RuntimeException("concertHall field length must not be longer than 10 .");
        }
        this.concertHall = concertHall;
    }

    public void setEventCode(Integer eventCode) {
        if (eventCode < 0 || eventCode > 999) {
            throw new RuntimeException("eventCode field must have 3 digits .");
        }
        this.eventCode = eventCode;
    }

    public void setMaxWeightInKg(Double maxWeightInKg) {
        if (maxWeightInKg < 0) {
            throw new RuntimeException("maxWeightInKg field must be greater than zero .");
        }
        this.maxWeightInKg = maxWeightInKg;
    }
}


