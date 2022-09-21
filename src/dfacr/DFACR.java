package dfacr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DFACR extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(50, 0, 0, 0));
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        root.setSpacing(25);

        Scene mainMenu = new Scene(root, 500, 750);

        primaryStage.setTitle("DFACR");
        primaryStage.setScene(mainMenu);

        Label title = new Label("Delaney's Fucking Awesome Clothing Randomizer"); ///spell check !!!!!!!
        title.setFont(new Font(18));

        Button toRandomizer = new Button("Clothing Randomizer");
        toRandomizer.setOnAction(v->{
            try{
                clothingRandomizer(primaryStage);
            } catch(Exception e){
                System.out.println("Oopsie woopsie :( || we ran into an error\n" + e);
            }
        });

        Button settings = new Button("Settings");
        settings.setOnAction(v->{
            try{
                settings(primaryStage, mainMenu);
            } catch(Exception e){
                System.out.println("Oopsie woopsie :( || we ran into an error\n" + e);
            }
        });

        root.getChildren().addAll(title, toRandomizer, settings);

        primaryStage.show();

    }

    public void settings(Stage primaryStage, Scene mainMenu) throws Exception{
        BorderPane root = new BorderPane();
        root.setBackground( new Background(new BackgroundFill(Color.GREEN, null, null)));
        // root.setAlignment(Pos.TOP_CENTER);
        // root.setPadding(new Insets(25, 100, 50, 100));
        // root.setSpacing(25);

        Button toMainMenu = new Button("Main Menu");
        toMainMenu.setOnAction(v ->{
           primaryStage.setScene(mainMenu);
        });

        HBox menuButton = new HBox();
        menuButton.setAlignment(Pos.CENTER_LEFT);
        menuButton.getChildren().add(toMainMenu);
        menuButton.setMinSize(root.getWidth(), root.getHeight());
        // DEBUG menuButton.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        menuButton.setPadding(new Insets(15, 15, 15, 15));

        VBox SettingsBox = new VBox();
        SettingsBox.setAlignment(Pos.TOP_CENTER);
        SettingsBox.setPadding(new Insets(15, 15, 15, 15));
        SettingsBox.setSpacing(15);
        SettingsBox.setBackground( new Background(new BackgroundFill(Color.BLUE, null, null)));
        SettingsBox.setPadding(new Insets(25, 25, 25, 25));

        Label title = new Label("Settings");

        //------------------------------
        HBox BoysonMeter = new HBox();
        BoysonMeter.setAlignment(Pos.CENTER);
        BoysonMeter.setSpacing(15);

        Label BoysonMeterLabel = new Label("Boyson Meter");
        ToggleButton BoysonMeterToggle = new ToggleButton();
        BoysonMeterToggle.setSelected(BoysonMeterGlobal);


        System.out.println(BoysonMeterGlobal);

        BoysonMeterToggle.selectedProperty().addListener(listener -> {
            if(BoysonMeterToggle.isSelected()){
                BoysonMeterGlobal = true;
            } else{
                BoysonMeterGlobal = false;
            }
        });
        
        








        BoysonMeter.getChildren().addAll(BoysonMeterLabel, BoysonMeterToggle);

        //------------------------------
        
        SettingsBox.getChildren().addAll(title, BoysonMeter);

        // root.getChildren().addAll(menuButton, SettingsBox);
        root.setTop(menuButton);
        root.setCenter(SettingsBox);


        //boysonometer
        //number of items??
        //types of items??
    
    //------------
        Scene settingsMenu = new Scene(root, 500, 750);

        primaryStage.setTitle("DFACR Settings");
        primaryStage.setScene(settingsMenu);
    //------------

        primaryStage.show();
    }

    public void clothingRandomizer(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(0, 0, 20, 0));
        
        Scene scene = new Scene(root, 500, 750);

        root.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));

        primaryStage.setScene(scene);
        
//----------------------------------------------------------------------------------------------------------------------

        VBox Output = new VBox();
        Output.setStyle("-fx-BackgroundImage: ");
        Label labelz[] = {
            new Label(),
            new Label(),
            new Label(),
            new Label(),
            new Label()
        };
        ImageView container[] = {
            new ImageView(), 
            new ImageView(), 
            new ImageView(), 
            new ImageView(), 
            new ImageView()
        }; //top to bottom. [0] = hat
        
        Output.setAlignment(Pos.CENTER);
        Output.setSpacing(10);

        newImages(container, labelz);

        for(int i = 0; i < 5; i++) {            //make not shitty :)))
            HBox display = new HBox();
            display.setAlignment(Pos.CENTER);
            display.setSpacing(20);

            //labelz[i].setText("test :)");

            container[i].setFitHeight(115);
            container[i].setPreserveRatio(true);

            display.getChildren().addAll(container[i], labelz[i]);

            Output.getChildren().add(display);
        }

//----------------------------------------------------------------------------------------------------------------------

        HBox Controls = new HBox();
        Controls.alignmentProperty().set(Pos.CENTER);
        Controls.setSpacing(10);

        Button randomize = new Button("Randomize");
        randomize.setOnAction(e -> {
            randomize.setDisable(true);
            OOTD.randomizeAll();
            newImages(container, labelz);
            randomize.setDisable(false);
            primaryStage.show();
        });

        Controls.getChildren().add(randomize);

//----------------------------------------------------------------------------------------------------------------------

        root.setCenter(Output);
        root.setBottom(Controls);
        primaryStage.show();
    }

    private void newImages(ImageView[] imageContainer, Label[] labelContainer) {
        for(int i = 0; i < imageContainer.length; i++) {
            try{    
                imageContainer[i].setImage( (new Image(new FileInputStream(clothingItems[i].getIndexPath() ) ) ) );
                labelContainer[i].setText( clothingItems[i].getClothingName());
                // Node.getChildren().add(imageContainer[i]);
            } catch( FileNotFoundException e ){
                System.out.println("File not found");
            }
        }
    }

    Outfit OOTD = new Outfit(directoryToolz.getClothingDirs());
    ClothingItem[] clothingItems = OOTD.getAll();

    Boolean BoysonMeterGlobal = false;

}
