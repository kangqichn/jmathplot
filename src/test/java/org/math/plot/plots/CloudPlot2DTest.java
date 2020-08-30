/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plots;

import java.awt.Color;
import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot2DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author kq
 */
public class CloudPlot2DTest {

    public static void main(String[] args) {
        Plot2DPanel p = new Plot2DPanel();

        double[][] cloud = new double[100][2];
        for (int i = 0; i < cloud.length; i++) {
            cloud[i][0] = Math.random() + Math.random();
            cloud[i][1] = Math.random() + Math.random();
        }
        p.addCloudPlot("cloud", Color.RED, cloud, 5, 5);

        double[][] cloud2 = new double[100][2];
        for (int i = 0; i < cloud2.length; i++) {
            cloud2[i][0] = 2 + Math.random() + Math.random();
            cloud2[i][1] = 2 + Math.random() + Math.random();
        }
        p.addCloudPlot("cloud2", Color.RED, cloud2, 5, 5);

        p.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
