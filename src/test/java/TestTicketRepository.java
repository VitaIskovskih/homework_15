import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.Ticket;
import ru.netology.TicketRepository;

public class TestTicketRepository {
    Ticket ticket1 = new Ticket(1, 300, "DME", "EGO", 120);
    Ticket ticket2 = new Ticket(2, 200, "ZKD", "EGO", 60);
    Ticket ticket3 = new Ticket(3, 100, "DME", "EGO", 90);
    Ticket ticket4 = new Ticket(4, 250, "DME", "EGO", 80);
    Ticket ticket5 = new Ticket(5, 150, "DME", "EGO", 130);


    @Test
    public void testAddTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);


        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDeleteTicket() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeTicket(ticket3.getId());

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

}
