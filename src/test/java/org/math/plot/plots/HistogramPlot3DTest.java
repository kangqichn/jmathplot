/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plots;

import org.math.plot.FrameView;
import org.math.plot.Plot3DPanel;

/**
 *
 * @author kq
 */
public class HistogramPlot3DTest {

    public static void main(String[] args) {
        double[][] XY = new double[500][2];
        for (int i = 0; i < XY.length; i++) {
            XY[i][0] = Math.random() + Math.random();
            XY[i][1] = Math.random() + Math.random();
        }
        Plot3DPanel p = new Plot3DPanel("SOUTH");
        p.addHistogramPlot("test", XY, 4, 6);
        new FrameView(p);
    }
}
