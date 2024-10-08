package org.example.service;

import org.example.models.Candy;
import org.example.models.Chocolate;
import org.example.models.Cookie;
import org.example.models.Sweet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class GiftTest {

    @Test
    public void testAdd() {
        Gift service = new Gift();

        Sweet candy = new Candy("B", 50, 30);
        Sweet chocolate = new Chocolate("C", 100, 100);
        Sweet cookie = new Cookie("A", 100, 10);

        service.addSweet(candy,chocolate,cookie);
        assertEquals(3, service.getSweets().size());

        service.addSweet(candy,chocolate,cookie);
        assertEquals(6, service.getSweets().size());
    }


    @Test
    public void testTotalWeightCalculation() {
        Gift service = new Gift();
        service.addSweet(new Candy("Candy", 50, 30));
        service.addSweet(new Chocolate("Twix", 100, 100));
        service.addSweet(new Cookie("Mariya", 100, 10));
        assertEquals(50+100+100, service.getTotalWeight());
    }

    @Test
    public void testSortBySugar() {
        Gift service = new Gift();
        service.addSweet(new Candy("B", 50, 30));
        service.addSweet(new Chocolate("C", 100, 100));
        service.addSweet(new Cookie("A", 100, 10));
        service.sortBySugarContent();

        List<Sweet> sweets = service.getSweets();
        assertEquals("A", sweets.get(0).getName());
        assertEquals("B", sweets.get(1).getName());
        assertEquals("C", sweets.get(2).getName());
    }

    @Test
    public void testFindSweetsBySugarRange() {
        Gift service = new Gift();

        Sweet candy = new Candy("B", 50, 30);
        Sweet chocolate = new Chocolate("C", 100, 100);
        Sweet cookie = new Cookie("A", 100, 10);

        service.addSweet(candy,chocolate,cookie);

        assertEquals(service.getSweets(), service.findSweetsBySugarRange(0,100));
        assertEquals(Arrays.asList(candy,cookie), service.findSweetsBySugarRange(0,30));
        assertEquals(List.of(), service.findSweetsBySugarRange(111,200));
    }


}