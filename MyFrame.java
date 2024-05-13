package JavaCoding.TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame implements MouseListener, ActionListener{
    
    ArrayList<Integer> pane = new ArrayList<>();
    ArrayList<Integer> black = new ArrayList<>();
    ArrayList<Integer> white = new ArrayList<>();

    private int turns = 1;
    private JButton button = new JButton("Reset!");
    private JLabel iinterface = new JLabel();
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();;
    private JLabel label3 = new JLabel();;
    private JLabel label4 = new JLabel();;
    private JLabel label5 = new JLabel();;
    private JLabel label6 = new JLabel();;
    private JLabel label7 = new JLabel();;
    private JLabel label8 = new JLabel();;
    private JLabel label9 = new JLabel();;
    private ImageIcon iconX = new ImageIcon("JavaCoding/TicTacToe/BLACK.png");
    private ImageIcon iconY = new ImageIcon("JavaCoding/TicTacToe/WHITE.png");

    private JLabel[] labelList = {label1,label2,label3,label4,label5,label6,label7,label8,label9};

    public MyFrame(){

        for (int i = 1; i < 10; i++) {
            pane.add(i);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.black);
        this.setResizable(false);
        this.setTitle("Tic Tac Toe");

        button.setBounds(429, 8, 50, 50);
        button.addActionListener(this);
        
 
        iinterface.setBounds(8, 500, 484, 65);
        iinterface.setOpaque(true);
        iinterface.setBackground(Color.pink);
        iinterface.setText("Black's turn.");
        iinterface.setHorizontalAlignment(SwingConstants.CENTER);
        iinterface.setFont(new Font("Times New Roman", Font.ITALIC, 30));

        label1.setBounds(8, 8, 156, 156);
        label1.setOpaque(true);
        label1.setBackground(Color.white);
        label1.addMouseListener(this);

        label4.setBounds(8, 172, 156, 156);
        label4.setOpaque(true);
        label4.setBackground(Color.white);
        label4.addMouseListener(this);

        label7.setBounds(8, 336, 156, 156);
        label7.setOpaque(true);
        label7.setBackground(Color.white);
        label7.addMouseListener(this);

        label2.setBounds(172, 8, 156, 156);
        label2.setOpaque(true);
        label2.setBackground(Color.white);
        label2.addMouseListener(this);

        label5.setBounds(172, 172, 156, 156);
        label5.setOpaque(true);
        label5.setBackground(Color.white);
        label5.addMouseListener(this);

        label8.setBounds(172, 336, 156, 156);
        label8.setOpaque(true);
        label8.setBackground(Color.white);
        label8.addMouseListener(this);

        label3.setBounds(336, 8, 156, 156);
        label3.setOpaque(true);
        label3.setBackground(Color.white);
        label3.addMouseListener(this);

        label6.setBounds(336, 172, 156, 156);
        label6.setOpaque(true);
        label6.setBackground(Color.white);
        label6.addMouseListener(this);

        label9.setBounds(336, 336, 156, 156);
        label9.setOpaque(true);
        label9.setBackground(Color.white);
        label9.addMouseListener(this);
        
        this.add(iinterface);
        iinterface.add(button);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(iinterface);
        this.setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) { // HERE!!!
        if (e.getSource() == label1) {
            switchingTurns(label1, 1);
        }
        else if (e.getSource() == label2) {
            switchingTurns(label2, 2);
        }
        else if (e.getSource() == label3) {
            switchingTurns(label3, 3);
        }
        else if (e.getSource() == label4) {
            switchingTurns(label4, 4);
        }
        else if (e.getSource() == label5) {
            switchingTurns(label5, 5);
        }
        else if (e.getSource() == label6) {
            switchingTurns(label6, 6);
        }
        else if (e.getSource() == label7) {
            switchingTurns(label7, 7);
        }
        else if (e.getSource() == label8) {
            switchingTurns(label8, 8);
        }
        else if (e.getSource() == label9) {
            switchingTurns(label9, 9);
        }
        
    }

    public void placeMarkX(JLabel label){
        label.removeMouseListener(this);
        turns++;
        label.setIcon(iconX);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void placeMarkY(JLabel label){
        label.removeMouseListener(this);
        turns++;
        label.setIcon(iconY);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
}

    public void removeThatNum(int num){
        for (int i = 0; i < pane.size(); i++) {
            if (num == pane.get(i)) { //i == index
                pane.remove(i);
            }
        }
    }

    public void switchingTurns(JLabel label, int num){
        if (turns % 2 == 1) { // if odd
                black.add(num);
                this.removeThatNum(num);
                placeMarkX(label);
                iinterface.setText("White's turn.");
                this.checkForBlack();
            }
            else{
                white.add(num);
                this.removeThatNum(num);
                placeMarkY(label);
                iinterface.setText("Black's turn.");
                this.checkForWhite();
            }
    }

    public boolean blackCheckDiagonal(){
        boolean b = false;
        for (int i = 0; i < black.size(); i++) {
            if (black.get(i) == 1) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 5) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 9) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (black.get(i) == 3) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 5) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 7) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    public boolean whiteCheckDiagonal(){
        boolean b = false;
        for (int i = 0; i < white.size(); i++) {
            if (white.get(i) == 1) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 5) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 9) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (white.get(i) == 3) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 5) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 7) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    public boolean blackCheckHorizontal(){
        boolean b = false;
        for (int i = 0; i < black.size(); i++) {
            if (black.get(i) == 1) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 2) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 3) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (black.get(i) == 4) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 5) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 6) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (black.get(i) == 7) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 8) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 9) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    public boolean whiteCheckHorizontal(){
        boolean b = false;
        for (int i = 0; i < white.size(); i++) {
            if (white.get(i) == 1) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 2) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 3) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (white.get(i) == 4) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 5) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 6) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (white.get(i) == 7) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 8) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 9) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    public boolean blackCheckVertical(){
        boolean b = false;
        for (int i = 0; i < black.size(); i++) {
            if (black.get(i) == 1) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 4) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 7) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (black.get(i) == 2) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 5) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 8) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (black.get(i) == 3) {
                for (int j = 0; j < black.size(); j++) {
                    if (black.get(j) == 6) {
                        for (int k = 0; k < black.size(); k++) {
                            if (black.get(k) == 9) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }
    

    public boolean whiteCheckVertical(){
        boolean b = false;
        for (int i = 0; i < white.size(); i++) {
            if (white.get(i) == 1) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 4) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 7) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (white.get(i) == 2) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 5) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 8) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
            else if (white.get(i) == 3) {
                for (int j = 0; j < white.size(); j++) {
                    if (white.get(j) == 6) {
                        for (int k = 0; k < white.size(); k++) {
                            if (white.get(k) == 9) {
                                b = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return b;
    }

    public void checkForWhite(){
        if (whiteCheckDiagonal() || whiteCheckHorizontal() || whiteCheckVertical()) {
            this.gameOver();
            iinterface.setText("White won!");
            iinterface.setHorizontalAlignment(SwingConstants.CENTER);
            iinterface.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        }
        else if (pane.isEmpty()) {
            iinterface.setText("Draw!");
            iinterface.setHorizontalAlignment(SwingConstants.CENTER);
            iinterface.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        }
    }
    
    public void checkForBlack(){
        if (blackCheckDiagonal() || blackCheckHorizontal() || blackCheckVertical()) {
            this.gameOver();
            iinterface.setText("Black won!");
            iinterface.setHorizontalAlignment(SwingConstants.CENTER);
            iinterface.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        }
        else if (pane.isEmpty()) {
            iinterface.setText("Draw!");
            iinterface.setHorizontalAlignment(SwingConstants.CENTER);
            iinterface.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        }
    }

    public void gameOver(){
        for (int i = 0; i < labelList.length; i++) {
            labelList[i].removeMouseListener(this);
        }
    }

    public void again() throws InterruptedException{
        turns = 1;
        iinterface.setText("Black's turn.");
        black.clear();
        white.clear();
        pane.clear();
        for (int i = 1; i < 10; i++) {
            pane.add(i);
        }
        System.out.println("Restarted.");

        label1.setIcon(null);
        label2.setIcon(null);
        label3.setIcon(null);
        label4.setIcon(null);
        label5.setIcon(null);
        label6.setIcon(null);
        label7.setIcon(null);
        label8.setIcon(null);
        label9.setIcon(null);

        label1.addMouseListener(this);
        label2.addMouseListener(this);
        label3.addMouseListener(this);
        label4.addMouseListener(this);
        label5.addMouseListener(this);
        label6.addMouseListener(this);
        label7.addMouseListener(this);
        label8.addMouseListener(this);
        label9.addMouseListener(this);

    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }


    @Override
    public void mouseReleased(MouseEvent e) {
      
    }


    @Override
    public void mouseEntered(MouseEvent e) {
       
    }


    @Override
    public void mouseExited(MouseEvent e) {
   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                this.again();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
    
}
