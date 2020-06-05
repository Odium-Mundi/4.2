package manager;

import domain.PurchaseTicket;
import domain.TicketByPriceAscComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();


    private PurchaseTicket purchaseTicket1 = new PurchaseTicket(1, 1200, "LED", "MOW", 120);
    private PurchaseTicket purchaseTicket2 = new PurchaseTicket(2, 1400, "MOW", "LED", 130);
    private PurchaseTicket purchaseTicket3 = new PurchaseTicket(3, 1100, "LED", "MOW", 420);

    @BeforeEach
    public void shouldSave() {
        manager.add(purchaseTicket1);
        manager.add(purchaseTicket2);
        manager.add(purchaseTicket3);
    }

    @Test
    void shouldGetAll() {
        PurchaseTicket[] expected = new PurchaseTicket[]{purchaseTicket1, purchaseTicket2, purchaseTicket3};
        PurchaseTicket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFromXtoY() {
        PurchaseTicket[] expected = new PurchaseTicket[]{purchaseTicket1, purchaseTicket3};
        PurchaseTicket[] actual = manager.getAll("LED", "MOW", comparator);

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldGetNullIfNoExists() {
        PurchaseTicket[] expected = new PurchaseTicket[]{};
        PurchaseTicket[] actual = manager.getAll("LED", "MEOW", comparator);

        assertArrayEquals(expected, actual);
    }
}