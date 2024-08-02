package exercise_7_ObserverPatternExample;

public class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("From Web App :" + name + " - " + stockName + " price updated to " + stockPrice);
    }
}