package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class BinarySearch {	
	

	public static void main (String [] args) throws NumberFormatException, IOException {
		long TInicio, TFin, tiempo;
		TInicio = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());		
		String[]firstarray = br.readLine().split(" ");
		int m = Integer.parseInt(br.readLine());
		int[] array = new int[firstarray.length];		
		for(int i=0; i<firstarray.length; i++) {
			array[i] = Integer.parseInt(firstarray[i]);
		}
		for(int i=0; i<array.length-1; i++) {
			for(int j=0; j<array.length-1-i; j++) {
				if(array[j]>array[j+1]) {
					int temp = 0;
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					}
				}
			}
		int pos1 = -1;
		int pos2 = -1;
		List <Integer> solutions = new ArrayList<Integer>();
		for(int i=0; i<array.length-1; i++) {
			for(int j=array.length-1; j>=i; j--) {
			if(array[i]+array[j]==m) {
				pos1=array[i];
				solutions.add(pos1);
				pos2=array[j];
				solutions.add(pos2);
				}
			}
		}
		int book1 = solutions.get(0);
		int book2 = solutions.get(1);
		for(int i=0; i<solutions.size()-1; i+=2) {
			if((solutions.get(i+1)-(solutions.get(i))<(book2-book1))){
				book1 = solutions.get(i);
				book2 = solutions.get(i+1);				
			}
			
		}
		TFin = System.currentTimeMillis();
		tiempo = TFin - TInicio;
		System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
		
		bw.newLine();
		bw.write("Peter should buy books whose prices are "+book1+" and "+book2+".\n");
		
		br.close();
		bw.close();
		}
	
		
		
}


