package Tetris;

import java.awt.Graphics2D;
import java.awt.Image;

/**
 * author: Jingyu Wang ( JingyuWang1988@gmail.com), Date: 2017-12-25, Time: 12:27 AM
 * Description:
 */
public class theGrid {
    private int  width,height;//w12 h 18
    private int[][] grid;
    private int size = 25;
    private Image[] blocks;

    public theGrid(int aw, int ah, Image[] b){
        this.width = aw;
        this.height = ah;
        grid = new int[height][width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                grid[i][j] = 0;
            }
        }
        blocks = b;
//        grid[0][7]=1;
//        grid[1][7]=1;
//        grid[3][7]=1;
//        grid[5][7]=1;
        grid[16][3]=1;
//
//        for(int i=0;i<width;i++){
//            grid[2][i] = 1;
//            grid[4][i] = 1;
//            grid[6][i] = 1;
//        }
        int countRemoved = checkRow();
        System.out.println(countRemoved);
    }
    public int checkRow(){
        int  rowNum = 0;
        for(int j=0; j<height; j++){
            boolean remove = true;
            for(int i = 0;i<width;i++){
                //System.out.println("j=" + j + "i=" + i);
                if (grid[j][i] == 0){
                    remove = false;
                    break;
                }
            }
            if(remove){
                removeRow(j);
                rowNum++;
            }
        }
        return rowNum;
    }
    public void removeRow(int rowNum){
        for(int j=rowNum; j>0; j--){
            for(int i = 0;i<width;i++){
                grid[j][i] = grid[j-1][i];
            }
        }
        for(int i=0; i<width; i++){
            grid[0][i] = 0;
        }
    }
    public void gamePlaying() throws InterruptedException{

        grid[0][3]=1;
        for(int i=0; i<height-1;i++){
            Thread.sleep(2000);
            System.out.println("Jin lai le");
            grid[i][3]=0;
            if(grid[i+1][3] == 1)
                break;
            else
                grid[i+1][3]=1;
        }
    }
    public void drawGrid(Graphics2D g){
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if (grid[i][j] == 1){
                    g.drawImage(blocks[0],j *size,i*size,size,size,null);
                }
            }
        }
    }
}
