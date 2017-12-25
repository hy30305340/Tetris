package Tetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TetrisMain extends Canvas implements Runnable{
    public static final int WIDTH = 350,HEIGHT = 525;
    private Image[] tetrisBlocks;
    private theGrid tgrid;

    public static void main(String args[]){
        JFrame frame = new JFrame("Tetris");
        frame.setSize(WIDTH,HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        TetrisMain tm = new TetrisMain();
        //*** create the menu bar space
        frame.setLayout(null);//setLayout() works with setBounds(), to execute the layout of setBounds
        tm.setBounds(0,25,WIDTH,HEIGHT-25);
        //*** create the menu bar space, end--

        //*** create menu
        JMenuBar bar = new JMenuBar();//create bar
        bar.setBounds(0,0,WIDTH,25);

        JMenu file = new JMenu("File");//create menu
        file.setBounds(0,0,45,24);

        bar.add(file);//add file into bar

        JMenuItem newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //here is the code for restart game
                System.out.println("Starting the new game......");
            }
        });
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //here is the code for restart game
                System.out.println("Closing......");
                System.exit(0);
            }
        });
        file.add(newGame);
        file.add(exit);
        //*** create menu, end--


        frame.add(tm);
        frame.add(bar);
        frame.setVisible(true);
        tm.start();
    }
    public void start(){
        Thread t = new Thread(this);//create a new thread;
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
    public void init(){
        this.addKeyListener(new Controller(this));
        try{
            tetrisBlocks = ImageLoader.loadImage("tetris.png", 25);
        }
        catch(IOException e){
            System.out.println("Error loading in tetris.png");
            System.exit(1);
        }
        tgrid = new theGrid(12,18,tetrisBlocks);
    }
    public void run() {
        init();//call blocks
        boolean running = true;
        while(running){
            update();
            BufferStrategy buf = getBufferStrategy();
            if(buf == null){
                createBufferStrategy(3);
                continue;
            }
            Graphics2D g = (Graphics2D) buf.getDrawGraphics();
            render(g);
            buf.show();
            System.out.println("zhun bei...");
            try {
                System.out.println("kai shi wan");
                tgrid.gamePlaying();

            } catch (InterruptedException e) {
                System.out.println("wan dan");
                e.printStackTrace();
            }

        }
    }
    public void render(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Algerian",Font.PLAIN,20));
        //g.drawString("Tetris",170,50);
        //g.drawImage(tetrisBlocks[1],100,100,25,25,null);
        //g.drawImage(tetrisBlocks[0],125,125,25,25,null);
        tgrid.drawGrid(g);
    }
    public void update(){
    }
}
