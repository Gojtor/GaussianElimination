package linear.algebra;

public class GaussianElimination{
    private double[][] matrix;
    private int row;
    private int col;


    public double[][] getMatrix() {
        return this.matrix;
    }
    public int getRows(){
        return this.row;
    }
    public int getCols(){
        return this.row;
    }
    public void setMatrix(double[][] matrix){
        if(this.matrix[0].length == matrix[0].length || this.matrix.length == matrix.length){
            this.matrix=matrix;
        }
        else{
            throw new IllegalArgumentException("The given matrix is not the same size compared to the original!");
        }
    }
    public GaussianElimination(int row,int col,double[][] matrix){
        this.matrix=matrix;
        this.row=row;
        this.col=col;
    }
    public void rowEchelonForm(){
        int h = 0;
        int k = 0;
        while(h<this.row && k<this.col){
            int i_max=argMax(h,k);
            if(matrix[i_max][k]==0){
                k=k+1;
            }
            else{
                swapRows(i_max,h);
                for(int i=h+1;i<row;i++){
                    multiplyAndAddRow(i,h,k);
                }
                multiplyRow(h,k);
                h= h+1;
                k= k+1;
            }
        }
    }
    public int argMax(int row,int col){
        int i_max=row;
        for(int i=row;i<this.row;i++){
                if (Math.abs(matrix[i][col]) > Math.abs(matrix[i_max][col])) {
                    i_max = i;
                }
            }
        return i_max;
    }
    public void swapRows(int row1,int row2){
           double[] tempRow=matrix[row1];
           matrix[row1]=matrix[row2];
           matrix[row2]=tempRow;
    }
    public void multiplyAndAddRow(int addRow,int mulRow, int colIndex){
        double f = matrix[addRow][colIndex] / matrix[mulRow][colIndex];
        matrix[addRow][colIndex]=0;
        for(int j=colIndex+1;j<this.col;j++){
            matrix[addRow][j] = matrix[addRow][j] - matrix[mulRow][j] * f;
        }
    }
    public void multiplyRow(int row, int col){
        double divider = matrix[row][col];
        for(int j=col;j<this.col;j++){
            matrix[row][j] = matrix[row][j] / divider; 
        }
    }
    public void backSubstitution(){
        for(int i=this.row-1;i>=0;i--){
            if(matrix[i][i]==0){
                throw new IllegalArgumentException("Diagonal element is null");
            }
            for(int j=i-1;j>=0;j--){
                multiplyAndAddRow(j,i,i);
            }
        }
    }
    public void print(){
        char[] xyz = {'x','y','z'};
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(this.matrix[i][j]>=0 && j<xyz.length){
                    System.out.print("+"+this.matrix[i][j]+xyz[j]);
                }
                else if(this.matrix[i][j]<0 && j<xyz.length){
                    System.out.print(""+this.matrix[i][j]+xyz[j]);
                }
                else{
                    System.out.print("="+this.matrix[i][j]);
                }
            }
            System.out.println();
        }
    }

}