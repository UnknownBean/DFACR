package dfacr;

import javafx.scene.image.Image;

public class ClothingImage extends Image {
    
    public ClothingImage(String url){
        super(url);
        itemName = URL2Name(url);
    }

    private String URL2Name(String url){
        if(url.contains("/ClothingItems/")){
            String[] splitUp = url.split("/");
            
            for(String s : splitUp){
                System.out.println(s);
            }
        }

        return ":)";
    }

    public String getItemName(){
        return itemName;
    }
    String itemName;
}
