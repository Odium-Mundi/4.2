package repository;

import domain.PurchaseTicket;

public class TicketRepository {
    private PurchaseTicket[] items = new PurchaseTicket[0];

    public void save(PurchaseTicket item) {
        int length = items.length + 1;
        PurchaseTicket[] tmp = new PurchaseTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public PurchaseTicket[] findAll() {
        return items;
    }

    public PurchaseTicket findById(int id) {
        for (PurchaseTicket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }

    public void removeAll() {
        items = new PurchaseTicket[0];
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseTicket[] tmp = new PurchaseTicket[length];
        int index = 0;
        for (PurchaseTicket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}
