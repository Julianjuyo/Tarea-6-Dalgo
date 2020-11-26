package Parte1;

import java.util.*;


public class Dijsktra {

	
	//-----------------------------
	//	METODO AUXILIAR
	//-----------------------------
	/**
	 * METODO que hace referencia a un vertice del grafo
	 * @author julianoliveros
	 *
	 */
	class Vertice implements Comparator<Vertice> {

		private int ID;
		private Integer rutaMasCorta;
		private Vertice verticePredecesor;

		public  Vertice() {
			this.setID(0);
			this.rutaMasCorta = 0;
			this.verticePredecesor = null;

		}

		public int getRutaMasCorta() {
			return rutaMasCorta;
		}
		public void setRutaMasCorta(int rutaMasCorta) {
			this.rutaMasCorta = rutaMasCorta;
		}

		public Vertice getVerticePredecesor() {
			return verticePredecesor;
		}
		public void setVerticePredecesor(Vertice verticePredecesor) {
			this.verticePredecesor = verticePredecesor;
		}
		private int getID() {
			return ID;
		}

		private void setID(int iD) {
			ID = iD;
		}
		@Override
		public int compare(Vertice node1, Vertice node2) 
		{ 
			if (node1.rutaMasCorta < node2.rutaMasCorta) 
				return -1; 
			if (node1.rutaMasCorta > node2.rutaMasCorta) 
				return 1; 
			return 0; 
		}
	}
	
	
	//-----------------------------
	//	ATRIBUTOS
	//-----------------------------

	public static final int INFINITO = Integer.MAX_VALUE;

	private ArrayList<Vertice> grafo ; // grafo que contiene los vertices
	private Boolean[] S; // Arreglo que contiene los vertices ya marcados
	//private PriorityQueue<Vertice> minPQ;

	
	//-----------------------------
	//	METODOS
	//-----------------------------

	/**
	 * Metodo que Inicializa el grafo 
	 */
	public Dijsktra() {
		setGrafo(new ArrayList<Vertice>());

	}


	/**
	 * MEtodo que encuentra los caminos de costo minimo utilizando el algoritmo de Djisktra
	 * @param matrizDeAdj matriz que tiene los ejes
	 * @param verticeInicial El vertice desde el cual se quiere hallar los costos minimos
	 * @return grafo con los vertices
	 */
	public ArrayList<Vertice>  DijkstraAlgoritmo(int[][] matrizDeAdj, int verticeInicial)
	{
		System.out.println("Entro al algoritmo" );
		setGrafo(new ArrayList<Vertice>());
		
		int numVertices = matrizDeAdj.length;
		S = new Boolean[numVertices]; 

		crearEInicializarGrafo(numVertices, verticeInicial);


		//For que recorre las filas del grafo
		for (int cuenta = 0; cuenta < numVertices-1; cuenta++) {

			int u = DistanciaMinima(S, numVertices);
			S[u]= true;


			//for que busca dentro de los vertices para buscar aquellos adjacentes de  u.
			for (int j = 0; j < numVertices ; j++) { 

				//Se verifica que no este marcado, Que haya un eje entre los dos vertices y que la ruta mas corta no sea infinito
				if(!S[j] && matrizDeAdj[u][j] > 0 & grafo.get(u).getRutaMasCorta()!=INFINITO) {

					Vertice uVertice = grafo.get(u);
					Vertice vVertice = grafo.get(j);

					//Verifica si la nueva ruta tiene un menor costo a la actual
					if(uVertice.getRutaMasCorta()+ matrizDeAdj[u][j]< vVertice.getRutaMasCorta()) {

						//Asigna la nueva ruta mas corta para llegar a dicho vertice
						vVertice.setRutaMasCorta(uVertice.getRutaMasCorta()+ matrizDeAdj[u][j]);
						
						//Asigna a el prodecesor de la ruta
						vVertice.setVerticePredecesor(uVertice);
					}
				}
			}	
		}		
		return grafo;
	}



	/**
	 * Metodo que fucniona como una cola de prioridad en donde se busca el eje con menor costo
	 * @param S Arreglo que indica si un vertice ay fue visitado
	 * @param numvertices numero de vertices
	 * @return retorna el costo del indice con menor costo
	 */
	public int DistanciaMinima( Boolean S[], int numvertices){
		
		int min = Integer.MAX_VALUE; 
		int indiceDelMenor = -1; 
		
		for (int j = 0; j < numvertices; j++){

			Vertice vVertice = grafo.get(j);

			if (S[j] == false && vVertice.rutaMasCorta <= min) { 
				min = vVertice.rutaMasCorta; 
				indiceDelMenor = j; 
			} 
		}
		return indiceDelMenor;
	} 



	/**
	 * Metodo que imprime las distancias mas cortas desde un vertice origen hasta todos los vertices.
	 * @param g grafo 
	 * @param num_Vertices numero de vertices del grafo
	 * @param ini Indice del grafo origen
	 */
	public void Imprimir(ArrayList<Vertice> g,int num_Vertices , int ini)   { 
		for (int i = 0; i < num_Vertices; i++) 
			
			if(g.get(i).getRutaMasCorta()==INFINITO) {
				System.out.println("\n"+"!!!!!!!!!!");
				System.out.println("ERROR NO SE PUEDE LLEGAR A EL VERTICE ("+ i + ") DESDE EL VERTICE 0 ("+ini+")"); 
				System.out.println("!!!!!!!!!!");
			}
			else {
				System.out.println("La Distancia desde: ("+ini+") Hasta: ("+ i + ") es de: " + g.get(i).getRutaMasCorta()); 	
			}
	}



	/**
	 * Metodo en el cual se crean los vertices del grafo, ademas se inicializan sus valores para poder implementar Dijsktra
	 * Le asigna al vertice inicial una distancia de 0
	 * 
	 * @param numeroVertices
	 * @param verticeInicial
	 */
	public void crearEInicializarGrafo(int numeroVertices, int verticeInicial) {

		for (int i = 0; i < numeroVertices; i++) {

			Vertice actual = new Vertice();
			actual.setID(i);
			actual.setRutaMasCorta(INFINITO);
			actual.setVerticePredecesor(null);
			getGrafo().add(actual);
			S[i]= false;
		}
		getGrafo().get(verticeInicial).setRutaMasCorta(0);

	}


	/**
	 * Metodo que retorna el grafo
	 * @return retorna el grafo
	 */
	public ArrayList<Vertice> getGrafo() {
		return grafo;
	}

	/**
	 * Metodo que asigna un grafo
	 * @param grafo
	 */
	public void setGrafo(ArrayList<Vertice> grafo) {
		this.grafo = grafo;
	}



}
