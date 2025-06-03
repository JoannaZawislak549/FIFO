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
public class FifoPriority implements IFifo {
    private ArrayList<Tuple<String, Integer>> elements;
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void push(String name, int priority){
        this.elements.add(new Tuple<>(name, priority));
    }

    @Override
    public Tuple<String, Integer> popFirst(){
        if (this.elements.isEmpty()){
            return null;
        }
        Tuple<String, Integer> element = this.elements.getFirst();
        this.elements.removeFirst();
        return element;
    }

    @Override
    public Tuple<String, Integer> popHighThree() {
        if (this.elements.isEmpty()) {
            return null;
        }
            int temp_max = this.elements.getFirst().second;
            Tuple<String, Integer> result = this.elements.getFirst();

            int size = Math.min(3, this.elements.size());

            for (int i = 0; i < size; i++) {
                Tuple<String, Integer> tuple = this.elements.get(i);
                if (tuple.second > temp_max) {
                    temp_max = tuple.second;
                    result = tuple;
                }
            }
            this.elements.remove(result);
            return result;

        }


    @Override
    public Tuple<String, Integer> popHighest() {
            if (this.elements.isEmpty()){
                return null;
            }

        int temp_max = this.elements.getFirst().second;
        Tuple<String, Integer> result = this.elements.getFirst();
        for (Tuple<String, Integer> tuple : this.elements){
            if (tuple.second > temp_max){
                temp_max = tuple.second;
                result = tuple;
            }
        }
        this.elements.remove(result);
        return result;

    }

    @Override
    public void pushFew(int quantity){

        for(int i = 0; i < quantity; i++){
            System.out.println("Podaj stringa");
            String name = scanner.nextLine();
            System.out.println("Podaj priorytet (0-10)");
            int priority = scanner.nextInt();
            scanner.nextLine();
            this.push(name, priority);
        }
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.elements)
                .toString();
    }
}
