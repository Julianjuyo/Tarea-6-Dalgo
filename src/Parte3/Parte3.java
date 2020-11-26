package Parte3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Parte3 {

	public static void main(String[] args) {
		String  path = args[0]; // ruta al archivo ingresa por argumentos del programa.
		int[][] matrizAdyacencia = null;
		try {
			matrizAdyacencia = cargarMatriz(path);
		}
		catch(FileNotFoundException e) {System.out.println("archivo "+args[0]+" no encontrado");} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(matrizAdyacencia!=null) {

			for(Integer i :ordenTopologico(matrizAdyacencia))
			{
				System.out.println(i); // imprime el orden topológico del grafo, si imprime un repetido es un ciclo.
			}
		}
		else {
			System.out.println("No se cargó la matriz correctamente");
		}
	}

	private static Stack<Integer> ordenTopologico(int[][] matrizAdyacencia) {
		Stack<Integer> ordenTopologico = new Stack<>(); //orden topológico del grafo
		boolean[] marcados = new boolean[matrizAdyacencia.length]; // Los verices por los que yá pasé
		boolean[] enEjecucion = new boolean[matrizAdyacencia.length]; // Los vértices que tienen un llamado recursivo en curso
		boolean ciclo = false; //solo se usa para imprimir "hay ciclo" u "orden topológico" como título según sea el caso
		for(int i =0;i<matrizAdyacencia.length;i++)
		{
			if(!marcados[i]) //si no he pasado por ahí
			{
				try {
					dfs(marcados,ordenTopologico,matrizAdyacencia,i,enEjecucion);//Haga DFS sobre el vértice
				} catch (Exception e) { //Excepción si hay un ciclo
					System.out.println(e.getMessage());
					ciclo=true;
					break;
				} 
			}
		}
		if (!ciclo)
		System.out.println("El orden topológico es ");
		return ordenTopologico;
	}

	private static void dfs(boolean[] marcados,Stack<Integer> ordenTopologico,int[][] matrizAdyacencia, int i,boolean[] ejecucion) throws Exception {

		marcados[i]=true; //marcar que ya pasé por yo mismo
		ejecucion[i]=true; //estoy haciendo DFS en este momento
		for(int j =0;j<matrizAdyacencia[i].length;j++) //para cada adyacente
		{
			if(matrizAdyacencia[i][j] != -1 && i!=j)
			{
				if(marcados[j] && ejecucion[j])//mi adyacente es un vertice sobre el que ya llamé dfs y no ha terminado -> hallé un ciclo
				{
					ordenTopologico.push(j);
					ordenTopologico.push(i);//pongo el repetido en la pila por convención, facilita ver el recorrido del ciclo.
					throw new Exception("Se encontró un ciclo en el grafo"); // termino la ejecución puesto que encontré un ciclo
				}
				else if (!marcados[j])
				{
					dfs(marcados,ordenTopologico,matrizAdyacencia,j,ejecucion);
				}
			}
		}
		ejecucion[i]=false;//termine DFS
		ordenTopologico.push(i);
	}

	private static int[][] cargarMatriz(String path) throws IOException,FileNotFoundException {

		BufferedReader br = new BufferedReader(new FileReader(path));
		br.mark(1000000); //el tamaño máximo de la matriz es de 500000
		int i = br.readLine().split("\t").length;//sacar el tamaño a partir de la primera línea
		br.reset(); // reiniciar el reader para cargar la matriz completa
		String linea;
		int[][] matriz = new int[i][i];
		for(int j=0;(linea = br.readLine())!=null;j++) //el índice j es necesario para cargar la matriz
		{
			String[] values = linea.split("\t");
			for(int k=0;k<i;k++)
			{
				matriz[j][k]=Integer.parseInt(values[k]);
			}
		}
		br.close();
		return matriz;
	}
}
