/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot.plots;

import org.math.plot.FrameView;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author kq<kangqichn@qq.com>
 */
public class GridPlot3DTest {

    public static void main(String[] args) {

        int n = 14;
        int m = 16;
        Plot3DPanel p = new Plot3DPanel();
        double[] X = new double[n];
        double[] Y = new double[m];
        double[][] Z = new double[m][n];

        for (int i = 0; i < X.length; i++) {
            X[i] = 3 + i / (double) X.length;
            for (int j = 0; j < Y.length; j++) {
                Y[j] = 5 + j / (double) Y.length;
                Z[j][i] = Math.exp(X[i]) + Y[j];
            }
        }
        p.addGridPlot("toto", X, Y, Z);

        p.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p);
    }
}
