package Parte2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parte2 {

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
			hallarComponentesConectados(matrizAdyacencia);}
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
			for(int k=0;k<j;k++) //basta con leer la diagonal inferior de la matriz porque es simétrica -> a[i][j] = a[j][i]
			{
				matriz[j][k]=Integer.parseInt(values[k]);
				matriz[k][j]=matriz[j][k];
			}
		}
		br.close();

		return matriz;
	}

	private static void hallarComponentesConectados(int[][] matrizAdyacencia) {
		// TODO Auto-generated method stub
		
	}


}
