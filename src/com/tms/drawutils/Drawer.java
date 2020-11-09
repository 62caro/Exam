package com.tms.drawutils;

import com.tms.figures.Figure;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer<T extends Figure & Drawable> implements Drawable{

    ArrayList<Figure> figures;


    public Drawer(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Figure figure : figures){
            figure.draw(gc);
        }
    }

    public void repaint(Canvas canvas){
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }


}
