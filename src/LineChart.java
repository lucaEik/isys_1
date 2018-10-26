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
        ArrayList data = Group.chartData;

        DefaultCategoryDataset dataset = createDataset(data);
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "Opinion", // Chart title
                "Individuals w/ opinion A", // X-Axis Label
                "Number of Days", // Y-Axis Label
                dataset,PlotOrientation.VERTICAL,
                true,true,false
        );
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public DefaultCategoryDataset createDataset(ArrayList data) {
        // Key : tage // Value prozentualen anteil der leute die die meinung a haben
        //
        Map <Integer, List<Integer>> map = new HashMap<>();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int count = 0;
        int dayCounter = 1;
        Iterator ittr = data.iterator();
        String series1 = "dependent";
        String series2 = "independent";
        while (ittr.hasNext()) {
            int val = (Integer)ittr.next();
            if (map.get(dayCounter) == null) {
                map.put(dayCounter, new LinkedList<Integer>());}
                else {
                    map.get(dayCounter).add(val);
                }

                if (ittr.hasNext() && val == Constants.GROUP_SIZE) {
                    dayCounter = 0;
                }
                dayCounter++;
        }

        int counter = 0;
        int avg = 0;
        for (Map.Entry<Integer, List<Integer>> ent : map.entrySet()){
            for (Integer val : ent.getValue()){
                System.out.println("val: " + val);
                avg += val;
                counter ++;

            }
            System.out.println("avg: " + avg);
            System.out.println("counter: " + counter);
            if (avg != 0 ) {
                dataset.addValue(avg/ent.getValue().size(), series1, String.valueOf(counter));
            }

            avg = 0;
            counter = 0;
        }

       // System.out.print(map);
       // dataset.addValue((Integer)ittr.next(), series1, String.valueOf(dayCounter));
        return dataset;
    }
}
