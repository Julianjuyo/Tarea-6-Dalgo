package Parte1;

import java.util.Scanner;
import Parte1.Dijkstra;
import Parte1.BellmanFord;
import Parte1.FloydWarschall;


public class main {

	private static Scanner in;

	
	public static void main(String[] args) 
	{
		run();
	}
	
	
	public static void  run()
	{
		in = new Scanner(System.in);
		
		System.out.println("Que algoritmo desea Implementar (escriba el numero)"+ "\n"
							+ "1. Dijkstra"+ "\n"
							+ "2. Bellman Ford"+ "\n"
							+ "3. Floyd Warschall"+ "\n");
		
		if (in.next().equals("Dijkstra") || in.next().equals("1"))
		{
			
		}
		else if (in.next().equals("Bellman Ford")|| in.next().equals("2"))
		{
			
		}
		if (in.next().equals("Floyd Warschall")|| in.next().equals("3"))
		{
			
		}
		
	}
	
}
