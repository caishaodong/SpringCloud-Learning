package com.dong.springcloud.ribbonconsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RibbonConsumerApplicationTests {

    @Test
    public void contextLoads() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int current = 0;
        int next = 0;

        while (next < 10) {
            current = atomicInteger.get();
            next = (current + 1) % 11;
            System.out.println(atomicInteger.compareAndSet(current, next));
            System.out.println(next);
        }


    }


}
