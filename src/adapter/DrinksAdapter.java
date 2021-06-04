/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import DomainProduct.BottleDrinks;
import DomainProduct.CanDrinks;
import DomainProduct.Drinks;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DrinksAdapter {
    //get all drinks record
    public static List<Drinks> getDrinks(){
        List<String> drks = Drinks.getAll();
        
        //temp collection
        List<Drinks> temp = new ArrayList();
        for (String line: drks){
            String[] split = line.split("\\|");
            Drinks newDrinks = new Drinks();
            newDrinks.setID(Integer.parseInt(split[0]));
            newDrinks.setName(split[1]);
            newDrinks.setQuantity(Integer.parseInt(split[2]));
            newDrinks.setSupplier(split[3]);
            newDrinks.setType(split[4]);
            newDrinks.setPrice(Double.parseDouble(split[5]));
            newDrinks.setImagePath(split[6]);
            temp.add(newDrinks);
        }
        return temp;
    }
    
    public static List<BottleDrinks> getBottleDrinks(){
        //get bottle drinks record
        List<String> drks = BottleDrinks.getAll();
        //temp
        List<BottleDrinks> temp = new ArrayList();
        for (String line: drks){
            String[] split = line.split("\\|");
            BottleDrinks newBottleDrinks = new BottleDrinks();
            newBottleDrinks.setID(Integer.parseInt(split[0]));
            newBottleDrinks.setName(split[1]);
            newBottleDrinks.setQuantity(Integer.parseInt(split[2]));
            newBottleDrinks.setSupplier(split[3]);
            newBottleDrinks.setType(split[4]);
            newBottleDrinks.setPrice(Double.parseDouble(split[5]));
            newBottleDrinks.setImagePath(split[6]);
            temp.add(newBottleDrinks);
        }
        return temp;
    }
    
    public static List<CanDrinks> getCanDrinks(){
        //get can drinks records
        List<String> drks = CanDrinks.getAll();
        //temp
        List<CanDrinks> temp = new ArrayList();
        for (String line: drks){
            String[] split = line.split("\\|");
            CanDrinks newCanDrinks = new CanDrinks();
            newCanDrinks.setID(Integer.parseInt(split[0]));
            newCanDrinks.setName(split[1]);
            newCanDrinks.setQuantity(Integer.parseInt(split[2]));
            newCanDrinks.setSupplier(split[3]);
            newCanDrinks.setType(split[4]);
            newCanDrinks.setPrice(Double.parseDouble(split[5]));
            newCanDrinks.setImagePath(split[6]);
            temp.add(newCanDrinks);
        }
        return temp;
    }
    public static void main (String[] args) {
    //System.out.println(DrinksAdapter.getDrinks());
}
}
