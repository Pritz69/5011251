package exercise_7;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecastingOptimized {
	
    private static Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
      
        if (periods == 0) {
            return presentValue;
        }
        
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
       
        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;		// Default Input For TESTING PURPOSE
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // 10 periods

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}

