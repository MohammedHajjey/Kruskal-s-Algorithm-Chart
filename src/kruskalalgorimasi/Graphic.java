package kruskalalgorimasi;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

public class Graphic extends Canvas{
    
    JFrame f;
    int point1, point2;
    int num;
    int graph[][];
    int parent[];
    int coor[][];

    
    public void paint(Graphics g) {
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);
        for (int i = 0; i < num; i++) {
            g.fillOval(coor[i][0], coor[i][1], 25, 25);
            g.drawString("[" + (i + 1) + "]", coor[i][0] - 8, coor[i][1] - 8);
        }
        int[][] matrix = new int[parent.length][parent.length];
        Random rand = new Random();

        for (int i = 0; i < parent.length; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = (rand.nextInt(401) + 70); // 0 ile 400 arasında rastgele bir sayı atama
            }
        }

        for (int i = 1; i < num; i++) {
            point1 = i;
            point2 = parent[i];
            g.drawLine(coor[point1][0] + 12, coor[point1][1] + 12, coor[point2][0] + 12, coor[point2][1] + 12);
            g.drawString(parent[i] + "", (((coor[point1][0] + coor[point2][0]) / 2) - 5), (((coor[point1][1] + coor[point2][1]) / 2) - 5));
        }

    }

    public Graphic(int g[]) {
        //graph = new int[n][n];
        parent = new int[g.length];
//        coor = new int[n][2];
//        num = n;
//        graph = g;
        parent = g;
//        coor = c;

        f = new JFrame("Minimum Spanning Tree");
        f.add(this);
        f.setSize(500, 00);
        f.setVisible(true);
}
}