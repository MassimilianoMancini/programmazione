package javamm;

@SuppressWarnings("all")
public class ContaSottomatrici {
  public static int contaSottomatrici(int[][] T, int[][] S) {
    int occ = 0;
    for (int i = 0; ((i + S.length) < T.length); i++) {
      for (int j = 0; ((j + S[0].length) < T[0].length); j++) {
        boolean _tripleEquals = (S == Integer.valueOf(T[i][j]));
        if (_tripleEquals) {
          occ++;
        }
      }
    }
    return occ;
  }
  
  public static void main(String[] args) {
  }
}
