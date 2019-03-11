package com.example.caps;

import ca.roumani.i2c.*;

public class Game {
    private CountryDB db;

    public Game() {
        this.db = new CountryDB();
    }

    public String[] qa() {
        String answer[] = new String[2];
        int n = db.getCapitals().size();
        String index = db.getCapitals().get((int) (n * Math.random()));
        Country ref = db.getData().get(index);
        if(Math.random() < 0.5) {
            answer[0] = "What is the capital of " + ref.getName();
            answer[1] = ref.getCapital();
        } else {
            answer[0] = ref.getCapital() + " is the capital of?";
            answer[1] = ref.getName();
        }
        return answer;
    }
}
