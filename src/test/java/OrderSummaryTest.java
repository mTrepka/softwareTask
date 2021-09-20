import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mtrepka.task.entity.Apple;
import org.mtrepka.task.entity.Orange;
import org.mtrepka.task.entity.OrderSummary;
import org.mtrepka.task.factory.FruitFactory;

public class OrderSummaryTest {
    @Test
    public void summaryCalc() {
        OrderSummary os = new OrderSummary();
        Apple apple = new Apple(10);
        Orange orange = new Orange(10);
        double appleSummary = 5*apple.getPrice();
        double orangeSummary = 7*orange.getPrice();// 9/3*2=6 + 1 w/o discount
        Assertions.assertTrue(appleSummary==apple.getValue());
        Assertions.assertTrue(orangeSummary==orange.getValue());
        double valSummary = apple.getValue()+orange.getValue();
        os.getFruitList().add(apple);
        os.getFruitList().add(orange);
        Assertions.assertTrue(valSummary==os.getOrderValue());
    }
}
