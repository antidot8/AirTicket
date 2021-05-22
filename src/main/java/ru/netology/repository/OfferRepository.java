package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Offer;

public class OfferRepository {
    private Offer[] items = new Offer[0];

    public void save(Offer item) {
        int length = items.length + 1;
        Offer[] tmp = new Offer[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Offer[] getAll() {
        return items;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            int length = items.length - 1;
            Offer[] tmp = new Offer[length];
            int index = 0;
            for (Offer item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }

    public Offer findById(int id) {
        for (Offer item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}