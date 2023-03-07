package dfacr;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

/** DirectoryToolz class
 * provides basic directory functions for a larger program that relies on files within it's directory. 
 * could be reusable?
 */
public class directoryToolz {
    public directoryToolz(){}
    
    /** Finds and returns the parent directory for clothing items from
     * the current path. Expects the parent directory to be called "ClothingItems"
     * 
     * @return the parent directory containing clothing items || null if no directory is found. 
     */
    public static HashMap<String, File[]> getClothingDirs(){
        File[] directories = new File( System.getProperty("user.dir") + "/ClothingItems" ).listFiles(File::isDirectory);
        
        // for(File f : directories){
        //     // System.out.print("dir:" + f.getAbsolutePath() + "\n");
        //     indexClothingDirectory(f);
        // }

        HashMap<String, File[]> fileIndexes = new HashMap<String, File[]>();
        
        for(File subDir : directories){
            // System.out.println(subDir.toString());
            // System.out.println(subDir.getName());
            fileIndexes.put(subDir.getName(), indexClothingDirectory(subDir) );        
        }

         return fileIndexes;
        
    }
    
    /** Indexes the desired clothing item directory and returns a string array of PNG names.
     * 
     * @param dirToEx directory to index
     * @return a string array of png file names
     */
    private static File[] indexClothingDirectory(File dirToEx){
        File[] pngImages = dirToEx.listFiles(new FilenameFilter() {
            public boolean accept(File directory, String filename){
                // System.out.println(filename);
                return filename.endsWith(".png") || filename.endsWith(".PNG");
            }
        });
        
                //    for(File img : pngImages){
                //     //    System.out.println(img.toString());
                //    }

        return pngImages;
    }

}

