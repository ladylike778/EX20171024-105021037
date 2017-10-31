import com.sun.org.apache.xpath.internal.operations.String;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    Container cp;
    private JLabel l1=new JLabel("帳號");
    private JLabel l2=new JLabel("密碼");
    private JTextField t1=new JTextField();
    private JPasswordField t2=new JPasswordField();
    private JButton b1=new JButton("login");
    private JButton b2=new JButton("exit");
    private Dimension dd=Toolkit.getDefaultToolkit().getScreenSize();
    private  int FW=250,FH=150;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(dd.width/2-FW/2,dd.height/2-FH/2,FW,FH);
        cp=this.getContentPane();
        cp.setLayout(new GridLayout(3,2,2,2));
        this.setDefaultCloseOperation(3);
        cp.add(l1);
        cp.add(t1);
        cp.add(l2);
        cp.add(t2);
        cp.add(b1);
        cp.add(b2);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t1.getText().equals("a")&& new java.lang.String(t2.getPassword()).equals("a"))
                {MF2 ab=new MF2(MainFrame.this);
                    ab.setVisible(true);
                    MainFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"who are you");
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}