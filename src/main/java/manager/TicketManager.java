package manager;

import domain.PurchaseTicket;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import repository.TicketRepository;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public boolean matches(PurchaseTicket purchaseTicket, String from, String to) {
        if (purchaseTicket.getDepartureAirport().equalsIgnoreCase(from) && purchaseTicket.getArrivalAirport().equalsIgnoreCase(to)) {
            return true;
        }
        return false;
    }

    private PurchaseTicket[] items = new PurchaseTicket[0];
    private int itemLength;

    public void add(PurchaseTicket item) {
        repository.save(item);
    }

    public PurchaseTicket[] getAll(String from, String to) {
        PurchaseTicket[] result = new PurchaseTicket[0];

        for (PurchaseTicket purchaseTicket: repository.findAll()) {
            if (matches(purchaseTicket, from, to)) {
                PurchaseTicket[] tmp = new  PurchaseTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = purchaseTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
