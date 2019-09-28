package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class Controller {

    @FXML
    public ImageView imageView;

    @FXML
    private TextField heightArea;

    @FXML
    private TextField weightArea;

    @FXML
    private Label textForUser;

    public void setImage(int imageNumber){
        System.out.println(imageNumber);
        try {
            File file = new File("pwd/home/farida/Dprojects/JavaFX IdeaProjects/BMI/src/sample/s"+imageNumber+".png");
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @FXML
    void calculate(ActionEvent event) {
        double weight = Double.parseDouble(weightArea.getText());
        double height = Double.parseDouble(heightArea.getText());

        double bmi = weight / (height * height);

        String status;
        if (bmi < 18.6){
            setImage(1);
            status = "Underweight";
        }else if (bmi < 25.0 && bmi > 18.5){
            setImage(2);
            status = "Normal weight";
        }else if (bmi < 30.0 && bmi > 24.9){
            setImage(3);
            status = "Owerweight";
        }else {
            setImage(4);
            status = "Obese";
        }

        textForUser.setText(String.format("Your BMI is %.2f. \n your status is %s", bmi, status));
    }

}