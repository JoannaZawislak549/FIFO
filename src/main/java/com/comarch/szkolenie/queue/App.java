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

        fifo.push("Janusz");
        System.out.println(fifo);
        fifo.pushFew(3);
        System.out.println(fifo);
        fifo.pop();
        System.out.println(fifo);

    }
}
