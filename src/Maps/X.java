package Maps;

import Main.Algorithms.GamePanel;

public class X {
    public int[][] map;
    public int brickHeight;
    public int brickWidth;
    public int row = 11;
    public int col = 13;
    String backGround;
    private int r,c;

    public X() {
        map = new int[row][col];
        this.brickHeight = (GamePanel.HEIGHT/2)/row;
        this.brickWidth = (GamePanel.WIDTH - 2*80)/col;
        this.backGround = "resource/Image/pinksky.jpg";
    }
    public int getH() {
        return brickHeight;
    }

    public int getW() {
        return brickWidth;
    }
    public String getBackground() {
        return backGround;
    }

    public int[][] buildMap(int type) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 0;
            }
        }
        map[2][0]=4;
        map[3][0]=4;
        map[4][0]=4;
        map[5][0]=4;
        map[6][0]=4;
        map[7][0]=4;
        map[8][0]=4;
        map[2][12]=4;
        map[3][12]=4;
        map[4][12]=4;
        map[5][12]=4;
        map[6][12]=4;
        map[7][12]=4;
        map[8][12]=4;
        map[3][1]=4;
        map[4][1]=4;
        map[5][1]=4;
        map[6][1]=4;
        map[7][1]=4;
        map[3][11]=4;
        map[4][11]=4;
        map[5][11]=4;
        map[6][11]=4;
        map[7][11]=4;
        map[4][2]=4;
        map[5][2]=4;
        map[6][2]=4;
        map[4][10]=4;
        map[5][10]=4;
        map[6][10]=4;
        map[5][3]=4;
        map[5][9]=4;
        map[0][4]=5;
        map[0][5]=5;
        map[0][6]=5;
        map[0][7]=5;
        map[0][8]=5;
        map[10][4]=5;
        map[10][5]=5;
        map[10][6]=5;
        map[10][7]=5;
        map[10][8]=5;
        map[1][5]=5;
        map[1][6]=5;
        map[1][7]=5;
        map[9][5]=5;
        map[9][6]=5;
        map[9][7]=5;
        map[2][6]=5;
        map[8][6]=5;
        map[1][0]=6;
        map[9][0]=6;
        map[2][1]=6;
        map[8][1]=6;
        map[3][2]=6;
        map[7][2]=6;
        map[4][3]=6;
        map[6][3]=6;
        map[5][4]=6;
        map[5][8]=6;
        map[1][12]=6;
        map[9][12]=6;
        map[2][11]=6;
        map[8][11]=6;
        map[3][10]=6;
        map[7][10]=6;
        map[4][9]=6;
        map[6][9]=6;
        map[0][3]=3;
        map[0][9]=3;
        map[1][4]=3;
        map[1][8]=3;
        map[2][5]=3;
        map[2][7]=3;
        map[3][6]=3;
        map[7][6]=3;
        map[10][3]=3;
        map[10][9]=3;
        map[9][4]=3;
        map[9][8]=3;
        map[8][5]=3;
        map[8][7]=3;
        if (type == 2) {
            for (int t = 0; t<2 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 9;
                        break;
                    }
                }

            }
            for (int t = 0; t<2 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9&& map[r][c]>0) {
                        map[r][c] = 10;
                        break;
                    }
                }

            }
            for (int t = 0; t<2 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 11;
                        break;
                    }
                }

            }
            for (int t = 0; t<2 ; t++) {
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
