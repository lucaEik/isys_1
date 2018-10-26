import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import org.jfree.chart.plot.PlotOrientation;

import java.security.Key;
import java.util.*;

public class LineChart extends JFrame {

    public LineChart(String title) {
        super(title);
        // Create dataset
    }

    public void setUp(List dataInd, List dataD) {

        DefaultCategoryDataset dataset = createDataset(dataInd, dataD);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Opinion", // Chart title
                "Days Passed", // X-Axis Label
                "Percentage of People with opinion A", // Y-Axis Label
                dataset,PlotOrientation.VERTICAL,
                true,true,false
        );
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public DefaultCategoryDataset createDataset(List dataIndependet, List dataDependent) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Iterator ittr = dataIndependet.iterator();
        Iterator ittr_2 = dataDependent.iterator();
        int dayCounter = 1;
        String series1 = "independent";
        String series2 = "dependent";
        while (ittr.hasNext()) {
            dataset.addValue((double)ittr.next(), series1, String.valueOf(dayCounter) );
            dayCounter++;
        }
        dayCounter = 1;
        while (ittr_2.hasNext()) {
            dataset.addValue((double)ittr_2.next(), series2, String.valueOf(dayCounter) );
            dayCounter++;
        }
        return dataset;
    }
}

