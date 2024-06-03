package com.dh21022839.DDS_A2_M2.util;

import com.dh21022839.DDS_A2_M2.mapping.Node;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class utilities
{
    public static Double getEdgeValue(Node node1, Node node2)
    {
        // return hypotenuse value for edge using pythagoras
        double n1x = node1.getCoordinateX();
        double n1y = node1.getCoordinateY();
        double n2x = node2.getCoordinateX();
        double n2y = node2.getCoordinateY();
        double edgeValue = Math.sqrt(Math.pow((n1x-n2x), 2) + Math.pow((n1y-n2y), 2));

        // round to 1 dp and return
        BigDecimal bd = new BigDecimal(edgeValue).setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();

    }

}
