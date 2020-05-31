package CoreJava.chapter14.bounceThread;

import CoreJava.chapter14.bounce.Ball;
import CoreJava.chapter14.bounce.BallComponent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-05-31 14:48
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class BounceFrame extends JFrame
{
    private BallComponent comp;
    public static final int STEPS = 5000;
    public static final int DELAY = 3;

    public BounceFrame()
    {
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall()
    {
        Runnable r = () -> {
            try {
                Ball ball = new Ball();
                comp.add(ball);

                for (int i = 1; i <= STEPS; i++)
                {
                    ball.move(comp.getBounds());
                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}
