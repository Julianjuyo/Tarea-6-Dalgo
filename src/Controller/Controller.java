package Controller;


import java.util.Scanner;
import Parte1.*;
import main.MVC;
import Parte2.*;
import Parte3.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Controller {

	public final static String GRAFO_DISTANCIA_5 = "./data/distances5.txt";
	public final static String GRAFO_DISTANCIA_100 = "./data/distances100.txt";
	public final static String GRAFO_DISTANCIA_1000 = "./data/distances1000.txt";

	private  Dijkstra dijkstra;
	private BellmanFord bellmanFord;
	private FloydWarschall floydWarschall;

	public Controller ()
	{
		dijkstra = new Dijkstra();
		bellmanFord = new BellmanFord();
		floydWarschall = new FloydWarschall();
	}




	public void  run()
	{
		int[][] grafo5 = null;
		int[][] grafo100 = null;
		int[][] grafo1000 = null;


		try {
			System.out.println("Cargando los grafos");

			grafo5 = cargarArchivo(GRAFO_DISTANCIA_5,5);
			grafo100 = cargarArchivo(GRAFO_DISTANCIA_100,100);
			grafo1000 = cargarArchivo(GRAFO_DISTANCIA_1000,1000);
			System.out.println("\n");

			//			System.out.println("grafofinal5"+grafo5[1][0]); //90
			//			System.out.println("grafofinal5"+grafo5[4][3]); // 36
			//			System.out.println("grafofinal100"+grafo100[1][0]); //12
			//			System.out.println("grafofinal100"+grafo100[99][98]); // 81
			//			System.out.println("grafofinal1000"+grafo1000[2][0]); // 53
			//			System.out.println("grafofinal1000"+grafo1000[999][998]); //99

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int verticeInicial;
		int Verticedestino;
		int NoVertices;
		long TInicio, TFin, tiempo; 

		while(!fin) {

			menu();

			int option = lector.nextInt();
			switch(option){

			case 1:	
				System.out.println("Implementando el algoritmo de Dijkstra \n");

				System.out.println("Seleccione el vertice Origen");
				verticeInicial = 1 ;//Integer.parseInt(lector.next());

				System.out.println("Seleccione el vertice Destino");
				Verticedestino = 2;// Integer.parseInt(lector.next());


				System.out.println("Que grafo desea utilizar (escribir 1 o 2 o 3) \n 1. Grafo con 5 vertices1 \n 2. grafo con 100 vertices \n 3. Grafo con 1000 vertices");

				NoVertices = 1; //Integer.parseInt(lector.next());


				TInicio = System.currentTimeMillis();

				if(NoVertices==1) {
					dijkstra.DijkstraAlgoritmo(grafo5, verticeInicial, Verticedestino);	
				}
				else if(NoVertices==2) {
					dijkstra.DijkstraAlgoritmo(grafo100, verticeInicial, Verticedestino);	
				}
				else if(NoVertices==3) {
					dijkstra.DijkstraAlgoritmo(grafo1000, verticeInicial, Verticedestino);	
				}

				TFin = System.currentTimeMillis(); 
				tiempo = TFin - TInicio;
				System.out.println("El tiempo que tardo el algoritmo fue de: "+tiempo+"milisegundos");	



				System.out.println("------------------------------------------------------------------------------- \n");
				break;


			case 2:
				System.out.println("Implementando el algoritmo de Bellman Ford");

				System.out.println("Seleccione el vertice Origen");
				verticeInicial = Integer.parseInt(lector.next());

				System.out.println("Seleccione el vertice Destino");
				Verticedestino = Integer.parseInt(lector.next());


				System.out.println("Que grafo desea utilizar (escribir 1 o 2 o 3) \n 1. Grafo con 5 vertices1 \n 2. grafo con 100 vertices \n 3. Grafo con 1000 vertices");

				NoVertices = Integer.parseInt(lector.next());



				TInicio = System.currentTimeMillis();

				if(NoVertices==1) {
					bellmanFord.BellmanFordAlgoritmo(grafo5, verticeInicial, Verticedestino);	
				}
				else if(NoVertices==2) {
					bellmanFord.BellmanFordAlgoritmo(grafo100, verticeInicial, Verticedestino);					
				}
				else if(NoVertices==3) {
					bellmanFord.BellmanFordAlgoritmo(grafo1000, verticeInicial, Verticedestino);					
				}

				TFin = System.currentTimeMillis(); 
				tiempo = TFin - TInicio;
				System.out.println("El tiempo que tardo el algoritmo fue de: "+tiempo+"milisegundos");	

				System.out.println("------------------------------------------------------------------------------- \n");
				break;


			case 3:
				System.out.println("Implementando el algoritmo de Floyd Warschall");

				System.out.println("Seleccione el vertice Origen");
				verticeInicial = Integer.parseInt(lector.next());

				System.out.println("Seleccione el vertice Destino");
				Verticedestino = Integer.parseInt(lector.next());


				System.out.println("Que grafo desea utilizar (escribir 1 o 2 o 3) \n 1. Grafo con 5 vertices1 \n 2. grafo con 100 vertices \n 3. Grafo con 1000 vertices");

				NoVertices = Integer.parseInt(lector.next());


				TInicio = System.currentTimeMillis();

				if(NoVertices==1) {
					floydWarschall.FloydWarschallAlgoritmo(grafo5);	
				}
				else if(NoVertices==2) {
					floydWarschall.FloydWarschallAlgoritmo(grafo100);	
				}
				else if(NoVertices==3) {
					floydWarschall.FloydWarschallAlgoritmo(grafo1000);	
				}

				TFin = System.currentTimeMillis(); 
				tiempo = TFin - TInicio;
				System.out.println("El tiempo que tardo el algoritmo fue de: "+tiempo+"milisegundos");	


				System.out.println("------------------------------------------------------------------------------- \n");
				break;


			case 4:
				System.out.println("Implementando el algoritmo de BFS");

				System.out.println("------------------------------------------------------------------------------- \n");
				break;


			case 5:
				System.out.println("Implementando el algoritmo de DFS");

				System.out.println("------------------------------------------------------------------------------- \n");
				break;

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------" + "\n");
				break;

			}
		}
	}





	/**
	 * Este metodo  lee y carga el archivo seleccionado creando un grafo
	 * 
	 * @param nombreArchivo
	 * @return Retorna un grafo de tamano especificado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int[][] cargarArchivo( String nombreArchivo, int tamano) throws FileNotFoundException, IOException{

		System.out.println(nombreArchivo);

		int [][] grafo = new int [tamano][tamano];
		int j=0;

		try (FileReader reader = new FileReader(nombreArchivo);	
				BufferedReader in = new BufferedReader(reader)) 
		{

			String line = in.readLine();	
			while (line !=null)
			{
				//System.out.println("1."+line);			
				String [] items = line.split("\t");

				for (int i = 0; i < tamano; i++) {
					int valor = Integer.parseInt(items[i]);
					grafo[i][j]= valor;
					//System.out.println("grafo"+grafo[i][j]);
				}
				line = in.readLine();
				j++;
			}
			return grafo;
		}	
	}

	public void menu() {
		System.out.println("Que algoritmo desea Implementar (escriba el numero)"+ "\n"
				+ "1. Dijkstra"+ "\n"
				+ "2. Bellman Ford"+ "\n"
				+ "3. Floyd Warschall"+ "\n"
				+ "4. BFS"+ "\n"
				+ "5. DFS"+ "\n");

	}





}
