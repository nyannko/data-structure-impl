class Solution {
  
  static float[][] clone(float[][] a) {
     int length = a.length;
     if(length > 0) {
     float[][] b = new float[length][a[0].length];
     for(int i = 0; i < a.length; i++) {
        for(int j = 0; j < a[0].length; j++) {
          b[i][j] = a[i][j];
        }
      }
        return b;
    }
    return new float[][] {};
  }
}
    // clone a to b
