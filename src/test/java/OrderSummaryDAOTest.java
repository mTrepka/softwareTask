import org.junit.Assert;
import org.junit.Test;
import org.mtrepka.task.dao.FruitDAO;
import org.mtrepka.task.dao.OrderSummaryDAO;

public class OrderSummaryDAOTest {

    @Test
    public void orderSummaryTest() {
        long DAO_ID = 5;

        OrderSummaryDAO dao = new OrderSummaryDAO();
        dao.setId(DAO_ID);
        FruitDAO fruitDAO = new FruitDAO();
        fruitDAO.setName("apple");
        fruitDAO.setAmount(5);
        dao.getFruitDAOList().add(fruitDAO);
        OrderSummaryDAO dao2 = OrderSummaryDAO.toOrderSummaryDAO(OrderSummaryDAO.toOrderSummary(dao));
        Assert.assertTrue(dao2.getId()==DAO_ID);
        Assert.assertTrue(dao2.getFruitDAOList().size()==1);
        Assert.assertTrue(dao2.getFruitDAOList().get(0).getName().equalsIgnoreCase("apple"));
        Assert.assertTrue(dao2.getFruitDAOList().get(0).getAmount()==5);
    }

}
