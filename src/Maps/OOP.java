package Maps;

import Main.Algorithms.GamePanel;

public class OOP {
    public int[][] map;
    public int brickHeight;
    public int brickWidth;
    public int row = 6;
    public int col = 13;
    String backGround;
    private int r,c;

    public OOP() {
        map = new int[row][col];
        this.brickHeight = (GamePanel.HEIGHT/2 - 2*50)/row;
        this.brickWidth = (GamePanel.WIDTH - 2*80)/col;
        this.backGround = "resource/Image/computer3.png";
    }
    public int getH() {
        return brickHeight;
    }
    public String getBackground() {
        return backGround;
    }

    public int getW() {
        return brickWidth;
    }

    public int[][] buildMap(int type) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 0;
            }
        }
        map[0][1]=6;
        map[0][2]=6;
        map[1][0]=6;
        map[1][1]=3;
        map[1][2]=3;
        map[1][3]=6;
        map[2][0]=6;
        map[2][1]=3;
        map[2][2]=3;
        map[2][3]=6;
        map[3][0]=6;
        map[3][1]=3;
        map[3][2]=3;
        map[3][3]=6;
        map[4][0]=6;
        map[4][1]=3;
        map[4][2]=3;
        map[4][3]=6;
        map[5][1]=6;
        map[5][2]=6;
        map[0][6]=5;
        map[0][7]=5;
        map[1][5]=5;
        map[1][6]=3;
        map[1][7]=3;
        map[1][8]=5;
        map[2][5]=5;
        map[2][6]=3;
        map[2][7]=3;
        map[2][8]=5;
        map[3][5]=5;
        map[3][6]=3;
        map[3][7]=3;
        map[3][8]=5;
        map[4][5]=5;
        map[4][6]=3;
        map[4][7]=3;
        map[4][8]=5;
        map[5][6]=5;
        map[5][7]=5;
        map[0][10]=4;
        map[0][11]=4;
        map[0][12]=4;
        map[1][10]=4;
        map[1][11]=3;
        map[1][12]=4;
        map[2][10]=4;
        map[2][11]=3;
        map[2][12]=4;
        map[3][10]=4;
        map[3][11]=4;
        map[3][12]=4;
        map[4][10]=4;
        map[5][10]=4;
        if (type == 2) {
            for (int t = 0; t<1 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 9;
                        break;
                    }
                }

            }
            for (int t = 0; t<1 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9&& map[r][c]>0) {
                        map[r][c] = 10;
                        break;
                    }
                }

            }
            for (int t = 0; t<1 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 11;
                        break;
                    }
                }

            }
            for (int t = 0; t<1 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 12;
                        break;
                    }
                }

            }
            for (int t = 0; t<1 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 13;
                        break;
                    }
                }

            }

        }
        return map;

    }

}
