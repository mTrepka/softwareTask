import org.junit.Test;
import org.junit.runner.RunWith;
import org.mtrepka.task.SoftwareTask;
import org.mtrepka.task.controller.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = SoftwareTask.class)
@AutoConfigureMockMvc
public class RestTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private Rest rest;

    @Test
    public void givenFruits_thenReturnSummaryOrder() throws Exception{
        String order = "{\"orange\":5, \"apple\":20}";
        mvc.perform(post("/api/order").contentType(MediaType.APPLICATION_JSON).content(order)).andExpect(status().isOk());
    }

    @Test
    public void givenId_thenReturnSummaryOrder() throws Exception{
        Map<String,Integer> fruits  = new HashMap<>();
        fruits.put("apple",5);
        rest.postOrder(fruits);
        mvc.perform(get("/api/order?id=1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void returnAllSummaryOrder() throws Exception{
        Map<String,Integer> fruits  = new HashMap<>();
        fruits.put("apple",5);
        rest.postOrder(fruits);
        mvc.perform(get("/api/order/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
