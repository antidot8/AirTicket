package ru.netology.domain;

import java.util.Comparator;

public class OfferByTimeAscComparator implements Comparator<Offer> {

    public int compare(Offer o1, Offer o2) {
        return o1.getTimeTravel() - o2.getTimeTravel();
    }
}
