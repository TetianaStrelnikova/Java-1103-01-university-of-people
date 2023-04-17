package application;

import java.awt.*;
import javax.swing.*;

public class FractalWalk extends JFrame {
  private double[] s;
  private double[] t;
  private int x1, y1, x2, y2;

  public FractalWalk() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);
    setVisible(true);
  }

  public void setPoints(Point[] points) {
    x1 = points[0].x;
    y1 = points[0].y;
    x2 = points[points.length-1].x;
    y2 = points[points.length-1].y;
    s = new double[points.length];
    t = new double[points.length];
    s[0] = t[0] = 0;
    double d = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
    for (int i = 1; i < points.length; i++) {
      s[i] = ( (x2-x1)*(points[i].x-x1) + (y2-y1)*(points[i].y-y1)) / d;
      t[i] = ( (x2-x1)*(points[i].y-y1) - (y2-y1)*(points[i].x-x1)) / d;
    }
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    recursiveWalk(g, x1, y1, x2, y2, s, t, 7);
  }

  private void recursiveWalk(Graphics g, int x1, int y1, int x2, int y2, double[] s, double[] t, int level) {
    if (level == 0) {
      g.drawLine(x1, y1, x2, y2);
    } else {
      int[] x = new int[s.length];
      int[] y = new int[t.length];
      for (int i = 0; i < s.length; i++) {
        x[i] = (int)(x1 + s[i] * (x2 - x1) - t[i] * (y2 - y1));
        y[i] = (int)(y1 + t[i] * (x2 - x1) + s[i] * (y2 - y1));
      }

      for (int i = 1; i < s.length; i++) {
        recursiveWalk(g, x[i-1], y[i-1], x[i], y[i], s, t, level - 1);
      }
    }
  }


  public static void main(String[] args) {
    FractalWalk fractalWalk = new FractalWalk();
    Point[] points = new Point[] {new Point(100, 100), new Point(200, 200), new Point(300, 100)};
    fractalWalk.setPoints(points);
  }
}