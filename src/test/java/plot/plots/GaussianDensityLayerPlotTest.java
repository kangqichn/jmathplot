/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot.plots;

import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author kq<kangqichn@qq.com>
 */
public class GaussianDensityLayerPlotTest {

    public static void main(String[] args) {
        double[] sXYZ = null;

        Plot2DPanel p2 = new Plot2DPanel();
        for (int i = 0; i < 2; i++) {
            double[][] XYZ = new double[10][2];
            sXYZ = new double[10];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] = /*1 + */ Math.random();
                XYZ[j][1] = /*100 * */ Math.random();
                sXYZ[j] = /*100 * */ Math.random();
            }

            p2.addScatterPlot("toto" + i, XYZ);
        }
        p2.getPlot(0).addGaussQuantiles(0, sXYZ);
        p2.getPlot(1).addGaussQuantiles(1, 0.1);

        new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
