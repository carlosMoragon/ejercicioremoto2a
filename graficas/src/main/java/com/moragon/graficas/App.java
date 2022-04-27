package com.moragon.graficas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) throws Exception {
        DefaultXYDataset dataset = new DefaultXYDataset();
        //Una serie por cada metodo de ordenacion
        dataset.addSeries("burbuja", new double[][]{{10, 100, 1000, 10000, 100000}, {5100, 341800, 2908900, 37671000/*, 3818753100.00*/}});
        dataset.addSeries("MergeSort", new double[][]{{10, 100, 1000, 10000, 100000}, {8900, 166700, 1350100, 136244000/*, 5846967000.00*/}});
        dataset.addSeries("Seleccion Directa", new double[][]{{10, 100, 1000, 10000, 100000}, {4200, 244300, 8973200, 40758100/*, 2694775700.00*/}});
        dataset.addSeries("Insercion Directa", new double[][]{{10, 100, 1000, 10000, 100000}, {4000, 245200, 4040300, 35845300/*, 2446415100.00*/}});
        dataset.addSeries("QuickSort", new double[][]{{10, 100, 1000, 10000}, {4800, 294300, 5016100, 29275300}});
        //dataset.addSeries("busqueda Lineal", new double[][] {{10, 100, 1000, 10000, 100000 }, {82200,16600,146000,417600,1555000}});
        //dataset.addSeries("Busqueda Binaria", new double[][] {{ 10, 100, 1000, 10000,

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.RED);
        renderer.setSeriesPaint(3, Color.BLACK);
        renderer.setSeriesPaint(4, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        renderer.setSeriesStroke(2, new BasicStroke(2));
        renderer.setSeriesStroke(3, new BasicStroke(2));
        renderer.setSeriesStroke(4, new BasicStroke(2));
        JFreeChart chart = ChartFactory.createXYLineChart("Pruebas Inverso", "Tamaño", "Tiempo", dataset);
        chart.getXYPlot().getRangeAxis();
        ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat(""));
        chart.getXYPlot().setRenderer(renderer);
        BufferedImage image = chart.createBufferedImage(600, 400);
        ImageIO.write(image, "png", new File("Pruebas-inverso.png"));
    }
}
