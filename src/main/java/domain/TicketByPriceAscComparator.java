package domain;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<PurchaseTicket> {
    public int compare(PurchaseTicket o1, PurchaseTicket o2) {
        return o1.getTimeWay() - o2.getTimeWay();
    }
}
