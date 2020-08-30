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
public class LinePlotTest {

    public static void main(String[] args) {
        Plot2DPanel p2 = new Plot2DPanel();

        double[][] XYZ = new double[100][2];
        for (int j = 0; j < XYZ.length; j++) {
            XYZ[j][0] = 2 * Math.PI * (double) j / XYZ.length;
            XYZ[j][1] = Math.sin(XYZ[j][0]);
        }
        XYZ[50][0] = Double.NaN;
        p2.addLinePlot("sin", XYZ);

        p2.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Plot3DPanel p = new Plot3DPanel();

        XYZ = new double[100][3];
        for (int j = 0; j < XYZ.length; j++) {
            XYZ[j][0] = 2 * Math.PI * (double) j / XYZ.length;
            XYZ[j][1] = Math.sin(XYZ[j][0]);
            XYZ[j][2] = Math.sin(XYZ[j][0]) * Math.cos(XYZ[j][1]);
        }
        p.addLinePlot("toto", XYZ);

        p.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
