import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import org.jfree.chart.plot.PlotOrientation;
import java.util.List;

/**
 * A JFrame with a line chart showing the results of the simulation. The line chart displays the average popularity of A
 * for each day of the simulation.
 */
public class LineChart extends JFrame {

    /**
     * Creates a Window with a line chart, displaying the values from the two lists given as arguments.
     * @param title The Window's title
     * @param independent A list containing the values for the independent simulation
     * @param dependent A List containing the values for the dependent simulation
     */
    public LineChart(String title, List<Double> independent, List<Double> dependent) {
        super(title);
        DefaultCategoryDataset dataset = createDataset(independent, dependent);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Spreading of Opinion A", // Chart title
                "Time (in days)", // X-Axis Label
                "Average percentage Popularity of A in %", // Y-Axis Label
                dataset,PlotOrientation.VERTICAL,
                true,true,false
        );
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    /**
     * Creates a Dataset containing the values from the simulations whith day as the column key and the row keys
     * "independent" and "dependent"
     * @param independent The values from the independent simulation
     * @param dependent The values from the dependent simulations
     * @return A Dataset containing the values from both simulations
     */
    public DefaultCategoryDataset createDataset(List<Double> independent, List<Double> dependent) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Adding the values from the independent simulation
        for (Double d : independent) {
            dataset.addValue(d * 100, "independent", "" + independent.indexOf(d));
        }

        // Adding the values from the dependent simulation
        for (Double d : dependent) {
            dataset.addValue(d * 100, "dependent", "" + dependent.indexOf(d));
        }

        return dataset;
    }
}