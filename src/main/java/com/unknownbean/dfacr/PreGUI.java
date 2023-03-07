/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfacr;

import java.util.Scanner;

/**
 *
 * @author guavi
 */
public class PreGUI {
    public static void main(String[] args) {
       Scanner myObj = new Scanner(System.in);
       String prompt = "y";
       
       do{
            Outfit OOTD = new Outfit( directoryToolz.getClothingDirs() );//directoryToolz.getClothingDirs() );
            OOTD.randomizeAll();
            OOTD.displayIndexes();
            
            dfacr.directoryToolz.getClothingDirs();

            System.out.println("repeat?");
            prompt = myObj.nextLine();
        }while(prompt.equals("y"));
        
        myObj.close();
    }
    
}
