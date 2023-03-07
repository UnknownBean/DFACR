/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfacr;

// import dfacr.Outfit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author guavi
 * 
 * TO ADD: CREATE PHOTOSHOP TEMPLATES/MODELS TO STANDARDIZE THE SIZE OF THE CLOTHING!!!! LINE UP THE CLOTHING ITEM TO THE CUTOUT, SELECT INVERSE, DELETE. 
 * WILL ACCOUNT FOR VARIABILITY IN PICTURE SIZE AND ETC. MAKES WHOLE THING RUN MORE SMOOTHLY. YOU NEED TO FUCKING DO THIS, DON'T FUCKING FORGET
 * THIS IS FOR DELANEY, NOT FOR THE CUTOUTS.
 * 
 * 
 * 
 * 
 * 
 * 
 * 

 FUCKING DO IT YOU SCOONHOUND. I'M NOT KIDDING. I'M FUCKING DOING IT. god
 */
public class DFACROLD extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        HBox Controls = new HBox();
        VBox Output = new VBox();

        //Output    
//<editor-fold>        
        Output.alignmentProperty().set(Pos.CENTER);
        Output.setBackground(Background.EMPTY);
        Output.setSpacing(10);
        // hat = new Label("test");
        // shirt = new Label("test");
        // pants = new Label("test");
        // socks = new Label("test");
        // shoes = new Label("test");

        // updateDisplay();
        
        // //Output.getChildren().addAll(hat, shirt, pants, socks, shoes);
        ImageView shirt[] = {hatImageView, shirtImageView, pantsImageView, socksImageView, shoesImageView};
        
        updateDisplay(shirt, root);

        Output.getChildren().addAll(hatImageView, shirtImageView, pantsImageView, socksImageView, shoesImageView);
//</editor-fold>

        //Controls
//<editor-fold>
        Controls.alignmentProperty().set(Pos.CENTER);
        Controls.setBackground(Background.EMPTY);
        Controls.setPadding(new Insets(0.0f, 0.0f, 15.0f, 0.0f));
        Controls.setSpacing(10);

        Button updateFit = new Button();
        updateFit.setText("Update Fit");
        updateFit.setOnAction(e->{
            mainFit.randomizeAll();
            // updateDisplay();
            primaryStage.show();
        });
        Controls.getChildren().add(updateFit);
//</editor-fold>   

//<editor-fold>
        //root.getChildren().addAll(Output, Controls);

        root.setBackground(Background.EMPTY);
        // root.setCenter(Output);
        root.setBottom(Controls);

        primaryStage.setTitle("DFACR");
        Scene scene = new Scene(root, 500, 750);
//        scene.setFill(Color.PINK);
        primaryStage.setScene(scene);
        primaryStage.show();

//</editor-fold>
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void updateDisplay(ImageView s[], BorderPane root) { //updates the display with the current fit
        mainFit.randomizeAll();

        try{
            hatImageView = new ImageView(new Image(new FileInputStream(mainFit.hat.getIndexPath())));
            shirtImageView = new ImageView(new Image(new FileInputStream(mainFit.shirt.getIndexPath())));
            pantsImageView = new ImageView(new Image(new FileInputStream(mainFit.pants.getIndexPath())));
            socksImageView = new ImageView(new Image(new FileInputStream(mainFit.socks.getIndexPath())));
            shoesImageView = new ImageView(new Image(new FileInputStream(mainFit.shoes.getIndexPath())));            
            
        } catch( FileNotFoundException e ){
            System.out.println(e.toString());
        }
    }

    Outfit mainFit = new Outfit( directoryToolz.getClothingDirs() );

    ImageView hatImageView;
    ImageView shirtImageView;
    ImageView pantsImageView;
    ImageView socksImageView;
    ImageView shoesImageView;

    Label hat;
    Label shirt;
    Label pants;
    Label socks;
    Label shoes;
}
