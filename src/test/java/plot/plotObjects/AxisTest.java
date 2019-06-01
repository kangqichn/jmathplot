/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot.plotObjects;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JFrame;
import org.math.plot.FrameView;
import org.math.plot.Plot3DPanel;

/**
 *
 * @author kq<kangqichn@qq.com>
 */
public class AxisTest {

    /*
	 * MAIN METHOD(for testing)
     */
    public static void main(String[] args) {
        Plot3DPanel p = new Plot3DPanel();
        Object[][] XYZ = new Object[8][3];
        Object[][] XYZ2 = new Object[10][3];

        for (int j = 0; j < XYZ.length; j++) {
            XYZ[j][0] = Math.random();
            XYZ[j][1] = Math.random();
            XYZ[j][2] = "" + ((char) ('a' + j));
        }

        for (int j = 0; j < XYZ2.length; j++) {
            XYZ2[j][0] = Math.random();
            XYZ2[j][1] = Math.random();
            XYZ2[j][2] = "" + ((char) ('a' + j));
        }

        p.addScatterPlot("toto", p.mapData(XYZ));
        p.addScatterPlot("toti", p.mapData(XYZ2));
        p.setAxisScale(1, "log");

        new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HashMap<String, Double> arg = p.getAxis(2).getStringMap();
        Collection<Double> ouch = arg.values();
        Iterator<Double> it = ouch.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
