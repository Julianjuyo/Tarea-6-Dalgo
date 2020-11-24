package Parte1;


public class FloydWarschall {


	//-----------------------------
	//	ATRIBUTOS
	//-----------------------------

	public static final int INFINITO = Integer.MAX_VALUE;

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
	 * @param verticeInicial El vertice desde el cual se quiere hallar los costos minimos
	 * @return grafo con los vertices
	 */
	public int[][] FloydWarschallAlgoritmo(int[][] matrizDeAdj)
	{
		System.out.println("Entro al algoritmo" );

		int numVertices = matrizDeAdj.length;

		int[][] m = new int[numVertices][numVertices]; //inicializar(matrizDeAdj, numVertices);

		int i=0;
		int j=0;
		int k=0;

		//		for (int i = 0; i < numVertices; i++) {
		//
		//			for (int j = 0; j < numVertices; j++) {

		while (k<numVertices) {

			System.out.println("ITERACIOOOOOOON K ES Y ESTA EN "+k);
			if(k==0) {

				if (matrizDeAdj[i][j] == -1) {
					m[i][j] = 0;
				}
				else {

					m[i][j] = matrizDeAdj[i][j];
				}
				System.out.println("1: "+m[i][j] );

			}
			else if(k>0 && i!=k && j!=k){
				m[i][j]= Math.min(Math.min(m[i][j], m[i][k]) , m[k][j]);

				System.out.println("2: "+m[i][j] );
			}
			else if(k>0 && (i==k ||j==k)) {
				
				System.out.println("ENTRO AQUI: "+ +m[i][j] );
			}



			if(j<numVertices-1 ) {
				j++;

			}
			else if(j== numVertices-1 && i< numVertices-1) {
				i++;
				j=0;
			}
			else if(j== numVertices-1 && i==numVertices-1) {
				i=0;
				j=0;
				k++;
			}
			System.out.println("i: "+i );
			System.out.println("j: "+j );
			System.out.println("k: "+k );

			System.out.println("\n" );


		}	
		//			}
		//		}

		return m;
	}




	/**
	 * Metodo que imprime las distancias mas cortas desde un vertice origen hasta todos los vertices.
	 * @param g grafo 
	 * @param num_Vertices numero de vertices del grafo
	 * @param ini Indice del grafo origen
	 */
	public void Imprimir(int[][]  m , int V)   { 

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {

				System.out.println("La Distancia desde: ("+i+") Hasta: ("+ j + ") es de: " + m[i][j]); 
			}
		}



	}



	public int[][] inicializar(int[][] matrizDeAdj, int V){

		int[][] m = new int[V][V];


		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {

				if (matrizDeAdj[i][j] == -1) {
					m[i][j] = INFINITO;
				}
				else {

					m[i][j] = matrizDeAdj[i][j];
				}
			}
		}
		return m;
	}



}
