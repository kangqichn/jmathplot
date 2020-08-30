package org.math.plot.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.math.array.DoubleArray;

/**
 * BSD License
 *
 * @author Yann RICHET
 */
public class Array {

    public static HashMap<Double, String> reverseStringMap(HashMap<String, Double> map) {
        if (map == null) {
            return null;
        }
        HashMap<Double, String> reverseMap = new HashMap<Double, String>();
        for (String key : map.keySet()) {
            reverseMap.put(map.get(key), key);
        }
        return reverseMap;
    }

    public static HashMap<String, Double> mapStringArray(double minvalue, double step, List<String> array) {
        if (array == null) {
            return null;
        }
        Collections.sort(array);
        HashMap<String, Double> map = new HashMap<String, Double>(array.size());
        double v = minvalue;
        for (String string : array) {
            if (!map.containsKey(string)) {
                map.put(string, v);
                v += step;
            }
        }
        return map;
    }

    public static String toString(HashMap hash) {
        StringBuffer sb = new StringBuffer();
        for (Object key : hash.keySet()) {
            sb.append(key + " > " + hash.get(key) + "\n");
        }
        return sb.toString();
    }

    public static HashMap<String, Double> mapStringArray(List<String> array) {
        return mapStringArray(0, 1, array);
    }

    // Create methods
    public static String cat(Object[] array) {
        return DoubleArray.toString("%s", array);
    }

    public static String cat(Object[][] array) {
        return DoubleArray.toString("%s", array);
    }

    public static String[] duplicate(int m, String c) {
        String[] o = new String[m];
        for (int i = 0; i < m; i++) {
            o[i] = c;
        }
        return o;
    }

    public static int[] duplicate(int m, int c) {
        int[] o = new int[m];
        for (int i = 0; i < m; i++) {
            o[i] = c;
        }
        return o;
    }

    public static double[][] one(int m, int n) {
        return DoubleArray.ones(m, n);
    }

    public static double[] one(int m) {
        return DoubleArray.ones(m);
    }

    // Modify rows & colmumns methods
    public static double[][] insertColumns(double[][] x, double[][] y, int J) {
        double[][] array = new double[x.length][x[0].length + y[0].length];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(x[i], 0, array[i], 0, J);
            System.arraycopy(y[i], 0, array[i], J, y[i].length);
            System.arraycopy(x[i], J, array[i], J + y[i].length, x[i].length - J);
        }
        return array;
    }

    public static double[][] insertColumn(double[][] x, double[] y, int J) {
        double[][] array = new double[x.length][x[0].length + 1];
        for (int i = 0; i < array.length; i++) {
            System.arraycopy(x[i], 0, array[i], 0, J);
            array[i][J] = y[i];
            System.arraycopy(x[i], J, array[i], J + 1, x[i].length - J);
        }
        return array;
    }

    public static double[] min(double[][] M) {
        double[] min = new double[M[0].length];
        for (int j = 0; j < min.length; j++) {
            min[j] = M[0][j];
            for (int i = 1; i < M.length; i++) {
                if (!Double.isNaN(M[i][j])) {
                    min[j] = FastMath.min(min[j], M[i][j]);
                }
            }
        }
        return min;
    }

    public static int min(int... M) {
        int min = M[0];
        for (int i = 1; i < M.length; i++) {
            min = FastMath.min(min, M[i]);
        }
        return min;
    }

    public static int max(int... M) {
        int max = M[0];
        for (int i = 1; i < M.length; i++) {
            max = FastMath.max(max, M[i]);
        }
        return max;
    }

    public static double min(double... M) {
        double min = M[0];
        for (int i = 1; i < M.length; i++) {
            if (!Double.isNaN(M[i])) {
                min = FastMath.min(min, M[i]);
            }
        }
        return min;
    }

    public static double[] max(double[][] M) {
        double[] max = new double[M[0].length];
        for (int j = 0; j < max.length; j++) {
            max[j] = M[0][j];
            for (int i = 1; i < M.length; i++) {
                if (!Double.isNaN(M[i][j])) {
                    max[j] = FastMath.max(max[j], M[i][j]);
                }
            }
        }
        return max;
    }

    public static double max(double... M) {
        double max = M[0];
        for (int i = 1; i < M.length; i++) {
            if (!Double.isNaN(M[i])) {
                max = FastMath.max(max, M[i]);
            }
        }
        return max;
    }

}
