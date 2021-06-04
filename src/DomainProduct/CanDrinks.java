/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainProduct;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CanDrinks extends Drinks{
     //using drinks get all code to get all drinks that is bottle
    public static List<String> getAll(){
    List<String> lstAll = Drinks.getAll();
    
    List<String> CanLst = new ArrayList();
    for (String elem : lstAll){
    //filter the bottle drinks records
    String[] split = elem.split("\\|");
    if (split[4].equalsIgnoreCase("Cans")){
        CanLst.add(elem);
    }
}
    return CanLst;
    }
    
    public static void main(String[] args){
System.out.println(new CanDrinks().getAll());
}
}

