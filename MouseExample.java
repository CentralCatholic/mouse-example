import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;

class MouseExample extends JFrame {
    private JPanel body;

    MouseExample() {
        this.body = new JPanel();

        // Now, set the properties of the body panel.
        MouseAdapter mouse = new MouseAdapter() {

            private Point onPressed;

            public void mouseMoved(MouseEvent e) {
                String point = String.format("(%d, %d)", e.getX(), e.getY());
                MouseExample.this.setTitle(point);
            }

            public void mouseClicked(MouseEvent e) {
                Graphics g = body.getGraphics();
                g.setColor(Color.CYAN);
                g.fillOval(e.getX(), e.getY(), 15, 15);
            }

            public void mousePressed(MouseEvent e) {
                this.onPressed = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                if (this.onPressed == null) {
                    return;
                }
                Graphics g = body.getGraphics();
                g.setColor(Color.BLUE);

                int x1, x2, y1, y2;
                x1 = (int) this.onPressed.getX();
                y1 = (int) this.onPressed.getY();
                x2 = e.getX();
                y2 = e.getY();
                g.drawLine(x1, y1, x2, y2);
            }
        };

        // Add the mouse listener to the jpanel.
        this.body.addMouseListener(mouse);
        this.body.addMouseMotionListener(mouse);

        // Add the new panel to the jframe
        this.add(this.body);
    }
}
