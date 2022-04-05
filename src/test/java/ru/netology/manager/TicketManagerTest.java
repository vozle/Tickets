package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1, 2199, "SVO", "KZN", 95);
    private Ticket second = new Ticket(2, 1299, "VKO", "KZN", 95);
    private Ticket third = new Ticket(3, 6651, "SVO", "KZN", 105);
    private Ticket fourth = new Ticket(4, 3940, "SVO", "KZN", 110);
    private Ticket fifth = new Ticket(5, 10339, "DME", "KJA", 435);

    @BeforeEach
    public void addTickets() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    void shouldSortTicketsByPrice() {
        Ticket[] actual = {first, second, third, fourth, fifth};
        Ticket[] expected = {second, first, fourth, third, fifth};

        Arrays.sort(actual);

        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSortSVOToKZNByPrice() {
        Ticket[] actual = manager.findAll("SVO", "KZN");
        Ticket[] expected = {first, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortDMEToKJAByPrice() {
        Ticket[] actual = manager.findAll("DME", "KJA");
        Ticket[] expected = {fifth};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortKRRToEKTByPrice() {
        Ticket[] actual = manager.findAll("KRR", "EKT");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }
}