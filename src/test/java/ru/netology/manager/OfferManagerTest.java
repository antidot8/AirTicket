package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OfferManagerTest {
    private OfferRepository repository = new OfferRepository();
    private OfferManager manager = new OfferManager(repository);
    private Offer offer1 = new Offer(1800, "SVO", "SVX");
    private Offer offer2 = new Offer(2500, "OVB", "DME");
    private Offer offer3 = new Offer(3300, "SVO", "SVX");
    private Offer offer4 = new Offer(4200, "SVO", "SVX");
    private Offer offer5 = new Offer(5100, "SVO", "DME");
    private Offer offer6 = new Offer(2100, "OVB", "DME");
    private Offer offer7 = new Offer(3100, "OVB", "DME");


    @BeforeEach
    void setUp() {
        manager.add(offer1);
        manager.add(offer2);
        manager.add(offer3);
        manager.add(offer4);
        manager.add(offer5);
        manager.add(offer6);
        manager.add(offer7);
    }

    @Test
    public void shouldSortByPrice() {
        Offer[] expected = new Offer[]{offer1, offer6, offer2, offer7, offer3, offer4, offer5};
        Offer[] actual = new Offer[]{offer3, offer1, offer2, offer5, offer7, offer4, offer6};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOnSearch() {
        Offer[] expected = new Offer[]{offer1, offer3, offer4};
        Offer[] actual = manager.findAll("SVO","SVX");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNotExistFromButExistTo() {
        Offer[] expected = new Offer[0];
        Offer[] actual = manager.findAll("OVB", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfNotExistAll() {
        Offer[] expected = new Offer[0];
        Offer[] actual = manager.findAll("TJM", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfExistFromButNotExistTo() {
        Offer[] expected = new Offer[0];
        Offer[] actual = manager.findAll("SVO", "TJM");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchIfExistAll() {
        Offer[] expected = new Offer[]{offer6, offer2, offer7};
        Offer[] actual = manager.findAll("OVB", "DME");
        assertArrayEquals(expected, actual);
    }
}