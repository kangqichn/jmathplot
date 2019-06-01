package org.math.plot.plots;

import java.awt.*;

import org.math.plot.render.*;
import org.math.plot.utils.*;

/**
 * @author Yann RICHET
 * @version 1.0
 */
/**
 * Layer to add a vector field to an existing Plot
 */
public class VectorLayerPlot extends LayerPlot {

    public static int RADIUS = 5;

    double[][] V;

    /**
     * Create a vector fiels based on data of a plot
     *
     * @param p Base plot to support vector field
     * @param v Vector field of same lenght that p data
     */
    public VectorLayerPlot(Plot p, double[][] v) {
        super("Vector of " + p.name, p);
        if (v != null) {
            Array.checkRowDimension(v, p.getData().length);
            Array.checkColumnDimension(v, p.getData()[0].length);
        }
        V = v;

    }

    @Override
    public void setData(double[][] v) {
        V = v;
    }

    @Override
    public double[][] getData() {
        return V;
    }

    public void plot(AbstractDrawer draw, Color c) {
        if (!plot.visible) {
            return;
        }

        draw.setColor(c);

        draw.setLineType(AbstractDrawer.CONTINOUS_LINE);

        for (int i = 0; i < plot.getData().length; i++) {
            double[] d = Array.getRowCopy(plot.getData(), i);
            for (int j = 0; j < d.length; j++) {
                d[j] += V[i][j];
            }
            draw.drawLine(plot.getData()[i], d);
            //TODO: draw arrow at position d

        }

    }

}
