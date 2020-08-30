/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plots;

import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author kq
 */
public class DensityLayerPlotTest {

    public static void main(String[] args) {
        Plot2DPanel p2 = new Plot2DPanel();
        for (int i = 0; i < 2; i++) {
            double[][] XYZ = new double[10][2];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] = /*1 + */ Math.random();
                XYZ[j][1] = /*100 * */ 10 * Math.random();
            }

            p2.addScatterPlot("toto" + i, XYZ);
        }
        p2.getPlot(0).addQuantiles(1, new double[]{/*-3,-2,*/-4, -2, -0.5, 0, 0.5, 2, 4 /*,2,3*/});
        p2.getPlot(1).addQuantiles(1, new double[]{-3, -2, -1, 0, 1, 2, 3});
        //p2.getPlot(1).addLayer(new DensityLayerPlot(p2.getPlot(1), 1, new double[] { -.1, 0, .1 }));

        new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
