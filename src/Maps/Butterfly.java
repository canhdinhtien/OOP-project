package Maps;

import Main.Algorithms.GamePanel;
public class Butterfly {
    public int[][] map;
    public int brickHeight;
    public int brickWidth;
    public int row = 15;
    public int col = 19;
    String backGround;
    private int r, c;

    public Butterfly() {
        map = new int[row][col];
        this.brickHeight = (GamePanel.HEIGHT/2)/row;
        this.brickWidth = (GamePanel.WIDTH - 2*80)/col;
        this.backGround = "resource/Image/butterfly (1).jpg";
    }
    public String getBackground() {
        return backGround;
    }
    public int getH() {
        return brickHeight;
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
        map[0][6]=6;
        map[0][7]=6;
        map[0][12]=6;
        map[0][11]=6;
        map[1][8] = 6;
        map[1][10] = 6;
        map[2][9] = 3;
        map[3][9] = 3;
        map[1][2]=3;
        map[1][3]=3;
        map[1][4]=3;
        map[1][14]=3;
        map[1][15]=3;
        map[1][16]=3;
        map[2][0]=3;
        map[2][1]=3;
        map[2][2]=3;
        map[2][3]=3;
        map[2][4]=3;
        map[2][5]=3;
        map[2][6]=3;
        map[2][12]=3;
        map[2][13]=3;
        map[2][14]=3;
        map[2][15]=3;
        map[2][16]=3;
        map[2][17]=3;
        map[2][18]=3;
        map[3][0]=3;
        map[3][1]=5;
        map[3][2]=5;
        map[3][3]=5;
        map[3][4]=5;
        map[3][5]=5;
        map[3][6]=3;
        map[3][7]=3;
        map[3][11]=3;
        map[3][12]=3;
        map[3][13]=5;
        map[3][14]=5;
        map[3][15]=5;
        map[3][16]=5;
        map[3][17]=5;
        map[3][18]=3;
        map[4][0]=3;
        map[4][1]=5;
        map[4][2]=5;
        map[4][3]=5;
        map[4][4]=5;
        map[4][5]=5;
        map[4][6]=5;
        map[4][7]=3;
        map[4][8]=3;
        map[4][9]=3;
        map[4][10]=3;
        map[4][11]=3;
        map[4][12]=5;
        map[4][13]=5;
        map[4][14]=5;
        map[4][15]=5;
        map[4][16]=5;
        map[4][17]=5;
        map[4][18]=3;
        map[5][0]=3;
        map[5][1]=5;
        map[5][2]=5;
        map[5][3]=5;
        map[5][4]=5;
        map[5][5]=5;
        map[5][6]=5;
        map[5][7]=5;
        map[5][8]=5;
        map[5][9]=8;
        map[5][10]=5;
        map[5][11]=5;
        map[5][12]=5;
        map[5][13]=5;
        map[5][14]=5;
        map[5][15]=5;
        map[5][16]=5;
        map[5][17]=5;
        map[5][18]=3;
        map[6][0]=3;
        map[6][1]=3;
        map[6][2]=3;
        map[6][3]=7;
        map[6][4]=7;
        map[6][5]=7;
        map[6][6]=7;
        map[6][7]=7;
        map[6][8]=5;
        map[6][9]=6;
        map[6][10]=5;
        map[6][11]=7;
        map[6][12]=7;
        map[6][13]=7;
        map[6][14]=7;
        map[6][15]=7;
        map[6][16]=3;
        map[6][17]=3;
        map[6][18]=3;
        map[7][2]=3;
        map[7][3]=3;
        map[7][4]=7;
        map[7][5]=7;
        map[7][6]=7;
        map[7][7]=7;
        map[7][8]=5;
        map[7][9]=6;
        map[7][10]=5;
        map[7][11]=7;
        map[7][12]=7;
        map[7][13]=7;
        map[7][14]=7;
        map[7][15]=3;
        map[7][16]=3;
        map[8][3]=3;
        map[8][4]=3;
        map[8][5]=3;
        map[8][6]=3;
        map[8][7]=3;
        map[8][8]=3;
        map[8][9]=6;
        map[8][10]=3;
        map[8][11]=3;
        map[8][12]=3;
        map[8][13]=3;
        map[8][14]=3;
        map[8][15]=3;
        map[9][7]=3;
        map[9][8]=6;
        map[9][9]=6;
        map[9][10]=6;
        map[9][11]=3;
        map[10][6]=3;
        map[10][7]=4;
        map[10][8]=4;
        map[10][9]=4;
        map[10][10]=4;
        map[10][11]=4;
        map[10][12]=3;
        map[11][5]=3;
        map[11][6]=4;
        map[11][7]=4;
        map[11][8]=4;
        map[11][9]=3;
        map[11][10]=4;
        map[11][11]=4;
        map[11][12]=4;
        map[11][13]=3;
        map[12][4]=3;
        map[12][5]=4;
        map[12][6]=4;
        map[12][7]=4;
        map[12][8]=3;
        map[12][10]=3;
        map[12][11]=4;
        map[12][12]=4;
        map[12][13]=4;
        map[12][14]=3;
        map[13][4]=3;
        map[13][5]=4;
        map[13][6]=4;
        map[13][7]=3;
        map[13][11]=3;
        map[13][12]=4;
        map[13][13]=4;
        map[13][14]=3;
        map[14][4]=3;
        map[14][5]=3;
        map[14][6]=3;
        map[14][12]=3;
        map[14][13]=3;
        map[14][14]=3;
        if (type == 2) {
            for (int t = 0; t<3 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 9;
                        break;
                    }
                }

            }
            for (int t = 0; t<3 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9&& map[r][c]>0) {
                        map[r][c] = 10;
                        break;
                    }
                }

            }
            for (int t = 0; t<3 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 11;
                        break;
                    }
                }

            }
            for (int t = 0; t<3 ; t++) {
                while (true) {
                    r = (int) (Math.random()*(row-2)+1);
                    c = (int) (Math.random()*(col-2)+1);
                    if (map[r][c]<9 && map[r][c]>0) {
                        map[r][c] = 12;
                        break;
                    }
                }

            }
            for (int t = 0; t<3 ; t++) {
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
