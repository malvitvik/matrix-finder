import java.security.InvalidParameterException;
import java.util.Arrays;

public class MatrixFinder {
	
	private int[][] matrix;
	
	public MatrixFinder(int[][] matrix) {
		this.matrix = matrix;
		System.out.print("matrix = ");
		if (matrix.length == 0) {
			System.out.println("[]");
		} else {
			System.out.println();
			int length = matrix[0].length;
			for (int[] arr : matrix) {
				System.out.println(Arrays.toString(arr));
				
				if (arr.length != length) 
					throw new InvalidParameterException("Matrix should be rectangle");
			}
		}
	}
	
	public boolean find(int value) {
		System.out.println("Find " + value);
		int count = 0;
		if (matrix.length == 0 || matrix[0].length == 0) {
			System.out.println("count = " + count);
			return false;
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (value == matrix[i][j]) {
					System.out.println("count = " + count);
					return true;
				}
				count++;
			}
		}

		System.out.println("count = " + count);
		return false;
	}


	public boolean find2(int value) {
		System.out.println("Find " + value);
		int count = 0;
		if (matrix.length == 0 || matrix[0].length == 0) {
			System.out.println("count = " + count);
			return false;
		}
		
		int i = 0, j =  matrix[0].length - 1;

		while (i < matrix.length && j >= 0) {
			int matrixValue = matrix[i][j];
			if (value == matrixValue) {
				System.out.println("count = " + count);
				return true;
			}
			count++;
			
			if (value < matrixValue) {
				j--;
			} else {
				i++;
			}

		}

		System.out.println("count = " + count);
		return false;
	}
}
