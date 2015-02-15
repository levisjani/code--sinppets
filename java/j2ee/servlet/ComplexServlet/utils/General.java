import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class General {
    public static List<Item> itemsList() {
        List<Item> list = new ArrayList<Item>();
        list.add(new Item("211-111111", "Book", 9.99));
        list.add(new Item("212-222222", "CD", 5.99));
        list.add(new Item("145-333333", "Magazine", 2.99));
        return list;
    }

    public static String hyperlink(String text, String link) {
        return String.format("<a href=\"%s\">%s</a>", link, text);
    }

    public static Item findItem(String id) {
        List<Item> items = itemsList();
        for (Item it : items) {
            if (it.getId().equals(id))
                return it;
        }
        return null;
    }

    public static double calcTotal(HashMap<Item, Integer> cart) {
        double totPrice = .0;
        Set<Item> items = cart.keySet();
        for (Item it : items) {
            int quantity = cart.get(it);
            totPrice += quantity * it.getUnitPrice();
        }
        return totPrice;
    }

    public static void makePayment(String ccno, double totPrice) {
    
    }
}
