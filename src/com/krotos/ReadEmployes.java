package com.krotos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadEmployes {
    File file=new File("employes.txt");
    BufferedReader br;
    List<Employee> listEmp=new ArrayList<>();

    {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ni ma pliku");
        }
    }
    public void readuj(){
        String line;
        String[] tabLine;
        int max=1000;
        for(int i=0;i<max;i++){
            try {
                line=br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            if (line==null){
                break;
            }
            //System.out.println(line);
            line.trim();
            tabLine=line.split(";");
            listEmp.add(new Employee(tabLine[0],tabLine[1],tabLine[2],Long.parseLong(tabLine[3].trim()) ));
        }
        System.out.println("Lista emp:");
        //System.out.println(Arrays.toString(listEmp.toArray()));
        listEmp.stream().forEach(em-> System.out.println(em));
    }
}
