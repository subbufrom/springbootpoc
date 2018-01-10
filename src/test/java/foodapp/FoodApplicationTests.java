package foodapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodApplicationTests {

    @Test
    public void contextLoad() {
        FoodApplication.main(new String[]{
                "--server.port = 8888",
        });
    }
}
