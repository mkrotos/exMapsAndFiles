package com.krotos;

import java.util.*;
import java.util.stream.Collectors;

public class MapaOsobIDzalow {
    Scanner scanner = new Scanner(System.in);

    private String os;
    private Character dzial;
    private boolean run = true;
    private Map<String,Character> map=new HashMap<>();

    public void run() {
        String input;
        String[] tabInput;
        while (run) {
            System.out.println("Wpisz: osoba, dział (lub 'end' lub 'list')");
            input = scanner.nextLine();
            switch (input) {
                case "end":
                    run = false;
                    break;
                case "list":
                    list();
                    break;
                default:
                    tabInput=input.split(",");
                    System.out.println(Arrays.toString(tabInput));
                    os=tabInput[0];
                    dzial= tabInput[1].trim().charAt(0);
                    map.put(os,dzial);
            }
        }
        System.out.println(map);
    }
    private void list(){
        Set<Character> setDzial=new HashSet<>(map.values());
        for (Character dzial:setDzial){
            System.out.println(dzial+": "+map.keySet().stream().filter(os->map.get(os).equals(dzial)).collect(Collectors.toList()));
        }
    }
}
