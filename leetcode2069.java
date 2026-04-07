class Robot {
    int x = 0, y = 0;
    int width, height;
    int dir = 0;
    
    String[] dirs = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void step(int num) {
        int perimeter = 2 * (width - 1) + 2 * (height - 1);
        num %= perimeter;
        if (num == 0) num = perimeter;

        while (num > 0) {
            int move = 0;

            switch (dir) {
                case 0:
                    move = Math.min(num, width - 1 - x);
                    x += move;
                    break;

                case 1:
                    move = Math.min(num, height - 1 - y);
                    y += move;
                    break;

                case 2:
                    move = Math.min(num, x);
                    x -= move;
                    break;

                case 3:
                    move = Math.min(num, y);
                    y -= move;
                    break;
            }

            num -= move;

            if (num > 0) {
                dir = (dir + 1) % 4;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        return dirs[dir];
    }
}
