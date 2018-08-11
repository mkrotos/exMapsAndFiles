package com.krotos;

import java.util.*;
import java.util.stream.Collectors;

public class MapaKont {
    Map<String, Long> mapKont = new HashMap<>();

    private void init() {
        mapKont.put("Adakm", 500l);
        mapKont.put("Bart", 5000l);
        mapKont.put("Tomk", 500000l);
        mapKont.put("Lam", 20230l);
        mapKont.put("Palg", 50230l);
    }

    public void run() {
        init();
        List<String> listBogatych = new ArrayList<>();
        listBogatych = mapKont.keySet().stream().filter(os -> (os.contains("k") || os.contains("g")) && mapKont.get(os) > 10000).sorted(Comparator.comparingLong(o -> mapKont.get(o))).collect(Collectors.toList());
        //listBogatych.sort((o1, o2) -> mapKont.get(o1).compareTo(mapKont.get(o2)));
        System.out.println(Arrays.toString(listBogatych.toArray()));
    }
}
