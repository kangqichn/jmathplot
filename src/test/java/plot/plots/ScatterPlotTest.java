/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot.plots;

import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot2DPanel;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;
import org.math.plot.plots.ScatterPlot;

/**
 *
 * @author kq<kangqichn@qq.com>
 */
public class ScatterPlotTest {

    public static void main(String[] args) {
        Plot2DPanel p2 = new Plot2DPanel();
        for (int i = 0; i < 3; i++) {
            double[][] XYZ = new double[10][2];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] = /*1 + */ Math.random();
                XYZ[j][1] = /*100 * */ Math.random();
            }
            p2.addScatterPlot("toto" + i, XYZ);
        }

        p2.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Plot3DPanel p = new Plot3DPanel();
        String[] tags = null;
        for (int i = 0; i < 3; i++) {
            double[][] XYZ = new double[10][3];
            tags = new String[10];
            for (int j = 0; j < XYZ.length; j++) {
                XYZ[j][0] = /*1 +*/ 2.5 * Math.random();
                XYZ[j][1] = /*100 **/ Math.random();
                XYZ[j][2] = /*0.0001 **/ Math.random();
                tags[j] = "tags " + j;
            }
            p.addScatterPlot("toto" + i, XYZ);
        }
        ((ScatterPlot) p.getPlot(0)).setTags(tags);

        p.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
