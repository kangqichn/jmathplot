/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plotObjects;

import java.awt.Color;
import org.math.plot.FrameView;
import org.math.plot.canvas.Plot3DCanvas;
import org.math.plot.plotObjects.BaseLabel;

/**
 *
 * @author kq
 */
public class BaseLabelTest {

    /*
	 * public void resetBase() { System.out.println("BaseLabel.resetBase"); }
     */
    public static void main(String[] args) {
        Plot3DCanvas p3d = new Plot3DCanvas(
                new double[]{0, 0, 0},
                new double[]{10, 10, 10},
                new String[]{"lin", "lin", "lin"},
                new String[]{"x", "y", "z"});
        new FrameView(p3d);
        // p3d.addPlot(DoubleArray.random(10, 3), "plot", "SCATTER");
        p3d.addPlotable(new BaseLabel("label", Color.RED, new double[]{-0.1, 0.5, 0.5}));
    }

}
