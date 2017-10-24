import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Random;

import javax.swing.*;

public class MF2 extends JFrame {
    private Container cp;
    private Dimension ddd=Toolkit.getDefaultToolkit().getScreenSize();
    private int FW=500  ,FH=300;
    private JMenuBar jmb=new JMenuBar();
    private JMenu abc=new JMenu("file");
    private JMenu abc2=new JMenu("option");
    private JMenuItem a1=new JMenuItem("start");
    private JMenuItem a2=new JMenuItem("exit");
    private JInternalFrame iiii=new JInternalFrame();
    private JDesktopPane jdp=new JDesktopPane();
    private JLabel la[]=new JLabel[6];
    private Random rnd=new Random(System.currentTimeMillis());
    private JButton b1=new JButton("generate");
    private JButton b2=new JButton("exit");
    public MF2(){
        init();
    }
    private void init(){
        this.setLayout(new BorderLayout());
        this.setBounds(ddd.width/2-FW/2,ddd.height/2-FH/2,FW,FH);
        this.setJMenuBar(jmb);
        jmb.add(abc);
        jmb.add(abc2);
        abc.add(a1);
        abc.add(a2);

        this.setContentPane(jdp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.add(iiii);
                iiii.setBounds(0,0,300,80);
                iiii.setVisible(true);
                iiii.setLayout(new GridLayout(2,6));

                for(int i=0;i<6;i++){
                    la[i]=new JLabel();
                }generate();
                iiii.add(b1);
                iiii.add(b2);

            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iiii.dispose();
            }
        });




    }
        private void generate(){
        for(int i=0;i<6;i++){
            la[i].setText(Integer.toString(rnd.nextInt(48)+1));
            iiii.add(la[i]);
            for(int j=0;j<i;j++){
                if(la[i].equals(la[j])){
                    la[i].setText(Integer.toString(rnd.nextInt(48)+1));
                }
            }

        }

        }
}