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
public class StaircasePlotTest {

    public static void main(String[] args) {
        Plot2DPanel p = new Plot2DPanel();

        double[] X = new double[10];
        double[] Y = new double[10];
        for (int j = 0; j < X.length; j++) {
            X[j] = j;
            Y[j] = Math.random();
        }
        p.addStaircasePlot("toto", X, Y);

        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
