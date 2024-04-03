package rheinmetall.scene.figures;

import java.awt.*;

public class Kante {

    private int start, end;
    private Color color= Color.BLACK;


    public Kante(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public Kante(final int start, final int end, final Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public int getStart() {
        return start;
    }

    public void setStart(final int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(final int end) {
        this.end = end;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }
}
