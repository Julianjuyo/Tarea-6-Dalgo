package Parte1;

import java.util.ArrayList;
import java.util.Comparator;

import Parte1.Dijsktra.Vertice;

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

		int numVertices = matrizDeAdj.length;


		crearEInicializarGrafo(numVertices, verticeInicial);
		int numeroEjes = numeroEdjes(matrizDeAdj);
		System.out.println(numeroEjes);


		for (int i = 0; i < numVertices-1; i++) {

			for (int edje = 0; edje < numVertices; edje++) {

				int valorEdje = matrizDeAdj[i][edje];

				//System.out.println(valorEdje);
				
				if(valorEdje!=0 && valorEdje!=-1) {

					Vertice uVertice = grafo.get(i);
					Vertice vVertice = grafo.get(edje);

					int nuevaMasCorta = valorEdje + uVertice.getRutaMasCorta();

					if ( vVertice.getRutaMasCorta() > nuevaMasCorta ) {

						vVertice.setRutaMasCorta(nuevaMasCorta);
						vVertice.setVerticePredecesor(uVertice);
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

						System.out.println(valorEdje);
						System.out.println(uVertice.ID);
						System.out.println(vVertice.ID);
						System.out.println("ERROR HAY CLICO");
					}
				}

			}
		}
		return grafo;
	}



	/**
	 * 
	 * @param matrizDeAdj
	 * @return
	 */
	public int numeroEdjes(int[][] matrizDeAdj)
	{
		int resp=0;
		for (int i = 0; i < matrizDeAdj.length; i++) {
			for (int j = 0; j < matrizDeAdj.length; j++) {

				if(matrizDeAdj[i][j]!=0 && matrizDeAdj[i][j]!=-1) {

					
					resp++;
				}
			}
		}
		return resp;
	}





	/**
	 * Metodo que imprime las distancias mas cortas desde un vertice origen hasta todos los vertices.
	 * @param g grafo 
	 * @param num_Vertices numero de vertices del grafo
	 * @param ini Indice del grafo origen
	 */
	public void Imprimir(ArrayList<Vertice> g,int num_Vertices , int ini)   { 
		for (int i = 0; i < num_Vertices; i++) 
			System.out.println("La Distancia desde: ("+ini+") Hasta: ("+ i + ") es de: " + g.get(i).getRutaMasCorta()); 
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
