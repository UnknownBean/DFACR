/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfacr;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class ClothingItem{
    public ClothingItem(File[] indexList){
        this.indexList = indexList;
        this.maxSize = indexList.length - 1;
    }
    
    public Integer getIndex(){
        return indexValue;
    }

    public String getClothingName(){
        return indexList[indexValue].getName();
        // return "test :)";
    }
    
    public void setIndex(Integer indexToSet){
        this.indexValue = indexToSet;
    }
    
    public File getIndexPath(){
        return indexList[indexValue];
    }
    
    public void randomize(){
        this.indexValue = ThreadLocalRandom.current().nextInt(0, maxSize);
    }
    
    int maxSize;
    Integer indexValue;
    File[] indexList;
}
