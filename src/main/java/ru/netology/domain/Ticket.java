package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String deportation;
    private String destination;
    private int time;

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }

    public boolean matches(String deportation, String destination) {
        if (getDeportation().contains(deportation) && getDestination().contains(destination)) {
            return true;
        } else {
            return false;
        }
    }
}
