/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot.plots;

import java.awt.Color;
import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author kq<kangqichn@qq.com>
 */
public class BoxPlot3DTest {

    public static void main(String[] args) {
        Plot3DPanel plotpanel = new Plot3DPanel();
        for (int i = 0; i < 1; i++) {
            double[][] receiverXYZ = new double[100][6];
            for (int j = 0; j < receiverXYZ.length; j++) {
                receiverXYZ[j][0] = /*1 + */ Math.random();
                receiverXYZ[j][1] = /*100 * */ Math.random();
                receiverXYZ[j][2] = /*100 * */ Math.random();
                receiverXYZ[j][3] = /*1 + */ Math.random() / 10;
                receiverXYZ[j][4] = /*100 * */ Math.random() / 10;
                receiverXYZ[j][5] = /*100 * */ Math.random() / 10;
            }
            int receiverPlotDataIndex = plotpanel.addBoxPlot("Receivers", Color.orange, receiverXYZ);
        }

        plotpanel.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(plotpanel).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
