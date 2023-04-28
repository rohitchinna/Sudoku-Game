class SudokuSolver{

    static int N = 9;

    static boolean isValid(int[][] mat, int row, int col, int num){
        for(int i=0;i<N;i++){
            if(mat[row][i] == num)
                return false;
            if(mat[i][col] == num)
                return false;
            if(mat[3 * (row/3) + i/3][3  *(col/3) + i % 3] == num)
                return false;
        }
        return true;
        
    }

    static boolean SolveSudoku(int[][] mat){
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++){

                if(mat[i][j] == 0){
                
                    for(int num = 1 ; num <= N; num++){
                        if(isValid(mat, i,j,num)){
                            mat[i][j] = num;
                            if(SolveSudoku(mat))
                                return true;
                            else
                                mat[i][j] = 0;
                        }
                    }   
                    return false;
                }
            }
        }
        return true;
    }

    static void printMat(int[][] mat){
        for(int i =0;i<N;i++){
            for(int j = 0;j<N;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] mat ={{ 0, 0, 5, 0, 0, 0, 9, 0, 0 },
                        { 0, 2, 0, 0, 0, 1, 0, 0, 0 },
                        { 0, 9, 0, 0, 7, 0, 0, 0, 0 },
                        { 0, 0, 3, 0, 0, 0, 0, 6, 0 },
                        { 9, 0, 0, 8, 0, 3, 0, 0, 0 },
                        { 0, 0, 0, 0, 5, 0, 0, 0, 7 },
                        { 1, 0, 0, 0, 0, 0, 2, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                        { 0, 0, 0, 2, 0, 6, 0, 0, 0 } };
        System.out.println("---- Sudoku Solver -----");
        if(SolveSudoku(mat)){
            printMat(mat);
        }
        else{
            System.out.println("Solution doesn't exist");
        }
    }
}