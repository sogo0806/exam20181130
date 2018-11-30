import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

import java.awt.event.*;
import java.io.*;

public class Game extends JFrame {
    private ImageIcon icon = new ImageIcon("backgroung.jpg");
    private ImageIcon icon1 = new ImageIcon("player.gif");
    private  JLabel jlb = new JLabel();
    private JLabel jlb2 = new JLabel();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int screenw = screenSize.width;
    private int screenh = screenSize.height;
    private int frw =800 , frh =500 ;
    private int dirFlag = 1;
    private int  weight = 800 , hight = 460;



    public Game(){
        ex1();
    }
    public void ex1() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(screenw/2-frw/2,screenh/2-frh/2,frw,frh);
        this.setLayout(null);
        jlb.setOpaque(true);
        this.add(jlb);
        jlb.setBounds(0, 0, 800, 500);
        jlb.setIcon(icon);

        jlb2.setIcon(icon1);
        jlb.add(jlb2);
        jlb2.setBounds(0, 0, 80, 80);


        this.setResizable(false);



        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()){
                    case KeyEvent.VK_RIGHT :
                        jlb2.setIcon(icon1);
                        if (jlb2.getX() + 80 < weight){
                            jlb2.setLocation(jlb2.getX()+10,jlb2.getY());
                        }else {
                            dirFlag = 2;
                        }
                        break;

                    case KeyEvent.VK_LEFT :
                        jlb2.setIcon(icon1);
                        if (jlb2.getX() > 0){
                            jlb2.setLocation(jlb2.getX()-10,jlb2.getY());
                        }else {
                            dirFlag = 1;
                        }
                        break;

                    case KeyEvent.VK_UP :
                        jlb2.setIcon(icon1);
                        if (jlb2.getY() > 0){
                            jlb2.setLocation(jlb2.getX(),jlb2.getY()-10);
                        }else {
                            dirFlag = 4;
                        }
                        break;

                    case KeyEvent.VK_DOWN :
                        jlb2.setIcon(icon1);
                        if ((jlb2.getY()+80 ) < hight){
                            jlb2.setLocation(jlb2.getX(),jlb2.getY()+10);
                        } else {
                            dirFlag = 3;
                        }
                        break;
                }
            }
        });
    }
}