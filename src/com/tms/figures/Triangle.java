package com.tms.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {

    private double cx1;
    private double cx2;
    private double cy1;
    private double cy2;

    public Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double cx1, double cx2, double cy1, double cy2) {
        this(cx, cy, lineWidth, color);
        this.cx1 = cx1;
        this.cx2 = cx2;
        this.cy1 = cy1;
        this.cy2 = cy2;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);

        gc.strokePolygon(new double[]{cx, cx1, cx2}, new double[]{cy, cy1, cy2}, 3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.cx1, cx1) == 0 &&
                Double.compare(triangle.cx2, cx2) == 0 &&
                Double.compare(triangle.cy1, cy1) == 0 &&
                Double.compare(triangle.cy2, cy2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cx1, cx2, cy1, cy2);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "cx1=" + cx1 +
                ", cx2=" + cx2 +
                ", cy1=" + cy1 +
                ", cy2=" + cy2 +
                '}';
    }
}
