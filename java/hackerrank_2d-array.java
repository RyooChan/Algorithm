  private static final int xMove[] = {-1,-1, -1, 0, 1, 1, 1};
  private static final int yMove[] = {-1, 0, 1, 0, -1, 0, 1};

  public static int hourglassSum(List<List<Integer>> arr) {
      int ans = Integer.MIN_VALUE;
      
      for(int i=1; i<6-1; i++) {
          for(int j=1; j<6-1; j++) {
              int sum = 0;
              
              for(int k=0; k<xMove.length; k++) {
                  sum += arr.get(i + xMove[k]).get(j + yMove[k]);
              }
              
              ans = Math.max(sum, ans);
          }
      }
      
      return ans;
  }
