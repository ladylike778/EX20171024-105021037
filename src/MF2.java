import com.sun.javafx.css.converters.FontConverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Random;

import javax.swing.*;

public class MF2 extends JFrame {
    private Container cp;
    private Dimension ddd=Toolkit.getDefaultToolkit().getScreenSize();
    private int FW=600  ,FH=400;
    private JMenuBar jmb=new JMenuBar();
    private JMenu abc=new JMenu("file");
    private JMenu abc2=new JMenu("option");
    private JMenuItem a1=new JMenuItem("start");
    private JMenuItem a2=new JMenuItem("exit");
    private JMenuItem a3=new JMenuItem("fontseting");
    private JMenuItem a4=new JMenuItem("fileload");
    private JInternalFrame iiii=new JInternalFrame();
    private JInternalFrame loadfileframe=new JInternalFrame();
    private JDesktopPane jdp=new JDesktopPane();
    private JLabel la[]=new JLabel[6];
    private Random rnd=new Random(System.currentTimeMillis());
    private JButton b1=new JButton("generate");
    private JButton b2=new JButton("exit");
    private JPanel jpanel1=new JPanel(new GridLayout(2,2,5,5));
    private JLabel jll1= new JLabel("family");
    private JLabel jll2= new JLabel("fontstyle");
    private JLabel jll3= new JLabel("font size");
    private JTextField js1=new JTextField();
    private  String op[]={"PLAIN","BOLD","ITALIC","BOLD+ITALIC"};
    private JComboBox adddd=new JComboBox(op);
    private JTextField js2=new JTextField();
    private MainFrame aaaaa;
    private JPanel kj=new JPanel(new GridLayout(1,6,2,2));
    private JPanel kj2 =new JPanel(new GridLayout(1,2));
    private JFileChooser jfc=new JFileChooser();
    private JTextArea jta=new JTextArea();
    private JButton b4=new JButton("exit");
    private JScrollPane jspp=new JScrollPane(jta);

    public MF2(MainFrame loginf){
        init();
        aaaaa=loginf;

    }
    private void init(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setBounds(ddd.width/2-FW/2,ddd.height/2-FH/2,FW,FH);
        this.setJMenuBar(jmb);
        jmb.add(abc);
        jmb.add(abc2);
        abc.add(a1);
        abc.add(a2);
        abc.add(a4);
        abc2.add(a3);
        jpanel1.add(jll1);
        jpanel1.add(jll2);
        jpanel1.add(jll3);
        jpanel1.add(js1);
        jpanel1.add(adddd);
        jpanel1.add(js2);

        this.setContentPane(jdp);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                aaaaa.setVisible(true);
            }
        });

        jdp.add(iiii);jdp.add(loadfileframe);
        iiii.setBounds(0,0,300,80);
        loadfileframe.setBounds(0,0,300,200);
        iiii.setLayout(new BorderLayout());
        loadfileframe.setLayout(new BorderLayout());
        for(int i=0;i<6;i++){
            la[i]=new JLabel();
            kj.add(la[i]);
        }
        kj2.add(b1);
        kj2.add(b2);
        iiii.add(kj, BorderLayout.NORTH);
        iiii.add(kj2,BorderLayout.CENTER);
        loadfileframe.add(jspp);
        loadfileframe.add(b4,BorderLayout.SOUTH);


        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iiii.setVisible(true);
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
                iiii.setVisible(false);
            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=JOptionPane.showConfirmDialog(MF2.this,jpanel1,"fontstyle",JOptionPane.OK_CANCEL_OPTION);
                int nw=0;
                switch (adddd.getSelectedIndex()){
                    case 0:
                      nw=Font.PLAIN;
                      break;
                    case 1:
                        nw=Font.BOLD;
                        break;
                    case 2:
                        nw=Font.ITALIC;
                        break;
                    case 3:
                        nw=Font.BOLD+Font.ITALIC;
                        break;
                }
                if(result == JOptionPane.OK_OPTION){
                    UIManager.put("Menu.font",new Font(js1.getText(),nw,Integer.parseInt(js2.getText())));
                }
            }
        });
        a4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadfileframe.setVisible(true);
                if(jfc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    try{
                        File inFile=jfc.getSelectedFile();
                        BufferedReader br=new BufferedReader(new FileReader(inFile));
                        String st="";
                        while ((st=br.readLine())!=null){
                            String[] data=st.split(",");
                            String[] data2={"書名","作者","出版商","價格","類別"};
                            for(int i=0;i<data.length;i++){
                                jta.append(data2[i]+":"+data[i]+"\n");
                            }

                        }
                    }catch (Exception ioe){
                        JOptionPane.showMessageDialog(null,"Open file error"+ioe.toString());
                    }

                }
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadfileframe.setVisible(false);
                if2clean();

            }
        });
    }
        private void generate(){
        for(int i=0;i<6;i++){
            la[i].setText(Integer.toString(rnd.nextInt(48)+1));

            for(int j=0;j<i;j++){
                if(la[i].equals(la[j])){
                    i--;
                    }else {

                }
                }
            }
        }
        private void if2clean(){
            jta.setText("");
        }
}