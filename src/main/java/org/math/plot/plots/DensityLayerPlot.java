package org.math.plot.plots;

import java.awt.Color;
import org.math.array.DoubleArray;
import static org.math.array.DoubleArray.getRowCopy;
import org.math.plot.render.AbstractDrawer;

/**
 * @author Yann RICHET
 */
public class DensityLayerPlot extends LayerPlot {

    public static int WIDTH = 2;

    int axis;

    double[] constant_Q;

    double[][] Q;

    public DensityLayerPlot(Plot p, int a, double[] quantiles) {
        this(p, a, new double[0][0]);
        constant_Q = quantiles;
    }

    /**
     * Build a quantile plot based on given plot. The quantile is drawn as a
     * linear gradient from the base plot dots.
     *
     * @param p base plot
     * @param a axis number of quantile : 0=X quantile, 1=Y quantile, 2=Z
     * quantile
     * @param quantiles array of standard deviation values
     */
    public DensityLayerPlot(Plot p, int a, double[][] quantiles) {
        super("Density of " + p.name, p);
        if (quantiles != null && quantiles.length > 0) {
            DoubleArray.checkRowDimension(quantiles, p.getData().length);
        }
        Q = quantiles;
        axis = a;
    }

    public int getAxe() {
        return axis;
    }

    public void plot(AbstractDrawer draw, Color c) {
        if (!plot.visible) {
            return;
        }

        draw.setColor(c);

        draw.setLineType(AbstractDrawer.CONTINOUS_LINE);
        draw.setLineWidth(WIDTH);
        if (constant_Q == null) {
            for (int i = 0; i < plot.getData().length; i++) {

                double norm = Double.MAX_VALUE;
                for (int j = 0; j < Q[i].length - 1; j++) {
                    norm = Math.min(1 / (Q[i][j + 1] - Q[i][j]), norm);
                }

                double[] d0 = getRowCopy(plot.getData(), i);
                double[] d1 = getRowCopy(plot.getData(), i);
                double[] d2 = getRowCopy(plot.getData(), i);

                for (int j = 0; j < Q[i].length - 2; j++) {
                    d1[axis] = d0[axis] + ((Q[i][j] + Q[i][j + 1]) / 2);
                    d2[axis] = d0[axis] + ((Q[i][j + 1] + Q[i][j + 2]) / 2);
                    Color c1 = new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (255.0 * (norm / (Q[i][j + 1] - Q[i][j]))));
                    Color c2 = new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (255.0 * (norm / (Q[i][j + 2] - Q[i][j + 1]))));
                    draw.setGradient(d1, c1, d2, c2);
                    draw.drawLine(d1, d2);
                }
            }
        } else {

            double norm = Double.MAX_VALUE;
            for (int j = 0; j < constant_Q.length - 1; j++) {
                norm = Math.min(1 / (constant_Q[j + 1] - constant_Q[j]), norm);
            }

            for (int i = 0; i < plot.getData().length; i++) {
                double[] d0 = getRowCopy(plot.getData(), i);
                double[] d1 = getRowCopy(plot.getData(), i);
                double[] d2 = getRowCopy(plot.getData(), i);

                for (int j = 0; j < constant_Q.length - 2; j++) {
                    d1[axis] = d0[axis] + (constant_Q[j] + constant_Q[j + 1]) / 2;
                    d2[axis] = d0[axis] + (constant_Q[j + 1] + constant_Q[j + 2]) / 2;
                    Color c1 = new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (255.0 * (norm / (constant_Q[j + 1] - constant_Q[j]))));
                    Color c2 = new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (255.0 * (norm / (constant_Q[j + 2] - constant_Q[j + 1]))));
                    draw.setGradient(d1, c1, d2, c2);
                    draw.drawLine(d1, d2);
                }
            }
        }
        draw.resetGradient();
        draw.setLineWidth(AbstractDrawer.DEFAULT_LINE_WIDTH);

    }

    @Override
    public void setData(double[][] d) {
        //Q = d[0];
    }

    @Override
    public double[][] getData() {
        return null;//new double[][] { sigma };
    }

}
