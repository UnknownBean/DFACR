package dfacr;

import java.io.File;
import java.util.HashMap;

/** Outfit
 * Represents an outfit, consisting of various clothing items.
 */
public class Outfit {

    /**
     * Creates a new Outfit instance with the given clothing lists.
     *
     * @param clothingLists a HashMap containing lists of File objects for each clothing item type
     */
    public Outfit(HashMap<String, File[]> clothingLists){
        // Initialize each clothing item with a random selection from its respective list
        this.hat = new ClothingItem(clothingLists.get("hat"));
        this.shirt = new ClothingItem(clothingLists.get("shirt"));
        this.pants = new ClothingItem(clothingLists.get("pant"));
        this.socks = new ClothingItem(clothingLists.get("sock"));
        this.shoes = new ClothingItem(clothingLists.get("shoe"));

        randomizeAll();
    }

    /**
     * Randomly selects a new clothing item from each list and assigns it to its respective ClothingItem instance.
     */
    public void randomizeAll(){
        this.hat.randomize();
        this.shirt.randomize();
        this.pants.randomize();
        this.socks.randomize();
        this.shoes.randomize();
    }

    /**
     * Prints the index of each clothing item in the outfit to the console.
     */
    public void displayIndexes(){
        System.out.println("Hat: " + hat.getIndex());
        System.out.println("Shirt: " + shirt.getIndex());
        System.out.println("Pants: " + pants.getIndex());
        System.out.println("Socks: " + socks.getIndex());
        System.out.println("Shoes: " + shoes.getIndex());
    }

    /**
     * Returns an array containing all of the clothing items in the outfit.
     *
     * @return an array of ClothingItem objects
     */
    public ClothingItem[] getAll(){
        ClothingItem[] all = new ClothingItem[5];
        all[0] = hat;
        all[1] = shirt;
        all[2] = pants;
        all[3] = socks;
        all[4] = shoes;
        return all;
    }

    /**
     * Returns the index of the hat in the outfit.
     *
     * @return the index of the hat
     */
    public Integer getHatVal(){
        return hat.getIndex();
    }

    /**
     * Returns the index of the shirt in the outfit.
     *
     * @return the index of the shirt
     */
    public Integer getShirtVal(){
        return shirt.getIndex();
    }

    /**
     * Returns the index of the pants in the outfit.
     *
     * @return the index of the pants
     */
    public Integer getPantVal(){
        return pants.getIndex();
    }

    /**
     * Returns the index of the socks in the outfit.
     *
     * @return the index of the socks
     */
    public Integer getSockVal(){
        return socks.getIndex();
    }

    /**
     * Returns the index of the shoes in the outfit.
     *
     * @return the index of the shoes
     */
    public Integer getShoeVal(){
       return shoes.getIndex();
    }

    /**
     * The hat ClothingItem in the outfit.
     */
    ClothingItem hat;

    /**
     * The shirt ClothingItem in the outfit.
     */
    ClothingItem shirt;

    /**
     * The pants ClothingItem in the outfit.
     */
    ClothingItem pants;

    /**
     * The socks ClothingItem in the outfit.
     */
    ClothingItem socks;

    /**
     * The shoes ClothingItem in the outfit.
     */
    ClothingItem shoes;
}
