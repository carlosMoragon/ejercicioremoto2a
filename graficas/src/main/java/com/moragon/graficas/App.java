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
        //Pruebas inverso
       // dataset.addSeries("burbuja", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {5100, 341800, 2908900, 37671000/*, 3818753100.00*/}});
        //dataset.addSeries("MergeSort", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {8900, 166700, 1350100, 136244000/*, 5846967000.00*/}});
        //dataset.addSeries("Seleccion Directa", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {4200, 244300, 8973200, 40758100/*, 2694775700.00*/}});
        //dataset.addSeries("Insercion Directa", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {4000, 245200, 4040300, 35845300/*, 2446415100.00*/}});
        //dataset.addSeries("QuickSort", new double[][]{{10, 100, 1000, 10000}, {4800, 294300, 5016100, 29275300}});
        //dataset.addSeries("busqueda Lineal", new double[][] {{10, 100, 1000, 10000, 100000 }, {82200,16600,146000,417600,1555000}});
        //dataset.addSeries("Busqueda Binaria", new double[][] {{ 10, 100, 1000, 10000,100000},{10900,3300,3400,3800,5000}});

        //Pruebas aleatorio
        //dataset.addSeries("burbuja", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {16500,311100,10353000,243246300/*, 3818753100.00*/}});
        //dataset.addSeries("MergeSort", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {24800,198300,5590000,92820700/*, 5846967000.00*/}});
        //dataset.addSeries("Seleccion Directa", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {13400,498400,9939100,29921600/*, 2694775700.00*/}});
        //dataset.addSeries("Insercion Directa", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {9400,108500,5305900,28665000/*, 2446415100.00*/}});
        //dataset.addSeries("QuickSort", new double[][]{{10, 100, 1000, 10000}, {15700,76600,303200,1338400}});
        //dataset.addSeries("busqueda Lineal", new double[][] {{10, 100, 1000, 10000, 100000 }, {1900,6500,57700,536600,667000}});
        //dataset.addSeries("Busqueda Binaria", new double[][] {{ 10, 100, 1000, 10000,100000},{2400,2400,2300,2800,2500}});

        //pruebas ordenado
        //dataset.addSeries("burbuja", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {4500,192300,5048300,29436700/*, 3818753100.00*/}});
        //dataset.addSeries("MergeSort", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {14600,138800,7368000,138080800/*, 5846967000.00*/}});
        //dataset.addSeries("Seleccion Directa", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {4400,425000,3737100,29888100/*, 2694775700.00*/}});
        //dataset.addSeries("Insercion Directa", new double[][]{{10, 100, 1000, 10000/*, 100000*/}, {2000,7800,13400,22800/*, 2446415100.00*/}});
        //dataset.addSeries("QuickSort", new double[][]{{10, 100, 1000, 10000}, {4700,249800,2730300,29109200}});
        //dataset.addSeries("busqueda Lineal", new double[][] {{10, 100, 1000, 10000, 100000 }, {3200,6700,55800,528900,673000}});
        //dataset.addSeries("Busqueda Binaria", new double[][] {{ 10, 100, 1000, 10000,100000},{2800,2700,3000,2400,6800}});

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.ORANGE);
        renderer.setSeriesPaint(1, Color.BLUE);
        //renderer.setSeriesPaint(2, Color.RED);
        //renderer.setSeriesPaint(3, Color.BLACK);
        //renderer.setSeriesPaint(4, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2));
        renderer.setSeriesStroke(1, new BasicStroke(2));
        //renderer.setSeriesStroke(2, new BasicStroke(2));
        //renderer.setSeriesStroke(3, new BasicStroke(2));
        //renderer.setSeriesStroke(4, new BasicStroke(2));
        JFreeChart chart = ChartFactory.createXYLineChart("Pruebas busqueda ordenado", "Tamaño", "Tiempo", dataset);
        chart.getXYPlot().getRangeAxis();
        ((NumberAxis) chart.getXYPlot().getRangeAxis()).setNumberFormatOverride(new DecimalFormat(""));
        chart.getXYPlot().setRenderer(renderer);
        BufferedImage image = chart.createBufferedImage(600, 400);
        ImageIO.write(image, "png", new File("Pruebas-busquedaOrdenado.png"));
    }
}
