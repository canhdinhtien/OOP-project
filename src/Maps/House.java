package Maps;

import Main.Algorithms.GamePanel;

public class House {
    public int[][] map;
    public int brickHeight;
    public int brickWidth;
    public int row = 12;
    public int col = 11;
    String backGround;
    private int r,c;

    public House() {
        map = new int[row][col];
        this.brickHeight = (GamePanel.HEIGHT/2)/row;
        this.brickWidth = (GamePanel.WIDTH - 2*80)/col;
        this.backGround = "resource/Image/7new.jpg";
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
        map[0][5]=3;
        map[1][4]=3;
        map[1][6]=3;
        map[2][3]=3;
        map[2][7]=3;
        map[3][2]=3;
        map[3][8]=3;
        map[4][1]=3;
        map[4][9]=3;
        map[5][0]=3;
        map[5][10]=3;
        map[6][0]=3;
        map[6][1]=4;
        map[6][2]=4;
        map[6][3]=4;
        map[6][4]=4;
        map[6][5]=4;
        map[6][6]=4;
        map[6][7]=4;
        map[6][8]=4;
        map[6][9]=4;
        map[6][10]=4;
        map[7][0]=3;
        map[7][1]=6;
        map[7][2]=6;
        map[7][3]=4;
        map[7][4]=8;
        map[7][5]=8;
        map[7][6]=8;
        map[7][7]=4;
        map[7][8]=6;
        map[7][9]=6;
        map[7][10]=3;
        map[8][0]=3;
        map[8][1]=6;
        map[8][2]=6;
        map[8][3]=4;
        map[8][4]=8;
        map[8][6]=8;
        map[8][7]=4;
        map[8][8]=6;
        map[8][9]=6;
        map[8][10]=3;
        map[9][0]=3;
        map[9][1]=6;
        map[9][2]=6;
        map[9][3]=4;
        map[9][4]=8;
        map[9][6]=8;
        map[9][7]=4;
        map[9][8]=6;
        map[9][9]=6;
        map[9][10]=3;
        map[10][0]=3;
        map[10][1]=6;
        map[10][2]=6;
        map[10][3]=4;
        map[10][4]=3;
        map[10][6]=3;
        map[10][7]=4;
        map[10][8]=6;
        map[10][9]=6;
        map[10][10]=3;
        map[11][0]=3;
        map[11][1]=3;
        map[11][2]=3;
        map[11][3]=3;
        map[11][4]=3;
        map[11][6]=3;
        map[11][7]=3;
        map[11][8]=3;
        map[11][9]=3;
        map[11][10]=3;
        map[2][5]=5;
        map[3][4]=5;
        map[3][5]=5;
        map[3][6]=5;
        map[4][3]=5;
        map[4][4]=5;
        map[4][5]=5;
        map[4][6]=5;
        map[4][7]=5;
        map[5][2]=5;
        map[5][3]=5;
        map[5][4]=5;
        map[5][5]=5;
        map[5][6]=5;
        map[5][7]=5;
        map[5][8]=5;
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

