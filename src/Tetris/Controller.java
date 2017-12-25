package Tetris;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * author: Jingyu Wang ( JingyuWang1988@gmail.com), Date: 2017-12-25, Time: 12:12 AM
 * Description:
 */
public class Controller implements KeyListener{
    TetrisMain game;
    public Controller(TetrisMain Agame){
        this.game = Agame;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            System.out.println("up pressed");
        }else if (e.getKeyCode()==KeyEvent.VK_LEFT){
            System.out.println("left pressed");
        }else if (e.getKeyCode()==KeyEvent.VK_DOWN){
            System.out.println("down pressed");
        }else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            System.out.println("right pressed");
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            System.out.println("space pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            System.out.println("up released");
        }else if (e.getKeyCode()==KeyEvent.VK_LEFT){
            System.out.println("left released");
        }else if (e.getKeyCode()==KeyEvent.VK_DOWN){
            System.out.println("down released");
        }else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            System.out.println("right released");
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            System.out.println("space released");
        }
    }
}
