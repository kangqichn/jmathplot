package org.math.plot.plotObjects;

import java.awt.*;
import org.math.plot.render.*;

/**
 * BSD License
 *
 * @author Yann RICHET
 */
public class BaseLabel extends Label /* implements BaseDependant */ {

    public BaseLabel(String l, Color c, double... rC) {
        super(l, c, rC);
    }

    @Override
    public void plot(AbstractDrawer draw) {
        draw.setColor(color);
        draw.setFont(font);
        draw.setTextAngle(angle);
        draw.setTextOffset(cornerE, cornerN);
        draw.drawTextBase(label, coord);
    }

}
