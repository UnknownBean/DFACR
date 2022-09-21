/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfacr;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

/**
 *
 * @author guavin1
 */
public class directoryToolz {
    public directoryToolz(){
        
    }
    
    /** Finds and returns the parent directory for clothing items from
     * the current path. Expects the parent directory to be called "ClothingItems"
     * 
     * @return the parent directory containing clothing items || null if no directory is found. 
     */
    public static HashMap<String, File[]> getClothingDirs(){
        File[] directories = new File( System.getProperty("user.dir") + "/ClothingItems" ).listFiles(File::isDirectory);
        HashMap<String, File[]> fileIndexes = new HashMap<String, File[]>();
        
        for(File subDir : directories){
            //System.out.println(subDir.toString());
            //System.out.println(subDir.getName());
            fileIndexes.put(subDir.getName(), indexClothingDirectory(subDir) );        
        }
    
         return fileIndexes;
        
    }
    
    /** Indexes the desired clothing item directory and returns a string array of PNG names.
     * 
     * @param dirToEx directory to index
     * @return a string array of png file names
     */ //INCLUDE PATH FROM USER.DIR!!
    private static File[] indexClothingDirectory(File dirToEx){
        File[] pngImages = dirToEx.listFiles(new FilenameFilter() {
            public boolean accept(File directory, String filename){
                return filename.endsWith(".png") || filename.endsWith(".PNG");
            }
        });
        
            //        for(File img : pngImages){
            //            System.out.println(img.toString());
            //        }
        return pngImages;
    }
    
//    public static void main(String[] args) throws IOException {
//
//        String dirName = "";
//
//        Files.list(new File(dirName).toPath())
//                .limit(10)
//                .forEach(path -> {
//                    System.out.println(path);
//                });
//    }
    
  public static void main(String[] args) {
    System.out.println("Working Directory = " + System.getProperty("user.dir"));
    getClothingDirs();
    //for( File fold : ) //create index for clothing directory. or combine it into find clothing dir maybe??
  
  //}
  
    }
}

