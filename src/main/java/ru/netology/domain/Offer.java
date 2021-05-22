package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offer implements Comparable<Offer>{
  private int id;
  private int price;
  private String from;
  private String to;
  private int timeTravel;

  public boolean matches(String from, String to) {
    return getFrom().equalsIgnoreCase(from) && getTo().equalsIgnoreCase(to);
  }

  public Offer(int price, String from, String to) {
    this.price = price;
    this.to = to;
    this.from = from;
  }

  @Override
  public int compareTo(Offer o) {
    return price - o.price;
  }
}