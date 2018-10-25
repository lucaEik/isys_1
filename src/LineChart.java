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
        HashMap<String, Integer> map = new HashMap<>();
        DefaultCategoryDataset dataset = createDataset(map);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Opinion", // Chart title
                "Date", // X-Axis Label
                "Number of Visitor", // Y-Axis Label
                dataset,PlotOrientation.VERTICAL,
                true,true,false
        );
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public DefaultCategoryDataset createDataset(double[] dependent, double[] independent) {
        // Key : tage // Value prozentualen anteil der leute die die meinung a haben
        //

        String series1 = "dependent";
        String series2 = "independent";

        Iterator itr = dependent.iterator();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(200, series1, "2016-12-19");
        dataset.addValue(150, series1, "2016-12-20");
        dataset.addValue(100, series1, "2016-12-21");
        dataset.addValue(210, series1, "2016-12-22");
        dataset.addValue(240, series1, "2016-12-23");
        dataset.addValue(195, series1, "2016-12-24");
        dataset.addValue(245, series1, "2016-12-25");

        dataset.addValue(150, series2, "2016-12-19");
        dataset.addValue(130, series2, "2016-12-20");
        dataset.addValue(95, series2, "2016-12-21");
        dataset.addValue(195, series2, "2016-12-22");
        dataset.addValue(200, series2, "2016-12-23");
        dataset.addValue(180, series2, "2016-12-24");
        dataset.addValue(230, series2, "2016-12-25");

        return dataset;
    }
}
