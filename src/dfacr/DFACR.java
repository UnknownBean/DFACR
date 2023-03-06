package dfacr;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/** Delaney's Fucking Awesome Clothing Randomizer
 * A JavaFX application I wrote for a friend who saw a tik tok. 
 * It's probably really ugly, but it does it's job *kinda*
 */
public class DFACR extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Create the root display box for the application
        VBox root = new VBox();
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(50, 0, 0, 0));
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        root.setSpacing(25);
        root.setMinHeight(750);

        //make the scene for the main..part? whatever the terminology is.
        Scene mainMenu = new Scene(root, 500, 750);

        //Stage Changes
        primaryStage.setTitle("DFACR"); //renames the application window to say "DFACR"
        primaryStage.setScene(mainMenu); //sets the scene to the main menu

        
        //Main Menu title
        Label title = new Label("Delaney's Fucking Awesome Clothing Randomizer"); //title for the main menu
        title.setFont(new Font(18)); //self explanatory

        //add menu option
        Button toRandomizer = new Button("Clothing Randomizer");
        toRandomizer.setOnAction(v->{
            try{
                clothingRandomizer(primaryStage);
            } catch(Exception e){
                System.out.println("we ran into an error\n" + e);
            }
        });

        //add menu option
        Button settings = new Button("Settings");
        settings.setOnAction(v->{
            try{
                settings(primaryStage, mainMenu);
            } catch(Exception e){
                System.out.println("we ran into an error\n" + e);
            }
        });

        root.getChildren().addAll(title, toRandomizer, settings);

        primaryStage.show();

    }

    /** Settings
     *   This method sets up the settings menu of the DFACR application using JavaFX.
     *   It takes in a Stage object representing the primary stage of the application and a Scene object
     *   representing the main menu scene. It throws an Exception if an error occurs during the process.
     *   @param primaryStage the Stage object representing the primary stage of the application
     *   @param mainMenu the Scene object representing the main menu scene of the application
     *   @throws Exception if an error occurs during the process
    */
    public void settings(Stage primaryStage, Scene mainMenu) throws Exception{
        BorderPane root = new BorderPane();
        root.setBackground( new Background(new BackgroundFill(Color.GREEN, null, null)));

        //Create Return Button
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

        //Create box to contain all settings options
        VBox SettingsBox = new VBox();
        SettingsBox.setAlignment(Pos.TOP_CENTER);
        SettingsBox.setPadding(new Insets(15, 15, 15, 15));
        SettingsBox.setSpacing(15);
        SettingsBox.setBackground( new Background(new BackgroundFill(Color.DARKGRAY, null, null)));
        SettingsBox.setPadding(new Insets(25, 25, 25, 25));

        Label title = new Label("Settings");


        //create menu option #1
        HBox BoysonMeter = new HBox();
        BoysonMeter.setAlignment(Pos.CENTER);
        BoysonMeter.setSpacing(15);
        
        Label BoysonMeterLabel = new Label("Boyson Meter");
        ToggleButton BoysonMeterToggle = new ToggleButton();
        BoysonMeterToggle.setSelected(BoysonMeterGlobal);

        //create menu option #2
        HBox ImageLabelDebug = new HBox();
        ImageLabelDebug.setAlignment(Pos.CENTER);
        ImageLabelDebug.setSpacing(15);
        
        Label ImageDebugLabel = new Label("Image Name Labels (debug)");
        ToggleButton ImageLabelDebugToggle = new ToggleButton();
        ImageLabelDebugToggle.setSelected(ImageLabelDebugGlobal);   

        ImageLabelDebugToggle.selectedProperty().addListener(listener -> {
            if(ImageLabelDebugToggle.isSelected()){
                ImageLabelDebugGlobal = true;
            } else{
                ImageLabelDebugGlobal = false;
            }
        

            
        });
        
        






        ImageLabelDebug.getChildren().addAll(ImageDebugLabel, ImageLabelDebugToggle);

        BoysonMeter.getChildren().addAll(BoysonMeterLabel, BoysonMeterToggle);

        //------------------------------
        
        SettingsBox.getChildren().addAll(title, BoysonMeter, ImageLabelDebug);


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
        
        Scene scene = new Scene(root, 500, 900); //changes the size of the clothing randomizer scene

        root.setBackground(new Background(new BackgroundFill(Color.PINK, null, null)));

        primaryStage.setScene(scene);
        
//----------------------------------------------------------------------------------------------------------------------

        VBox Output = makeRandomizer(); 

//----------------------------------------------------------------------------------------------------------------------

        HBox Controls = makeControls(primaryStage);

//----------------------------------------------------------------------------------------------------------------------

        root.setCenter(Output);
        root.setBottom(Controls);
        primaryStage.show();
    }

    private VBox makeRandomizer(){
        VBox Output = new VBox();
        // Output.setStyle("-fx-BackgroundImage: ");

        for(ClothingItem i : OOTD.getAll()){
            i.getImageView().setFitHeight(115);
            i.getImageView().setPreserveRatio(true);

            if(ImageLabelDebugGlobal){
                Output.getChildren().addAll(i.getImageView(), i.getLabel());
            } else{
                Output.getChildren().addAll(i.getImageView());
            }
        }
        
        Output.setAlignment(Pos.CENTER);
        Output.setSpacing(10);

       return Output;
    }

    private HBox makeControls(Stage primaryStage){
        HBox Controls = new HBox();
        Controls.alignmentProperty().set(Pos.CENTER);
        Controls.setSpacing(10);

        Button randomize = new Button("Randomize");
        
        randomize.setOnAction(e -> {
            randomize.setDisable(true);
            OOTD.randomizeAll();
            randomize.setDisable(false); //does this do anything if I undo it before I run display.show?
            primaryStage.show();
        });

        Controls.getChildren().add(randomize);
        
        return Controls;
    }




    Outfit OOTD = new Outfit(directoryToolz.getClothingDirs());
    ClothingItem[] clothingItems = OOTD.getAll();

    Boolean BoysonMeterGlobal = false;
    Boolean ImageLabelDebugGlobal = false;
}