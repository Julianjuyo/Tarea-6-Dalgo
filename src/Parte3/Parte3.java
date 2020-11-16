package Parte3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parte3 {

	public static void main(String[] args) {
		int[][] matrizAdyacencia = null;
		try {
			matrizAdyacencia = cargarMatriz(Integer.parseInt(args[0]));
		}
		catch(FileNotFoundException e) {System.out.println("archivo /data/distances"+args[0]+".txt no encontrado");} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(matrizAdyacencia!=null) {
			System.out.println(determinarCicloEnGrafoMatriz(matrizAdyacencia));}
		else {
			System.out.println("No se cargó la matriz correctamente");}
	}

	private static int[][] cargarMatriz(Integer i) throws IOException,FileNotFoundException {


		BufferedReader br = new BufferedReader(new FileReader("/data/distances"+i+".txt"));
		String linea;
		int[][] matriz = new int[i][i];
		for(int j=0;(linea = br.readLine())!=null;j++)
		{
			String[] values = linea.split(" ");
			for(int k=0;k<i;k++)
			{
				matriz[j][k]=Integer.parseInt(values[k]);
			}
		}
		br.close();

		return matriz;
	}
	
	//TODO tener en cuenta que el grafo es dirigido
	private static boolean determinarCicloEnGrafoMatriz(int[][] matriz) {
		
		boolean[] marcados = new boolean[matriz.length];
		int visitados=0;//los nodos siempre seran 1, 2, 3 ... n
		for(int i = 0;visitados<matriz.length;)
		{		
			for(int j = 0;j<matriz.length;j++)
			{
				if(matriz[i][j]!=-1 && !marcados[i])
				{
					marcados[i]=true;
					visitados++;
					i=j;
				}
				else if(matriz[i][j]!=-1 && marcados[j])
				{
					return true;
				}
			}
			
		}
		return false;
	}
	
}
