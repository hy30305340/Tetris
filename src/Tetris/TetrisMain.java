package Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisMain extends Canvas implements Runnable,KeyListener{
    public static void main(String args[]){
        JFrame frame = new JFrame("Tetris");
        frame.setSize(400,540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        TetrisMain tm = new TetrisMain();
        frame.add(tm);
        frame.setVisible(true);
        tm.start();
    }
    public void start(){
        Thread t = new Thread(this);//create a new thread;
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
    public void update(){

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void run() {
        boolean running = true;
        while(running){
            update();
        }
    }
}
