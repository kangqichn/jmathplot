/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plots;

import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author kq
 */
public class BarPlotTest {

    public static void main(String[] args) {
        Plot2DPanel p2 = new Plot2DPanel();
        for (int i = 0; i < 3; i++) {
            double[][] XYZ = new double[10][2];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] = /*1 + */ Math.random();
                XYZ[j][1] = /*100 * */ Math.random();
            }
            p2.addBarPlot("toto" + i, XYZ);
        }

        p2.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Plot3DPanel p = new Plot3DPanel();
        for (int i = 0; i < 3; i++) {
            double[][] XYZ = new double[10][3];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] = /*1 +*/ Math.random();
                XYZ[j][1] = /*100 **/ Math.random();
                XYZ[j][2] = /*0.0001 **/ Math.random();
            }
            p.addBarPlot("toto" + i, XYZ);
        }

        p.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
