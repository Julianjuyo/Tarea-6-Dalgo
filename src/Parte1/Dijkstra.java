package Parte1;

import java.util.PriorityQueue;

import Estructuras.Graph;


public class Dijkstra {
	
	private Graph grafo;

	
	
	
	public Dijkstra( )
	{
		grafo = new Graph();	
	}
	
	
	public void DijkstraAlgoritmo(int[][] matrixAdjacencia, int verticeInicial, int Verticedestino )
	{
		grafo.crearEInicializarGrafo( matrixAdjacencia.length ,verticeInicial);
		
		
		
		System.out.println("Entro a Dijkstra");
		
	}
	
//	
//	public void Inicializar(int[][] matrixAdjacencia, int verticeInicial ) {
//		
//		int infinito = Integer.MAX_VALUE;
//		 
//		for (int i = 0; i < grafo.length; i++) {
//			
//			grafo[i][i]= infinito;
//            
//		}
//	}
	
}
