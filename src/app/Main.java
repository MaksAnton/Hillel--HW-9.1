package app;

public class Main {

    public static void main(String[] args) {
        // Declaring a 4x4 matrix
        int[][] matrix = {
                {23, 45, 12, 37},
                {50, 11, 42, 20},
                {33, 27, 19, 48},
                {8, 39, 6, 4}
        };

        // Matrix output
        System.out.println("Matrix 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "  \t");
            }
            System.out.println();
        }

        // Calculate sums of elements of even and odd strings
        int sumEvenRows = 0;
        int sumOddRows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                } else {
                    sumOddRows += matrix[i][j];
                }
            }
        }

        // Calculate products of elements of even and odd columns
        int productEvenCols = 1;
        int productOddCols = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    productEvenCols *= matrix[i][j];
                } else {
                    productOddCols *= matrix[i][j];
                }
            }
        }

        // Magic square test
        boolean isMagicSquare = true;
        int magicSum = 0;

        // Sum of the first line
        for (int j = 0; j < 4; j++) {
            magicSum += matrix[0][j];
        }

        // Checking the sums of rows
        for (int i = 1; i < 4; i++) {
            int rowSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                isMagicSquare = false;
                break;
            }
        }

        // Check column sums
        if (isMagicSquare) {
            for (int j = 0; j < 4; j++) {
                int colSum = 0;
                for (int i = 0; i < 4; i++) {
                    colSum += matrix[i][j];
                }
                if (colSum != magicSum) {
                    isMagicSquare = false;
                    break;
                }
            }
        }

        // Checking the sums of diagonals
        if (isMagicSquare) {
            int mainDiagSum = 0, secondaryDiagSum = 0;
            for (int i = 0; i < 4; i++) {
                mainDiagSum += matrix[i][i];
                secondaryDiagSum += matrix[i][3 - i];
            }
            if (mainDiagSum != magicSum || secondaryDiagSum != magicSum) {
                isMagicSquare = false;
            }
        }

        // Виведення результатів
        System.out.println("\nThe sum of the elements in even rows (row 0, 2): " + sumEvenRows);
        System.out.println("The sum of elements in odd lines (line 1, 3): " + sumOddRows);
        System.out.println("Product of elements in even columns (column 0, 2):" + productEvenCols);
        System.out.println("Product of elements in odd columns (column 1, 3): " + productOddCols);
        System.out.println("The matrix " + (isMagicSquare ? "is a magic square." : "is not a magic square."));
    }
}

