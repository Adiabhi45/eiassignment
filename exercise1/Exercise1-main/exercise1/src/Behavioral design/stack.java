import java.util.ArrayList;
import java.util.List;

interface StockObserver {
    void update(String stock, double price);
}

class Investor implements StockObserver {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stock, double price) {
        System.out.println(name + " notified. " + stock + " is now $" + price);
    }
}

class StockMarket {
    private String stock;
    private double price;
    private List<StockObserver> observers = new ArrayList<>();

    public StockMarket(String stock) {
        this.stock = stock;
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (StockObserver observer : observers) {
            observer.update(stock, price);
        }
    }
}

public class   stack {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("AAPL");

        Investor investor1 = new Investor("Investor 1");
        Investor investor2 = new Investor("Investor 2");

        stockMarket.addObserver(investor1);
        stockMarket.addObserver(investor2);

        stockMarket.setPrice(150.00);
        stockMarket.setPrice(155.00);
    }
}
