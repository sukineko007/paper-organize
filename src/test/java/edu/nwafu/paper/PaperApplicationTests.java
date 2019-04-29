package edu.nwafu.paper;

import edu.nwafu.paper.service.impl.SingleChoiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperApplicationTests {

    @Autowired
    SingleChoiceService singleChoiceService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void updateUseCount(){
        singleChoiceService.increaseUseCount(1005);
    }

}
