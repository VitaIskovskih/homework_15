package ru.netology;

public class TicketRepository {
    Ticket [] tickets = new Ticket[0];

    public void save(Ticket growth) {
        Ticket extra[] = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            extra[i] = tickets[i];
        }
        extra[extra.length - 1] = growth;
        tickets = extra;
    }
    public void removeTicket(int id) {
        Ticket[] extra = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket growth : tickets) {
            if (growth.getId() != id) {
                extra[copyToIndex] = growth;
                copyToIndex++;
            }
        }
        tickets = extra;
    }
    public Ticket[] getProducts() {
        return tickets;
    }
}
