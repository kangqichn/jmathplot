package org.math.plot.plots;

import java.awt.*;

import org.math.plot.canvas.PlotCanvas;
import org.math.plot.render.*;
import org.math.plot.utils.Array;
import org.math.plot.utils.FastMath;

public class ScatterPlot extends Plot {

    private int type;
    private int radius;
    private boolean[][] pattern;
    private boolean use_pattern;
    double[][] XY;
    private String[] tags;

    public ScatterPlot(String n, Color c, boolean[][] _pattern, double[][] _XY) {
        super(n, c);
        XY = _XY;
        use_pattern = true;
        pattern = _pattern;
    }

    public ScatterPlot(String n, Color c, int _type, int _radius, double[][] _XY) {
        super(n, c);
        XY = _XY;
        use_pattern = false;
        type = _type;
        radius = _radius;
    }

    public ScatterPlot(String n, Color c, double[][] _XY) {
        this(n, c, AbstractDrawer.ROUND_DOT, AbstractDrawer.DEFAULT_DOT_RADIUS, _XY);
    }

    public void plot(AbstractDrawer draw, Color c) {
        if (!visible) {
            return;
        }

        draw.setColor(c);
        if (use_pattern) {
            draw.setDotType(AbstractDrawer.PATTERN_DOT);
            draw.setDotPattern(pattern);
        } else {
            draw.setDotRadius(radius);
            if (type == AbstractDrawer.CROSS_DOT) {
                draw.setDotType(AbstractDrawer.CROSS_DOT);
            } else {
                draw.setDotType(AbstractDrawer.ROUND_DOT);
            }
        }

        for (int i = 0; i < XY.length; i++) {
            draw.drawDot(XY[i]);
        }
    }

    public void setDotPattern(int t) {
        type = t;
        use_pattern = false;
    }

    public void setDotPattern(boolean[][] t) {
        use_pattern = true;
        pattern = t;
    }

    @Override
    public void setData(double[][] d) {
        datapanel = null;
        XY = d;
    }

    @Override
    public double[][] getData() {
        return XY;
    }

    @Override
    public double[][] getBounds() {
        return Array.mergeRows(Array.min(XY), Array.max(XY));
    }

    public double[] isSelected(int[] screenCoordTest, AbstractDrawer draw) {
        for (int i = 0; i < XY.length; i++) {
            int[] screenCoord = draw.project(XY[i]);

            if (FastMath.abs(screenCoord[0] - screenCoordTest[0]) < note_precision && FastMath.abs(screenCoord[1] - screenCoordTest[1]) < note_precision) {
                return XY[i];
            }
        }
        return null;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(String[] tags) {
        datapanel = null;
        this.tags = tags;
    }

    @Override
    public void noteCoord(AbstractDrawer draw, double[] coordNoted) {
        if (coordNoted == null) {
            return;
        }

        if (tags == null) {
            super.noteCoord(draw, coordNoted);
        } else {
            draw.setColor(PlotCanvas.NOTE_COLOR);
            for (int i = 0; i < XY.length; i++) {
                if (tags.length > i) {
                    if (Array.equals(XY[i], coordNoted)) {
                        draw.drawShadowedText(tags[i], .5f, coordNoted);
                    }
                }
            }
        }
        //draw.drawCoordinate(coordNoted);
        //draw.drawText(Array.cat(draw.canvas.reverseMapedData(coordNoted)), coordNoted);
    }
}
