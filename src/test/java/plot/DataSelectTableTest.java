/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plot;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.math.plot.DataSelectTable;
import org.math.plot.FrameView;
import org.math.plot.Plot3DPanel;
import org.math.plot.PlotPanel;

/**
 *
 * @author kq<kangqichn@qq.com>
 */
public class DataSelectTableTest {

    public static void main(String[] args) {
        final PlotPanel pp = new Plot3DPanel(PlotPanel.WEST);
        pp.setPreferredSize(new Dimension(400, 400));
        new FrameView(pp).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] data = {{0, 0, 0, 0, "a0"}, {1, 1, 1, 1, "a1"}, {2, 2, 2, 2, "a2"}, {3, 3, 3, 3, "a3"}, {4, 3, 3, 3, "a3"}, {5, 3, 3, 3, "a4"}};

        DataSelectTable dsp = new DataSelectTable(data, 3, "x1", "x2", "x3", "x4", "x5") {
            @Override
            public void fireSelectedDataChanged(String from) {
                super.fireSelectedDataChanged(from);
                pp.setAxisLabel(0, getSelectedXAxis());
                pp.setAxisLabel(1, getSelectedYAxis());
                pp.setAxisLabel(2, getSelectedZAxis());

                if (pp.getPlots().size() == 0) {
                    pp.addPlot("SCATTER", "data", pp.mapData(getSelectedProjectedData()));
                } else {
                    if (from.endsWith("axis")) {
                        pp.resetMapData();
                        pp.removeAllPlots();
                        pp.addPlot("SCATTER", "data", pp.mapData(getSelectedProjectedData()));
                    } else {
                        pp.getPlot(0).setData(pp.mapData(getSelectedProjectedData()));
                    }
                }
                //System.out.println(Array.cat(pp.getAxesScales()));
            }
        };
        new FrameView(dsp).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Object[][] data2 = { { 0, 0, 0, 0, "a0" }, { 1, 1, 1, 1, "a1" }, { 2, 2, 2, 2, "a2" }, { 3, 3, 3, 3, "a3" }, { 4, 3, 3, 3, "a3" },
				{ 5, 3, 3, 3, "a4" }, { 5, 4, 3, 3, "a4" } };
		dsp.setData(data2);*/
    }
}
