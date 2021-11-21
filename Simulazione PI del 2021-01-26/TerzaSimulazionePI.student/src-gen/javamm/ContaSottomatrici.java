package javamm;

@SuppressWarnings("all")
public class ContaSottomatrici {
  public static int contaSottomatrici(int[][] T, int[][] S) {
    int occ = 0;
    int k = 0;
    int l = 0;
    boolean nextpos = false;
    for (int i = 0; (((i + S.length) - 1) < T.length); i++) {
      for (int j = 0; (((j + S[0].length) - 1) < T[0].length); j++) {
        {
          nextpos = false;
          k = 0;
          while (((k < S.length) && (!nextpos))) {
            {
              l = 0;
              while (((l < S[0].length) && (!nextpos))) {
                {
                  boolean _tripleNotEquals = (S[k][l] != T[(k + i)][(l + j)]);
                  nextpos = _tripleNotEquals;
                  l++;
                }
              }
              k++;
            }
          }
          boolean _not = (!nextpos);
          if (_not) {
            occ++;
          }
        }
      }
    }
    return occ;
  }
  
  public static void main(String[] args) {
  }
}
