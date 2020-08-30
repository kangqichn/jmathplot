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
public class VectorLayerPlotTest {

    public static void main(String[] args) {
        Plot2DPanel p2 = new Plot2DPanel();
        double[][] XYZ = new double[100][2];
        double[][] dXYZ = new double[100][2];

        for (int j = 0; j < XYZ.length; j++) {
            XYZ[j][0] = Math.random() * 10;
            XYZ[j][1] = Math.random() * 10;
            dXYZ[j][0] = 1.0 / Math.sqrt(1 + Math.log(XYZ[j][0]) * Math.log(XYZ[j][0]));
            dXYZ[j][1] = Math.log(XYZ[j][0]) / Math.sqrt(1 + Math.log(XYZ[j][0]) * Math.log(XYZ[j][0]));
        }
        p2.addScatterPlot("toto", XYZ);

        p2.addVectortoPlot(0, dXYZ);
        new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
