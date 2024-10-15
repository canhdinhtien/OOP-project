package Maps;

import Main.Algorithms.GamePanel;

public class Classic {
    public int[][] map;
    public int brickHeight;
    public int brickWidth;
    public int row = 8;
    public int col = 8;
    String backGround;
    private int r,c;

    public Classic() {
        map = new int[row][col];
        this.brickHeight = (GamePanel.HEIGHT/2 -2*50)/row;
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
                map[i][j] = 3;
            }
        }
        if (type == 2) {
            for (int t = 0; t < 2; t++) {
                while (true) {
                    r = (int) (Math.random() * (row - 2) + 1);
                    c = (int) (Math.random() * (col - 2) + 1);
                    if (map[r][c] < 9 && map[r][c] > 0) {
                        map[r][c] = 9;
                        break;
                    }
                }

            }
            for (int t = 0; t < 2; t++) {
                while (true) {
                    r = (int) (Math.random() * (row - 2) + 1);
                    c = (int) (Math.random() * (col - 2) + 1);
                    if (map[r][c] < 9 && map[r][c] > 0) {
                        map[r][c] = 10;
                        break;
                    }
                }

            }
            for (int t = 0; t < 2; t++) {
                while (true) {
                    r = (int) (Math.random() * (row - 2) + 1);
                    c = (int) (Math.random() * (col - 2) + 1);
                    if (map[r][c] < 9 && map[r][c] > 0) {
                        map[r][c] = 11;
                        break;
                    }
                }

            }
            for (int t = 0; t < 2; t++) {
                while (true) {
                    r = (int) (Math.random() * (row - 2) + 1);
                    c = (int) (Math.random() * (col - 2) + 1);
                    if (map[r][c] < 9 && map[r][c] > 0) {
                        map[r][c] = 12;
                        break;
                    }
                }

            }
            for (int t = 0; t < 1; t++) {
                while (true) {
                    r = (int) (Math.random() * (row - 2) + 1);
                    c = (int) (Math.random() * (col - 2) + 1);
                    if (map[r][c] < 9 && map[r][c] > 0) {
                        map[r][c] = 13;
                        break;
                    }
                }
            }
        }
        return map;
    }
}
