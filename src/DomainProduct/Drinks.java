/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainProduct;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Drinks {
    protected static final String FILENAME = "Stock.txt";
    
    protected int id;
    protected String name;
    protected int quantity;
    protected String supplier;
    protected String type;
    protected double price; 
    protected String ImgPath;
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
       public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
       public String getSupplier(){
        return supplier;
    }
    
    public void setSupplier(String supplier){
        this.supplier = supplier;
    }
    
       public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
       public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
     public String getImagePath(){
        return ImgPath;
    }
    
    public void setImagePath(String ImgPath){
        this.ImgPath = ImgPath;
    }
    
    public static List<String> getAll(){
        //get all drinks information to list
        List<String> lst = null;
        try{
            lst = Files.readAllLines(Paths.get(FILENAME));
        }catch (IOException ex){
            Logger.getLogger(Drinks.class.getName()).log(Level.SEVERE, null, ex);// understand logger
        }
        return lst;
    }
    
    public void addNew(){
        //get the inserted drinks information
        String line = String.join("|", Integer.toString(this.getID()), this.getName(), Integer.toString(this.getQuantity()), this.getSupplier(),this.getType(), Double.toString(this.getPrice()), this.getImagePath());
        line += System.lineSeparator();//breakline
        List<String> lstAll = Drinks.getAll();
        List<String> newList = new ArrayList();
        Boolean exist = false;
        System.out.println(this.getImagePath());
        System.out.println(line);
         for (String elem : lstAll){
          //filter the bottle drinks records
            String[] split = elem.split("\\|");
            
            if (split[1].equalsIgnoreCase(name)){
                
                 exist = true;
                 break;
                //System.out.println(split[1]);
            }
         }
         if(exist == true){ //check is the name of the drinks repeated
             JOptionPane.showMessageDialog(null, "The drinks is exist, please enter others name.", "Error", JOptionPane.ERROR_MESSAGE);
         }else{
             writeTo(line, StandardOpenOption.CREATE, StandardOpenOption.APPEND); //Create if the file not exist; apend if the files ready to write
             JOptionPane.showMessageDialog(null, "The record is created successfully.");
         }
    }
    
    public void edit(){
        //get the editted drinks information
        String newline = String.join("|", Integer.toString(this.getID()), this.getName(), Integer.toString(this.getQuantity()), this.getSupplier(),this.getType(), Double.toString(this.getPrice()),this.getImagePath());
        //newline += System.lineSeparator();
        update(Integer.toString(this.getID()), newline, this.getName());
    }
    
  //  public void edit(){
   //     String newline = String.join("|", Integer.toString(this.getId()), this.getName(), Integer.toString(this.getQuantity())), this.getSupplier(),this.getType(), Double.toString(this.getPrice()));
   //     //newline += System.lineSeparator();
   //     update(Integer.toString(this.getId()), newline);
  //  }

    private void writeTo(String line, StandardOpenOption... mode) {
        try { //write inforamtion to text file
            Files.write(Paths.get(FILENAME), line.getBytes(), mode);
            System.out.println("Done!");
        } catch (IOException ex) {
            Logger.getLogger(Drinks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*    public void checkdrinksexist(String id, String name){
    //check is the drinks name same with existing record
    List<String> lstAll = Drinks.getAll();
    List<String> newList = new ArrayList();
    for (String elem : lstAll){
    //filter the bottle drinks records
    String[] split = elem.split("\\|");
    Boolean exist = false;
    if (split[1].equalsIgnoreCase(name)){
    JOptionPane.showMessageDialog(null, "The drinks is exist, please enter others name.", "Error", JOptionPane.ERROR_MESSAGE);
    exist = true;
    System.out.println(split[1]);
    }
    }
    }*/
    
    public double checkprice(String drksname){
        //check the price of the drinks
        //Drinks newDrinks = new Drinks();
        List<String> lstAll = Drinks.getAll();
        List<String> DrinkNameLst = new ArrayList();
        //double price;
        for (String elem : lstAll){
        //filter the bottle drinks records
        
        String[] split = elem.split("\\|");
        if (split[1].equalsIgnoreCase(drksname)){
          }
        double price = Double.parseDouble(split[5]);
        
        }System.out.println(price);
        return price; 
    }
    
    
    
    public void update(String id, String newRecord, String name){
        //update the drinks information by delete all record and writh again
    //getall record - old content
    List<String> lstAll = Drinks.getAll();
    //newList
    List<String> newList = new ArrayList();
    //find the target to update
    for (String oldLine : lstAll){
        String[] split = oldLine.split("\\|");
      //  if(oldLine.startsWith(id)){
            if(split[0].equalsIgnoreCase(id)){
                 newList.add(newRecord);
                 System.out.println(split[0]);
            //}
        }else{
        newList.add(oldLine);
       }   
    }
       
    //write back to the file with new content from newList
    if(newList.size()>0){
        //System.out.println(newList);
        this.writeTo(newList.get(0) + System.lineSeparator(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        for (int i = 1; i< newList.size(); i++){
           this.writeTo(newList.get(i)+System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        
    }
    
    }
    
    public void delete(){
        //ger record should be delete
     String deleteline = String.join("|", Integer.toString(this.getID()), this.getName(), Integer.toString(this.getQuantity()), this.getSupplier(),this.getType(), Double.toString(this.getPrice()));
     del(Integer.toString(this.getID()), deleteline);
    }
    
    public void del(String id, String delRecords){
        //delete record by delete all record in textfile and write in again without the selected record
    //getall record - old content
    List<String> lstAll = Drinks.getAll();
    //newList
    List<String> newList = new ArrayList();
    //find the target to remove
    for (String oldLine : lstAll){
        if(oldLine.startsWith(id)){
            newList.remove(oldLine);
        }else{
            newList.add(oldLine);
        }
    }//System.out.println(newList);
    //write back to the file 
    if(newList.size()>=0){
        System.out.println(newList);
        this.writeTo(newList.get(0) + System.lineSeparator(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        for (int i = 1; i< newList.size(); i++){
           this.writeTo(newList.get(i)+System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        
    }
    
    }
    
    /*    public static void DrinksName(){
    //get drinks only name
    //getall record - old content
    List<String> lstAll = Drinks.getAll();
    List<String> DrinkNameLst = new ArrayList();
    
    for (String elem : lstAll){
    //filter the bottle drinks records
    String[] split = elem.split("\\|");
    HashMap<String,String> drks = new HashMap<String,String>();
    drks.put(split[0],split[1]);
    //DrinkNameLst.add(name);
    System.out.println(drks);
    }
    HashMap<String, String> drks = new HashMap<String, String>();
    for (String i : drks.keySet()) {
    System.out.println("key: " + i + " value: " + drks.get(i));
    }
    
    //return drks;
    
    //Object[] drinkname =  DrinkNameLst.toArray();
    //System.out.println(Arrays.toString(drinkname));
    
    }*/
    
    
      public static void main(String[] args) {
          //test the code
//        System.out.println( new Drinks().getAll() );
        Drinks newDrinks = new Drinks();
        newDrinks.setID(2);
        newDrinks.setName("Coke");
        newDrinks.setQuantity(20);
        newDrinks.setSupplier("Coca Cola Co");
        newDrinks.setType("Cans");
        newDrinks.setPrice(2.50);
        String name = "HE Ice Lemon Tea";
        newDrinks.checkprice(name);
        
      //  newDrinks.addNew();
       // newDrinks.edit();
       //  newDrinks.delete();
      // newDrinks.DrinksName();
   
       
       
    }

 
}
    
    
