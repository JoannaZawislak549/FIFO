package com.comarch.szkolenie.queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;


@Getter
@Setter
@AllArgsConstructor
@Component
public class Fifo implements IFifo {
    private ArrayList<String> elements;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void push(String argument){
        this.elements.add(argument);
    }

    @Override
    public String pop(){
        String element = this.elements.getFirst();
        this.elements.removeFirst();
        return element;
    }

    @Override
    public void pushFew(int quantity){

        for(int i = 0; i < quantity; i++){
            System.out.println("Podaj stringa");
            this.push(scanner.nextLine());
        }
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.elements)
                .toString();
    }
}
