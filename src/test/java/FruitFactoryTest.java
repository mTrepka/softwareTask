import org.junit.jupiter.api.Test;
import org.mtrepka.task.entity.Apple;
import org.mtrepka.task.entity.Fruit;
import org.mtrepka.task.entity.Orange;
import org.mtrepka.task.factory.FruitFactory;
import org.springframework.util.Assert;



public class FruitFactoryTest {
    @Test
    public void getApple() {
        Fruit f = FruitFactory.getFruit("apple",5);
        Assert.isTrue(f instanceof Apple);
        Assert.isTrue(f.getAmount()==5);
    }

    @Test
    public void getOrange() {
        Fruit f = FruitFactory.getFruit("orange",15);
        Assert.isTrue(f instanceof Orange);
        Assert.isTrue(f.getAmount()==15);
    }

    @Test
    public void shouldReturnNull() {
        Assert.isNull(FruitFactory.getFruit(null,5));
        Assert.isNull(FruitFactory.getFruit("somethingX#43",5));
    }
}
