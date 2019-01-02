package com.dong.springcloud.springboot;

import com.sun.deploy.util.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    private AtomicInteger nextServerCyclicCounter;

    @Before
    public void setUp() {
        nextServerCyclicCounter = new AtomicInteger(0);
    }

    @Test
    public void contextLoads() {
        int current = 0;
        while (current <= 10) {
            current = this.nextServerCyclicCounter.get();
            System.out.println(current);
        }
    }

    @Test
    public void test1() {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("2");
        ids.add("3");
        System.out.println(ids.toString());
        String join = StringUtils.join(ids, ",");
        System.out.println(join);
    }

}
