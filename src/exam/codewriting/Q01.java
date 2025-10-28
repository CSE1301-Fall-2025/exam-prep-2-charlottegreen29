package exam.codewriting;

import edu.princeton.cs.introcs.StdDraw;

public class Q01 {

	// I did the rest of the exam 2 packet in here to check my work

	public static String select (String[] values, int location, int count){
		System.out.println(values[location]);
		int next = 3*location+1;
		if(location%2==0){
			next = location/2;
		}
		if (location==1 || count==0){
			return values[location-1];
		}
		else {
			return select(values,next,count-1);
		}
	}

	public static void main(String[] args){
		String[] val1 = {"E","T","I","D","R","G","A"};
		System.out.println(select(val1,1,1));
		System.out.println(select(val1,4,4));
		System.out.println();
		int[][] a = {{1,2,4},{3,4,1},{1,7,7}};
		int[] b = countValues(a,1);
		for (int val : b){
			System.out.print(val + " ");
		}
	}

	public static int[] countValues(int[][] a, int findMe){
		int[] countedValues = new int[a.length];
		for (int r=0; r<a.length; r++){
			for (int c=0; c<a[0].length; c++){
				if (a[r][c]==findMe){
					countedValues[c]++;
				}
			}
		}
		return countedValues;
	}

	// public static void recursiveCarpet ( double xCtr , double yCtr , double halfLength ) {
	// 	//your code here
	// }

	// public static void main(String[] args) {
	// 	//Your task is to complete the above method to draw the image
	// 	//shown in "image01.png" in the images folder.

	// 	//Your solution must use recursion

	// 	double halfCarpetLength = 0.25 ;
	// 	recursiveCarpet ( 0.5 , 0.5 , halfCarpetLength ) ;
	// }

}
