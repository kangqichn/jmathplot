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
public class CloudPlot3DTest {

    public static void main(String[] args) {
        Plot3DPanel p = new Plot3DPanel();

        //triangular random cloud (as sum of two uniform random numbers)
        double[][] cloud = new double[100][3];
        for (int i = 0; i < cloud.length; i++) {
            cloud[i][0] = Math.random() + Math.random();
            cloud[i][1] = Math.random() + Math.random();
            cloud[i][2] = Math.random() + Math.random();
        }
        p.addCloudPlot("cloud", Color.RED, cloud, 3, 3, 3);

        double[][] cloud2 = new double[100][3];
        for (int i = 0; i < cloud.length; i++) {
            cloud2[i][0] = 2 + Math.random() + Math.random();
            cloud2[i][1] = 2 + Math.random() + Math.random();
            cloud2[i][2] = 2 + Math.random() + Math.random();
        }
        p.addCloudPlot("cloud2", Color.RED, cloud2, 3, 3, 3);

        p.setLegendOrientation(PlotPanel.SOUTH);
        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
