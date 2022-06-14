package com.practise.lotto;

import java.util.*;

public class Lotto {

    private Database database;

    public Lotto(Database database) {
        this.database = database;
    }

    public Integer miniLotto(Set<Integer> numbers){

        Set<Integer> winningNumbers= database.wylosuj(5);

        if(numbers.size() > 5 || numbers.size() <5){
            return null;
        }

        for(Integer i : numbers){
            if(i < 1 || i > 36){
                return null;
            }
        }

        numbers.retainAll(winningNumbers);

        return numbers.size();
    }

}
