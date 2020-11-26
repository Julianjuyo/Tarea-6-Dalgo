package Parte2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parte2 {
	/**
	  * @author Camilo Rozo
	  */
	public static void main(String[] args) {
		String  path = args[0]; // ruta al archivo ingresa por argumentos del programa.
		int[][] matrizAdyacencia = null;
		try {
			matrizAdyacencia = cargarMatriz(path);
		}
		catch(FileNotFoundException e) {System.out.println("archivo /data/distances"+args[0]+".txt no encontrado");} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(matrizAdyacencia!=null) {
			for(int[] i:matrizAdyacencia)
			{
				for(int j:i)
				{
					System.out.append(j+"\t");
				}
				System.out.append("\n");
			}
			hallarComponentesConectados(matrizAdyacencia);}
		else {
			System.out.println("No se carg� la matriz correctamente");}
	}

	
	private static int[][] cargarMatriz(String path) throws IOException,FileNotFoundException {


		BufferedReader br = new BufferedReader(new FileReader(path));
		br.mark(1000000); //el tama�o m�ximo de la matriz es de 500000
		int i = br.readLine().split("\t").length;//sacar el tama�o a partir de la primera l�nea
		br.reset(); // reiniciar el reader para cargar la matriz completa
		String linea;
		int[][] matriz = new int[i][i];
		for(int j=0;(linea = br.readLine())!=null;j++) //el �ndice j es necesario para cargar la matriz
		{
			String[] values = linea.split("\t");
			for(int k=0;k<j;k++) //basta con leer la diagonal inferior de la matriz porque es sim�trica -> a[i][j] = a[j][i]
			{
				matriz[j][k]=Integer.parseInt(values[k]);
				matriz[k][j]=matriz[j][k];
			}
		}
		br.close();

		return matriz;
	}

	private static void hallarComponentesConectados(int[][] matrizAdyacencia) {
		
	}


}
