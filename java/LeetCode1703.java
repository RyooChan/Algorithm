class Solution {
    private static boolean[][][] check;
    private static int[] xMove = {-1, 1, 0, 0};
    private static int[] yMove = {0, 0, -1, 1};

    public int shortestPath(int[][] grid, int k) {
        if(grid.length == 1 && grid[0].length == 1 ) return 0;

        Queue<Info> q = new LinkedList<>();

        check = new boolean[grid.length][grid[0].length][k+1];

        check[0][0][k] = true;
        q.add(new Info(0, 0, k, 1));

        while(!q.isEmpty()) {
            Info info = q.remove();

            int x = info.x;
            int y = info.y;
            int step = info.step;
            int breaker = info.breaker;

            for(int i=0; i<4; i++) {
                int xTo = x + xMove[i];
                int yTo = y + yMove[i];

                if(xTo<0 || yTo<0 || xTo>=grid.length || yTo>=grid[0].length) continue;
                if(check[xTo][yTo][breaker]) continue;

                check[xTo][yTo][breaker] = true;
                if(xTo == grid.length - 1 && yTo == grid[0].length - 1) {
                    return step;
                }

                if(grid[xTo][yTo] == 1) {
                    if(breaker>0) q.add(new Info(xTo, yTo, breaker-1, step+1));
                } else {
                    q.add(new Info(xTo, yTo, breaker, step+1));
                }
                
            }
        }

        return -1;
    }
}
class Info {
    int x;
    int y;
    int breaker;
    int step;

    Info(int x, int y, int breaker, int step) {
        this.x = x;
        this.y = y;
        this.breaker = breaker;
        this.step = step;
    }
}
