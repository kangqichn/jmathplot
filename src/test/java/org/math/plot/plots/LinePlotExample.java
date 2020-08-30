/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plots;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author kq
 */
public class LinePlotExample {

    public static void main(String[] args) {
        double[] x = {1, 2, 3, 4, 5, 6};
        double[] y = {45, 89, 6, 32, 63, 12};
        //create your plotPanel
        Plot2DPanel plot = new Plot2DPanel();

        //def the legend position
        plot.addLegend("SOUTH");
        //add a line plot to the PlotPanel
        plot.addLinePlot("my plot", x, y);

        //put the plot panel in JFrame like a Jpanel
        JFrame frame = new JFrame("a plot panel");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
}
