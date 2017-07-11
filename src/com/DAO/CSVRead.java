package com.DAO;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVRead {

    public  void test() {

        String csvFile = "/Users/admin/Desktop/DB Project/books.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "\t";
        int i=0;
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                i++;
                System.out.print(country[0]+"- "+" "+country[1]+"- "+country[2]+"- "+country[3]+"- "+country[4]+"- "+country[5]+"-"+country[6]+" ");
                System.out.println(country[6]);
                System.out.println();
                if(i==10){
                	break;
                }
                //System.out.println("Country [code= " + country[0] + " , name=" + country[1] + "]");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
