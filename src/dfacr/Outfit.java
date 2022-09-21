/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfacr;

import java.io.File;
import java.util.HashMap;

public class Outfit {
    public Outfit(HashMap<String, File[]> clothingLists){
        this.hat = new ClothingItem(clothingLists.get("hat"));
        this.shirt = new ClothingItem(clothingLists.get("shirt"));
        this.pants = new ClothingItem(clothingLists.get("pant"));
        this.socks = new ClothingItem(clothingLists.get("sock"));
        this.shoes = new ClothingItem(clothingLists.get("shoe"));
        
        randomizeAll();
    }
    
    public void randomizeAll(){
        this.hat.randomize();
        this.shirt.randomize();
        this.pants.randomize();
        this.socks.randomize();
        this.shoes.randomize();
    }
    
    public void displayIndexes(){
        System.out.println("Hat: " + hat.getIndex());
        System.out.println("shirt: " + shirt.getIndex());
        System.out.println("pants: " + pants.getIndex());
        System.out.println("socks: " + socks.getIndex());
        System.out.println("shoes: " + shoes.getIndex());
    }

    public ClothingItem[] getAll(){
        ClothingItem[] all = new ClothingItem[5];
        all[0] = hat;
        all[1] = shirt;
        all[2] = pants;
        all[3] = socks;
        all[4] = shoes;
        return all;
    }
    
    public Integer getHatVal(){
        return hat.getIndex();
    }
    
    public Integer getShirtVal(){
        return shirt.getIndex();
    }
    
    public Integer getPantVal(){
        return pants.getIndex();
    }
    
    public Integer getSockVal(){
        return socks.getIndex();
    }
    
    public Integer getShoeVal(){
       return shoes.getIndex();
    }
    
    ClothingItem hat;
    ClothingItem shirt;
    ClothingItem pants;
    ClothingItem socks;
    ClothingItem shoes;
    
}

