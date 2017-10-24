/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensaver;

import edu.princeton.cs.introcs.*;
import java.awt.Color;

/**
 *
 * @author usuario 2
 */
public class ScreenSaver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int size = 600, np = 4;

        StdDraw.setCanvasSize(size, size);
        StdDraw.setPenRadius(0.001);
        StdDraw.setXscale(0, size - 1);
        StdDraw.setYscale(0, size - 1);
        StdDraw.clear();

        Color[] colors = {StdDraw.BLUE, StdDraw.CYAN, StdDraw.GREEN, StdDraw.RED, StdDraw.ORANGE};

        Pelota[] p = new Pelota[4]; // VECTOR
        for (int i = 0; i < np; i++) {

            p[i] = new Pelota((int) (Math.random() * 300) + 100, (int) (Math.random() * 300) + 100, 1, size, i);

        }
        System.out.println("lala");
        for (int i = 0; i < 4; i++) {
            p[i].start();
        }

        while (true) {
            StdDraw.clear(Color.BLACK);
            if (StdDraw.hasNextKeyTyped()) {
                System.out.println("Presionado ");
                char cc = StdDraw.nextKeyTyped();
                switch (cc) {
                    case 'v':
                        for (int i = 0; i < np; i++) {
                            p[i].velocidad--;
                        }
                        break;
                    case 'l':
                        for (int i = 0; i < np; i++) {
                            p[i].velocidad++;
                        }
                        break;

                }
                System.out.println("Key: " + cc);
            }
            for (int i = 0; i < np; i++) {
                StdDraw.setPenColor(colors[i % 6]);
                if (i < 3) {
                    for (int j = 0; j < 10; j++) {
                        StdDraw.line(p[i].x + j * 8, p[i].y, p[i + 1].x + j * 8, p[i + 1].y);
                    }
                } else {
                    for (int j = 0; j < 10; j++) {
                        StdDraw.line(p[i].x + j * 8, p[i].y, p[0].x + j * 8, p[0].y);
                    }
                }

            }
            StdDraw.show(8);
        }
    }
}
