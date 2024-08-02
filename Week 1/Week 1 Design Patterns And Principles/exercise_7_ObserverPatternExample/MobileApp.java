package exercise_7_ObserverPatternExample;

public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("From Mobile App :" + name + " - " + stockName + " price updated to " + stockPrice);
    }
}