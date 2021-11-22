package javamm;

@SuppressWarnings("all")
public class ContaSottomatrici {
  public static int contaSottomatrici(int[][] T, int[][] S) {
    int occurence = 0;
    int k = 0;
    int l = 0;
    boolean match = true;
    for (int i = 0; ((i + S.length) <= T.length); i++) {
      for (int j = 0; ((j + S[0].length) <= T[0].length); j++) {
        {
          match = true;
          k = 0;
          while (((k < S.length) && match)) {
            {
              l = 0;
              while (((l < S[0].length) && match)) {
                {
                  boolean _tripleEquals = (S[k][l] == T[(k + i)][(l + j)]);
                  match = _tripleEquals;
                  l++;
                }
              }
              k++;
            }
          }
          if (match) {
            occurence++;
          }
        }
      }
    }
    return occurence;
  }
  
  public static void main(String[] args) {
  }
}
