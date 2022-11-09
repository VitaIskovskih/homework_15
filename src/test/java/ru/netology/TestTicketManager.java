package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class TestTicketManager {
    Ticket ticket1 = new Ticket(1, 300, "DME", "EGO", 120);
    Ticket ticket2 = new Ticket(2, 200, "ZKD", "EGO", 60);
    Ticket ticket3 = new Ticket(3, 100, "DME", "EGO", 90);
    Ticket ticket4 = new Ticket(4, 150, "DME", "EGO", 80);
    Ticket ticket5 = new Ticket(5, 150, "DME", "EGO", 130);

    @Test
    public void testFindOneTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("ZKD","EGO");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindMultipleTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {ticket3, ticket4, ticket5, ticket1 };
        Ticket[] actual = manager.findAll("DME","EGO");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testCanNotFoundTicket() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DME", "OGZ");

        Assertions.assertArrayEquals(expected, actual);
    }
}
