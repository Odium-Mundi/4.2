package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseTicket implements Comparable<PurchaseTicket> {
    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int timeWay;

    @Override
    public int compareTo(PurchaseTicket purchaseTicket) {
        return id - purchaseTicket.id;
    }

    public int getId() {
        return id;
    }

}
