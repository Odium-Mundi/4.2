package manager;

import domain.PurchaseTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private PurchaseTicket purchaseTicket1 = new PurchaseTicket(1,1600,"LED","MOW",120);
    private PurchaseTicket purchaseTicket2 = new PurchaseTicket(2,1200,"MOW","LED",120);
    private PurchaseTicket purchaseTicket3 = new PurchaseTicket(3,1400,"LED","MOW",420);

    @BeforeEach
    public void shouldSave() {
        manager.add(purchaseTicket1);
        manager.add(purchaseTicket2);
        manager.add(purchaseTicket3);
    }

    @Test
    void shouldGetAll() {
        PurchaseTicket[] expected = new PurchaseTicket[]{purchaseTicket1,purchaseTicket2,purchaseTicket3};
        PurchaseTicket[] actual = repository.findAll();

        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldGetFromXtoX() {
        PurchaseTicket[] expected = new PurchaseTicket[]{purchaseTicket3,purchaseTicket1};
        PurchaseTicket[] actual = manager.getAll("LED", "MOW");

        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldGetNullIfNoExists() {
        PurchaseTicket[] expected = new PurchaseTicket[]{};
        PurchaseTicket[] actual = manager.getAll("LED", "MEOW");

        assertArrayEquals(expected,actual);
    }
}