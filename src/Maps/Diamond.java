package Maps;

import Main.Algorithms.GamePanel;

public class Diamond {
    public int[][] map;
    public int brickHeight;
    public int brickWidth;
    public int row = 7;
    public int col = 10;
    String backGround;
    private int r, c;

    public Diamond() {
        map = new int[row][col];
        this.brickHeight = (GamePanel.HEIGHT/2)/row;
        this.brickWidth = (GamePanel.WIDTH - 2*80)/col;
        this.backGround = "resource/Image/diamond.png";
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
        map[0][3]=3;
        map[0][4]=3;
        map[0][5]=3;
        map[0][6]=3;
        map[1][2]=3;
        map[1][3]=8;
        map[1][4]=8;
        map[1][5]=8;
        map[1][6]=8;
        map[1][7]=3;
        map[2][1]=3;
        map[2][2]=5;
        map[2][3]=5;
        map[2][4]=5;
        map[2][5]=5;
        map[2][6]=5;
        map[2][7]=5;
        map[2][8]=6;
        map[3][0]=3;
        map[3][1]=6;
        map[3][2]=6;
        map[3][3]=6;
        map[3][4]=6;
        map[3][5]=6;
        map[3][6]=6;
        map[3][7]=6;
        map[3][8]=6;
        map[3][9]=3;
        map[4][1]=3;
        map[4][2]=5;
        map[4][3]=5;
        map[4][4]=5;
        map[4][5]=5;
        map[4][6]=5;
        map[4][7]=5;
        map[4][8]=3;
        map[5][2]=3;
        map[5][3]=4;
        map[5][4]=4;
        map[5][5]=4;
        map[5][6]=4;
        map[5][7]=3;
        map[6][3]=3;
        map[6][4]=3;
        map[6][5]=3;
        map[6][6]=3;
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
