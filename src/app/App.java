package app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import app.Br;
import app.ChainageAvant;

public class App {
     // base de faits pour Chainage avant
    public static ArrayList<String> bf = new ArrayList<String>();
  
    public static void main(String[] args) throws Exception {
        // fait
        String f = new String();
        ArrayList<String> fVal = new ArrayList<String>();
       
       
        // base de regles
        Br bRegle = new Br();

        // read date from file
        readFromFile( fVal,  bf,  bRegle );
        // workaround for global string variable problem
        f+=fVal.get(0);

        // print base de faits
        System.out.println(bf.toString());

        // Print base de regles;
        System.out.println(bRegle.toString());


        System.out.println("Chainage Avant: -------------------\n");


        // // Chainage avant
        ChainageAvant.solve(bf,bRegle,f);

        System.out.println("--------------------------------------\n--------------------------------------");

       


        // prints
        // System.out.println(br.toString());
        // System.out.println(bRegle);
    }

    public static void readFromFile(ArrayList<String> f, ArrayList<String> bf, Br bRegle){
        BufferedReader reader;
        
        try {
            reader = new BufferedReader(new FileReader("data/in.txt"));
            // read first line 
            String line = reader.readLine();
            f.addAll(Arrays.asList(line.split(",")));
            // read second line
            line = reader.readLine();
            bf.addAll(Arrays.asList(line.split(",")));
          
           

            line= reader.readLine();
            
            Regle r ;
            String [] temp ;
            while(line !=null){
                temp = line.trim().split("\\s+");
                r = new Regle(temp[0].trim(), temp[1].trim());
                bRegle.addRegle(r);
                line= reader.readLine();  

            }
            reader.close();
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}