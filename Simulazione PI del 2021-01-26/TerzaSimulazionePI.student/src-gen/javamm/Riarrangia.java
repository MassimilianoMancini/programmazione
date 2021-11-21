package javamm;

@SuppressWarnings("all")
public class Riarrangia {
  public static int[] riarrangia(int[] a) {
    int[] r = new int[a.length];
    int i = 0;
    int j = 0;
    int k = 0;
    boolean negative = true;
    while ((k < a.length)) {
      if (negative) {
        boolean _lessThan = (a[i] < 0);
        if (_lessThan) {
          r[k++] = a[i];
          int _length = a.length;
          boolean _lessThan_1 = (j < _length);
          if (_lessThan_1) {
            negative = false;
          }
        }
        i++;
        int _length_1 = a.length;
        boolean _tripleEquals = (i == _length_1);
        if (_tripleEquals) {
          negative = false;
        }
      } else {
        boolean _greaterThan = (a[j] > 0);
        if (_greaterThan) {
          r[k++] = a[j];
          int _length_2 = a.length;
          boolean _lessThan_2 = (i < _length_2);
          if (_lessThan_2) {
            negative = true;
          }
        }
        j++;
        int _length_3 = a.length;
        boolean _tripleEquals_1 = (j == _length_3);
        if (_tripleEquals_1) {
          negative = true;
        }
      }
    }
    return r;
  }
  
  public static void main(String[] args) {
  }
}
