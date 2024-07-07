
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class appPrac1 implements ActionListener {
    Frame fr;
    TextField tf;
    Button b1, b2, b3;

    outer_listner ol;
    window wi;



    appPrac1(String s) {
        fr = new Frame(s);
        fr.setSize(400, 500);

        tf = new TextField();
        tf.setBounds(100, 100, 200, 80);
        fr.add(tf);

        b1 = new Button("SameclassLisener");
        b1.setBounds(100, 200, 160, 60);
        b1.addActionListener(this);
        fr.add(b1);

        b2 = new Button("OuterClassListener");
        b2.setBounds(100, 280, 160, 60);
        ol = new outer_listner(this);
        b2.addActionListener(ol);
        fr.add(b2);

        b3 = new Button("InnerClassListener");
        b3.setBounds(100, 360, 160, 60);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("InnerClassListener");
            }
        });
        fr.add(b3);

        wi = new window(this);
        fr.addWindowListener(wi);

        

        fr.setLayout(null);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (b1 == e.getSource()) {
            tf.setText("SameclassLisener");
        } else if (b2 == e.getSource()) {
            tf.setText("cancel");
        }

    }
}

class outer_listner implements ActionListener {
    appPrac1 gui;

    outer_listner(appPrac1 o) {
        gui = o;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gui.b2 == e.getSource()) {
            gui.tf.setText("OuterClassListener");

        }
    }

}

// implements WindowListener
class window extends WindowAdapter {
    appPrac1 gui;

    window(appPrac1 o) {
        gui = o;
    }

    public void windowClosing(WindowEvent e) {

        System.exit(0);
    }
}

public class Listeners {

    public static void main(String[] args) {

        appPrac1 app = new appPrac1("do be do be do");

    }
}
