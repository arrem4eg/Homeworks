package homework12;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {

        String[] cowNames = {"Rose", "Darla", "Meg", "Dahlia", "Margie", "Lois", "Flower", "Maggie", "Jasmine", "Minnie"};


        Map<String, Cow> cowHashMap = new HashMap<>();

        for (String str : cowNames) {
            Cow cow = new Cow(str);
            cowHashMap.put(cow.getName(), cow);
        }


        for (Map.Entry<String, Cow> entry : cowHashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }

    }
}

class Cow {
    private String name;

    public Cow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}