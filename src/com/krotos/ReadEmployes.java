package com.krotos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReadEmployes {
    File file = new File("employes.txt");
    BufferedReader br;
    List<Employee> listEmp = new ArrayList<>();

    {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ni ma pliku");
        }
    }

    public void readuj() {
        String line;
        String[] tabLine;
        int max = 1000;
        for (int i = 0; i < max; i++) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            if (line == null) {
                break;
            }
            //System.out.println(line);
            line.trim();
            tabLine = line.split(";");
            listEmp.add(new Employee(tabLine[0], tabLine[1], tabLine[2], Long.parseLong(tabLine[3].trim())));
        }
        System.out.println("Lista emp:");
        //System.out.println(Arrays.toString(listEmp.toArray()));
        listEmp.stream().forEach(em -> System.out.println(em));
    }

    public void sortAndWrite() {

        listEmp.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.id > o2.id) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        listEmp.stream().forEach(em -> System.out.println(em));
        try {
            PrintWriter pr=new PrintWriter("sortedEmployes.txt","UTF-8");
            for (Employee em:listEmp){
                pr.println(em.toString());
            }
            pr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("unsupported enc");
        }
    }
}
