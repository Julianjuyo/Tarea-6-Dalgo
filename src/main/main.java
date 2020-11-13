package main;


import java.util.Scanner;
import Parte1.Dijkstra;
import Parte1.BellmanFord;
import Parte1.FloydWarschall;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {

	public final static String GRAFO_DISTANCIA_5 = "./data/distances5.txt";
	public final static String GRAFO_DISTANCIA_100 = "./data/distances100.txt";
	public final static String GRAFO_DISTANCIA_1000 = "./data/distances1000.txt";

	private static Scanner in;


	public static void main(String[] args) 
	{
		run();
	}


	public static void  run()
	{
		//		in = new Scanner(System.in);
		//		
		//		
		//		
		//		//En esta parte se pregunta sobre el archivo que se desea cargar
		//
		//		System.out.println(" Que archivo desea cargar"+ "\n"
		//				+ "1. grafoDistancias5"+ "\n"
		//				+ "2. grafoDistancias100"+ "\n");
		//
		//		String ACargar = in.next();
		//		
		//		
		//		if (ACargar.equals("grafoDistancias5") || ACargar.equals("1"))
		//		{
		//			
		//		}
		//		else if (ACargar.equals("grafoDistancias100")|| ACargar.equals("2"))
		//		{
		//			archivo = grafoDistancias100;
		//		}
		//		else if (ACargar.equals("grafoDistancias1000")|| ACargar.equals("3"))
		//		{
		//			archivo = grafoDistancias100;
		//		}

		int[][] grafo5;
		int[][] grafo100;
		int[][] grafo1000;
		

		try {
			System.out.println("hola3");
			grafo5 = cargarArchivo(GRAFO_DISTANCIA_5,5);
			grafo100 = cargarArchivo(GRAFO_DISTANCIA_100,100);
			grafo1000 = cargarArchivo(GRAFO_DISTANCIA_1000,1000);

			System.out.println("grafofinal5"+grafo5[1][0]); //90
			System.out.println("grafofinal5"+grafo5[4][3]); // 36
			
			System.out.println("grafofinal100"+grafo100[1][0]); //12
			System.out.println("grafofinal100"+grafo100[99][98]); // 81
			
			System.out.println("grafofinal1000"+grafo1000[2][0]); // 53
			System.out.println("grafofinal1000"+grafo1000[999][998]); //99

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		//		//Se pregunta repespecto a el algoritmo a ejecutar
		//		System.out.println("Que algoritmo desea Implementar (escriba el numero)"+ "\n"
		//				+ "1. Dijkstra"+ "\n"
		//				+ "2. Bellman Ford"+ "\n"
		//				+ "3. Floyd Warschall"+ "\n");
		//		
		//		ACargar = in.next();
		//		
		//		if (ACargar.equals("Dijkstra") || ACargar.equals("1"))
		//		{
		//
		//		}
		//		else if (ACargar.equals("Bellman Ford")|| ACargar.equals("2"))
		//		{
		//
		//		}
		//		if (ACargar.equals("Floyd Warschall")|| ACargar.equals("3"))
		//		{
		//
		//		}

	}

	/**
	 * Este metodo  lee y carga el archivo seleccionado creando un grafo
	 * 
	 * @param nombreArchivo
	 * @return Retorna un grafo de tamano especificado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static int[][]  cargarArchivo( String nombreArchivo, int tamano) throws FileNotFoundException, IOException{

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
	
	

}
