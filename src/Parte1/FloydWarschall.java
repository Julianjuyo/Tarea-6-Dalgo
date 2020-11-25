package Parte1;


public class FloydWarschall {


	//-----------------------------
	//	ATRIBUTOS
	//-----------------------------

	public static final int INFINITO = 999999999;

	//-----------------------------
	//	METODOS
	//-----------------------------

	/**
	 * Metodo que Inicializa el grafo 
	 */
	public FloydWarschall() {
	}

	/**
	 * MEtodo que encuentra los caminos de costo minimo utilizando el algoritmo de Bellman Ford
	 * @param matrizDeAdj matriz que tiene los ejes
	 * @param numV numero de vertices
	 */
	public void FloydWarschallAlgoritmo(int matrizDeAdj[][], int numV) {

		int matrix[][] = inicializar(matrizDeAdj, numV);
		int i, j, k;


		for (k = 0; k < numV; k++) {
			for (i = 0; i < numV; i++) {
				for (j = 0; j < numV; j++) {

					if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];	
					}
				}
			}
		}
		Imprimir(matrix, numV);
	}

	/**
	 * Metodo que inicializa la matriz 
	 * @param matrizDeAdj
	 * @param V
	 * @return
	 */
	public int[][] inicializar(int[][] matrizDeAdj, int V){

		int[][] m = new int[V][V];

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {

				if(matrizDeAdj[i][j]==-1) {
					m[i][j] = INFINITO;
				}
				else {
					m[i][j] = matrizDeAdj[i][j];
				}
			}
		}
		return m;
	}


	/**
	 * Metodo que imprime las distancias mas cortas desde un vertice origen hasta todos los vertices.
	 * @param g grafo 
	 * @param num_Vertices numero de vertices del grafo
	 * @param ini Indice del grafo origen
	 */
	public void Imprimir(int matrix[][], int V) {

		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {

				if (matrix[i][j] == INFINITO)
					System.out.print("ERROR");
				else {
					System.out.print(matrix[i][j] + "  ");
					//System.out.println("La Distancia desde: ("+i+") Hasta: ("+ j + ") es de: " + matrix[i][j]); 
				}
			}
			System.out.println();
		}
	}
	
	
}

