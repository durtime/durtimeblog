package my.study.durtimeblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DurtimeblogApplicationTests {

    @Test
    void contextLoads() {
        String a ="java";
        String[] split = a.split(",");
        for (String s : split) {
            System.out.println(s);
        }
    }

}
