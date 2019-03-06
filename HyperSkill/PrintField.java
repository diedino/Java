public class PrintField {
    public static void main(String[] args) {
        char[][] matrix = new char[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i%2==0)
                    matrix[i][j]='X';
                else
                    matrix[i][j]='O';
            }
        }
        printField(matrix);
    }
    public static void printField(char[][] matrix){
        for (int i=0; i<matrix.length; i++) {
            for(int j=0; j< matrix[i].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
        System.out.println();
        }
    }
}
