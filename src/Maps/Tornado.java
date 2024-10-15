package Maps;

import Main.Algorithms.GamePanel;

public class Tornado {
    public int[][] map;
    public int brickHeight;
    public int brickWidth;
    public int row = 10;
    public int col = 10;
    String backGround;
    private int r,c;

    public Tornado() {
        map = new int[row][col];
        this.brickHeight = (GamePanel.HEIGHT/2 - 2*20)/row;
        this.brickWidth = (GamePanel.WIDTH - 2*80)/col;
        this.backGround = "resource/Image/12.jpg";
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
        map[0][0]=5;
        map[0][1]=5;
        map[0][2]=5;
        map[0][3]=5;
        map[0][4]=5;
        map[0][5]=5;
        map[0][6]=5;
        map[0][7]=5;
        map[0][8]=5;
        map[0][9]=5;
        map[1][0]=6;
        map[2][0]=6;
        map[3][0]=6;
        map[4][0]=6;
        map[5][0]=6;
        map[6][0]=6;
        map[7][0]=6;
        map[8][0]=6;
        map[9][0]=6;
        map[1][9]=4;
        map[2][9]=4;
        map[3][9]=4;
        map[4][9]=4;
        map[5][9]=4;
        map[6][9]=4;
        map[7][9]=4;
        map[8][9]=4;
        map[9][9]=4;
        map[2][2]=7;
        map[3][2]=7;
        map[4][2]=7;
        map[5][2]=7;
        map[6][2]=7;
        map[7][2]=7;
        map[8][2]=7;
        map[9][2]=7;
        map[2][7]=5;
        map[3][7]=5;
        map[4][7]=5;
        map[5][7]=5;
        map[6][7]=5;
        map[7][7]=5;
        map[9][3]=3;
        map[9][4]=3;
        map[9][5]=3;
        map[9][6]=3;
        map[9][7]=3;
        map[9][8]=3;
        map[2][3]=6;
        map[2][4]=6;
        map[2][5]=6;
        map[2][6]=6;
        map[7][4]=4;
        map[7][5]=4;
        map[7][6]=4;
        map[6][4]=3;
        map[5][4]=3;
        map[4][4]=3;
        map[4][5]=7;
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
