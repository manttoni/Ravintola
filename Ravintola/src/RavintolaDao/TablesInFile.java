/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RavintolaDao;

import RavintolaDomain.Customer;
import RavintolaDomain.Table;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Anttoni
 */
public class TablesInFile {

    private List<Table> tables;
    private String file;

    public TablesInFile(String file) throws IOException {
        tables = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));

            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                boolean reserved;
                if(parts[1].equals("true")){
                    reserved = true;
                } else{
                    reserved = false;
                }
                List<Integer> idList = new ArrayList<>();
                for (int i = 2; i < parts.length; i++) {
                    idList.add(Integer.parseInt(parts[i]));
                }
                Table t = new Table(id, reserved, idList);

                tables.add(t);
            }
        } catch (Exception e) {

            System.out.println("File not found");
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }

    }

    public void printTables() {
        for (int i = 0; i < tables.size(); i++) {
            System.out.println(tables.get(i));
        }
    }
    
    public Table getTable(int id){
        for(int i = 0; i < tables.size();i++){
            if(tables.get(i).getID() == id){
                return tables.get(i);
            }
        }
        return null;
    }

}
