package ru.netology;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository tickets;

    TicketManager(TicketRepository tickets) {
        this.tickets = tickets;
    }

    public void add(Ticket ticket) {
        tickets.save(ticket);
    }
    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : tickets.getProducts()) {
            if (matches(ticket, from, to)) {
                Ticket extra[] = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    extra[i] = result[i];
                }
                extra[extra.length - 1] = ticket;
                result = extra;
            }
        }
        Arrays.sort(result);
        return result;
    }
    public boolean matches(Ticket ticket, String from, String to) {
        if (!ticket.getDeparture().equals(from)) {
            return false;
        }
        if (!ticket.getArrival().equals(to)) {
            return false;
        }
        return true;
    }
}
