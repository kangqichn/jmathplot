/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plotObjects;

import java.awt.Dimension;
import java.io.File;
import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;
import org.math.plot.plotObjects.RasterImage;

/**
 *
 * @author kq
 */
public class RasterImageTest {

    public static void main(String[] args) {
        Plot2DPanel p2 = new Plot2DPanel();
        for (int i = 0; i < 1; i++) {
            double[][] XYZ = new double[10][2];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] =/*1 + */ Math.random();
                XYZ[j][1] = /*100 * */ Math.random();
            }
            p2.addScatterPlot("toto" + i, XYZ);
        }

        p2.addPlotable(new RasterImage(new File("test.gif"), 0.8f, new double[]{0.2, 0.5}, new double[]{1.2, 0.8}, new double[]{0.2, 1.1}));

        p2.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Plot3DPanel p = new Plot3DPanel();
        for (int i = 0; i < 1; i++) {
            double[][] XYZ = new double[10][3];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] = /*1 +*/ Math.random();
                XYZ[j][1] = /*100 **/ Math.random();
                XYZ[j][2] = /*0.0001 **/ Math.random();
            }
            p.addScatterPlot("toto" + i, XYZ);
        }

        p.addPlotable(new RasterImage(new File("test.gif"), 0.5f, new double[]{0.0, 0.0, 0.0}, new double[]{1, 0, 0.0}, new double[]{0.0, 0, 1}));
        p.addPlotable(new RasterImage(new File("test.gif"), 0.5f, new double[]{0.0, 0.0, 0.0}, new double[]{0, 1, 0.0}, new double[]{0, 0.0, 1}));
        p.addPlotable(new RasterImage(new File("test.gif"), 0.5f, new double[]{0.0, 0.0, 0.0}, new double[]{1, 0, 0}, new double[]{0, 1, 0}));
        // TODO this following case is not totally supported...
        //p.addPlotable(new PlotImage(new File("test.jpg"),0.5f,  new double[] {1,0,0},new double[] {1,1,0},new double[] {0,0,1}));

        p.setLegendOrientation(PlotPanel.SOUTH);
        p.setPreferredSize(new Dimension(600, 600));
        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
