package com.tms.figuresfx.controller;


import com.tms.ErrorsExceptions.ErrorCreateFigure;
import com.tms.drawutils.Drawer;
import com.tms.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {

    private ArrayList<Figure> figures;
    private Random random;
    Drawer<Figure> drawer;
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);

    @FXML
    Button triangle;

    @FXML
    private Canvas canvas;

    private int pressButton = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("Successful initialization");
        figures = new ArrayList<>();
        drawer = new Drawer<>(figures);
        random = new Random(System.currentTimeMillis());
    }

    public Figure createFigure(double x, double y, int number) throws ErrorCreateFigure {
        Figure figure = null;

        switch (number) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, Math.max(random.nextInt(3), 10), Color.BLUE, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, Math.max(random.nextInt(3), 10), Color.GREEN, random.nextInt(50) + 10, random.nextInt(100) + 10);
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, Math.max(random.nextInt(3), 10), Color.BLACK, x + random.nextInt(150), x + random.nextInt(100), y + random.nextInt(100) + 60, y + random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_ROUNDRECT:
                figure = new RoundRectangle(x, y, Math.max(random.nextInt(3), 10), Color.RED, random.nextInt(50), random.nextInt(100), random.nextInt(10), random.nextInt(10));
                break;
            case Figure.FIGURE_TYPE_ELLIPSE:
                figure = new Ellipse(x, y, Math.max(random.nextInt(3), 10), Color.VIOLET, random.nextInt(50));
                break;
            default:
                throw new ErrorCreateFigure("Figure doesn't exist");
        }
        return figure;
    }

    @FXML
    public void onMouseClicked(javafx.scene.input.MouseEvent mouseEvent) throws ErrorCreateFigure {

        switch (pressButton) {
            case 1:
                draw(mouseEvent, random.nextInt(5));
                break;
            case 2:
                circleButton(mouseEvent);
                break;
            case 3:
                triangleButton(mouseEvent);
                break;
            case 4:
                rectangleButton(mouseEvent);
                break;
            case 5:
                roundrectButton(mouseEvent);
                break;
            case 6:
                ellipseButton(mouseEvent);
                break;
            default:
                throw new ErrorCreateFigure("Figure doesn't exist");
        }
    }

    public void draw(MouseEvent mouseEvent, int num) throws ErrorCreateFigure {
        drawer.addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY(), num));
        drawer.repaint(canvas);
    }


    @FXML
    public void clearButton(MouseEvent mouseEvent) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        pressButton = 1;
        figures = new ArrayList<>();
        drawer = new Drawer<>(figures);
    }

    @FXML
    public void triangleButton(MouseEvent mouseEvent) throws ErrorCreateFigure {
        pressButton = 3;
        draw(mouseEvent, 2);
    }

    @FXML
    public void circleButton(MouseEvent mouseEvent) throws ErrorCreateFigure {
        pressButton = 2;
        draw(mouseEvent, 0);
    }

    @FXML
    public void rectangleButton(MouseEvent mouseEvent) throws ErrorCreateFigure {
        pressButton = 4;
        draw(mouseEvent, 1);
    }

    @FXML
    public void roundrectButton(MouseEvent mouseEvent) throws ErrorCreateFigure {
        pressButton = 5;
        draw(mouseEvent, 3);
    }

    @FXML
    public void ellipseButton(MouseEvent mouseEvent) throws ErrorCreateFigure {
        pressButton = 6;
        draw(mouseEvent, 4);
    }


}
