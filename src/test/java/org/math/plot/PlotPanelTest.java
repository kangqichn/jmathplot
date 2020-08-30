/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.math.plot;

import java.io.File;
import javax.swing.JFrame;
import org.math.io.files.ASCIIFile;
import static org.math.plot.PlotPanel.SCATTER;
import org.math.plot.utils.Array;

/**
 *
 * @author kq
 */
public class PlotPanelTest {

    public static void main(String[] args) {
        String man = "Usage: jplot.<sh|bat> <-2D|-3D> [-l <INVISIBLE|NORTH|SOUTH|EAST|WEST>] [options] <ASCII file (n rows, m columns)> [[options] other ASCII file]\n" + "[-l <INVISIBLE|NORTH|SOUTH|EAST|WEST>] giving the legend position\n" + "[options] are:\n" + "  -t <SCATTER|LINE|BAR|HISTOGRAM2D(<integer h>)|HISTOGRAM3D(<integer h>,<integer k>)|GRID3D|CLOUD2D(<integer h>,<integer k>)|CLOUD3D(<integer h>,<integer k>,<integer l>)>    type of the plot\n" + "      SCATTER|LINE|BAR: each line of the ASCII file contains coordinates of one point.\n" + "      HISTOGRAM2D(<integer h>): ASCII file contains the 1D sample (i.e. m=1) to split in h slices.\n" + "      HISTOGRAM3D(<integer h>,<integer k>): ASCII file contains the 2D sample (i.e. m=2) to split in h*k slices (h slices on X axis and k slices on Y axis).\n" + "      GRID3D: ASCII file is a matrix, first row gives n X grid values, first column gives m Y grid values, other values are Z values.\n" + "      CLOUD2D(<integer h>,<integer k>): ASCII file contains the 2D sample (i.e. m=2) to split in h*k slices (h slices on X axis and k slices on Y axis), density of cloud corresponds to frequency of X-Y slice in given 2D sample.\n" + "      CLOUD3D(<integer h>,<integer k>,<integer l>): ASCII file contains the 3D sample (i.e. m=3) to split in h*k*l slices (h slices on X axis, k slices on Y axis, l slices on Y axis), density of cloud corresponds to frequency of X-Y-Z slice in given 3D sample.\n" + "  -n name    name of the plot\n" + "  -v <ASCII file (n,3|2)>    vector data to add to the plot\n" + "  -q<X|Y|Z>(<float Q>) <ASCII file (n,1)>    Q-quantile to add to the plot on <X|Y|Z> axis. Each line of the given ASCII file contains the value of quantile for probvability Q.\n" + "  -qP<X|Y|Z> <ASCII file (n,p)>    p-quantiles density to add to the plot on <X|Y|Z> axis. Each line of the given ASCII file contains p values.\n" + "  -qN<X|Y|Z> <ASCII file (n,1)>    Gaussian density to add to the plot on <X|Y|Z> axis. Each line of the given ASCII file contains a standard deviation.";

        if (args.length == 0) {
            double[][] data = new double[20][];
            for (int i = 0; i < data.length; i++) {
                data[i] = new double[]{Math.random(), Math.random(), Math.random()};
            }
            ASCIIFile.writeDoubleArray(new File("tmp.dat"), data);

            args = new String[]{"-3D", "-l", "SOUTH", "-t", "SCATTER", "tmp.dat"};
            System.out.println(man);
            System.out.println("\nExample: jplot.<sh|bat> " + Array.cat(args));
        }

        PlotPanel p = null;
        if (args[0].equals("-2D")) {
            p = new Plot2DPanel();
        } else if (args[0].equals("-3D")) {
            p = new Plot3DPanel();
        } else {
            System.out.println(man);
        }

        try {

            String leg = "INVISIBLE";
            String type = SCATTER;
            String name = "";

            double[][] v = null;

            double[] qX = null;
            double[] qY = null;
            double[] qZ = null;
            double qXp = 0;
            double qYp = 0;
            double qZp = 0;

            double[][] qPX = null;
            double[][] qPY = null;
            double[][] qPZ = null;

            double[] qNX = null;
            double[] qNY = null;
            double[] qNZ = null;

            for (int i = 1; i < args.length; i++) {
                //System.out.println("<" + args[i] + ">");
                if (args[i].equals("-l")) {
                    leg = args[i + 1];
                    i++;
                } else if (args[i].equals("-t")) {
                    type = args[i + 1];
                    i++;
                } else if (args[i].equals("-n")) {
                    name = args[i + 1];
                    i++;
                } else if (args[i].equals("-v")) {
                    v = ASCIIFile.readDoubleArray(new File(args[i + 1]));
                    i++;
                } else if (args[i].startsWith("-qX(")) {
                    qX = ASCIIFile.readDouble1DArray(new File(args[i + 1]));
                    qXp = Double.parseDouble(args[i].substring(4, args[i].length() - 1));
                    i++;
                } else if (args[i].startsWith("-qY(")) {
                    qY = ASCIIFile.readDouble1DArray(new File(args[i + 1]));
                    qYp = Double.parseDouble(args[i].substring(4, args[i].length() - 1));
                    i++;
                } else if (args[i].startsWith("-qZ(")) {
                    qZ = ASCIIFile.readDouble1DArray(new File(args[i + 1]));
                    qZp = Double.parseDouble(args[i].substring(4, args[i].length() - 1));
                    i++;
                } else if (args[i].equals("-qPX")) {
                    qPX = ASCIIFile.readDoubleArray(new File(args[i + 1]));
                    i++;
                } else if (args[i].equals("-qPY")) {
                    qPY = ASCIIFile.readDoubleArray(new File(args[i + 1]));
                    i++;
                } else if (args[i].equals("-qPZ")) {
                    qPZ = ASCIIFile.readDoubleArray(new File(args[i + 1]));
                    i++;
                } else if (args[i].equals("-qNX")) {
                    qNX = ASCIIFile.readDouble1DArray(new File(args[i + 1]));
                    i++;
                } else if (args[i].equals("-qNY")) {
                    qNY = ASCIIFile.readDouble1DArray(new File(args[i + 1]));
                    i++;
                } else if (args[i].equals("-qNZ")) {
                    qNZ = ASCIIFile.readDouble1DArray(new File(args[i + 1]));
                    i++;
                } else {
                    File input_file = new File(args[i]);
                    int n = 0;
                    if (input_file.exists()) {
                        if (name.length() == 0) {
                            name = input_file.getName();
                        }

                        if (p instanceof Plot2DPanel) {
                            Plot2DPanel p2d = (Plot2DPanel) p;
                            if (type.equals("SCATTER")) {
                                n = p2d.addScatterPlot(name, ASCIIFile.readDoubleArray(input_file));
                            } else if (type.equals("LINE")) {
                                n = p2d.addLinePlot(name, ASCIIFile.readDoubleArray(input_file));
                            } else if (type.equals("BAR")) {
                                n = p2d.addBarPlot(name, ASCIIFile.readDoubleArray(input_file));
                            } else if (type.startsWith("HISTOGRAM2D(")) {
                                n = p2d.addHistogramPlot(name, ASCIIFile.readDouble1DArray(input_file), Integer.parseInt(type.substring(12, type.length() - 1)));
                            } else if (type.startsWith("CLOUD2D(")) {
                                n = p2d.addCloudPlot(name, ASCIIFile.readDoubleArray(input_file), Integer.parseInt(type.substring(8, type.indexOf(","))),
                                        Integer.parseInt(type.substring(type.indexOf(",") + 1, type.length() - 1)));
                            } else {
                                p2d.addPlot(type, name, ASCIIFile.readDoubleArray(input_file));
                            }
                        } else {
                            Plot3DPanel p3d = (Plot3DPanel) p;
                            if (type.equals("SCATTER")) {
                                n = p3d.addScatterPlot(name, ASCIIFile.readDoubleArray(input_file));
                            } else if (type.equals("LINE")) {
                                n = p3d.addLinePlot(name, ASCIIFile.readDoubleArray(input_file));
                            } else if (type.equals("BAR")) {
                                n = p3d.addBarPlot(name, ASCIIFile.readDoubleArray(input_file));
                            } else if (type.startsWith("HISTOGRAM3D(")) {
                                n = p3d.addHistogramPlot(name, ASCIIFile.readDoubleArray(input_file), Integer.parseInt(type.substring(12, type.indexOf(","))),
                                        Integer.parseInt(type.substring(type.indexOf(",") + 1, type.length() - 1)));
                            } else if (type.equals("GRID3D")) {
                                n = p3d.addGridPlot(name, ASCIIFile.readDoubleArray(input_file));
                            } else if (type.startsWith("CLOUD3D(")) {
                                n = p3d.addCloudPlot(name, ASCIIFile.readDoubleArray(input_file), Integer.parseInt(type.substring(8, type.indexOf(","))),
                                        Integer.parseInt(type.substring(type.indexOf(",") + 1, type.indexOf(",", type.indexOf(",") + 1))), Integer.parseInt(type.substring(type.indexOf(",", type.indexOf(",") + 1) + 1, type.length() - 1)));
                            } else {
                                p3d.addPlot(type, name, ASCIIFile.readDoubleArray(input_file));
                            }
                        }

                        if (v != null) {
                            p.addVectortoPlot(n, v);
                        }

                        if (qX != null) {
                            p.addQuantiletoPlot(n, 0, qXp, false, qX);
                        }
                        if (qY != null) {
                            p.addQuantiletoPlot(n, 1, qYp, false, qY);
                        }
                        if (qZ != null) {
                            p.addQuantiletoPlot(n, 2, qZp, false, qZ);
                        }

                        if (qPX != null) {
                            p.addQuantilestoPlot(n, 0, qPX);
                        }
                        if (qPY != null) {
                            p.addQuantilestoPlot(n, 1, qPY);
                        }
                        if (qPZ != null) {
                            p.addQuantilestoPlot(n, 2, qPZ);
                        }

                        if (qNX != null) {
                            p.addGaussQuantilestoPlot(n, 0, qNX);
                        }
                        if (qNY != null) {
                            p.addGaussQuantilestoPlot(n, 1, qNY);
                        }
                        if (qNZ != null) {
                            p.addGaussQuantilestoPlot(n, 2, qNZ);
                        }

                        type = "SCATTER";
                        leg = "SOUTH";
                        name = "";
                        qX = null;
                        qY = null;
                        qZ = null;
                        qXp = 0;
                        qYp = 0;
                        qZp = 0;

                        v = null;

                        qPX = null;
                        qPY = null;
                        qPZ = null;

                        qNX = null;
                        qNY = null;
                        qNZ = null;

                    } else {
                        System.out.println("File " + args[i] + " unknown.");
                        System.out.println(man);
                    }
                }
            }
            p.setLegendOrientation(leg);
            FrameView f = new FrameView(p);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\n" + man);
        }
    }
}
