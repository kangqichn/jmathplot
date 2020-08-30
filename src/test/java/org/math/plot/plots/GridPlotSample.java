/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot.plots;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static org.math.array.DoubleArray.increment;
import org.math.plot.Plot3DPanel;

/**
 *
 * @author kq
 */
public class GridPlotSample {
    public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//define your data
		double [] x = increment(0.0,0.1,1.0);
		double [] y = increment(0.0,0.05,1.0);
		double[][] z1 = f1(x,y);
		double[][] z2 =f2(x,y);
		
		//create plot
		Plot3DPanel plot = new Plot3DPanel();
		
		//add grid plot to the plotPanel
		plot.addGridPlot("z = cos(PI*x)*sin(PI*y)",x,y,z1);
		plot.addGridPlot("z = sin(PI*x)*cos(PI*y)",x,y,z2);
		
		//put the PlotPanel in JFrame like a JPanel
		JFrame frame = new JFrame("a plot panel");
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setContentPane(plot);
		frame.setVisible(true);
 	}
	public static double f1(double x, double y)
	{
		double z = Math.cos(x*Math.PI)*Math.sin(y*Math.PI);
		return z;
	}//f1
	public static double[][] f1(double[] x, double[] y)
	{
		double[][] z = new double[y.length][x.length];
		for(int i = 0; i < x.length;i++)
		{
			for(int j = 0; j < y.length;j++)
			{
				z[j][i] = f1(x[i],y[j]);
			}
		}
		return z;
		
		
	}//f2
	public static double f2(double x, double y)
	{
		double z = Math.sin(x*Math.PI)*Math.cos(x*Math.PI);
		return z;
	}
	public static double[][] f2(double []x, double []y)
	{
		double [][] z = new double[y.length][x.length];
		for(int i = 0; i < x.length;i++)
		{
			for(int j = 0; j < y.length;j++)
			{
				z[j][i]=f2(x[i],y[j]);
			}
		}
		return z;
				
	}
}
