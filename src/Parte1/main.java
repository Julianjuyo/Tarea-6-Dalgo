package Parte1;

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

	public final static String grafoDistancias5 = "./data/distances5.txt";
	public final static String grafoDistancias100 = "./data/distances100.txt";
	public final static String grafoDistancias1000 = "./data/distances1000.txt";

	private static Scanner in;


	public static void main(String[] args) 
	{
		run();
	}


	public static void  run()
	{
		in = new Scanner(System.in);
		String archivo = null;

		//En esta parte se pregunta sobre el archivo que se desea cargar

		System.out.println(" Que archivo desea cargar"+ "\n"
				+ "1. grafoDistancias5"+ "\n"
				+ "2. grafoDistancias100"+ "\n");

		String ACargar = in.next();
		
		if (ACargar.equals("grafoDistancias5") || ACargar.equals("1"))
		{
			archivo = grafoDistancias5;
		}
		else if (ACargar.equals("grafoDistancias100")|| ACargar.equals("2"))
		{
			archivo = grafoDistancias100;
		}
		else if (ACargar.equals("grafoDistancias1000")|| ACargar.equals("3"))
		{
			archivo = grafoDistancias100;
		}

		try {
			
			System.out.println("hola3");
			cargarArchivo(archivo);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}


		//Se pregunta repespecto a el algoritmo a ejecutar
		System.out.println("Que algoritmo desea Implementar (escriba el numero)"+ "\n"
				+ "1. Dijkstra"+ "\n"
				+ "2. Bellman Ford"+ "\n"
				+ "3. Floyd Warschall"+ "\n");
		
		ACargar = in.next();
		
		if (ACargar.equals("Dijkstra") || ACargar.equals("1"))
		{

		}
		else if (ACargar.equals("Bellman Ford")|| ACargar.equals("2"))
		{

		}
		if (ACargar.equals("Floyd Warschall")|| ACargar.equals("3"))
		{

		}

	}

	/**
	 * Este metodo cargar el archivo seleccionado
	 * 
	 * @param nombreArchivo
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static int [][] cargarArchivo( String nombreArchivo) throws FileNotFoundException, IOException{

		System.out.println(nombreArchivo);
		
		try (FileReader reader = new FileReader(nombreArchivo);

				
			BufferedReader in = new BufferedReader(reader)) 
			{
				String line = in.readLine();
				String [] items = line.split("\t");
				int fila = Integer.parseInt(items[0]);
				int columna = Integer.parseInt(items[1]);
				int [][] grafo = new int [fila][columna];
				line = in.readLine();
				
				
				for(int i=0;line!=null;i++) {
					items = line.split("\t| ");
					for(int j=0;j<items.length;j++) grafo[i][j] = Integer.parseInt(items[j]);
					line = in.readLine();
				}
				
				return grafo;
			}	
	}

}
