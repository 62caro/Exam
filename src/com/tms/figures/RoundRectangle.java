package com.tms.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class RoundRectangle extends Figure {

    private double width;
    private double height;
    private double arcround;
    private double archeight;

    public RoundRectangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_ROUNDRECT, cx, cy, lineWidth, color);
    }

    public RoundRectangle(double cx, double cy, double lineWidth, Color color, double width, double height, double arcround, double archeight) {
        this(cx, cy, lineWidth, color);
        this.width = width;
        this.height = height;
        this.arcround = arcround;
        this.archeight = archeight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArcround() {
        return arcround;
    }

    public void setArcround(double arcround) {
        this.arcround = arcround;
    }

    public double getArcheight() {
        return archeight;
    }

    public void setArcheight(double archeight) {
        this.archeight = archeight;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokeRoundRect(cx - width / 2, cy - height / 2, width, height, arcround, archeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundRectangle that = (RoundRectangle) o;
        return Double.compare(that.width, width) == 0 &&
                Double.compare(that.height, height) == 0 &&
                Double.compare(that.arcround, arcround) == 0 &&
                Double.compare(that.archeight, archeight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, arcround, archeight);
    }
}
