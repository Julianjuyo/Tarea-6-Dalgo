package Parte1;

import java.util.ArrayList;
import java.util.Comparator;



public class BellmanFord {

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



	//-----------------------------
	//	METODOS
	//-----------------------------

	/**
	 * Metodo que Inicializa el grafo 
	 */
	public BellmanFord() {
		setGrafo(new ArrayList<Vertice>());

	}


	/**
	 * MEtodo que encuentra los caminos de costo minimo utilizando el algoritmo de Bellman Ford
	 * @param matrizDeAdj matriz que tiene los ejes
	 * @param verticeInicial El vertice desde el cual se quiere hallar los costos minimos
	 * @return grafo con los vertices
	 */
	public ArrayList<Vertice>  BellmanFordAlgoritmo(int[][] matrizDeAdj, int verticeInicial)
	{
		System.out.println("Entro al algoritmo" );


		setGrafo(new ArrayList<Vertice>());
		int numVertices = matrizDeAdj.length;

		crearEInicializarGrafo(numVertices, verticeInicial);




		for (int i = 0; i < numVertices; i++) {

			Vertice uVertice =null;

			if (i==0) {
				uVertice = grafo.get(verticeInicial);				
				//				System.out.println("1 "+ i);
				//				System.out.println("1 "+ uVertice.rutaMasCorta);
			}
			else if (verticeInicial==i){
				uVertice = grafo.get(0);
				//				System.out.println("2 "+ i);
				//				System.out.println("2 "+ uVertice.rutaMasCorta);
			}
			else {
				uVertice = grafo.get(i);
				//				System.out.println("3 "+ i);
				//				System.out.println("3 "+ uVertice.rutaMasCorta);
			}


			if (uVertice.getRutaMasCorta()!=INFINITO) {

				//				System.out.println("Entro a "+ uVertice.getID());
				//				System.out.println(uVertice.getRutaMasCorta());


				for (int edje = 0; edje < numVertices; edje++) {

					int valorEdje = matrizDeAdj[uVertice.getID()][edje];

					//					System.out.println("\n"+ "POSICION i "+ uVertice.getID());
					//					System.out.println("POSICION edje "+ edje);
					//					System.out.println("VAlor del eje "+ valorEdje);

					if(valorEdje!=0 && valorEdje!=-1) {

						Vertice vVertice = grafo.get(edje);

						int nuevaMasCorta = valorEdje + uVertice.getRutaMasCorta();

						//						System.out.println("RUTA actual"+ vVertice.getRutaMasCorta());
						//						System.out.println("RUTA NUEVA"+ nuevaMasCorta);

						if ( vVertice.getRutaMasCorta() > nuevaMasCorta ) {

							vVertice.setRutaMasCorta(nuevaMasCorta);
							vVertice.setVerticePredecesor(uVertice);
							//							System.out.println("RUTA ACTUALIZADA"+ vVertice.getRutaMasCorta());
							//							System.out.println("PREDECESOR "+ vVertice.getVerticePredecesor().ID+"\n");
						}	
					}
				}
			}

		}


		for (int i = 0; i < matrizDeAdj.length; i++) {

			for (int j = 0; j < matrizDeAdj.length; j++) {

				int valorEdje = matrizDeAdj[i][j];

				if(valorEdje!=0 && valorEdje!=-1) {


					Vertice uVertice = grafo.get(i);
					Vertice vVertice = grafo.get(j);


					int nuevaMasCorta = valorEdje + uVertice.getRutaMasCorta();

					if ( vVertice.getRutaMasCorta() > nuevaMasCorta && vVertice.getVerticePredecesor()==uVertice ) {

						//						System.out.println(valorEdje);
						//						System.out.println(uVertice.ID);
						//						System.out.println(vVertice.ID);
						//						System.out.println("ERROR HAY CLICO");
					}
				}

			}
		}
		return grafo;
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
				System.out.println("ERROR NO SE PUEDE LLEGAR A EL VERTICE ("+ i + ") DESDE EL VERTICE ("+ini+")"); 
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