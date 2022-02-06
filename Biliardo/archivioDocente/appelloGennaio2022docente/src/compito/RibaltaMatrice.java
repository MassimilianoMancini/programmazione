package compito;

public class RibaltaMatrice {

	public static int[][] ribaltaIterativo(int[][] matrice, char[] asse) {

		int[][] matriceRibaltata = null;

		for (int indice = 0; indice < asse.length; indice++) {

			switch (asse[indice]) {
			case 'O':

				matriceRibaltata = new int[2 * matrice.length][matrice[0].length];

				for (int i = 0; i < matrice.length; i++) {
					matriceRibaltata[i] = matrice[i];
					matriceRibaltata[2 * matrice.length - 1 - i] = matrice[i];
				}
				break;

			case 'V':

				matriceRibaltata = new int[matrice.length][2 * matrice[0].length];

				for (int i = 0; i < matrice.length; i++) {
					for (int j = 0; j < matrice[0].length; j++) {
						matriceRibaltata[i][j] = matrice[i][j];
						matriceRibaltata[i][2 * matrice[0].length - 1 - j] = matrice[i][j];
					}
				}

			}
			matrice = matriceRibaltata;
		}
		return matrice;
	}

	public static int[][] ribaltaRicorsivo(int[][] matrice, char[] asse, int indice) {

		if (indice == asse.length)
			return matrice;

		int[][] matriceRibaltata = null;

		switch (asse[indice]) {
		case 'O':

			matriceRibaltata = new int[2 * matrice.length][matrice[0].length];

			for (int i = 0; i < matrice.length; i++) {
				matriceRibaltata[i] = matrice[i];
				matriceRibaltata[2 * matrice.length - 1 - i] = matrice[i];
			}
			break;

		case 'V':

			matriceRibaltata = new int[matrice.length][2 * matrice[0].length];

			for (int i = 0; i < matrice.length; i++) {
				for (int j = 0; j < matrice[0].length; j++) {
					matriceRibaltata[i][j] = matrice[i][j];
					matriceRibaltata[i][2 * matrice[0].length - 1 - j] = matrice[i][j];
				}
			}

		}
		return (ribaltaRicorsivo(matriceRibaltata, asse, indice + 1));
	}

	public static int[][] ribalta(int[][] matrice, char[] asse) {

		// return ribaltaRicorsivo(matrice, asse, 0);
		return ribaltaIterativo(matrice, asse);

	}
}
