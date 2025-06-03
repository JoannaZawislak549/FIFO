package com.comarch.szkolenie.queue;

import com.comarch.szkolenie.queue.configuration.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);
        IFifo fifo = context.getBean(IFifo.class);

        fifo.push("Janusz", 9);
        System.out.println(fifo);
        fifo.pushFew(3);
        System.out.println(fifo);
        System.out.println(fifo.popHighThree());
        System.out.println(fifo);

    }
}
