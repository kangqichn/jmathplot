/*
 * Created on 5 sept. 2005 by richet
 */
package org.math.plot.plotObjects;

import java.awt.*;
import java.io.*;

import org.math.plot.render.*;

public class RasterImage implements Plotable {

    File source;
    Image img;

    double[] xyzSW, xyzSE, xyzNW;

    boolean visible = true;
    float alpha;

    public RasterImage(File _source, float _alpha, double[] _xyzSW, double[] _xyzSE, double[] _xyzNW) {
        source = _source;
        img = Toolkit.getDefaultToolkit().getImage(source.getPath());
        xyzSW = _xyzSW;
        xyzSE = _xyzSE;
        xyzNW = _xyzNW;
        alpha = _alpha;
    }

    public void plot(AbstractDrawer draw) {
        if (!visible) {
            return;
        }

        draw.drawImage(img, alpha, xyzSW, xyzSE, xyzNW);
    }

    public void setVisible(boolean v) {
        visible = v;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setColor(Color c) {
        throw new IllegalArgumentException("method not available for this Object: PlotImage");
    }

    public Color getColor() {
        return null;
    }

}
