/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot.plots;

import org.math.plot.FrameView;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author kq<kangqichn@qq.com>
 */
public class HistogramPlot2DTest {

    public static void main(String[] args) {
        double[] X = new double[500];
        for (int i = 0; i < X.length; i++) {
            X[i] = Math.random() + Math.random();
        }
        Plot2DPanel p = new Plot2DPanel("SOUTH");
        p.addHistogramPlot("test", X, 10);
        new FrameView(p);
    }
}
