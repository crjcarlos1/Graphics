package droid.demos.com.graphviewexample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.UniqueLegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.series.Series;

public class MainActivity extends AppCompatActivity {

    private GraphView graph, graph2, graph3, graph4, graph5, graph6;
    private GraphView graph7, graph8, graph9, graph10, graph11, graph12;
    private GraphView graph13, graph14, graph15, graph16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graph = (GraphView) findViewById(R.id.graph);
        graph2 = (GraphView) findViewById(R.id.graph2);
        graph3 = (GraphView) findViewById(R.id.graph3);
        graph4 = (GraphView) findViewById(R.id.graph4);
        graph5 = (GraphView) findViewById(R.id.graph5);
        graph6 = (GraphView) findViewById(R.id.graph6);
        graph7 = (GraphView) findViewById(R.id.graph7);
        graph8 = (GraphView) findViewById(R.id.graph8);
        graph9 = (GraphView) findViewById(R.id.graph9);
        graph10 = (GraphView) findViewById(R.id.graph10);
        graph11 = (GraphView) findViewById(R.id.graph11);
        graph12 = (GraphView) findViewById(R.id.graph12);
        graph13 = (GraphView) findViewById(R.id.graph13);
        graph14 = (GraphView) findViewById(R.id.graph14);
        graph15 = (GraphView) findViewById(R.id.graph15);
        graph16 = (GraphView) findViewById(R.id.graph16);

        AdvancedLineGraph();
        grafica2();
        grafica3();
        grafica4();
        ScalingXGrph();
        SecondScaleGraph();
        ScalingXYGraph();
        ScrollingXGraph();
        SimplePointsGraph();
        StaticLabelsGraph();
        StylingColorsGraph();
        StylingLabelsGraph();
        TapListenerGraph();
        TitlesExampleGraph();
        UniqueLegendLineGraph();
        MultipleBarGraph();

    }

    private void AdvancedLineGraph() {
        // first series
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setTitle("first line");
        graph.addSeries(series);

        // second series
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(1, 3),
                new DataPoint(2, 6),
                new DataPoint(3, 2),
                new DataPoint(4, 5)
        });
        series2.setTitle("speed");
        series2.setDrawBackground(true);
        series2.setColor(Color.argb(255, 255, 60, 60));
        series2.setBackgroundColor(Color.argb(100, 204, 119, 119));
        series2.setDrawDataPoints(true);
        graph.addSeries(series2);

        // legend
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

    private void grafica2() {
        // first series
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setTitle("first line");
        graph.addSeries(series);

        // second series
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(1, 3),
                new DataPoint(2, 6),
                new DataPoint(3, 2),
                new DataPoint(4, 5)
        });
        series2.setTitle("speed");
        series2.setDrawBackground(true);
        series2.setColor(Color.argb(255, 255, 60, 60));
        series2.setBackgroundColor(Color.argb(100, 204, 119, 119));
        series2.setDrawDataPoints(true);
        graph2.addSeries(series2);

        // legend
        graph2.getLegendRenderer().setVisible(true);
        graph2.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

    private void grafica3() {

        BarGraphSeries<DataPoint> series = new BarGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph3.addSeries(series);

        // styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX() * 255 / 4, (int) Math.abs(data.getY() * 255 / 6), 100);
            }
        });

        series.setSpacing(50);
        series.setAnimated(true);

        // draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
        //series.setValuesOnTopSize(50);

        // legend
        series.setTitle("foo");
        graph3.getLegendRenderer().setVisible(true);
        graph3.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

    }

    private void grafica4() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph4.addSeries(series);

        // custom label formatter to show currency "EUR"
        graph4.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) + " €";
                }
            }
        });
    }

    private void ScalingXGrph() {
        // first series is a line
        DataPoint[] points = new DataPoint[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new DataPoint(i, Math.sin(i * 0.5) * 20 * (Math.random() * 10 + 1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        // set manual X bounds
        graph5.getViewport().setYAxisBoundsManual(true);
        graph5.getViewport().setMinY(-200);
        graph5.getViewport().setMaxY(200);

        graph5.getViewport().setXAxisBoundsManual(true);
        graph5.getViewport().setMinX(4);
        graph5.getViewport().setMaxX(80);

        // enable scaling
        graph5.getViewport().setScalable(true);

        series.setTitle("Random Curve");

        graph5.addSeries(series);

        graph5.getLegendRenderer().setVisible(true);
        graph5.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

    private void SecondScaleGraph() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph6.addSeries(series);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 30),
                new DataPoint(1, 30),
                new DataPoint(2, 60),
                new DataPoint(3, 20),
                new DataPoint(4, 50)
        });

        // set second scale
        graph6.getSecondScale().addSeries(series2);
        // the y bounds are always manual for second scale
        graph6.getSecondScale().setMinY(0);
        graph6.getSecondScale().setMaxY(100);
        series2.setColor(Color.RED);
    }

    private void ScalingXYGraph() {
        // first series is a line
        DataPoint[] points = new DataPoint[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new DataPoint(i, Math.sin(i * 0.5) * 20 * (Math.random() * 10 + 1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        // set manual X bounds
        graph7.getViewport().setYAxisBoundsManual(true);
        graph7.getViewport().setMinY(-150);
        graph7.getViewport().setMaxY(150);

        graph7.getViewport().setXAxisBoundsManual(true);
        graph7.getViewport().setMinX(4);
        graph7.getViewport().setMaxX(80);

        // enable scaling
        graph7.getViewport().setScalable(true);
        graph7.getViewport().setScalableY(true);

        series.setTitle("Random Curve");

        graph7.addSeries(series);

        graph7.getLegendRenderer().setVisible(true);
        graph7.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

    private void ScrollingXGraph() {
        // first series is a line
        DataPoint[] points = new DataPoint[50];
        for (int i = 0; i < 50; i++) {
            points[i] = new DataPoint(i, Math.sin(i * 0.5) * 20 * (Math.random() * 10 + 1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        // set manual X bounds
        graph8.getViewport().setXAxisBoundsManual(true);
        graph8.getViewport().setMinX(0);
        graph8.getViewport().setMaxX(10);

        // enable scrolling
        graph8.getViewport().setScrollable(true);

        series.setTitle("Random Curve");

        graph8.addSeries(series);

        graph8.getLegendRenderer().setVisible(true);
        graph8.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

    private void SimplePointsGraph() {

        int mSize = 10;

        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<>(new DataPoint[]{
                new DataPoint(0, -2),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph9.addSeries(series);
        series.setShape(PointsGraphSeries.Shape.POINT);
        series.setSize(mSize);

        PointsGraphSeries<DataPoint> series2 = new PointsGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, -1),
                new DataPoint(1, 4),
                new DataPoint(2, 2),
                new DataPoint(3, 1),
                new DataPoint(4, 5)
        });
        graph9.addSeries(series2);
        series2.setShape(PointsGraphSeries.Shape.RECTANGLE);
        series2.setColor(Color.RED);
        series2.setSize(mSize);

        PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(1, 3),
                new DataPoint(2, 1),
                new DataPoint(3, 0),
                new DataPoint(4, 4)
        });
        graph9.addSeries(series3);
        series3.setShape(PointsGraphSeries.Shape.TRIANGLE);
        series3.setColor(Color.YELLOW);
        series3.setSize(mSize);

        PointsGraphSeries<DataPoint> series4 = new PointsGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 2),
                new DataPoint(2, 0),
                new DataPoint(3, -1),
                new DataPoint(4, 3)
        });
        graph9.addSeries(series4);
        series4.setColor(Color.GREEN);
        series4.setCustomShape(new PointsGraphSeries.CustomShape() {
            @Override
            public void draw(Canvas canvas, Paint paint, float x, float y, DataPointInterface dataPoint) {
                paint.setStrokeWidth(5);
                canvas.drawLine(x - 10, y - 10, x + 10, y + 10, paint);
                canvas.drawLine(x + 10, y - 10, x - 10, y + 10, paint);
            }
        });
    }

    private void StaticLabelsGraph() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph10.addSeries(series);

        // use static labels for horizontal and vertical labels
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph10);
        staticLabelsFormatter.setHorizontalLabels(new String[]{"old", "middle", "new"});
        staticLabelsFormatter.setVerticalLabels(new String[]{"low", "middle", "high"});
        graph10.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
    }

    private void StylingColorsGraph() {
        DataPoint[] points = new DataPoint[30];
        for (int i = 0; i < 30; i++) {
            points[i] = new DataPoint(i, Math.sin(i * 0.5) * 20 * (Math.random() * 10 + 1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        points = new DataPoint[15];
        for (int i = 0; i < 15; i++) {
            points[i] = new DataPoint(i * 2, Math.sin(i * 0.5) * 20 * (Math.random() * 10 + 1));
        }
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(points);

        // styling grid/labels
        graph11.getGridLabelRenderer().setGridColor(Color.RED);
        graph11.getGridLabelRenderer().setHighlightZeroLines(false);
        graph11.getGridLabelRenderer().setHorizontalLabelsColor(Color.GREEN);
        graph11.getGridLabelRenderer().setVerticalLabelsColor(Color.RED);
        graph11.getGridLabelRenderer().setVerticalLabelsVAlign(GridLabelRenderer.VerticalLabelsVAlign.ABOVE);
        graph11.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph11.getGridLabelRenderer().reloadStyles();


        // styling viewport
        graph11.getViewport().setBackgroundColor(Color.argb(255, 222, 222, 222));
        graph11.getViewport().setDrawBorder(true);
        graph11.getViewport().setBorderColor(Color.BLUE);

        // styling series
        series.setTitle("Random Curve 1");
        series.setColor(Color.GREEN);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);

        series2.setTitle("Random Curve 2");
        series2.setDrawBackground(true);
        series2.setBackgroundColor(Color.argb(100, 255, 255, 0));
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
        series2.setDrawAsPath(true);
        series2.setCustomPaint(paint);

        // styling legend
        graph11.getLegendRenderer().setVisible(true);
        graph11.getLegendRenderer().setTextSize(25);
        graph11.getLegendRenderer().setBackgroundColor(Color.argb(150, 50, 0, 0));
        graph11.getLegendRenderer().setTextColor(Color.WHITE);
        //graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        //graph.getLegendRenderer().setMargin(30);
        graph11.getLegendRenderer().setFixedPosition(150, 0);

        graph11.addSeries(series);
        graph11.addSeries(series2);
    }

    private void StylingLabelsGraph() {

        DataPoint[] points = new DataPoint[30];
        for (int i = 0; i < 30; i++) {
            points[i] = new DataPoint(i, Math.sin(i * 0.5) * 20 * (Math.random() * 10 + 1));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);

        points = new DataPoint[15];
        for (int i = 0; i < 15; i++) {
            points[i] = new DataPoint(i * 2, Math.sin(i * 0.5) * 20 * (Math.random() * 10 + 1));
        }
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(points);

        // styling grid/labels
        graph12.getGridLabelRenderer().setHighlightZeroLines(false);
        graph12.getGridLabelRenderer().setVerticalLabelsAlign(Paint.Align.LEFT);
        graph12.getGridLabelRenderer().setLabelVerticalWidth(100);
        graph12.getGridLabelRenderer().setTextSize(20);
        graph12.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph12.getGridLabelRenderer().setHorizontalLabelsAngle(120);
        graph12.getGridLabelRenderer().reloadStyles();

        // styling series
        series.setTitle("Random Curve 1");
        series.setColor(Color.GREEN);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);

        graph12.addSeries(series);
        graph12.addSeries(series2);

    }

    private void TapListenerGraph() {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 3),
                new DataPoint(2, 1),
                new DataPoint(3, 0),
                new DataPoint(4, 3)
        });
        series.setColor(Color.rgb(255, 120, 120));
        series.setSpacing(50);
        graph13.addSeries(series);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, -1),
                new DataPoint(1, 1),
                new DataPoint(2, 2),
                new DataPoint(3, 1),
                new DataPoint(4, 4)
        });
        graph13.addSeries(series2);

        PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 3),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 5)
        });
        graph13.addSeries(series3);
        series3.setSize(10);
        series3.setColor(Color.RED);

        // register tap on series callback
        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(graph13.getContext(), "Series1: On Data Point clicked: " + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

        series2.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(graph13.getContext(), "Series2: On Data Point clicked: " + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });

        series3.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                Toast.makeText(graph13.getContext(), "Series3: On Data Point clicked: " + dataPoint, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void TitlesExampleGraph() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph14.addSeries(series);

        // titles
        graph14.setTitle("Chart Title");
        graph14.getGridLabelRenderer().setVerticalAxisTitle("Vertical Axis");
        graph14.getGridLabelRenderer().setHorizontalAxisTitle("Horizontal Axis");

        // optional styles
        //graph.setTitleTextSize(40);
        //graph.setTitleColor(Color.BLUE);
        //graph.getGridLabelRenderer().setVerticalAxisTitleTextSize(40);
        graph14.getGridLabelRenderer().setVerticalAxisTitleColor(Color.BLUE);
        //graph.getGridLabelRenderer().setHorizontalAxisTitleTextSize(40);
        graph14.getGridLabelRenderer().setHorizontalAxisTitleColor(Color.BLUE);
    }

    private void UniqueLegendLineGraph() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0.0, 0.0),
                new DataPoint(2.0, -51.0),
                new DataPoint(2.0, -51.0)
        });
        series.setTitle("Air");
        series.setColor(Color.rgb(115, 211, 230));
        graph15.addSeries(series);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(2.0, -51.0),
                new DataPoint(5.0, -110.0),
                new DataPoint(15.0, -110.0),
                new DataPoint(21.0, -51.0),
                new DataPoint(21.0, -51.0)
        });
        series1.setTitle("TMX12/50");
        series1.setColor(Color.rgb(115, 170, 230));
        graph15.addSeries(series1);

        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(21.0, -51.0),
                new DataPoint(22.0, -51.0),
                new DataPoint(22.3, -48.0),
                new DataPoint(23.0, -48.0),
                new DataPoint(23.3, -45.0),
                new DataPoint(24.0, -45.0),
                new DataPoint(24.3, -42.0),
                new DataPoint(25.0, -42.0),
                new DataPoint(25.3, -39.0),
                new DataPoint(26.0, -39.0),
                new DataPoint(26.3, -36.0),
                new DataPoint(27.0, -36.0),
                new DataPoint(27.3, -33.0),
                new DataPoint(28.0, -33.0),
                new DataPoint(28.3, -30.0),
                new DataPoint(29.0, -30.0),
                new DataPoint(29.3, -27.0),
                new DataPoint(31.0, -27.0),
                new DataPoint(31.3, -24.0),
                new DataPoint(34.0, -24.0),
                new DataPoint(34.3, -21.0)
        });
        series2.setTitle("Air");
        series2.setColor(Color.rgb(115, 211, 230));
        graph15.addSeries(series2);

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(34.3, -21.0),
                new DataPoint(37.0, -21.0),
                new DataPoint(37.3, -18.0),
                new DataPoint(41.0, -18.0),
                new DataPoint(41.3, -15.0),
                new DataPoint(46.0, -15.0),
                new DataPoint(46.3, -12.0),
                new DataPoint(54.0, -12.0),
                new DataPoint(54.3, -9.0),
                new DataPoint(65.0, -9.0),
                new DataPoint(65.3, -6.0),
                new DataPoint(84.0, -6.0),
                new DataPoint(84.3, -3.0),
                new DataPoint(124.0, -3.0),
                new DataPoint(124.3, 0.0)
        });
        series3.setTitle("NTX50");
        series3.setColor(Color.rgb(115, 230, 115));
        graph15.addSeries(series3);

        graph15.getViewport().setMinX(0);
        graph15.getViewport().setMaxX(130);
        graph15.getViewport().setXAxisBoundsManual(true);
        graph15.getViewport().setMinY(-115);
        graph15.getViewport().setMaxY(0);
        graph15.getViewport().setYAxisBoundsManual(true);
        graph15.getGridLabelRenderer().setHighlightZeroLines(false);
        graph15.getGridLabelRenderer().setHorizontalAxisTitle("Minutes");
        graph15.getGridLabelRenderer().setVerticalAxisTitle("Meter");
        graph15.setLegendRenderer(new UniqueLegendRenderer(graph15));
        graph15.getLegendRenderer().setVisible(true);
    }

    private void MultipleBarGraph() {
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, -2),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setSpacing(30);
        series.setAnimated(true);
        graph16.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[]{
                new DataPoint(0, -5),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 4),
                new DataPoint(4, 1)
        });
        series2.setColor(Color.RED);
        series2.setSpacing(30);
        series2.setAnimated(true);
        graph16.addSeries(series2);

        graph16.getViewport().setXAxisBoundsManual(true);
        graph16.getViewport().setMinX(-2);
        graph16.getViewport().setMaxX(6);

        // legend
        series.setTitle("foo");
        series2.setTitle("bar");
        graph16.getLegendRenderer().setVisible(true);
        graph16.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }

}
