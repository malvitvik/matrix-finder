import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int[][] matrix = getSortedMatrix(6, 6);
		MatrixFinder matrixFinder = new MatrixFinder(matrix);
		
		System.out.println(matrixFinder.find(44));
		System.out.println(matrixFinder.find(matrix[3][5]));
		System.out.println(matrixFinder.find2(44));
		System.out.println(matrixFinder.find2(matrix[3][5]));
	}


	private static int[][] getSortedMatrix(int lenX, int lenY) {
		Set<Integer> set = new HashSet<>();
		Random randomGenerator = new Random();
		int length = lenX * lenY;

		while (set.size() != length) {
			int next = randomGenerator.nextInt(length * 2) + 1;// +1 ensure a number in {1,2,3}
			set.add(next);
		}
		
		int[][] values = new int[lenX][lenY];
		Integer[] array = new Integer[length];
		array = set.toArray(array);
		Arrays.sort(array);
		
		for(int j = 0; j < lenX; j++) {
			for(int i = 0; i < lenY; i++)
			{
				values[j][i] = array[j * lenY + i];
			}
		}
		
		return values;
	}

}