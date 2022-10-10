package patterns.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    private static final Map<Integer, Integer> pricesOnProducts = new HashMap<>();
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy payStrategy;

    static {
        pricesOnProducts.put(1, 2200);
        pricesOnProducts.put(2, 1650);
        pricesOnProducts.put(3, 3000);
        pricesOnProducts.put(4, 800);
    }

    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;
            String continueChoice;
            do {
                System.out.println(
                        "Please, select a product:" + "\n" +
                                "1 - Mother board" + "\n" +
                                "2 - CPU" + "\n" +
                                "3 - HDD" + "\n" +
                                "4 - Memory" + "\n"
                );
                int choice = Integer.parseInt(READER.readLine());
                cost = pricesOnProducts.get(choice);
                System.out.println("Count: ");
                int count = Integer.parseInt(READER.readLine());
                order.setTotalCost(order.getTotalCost() + cost * count);
                System.out.println("Do you wish to continue selecting products? (Y/N): ");
                continueChoice = READER.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (payStrategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = READER.readLine();
                if (paymentMethod.equals("1")) {
                    payStrategy = new PayByPayPal();
                } else {
                    payStrategy = new PayByCreditCard();
                }
            }

            order.processOrder(payStrategy);

            System.out.println("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = READER.readLine();
            if (proceed.equalsIgnoreCase("p")) {
                if (payStrategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful");
                } else {
                    System.out.println("FAIL!");
                }
                order.setClosed(true);
            }

        }
    }

}
