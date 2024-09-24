interface Beverage {
    String getDetails();
    double price();
}

class PlainCoffee implements Beverage {
    @Override
    public String getDetails() {
        return "Plain Coffee";
    }

    @Override
    public double price() {
        return 2.00;
    }
}

abstract class AddOnDecorator implements Beverage {
    protected Beverage beverage;

    public AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDetails() {
        return beverage.getDetails();
    }

    @Override
    public double price() {
        return beverage.price();
    }
}

class MilkAddOn extends AddOnDecorator {
    public MilkAddOn(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDetails() {
        return beverage.getDetails() + " with Milk";
    }

    @Override
    public double price() {
        return beverage.price() + 0.50;
    }
}

class SugarAddOn extends AddOnDecorator {
    public SugarAddOn(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDetails() {
        return beverage.getDetails() + " with Sugar";
    }

    @Override
    public double price() {
        return beverage.price() + 0.20;
    }
}

class CreamAddOn extends AddOnDecorator {
    public CreamAddOn(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDetails() {
        return beverage.getDetails() + " with Whipped Cream";
    }

    @Override
    public double price() {
        return beverage.price() + 0.70;
    }
}

public class CoffeeOrder{
    public static void main(String[] args) {
        Beverage baseCoffee = new PlainCoffee();
        Beverage milkCoffee = new MilkAddOn(baseCoffee);
        Beverage milkSugarCoffee = new SugarAddOn(milkCoffee);
        Beverage fullBeverage = new CreamAddOn(milkSugarCoffee);
        System.out.println(fullBeverage.getDetails() + " costs $" + fullBeverage.price());
    }
}
