package dfacr;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Clothing Item Class
 * A subclass representing an individual item that fits into a larger collection of objects.
 * This class holds information about a single clothing item, including its image, name, and index in a larger collection.
 */
public class ClothingItem {
    
    // Fields
    int maxSize; // Maximum index value
    Integer indexValue; // Current index value
    File[] indexList; // List of clothing item files
    File currentClothingFile; // Current clothing item file
    ImageView currentClothingImage; // Current clothing item image
    Label currentLabel; // Current clothing item name label
    
    /**
     * ClothingItem Constructor
     * Initializes the ClothingItem object with the given index list.
     * Sets the maximum index value to the size of the index list minus one.
     * Creates a new ImageView and Label for the current clothing item.
     * @param indexList The list of clothing item files.
     */
    public ClothingItem(File[] indexList) {
        this.indexList = indexList;
        this.maxSize = indexList.length - 1;
        this.currentClothingImage = new ImageView();
        this.currentClothingImage.setStyle("-fx-border-color: black; -fx-border-width: 2;");
        this.currentLabel = new Label();
    }
    
    /**
     * getIndex Method
     * Returns the current index value of the ClothingItem object.
     * @return The current index value.
     */
    public Integer getIndex() {
        return indexValue;
    }

    /**
     * getClothingName Method
     * Returns the name of the current clothing item file.
     * @return The name of the current clothing item file.
     */
    public String getClothingName() {
        return indexList[indexValue].getName();
    }
    
    /**
     * setIndex Method
     * Sets the current index value of the ClothingItem object to the given value.
     * @param indexToSet The value to set the index to.
     */
    public void setIndex(Integer indexToSet) {
        this.indexValue = indexToSet;
    }
    
    /**
     * getIndexPath Method
     * Returns the file path of the current clothing item file.
     * @return The file path of the current clothing item file.
     */
    public File getIndexPath() {
        return indexList[indexValue];
    }
    
    /**
     * randomize Method
     * Generates a random index value within the range of possible index values and sets it as the current index value.
     * Sets the current clothing item file, image, and name label to match the newly generated index value.
     */
    public void randomize() {
        this.indexValue = ThreadLocalRandom.current().nextInt(0, maxSize);
        this.currentClothingFile = indexList[indexValue];
        this.currentClothingImage.setImage(new Image(currentClothingFile.toURI().toString()));
        this.currentLabel.setText(this.currentClothingFile.getName());
    }

    /**
     * getImageView Method
     * Returns the current clothing item image.
     * @return The current clothing item image.
     */
    public ImageView getImageView() {
        return this.currentClothingImage;
    }

    /**
     * getLabel Method
     * Returns the current clothing item name label.
     * @return The current clothing item name label.
     */
    public Label getLabel() {
        return this.currentLabel;
    }
}
