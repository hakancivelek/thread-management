package fundamentals.eveluation.java5;

import fundamentals.eveluation.Order;
import fundamentals.eveluation.OrderResult;

public class Approach5Runner {

    public static void main(String[] args) {

        Approach5 approach = new Approach5();

        Order order = new Order("ORDER-1");

        OrderResult result = approach.processOrder(order);

        System.out.println("\nFINAL RESULT: " + result);
    }
}