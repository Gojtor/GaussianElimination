package linear;

import linear.algebra.GaussianElimination;

public class EquationSolver{
    public static void main(String[] args){
        double[][] matrix = new double[args.length][args.length];


        for(int i=0;i<args.length;i++){
            matrix[i]=stringToDoubles(args[i]);
        }
        /*
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        */

        GaussianElimination elem = new GaussianElimination(matrix.length,matrix[0].length,matrix);
        System.out.println("Normal matrix");
        elem.print();
        System.out.println("\nAfter rowEchelonForm");
        elem.rowEchelonForm();
        elem.print();
        System.out.println("\nAfter backSubstitution");
        elem.backSubstitution();
        elem.print();
    }
    public static double[] stringToDoubles(String array){

        array = array.replaceAll(" ","");
        String[] numbers = array.split(",");
        double[] casted = new double[numbers.length];
        for(int i=0;i<numbers.length;i++){
                casted[i] = Double.parseDouble(String.valueOf(numbers[i]));
        }
        return casted;
    }
}