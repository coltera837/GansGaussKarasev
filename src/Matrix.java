import java.util.ArrayList;

public class Matrix {
    private int matrix_string_count, matrix_columns_count;
    private double[][] matrix;
    private String basic_coefficients;

    public Matrix(){
        matrix_string_count = 0;
        matrix_columns_count = 0;
        matrix = null;
        basic_coefficients = "";
    }

    public Matrix(int matrix_string_count, int matrix_columns_count, double[][] matrix, String basic_coefficients){
        this.matrix_string_count = matrix_string_count;
        this.matrix_columns_count = matrix_columns_count;
        this.matrix = matrix;
        this.basic_coefficients = basic_coefficients;
    }

    public Matrix(Matrix copy){
        this.matrix_string_count = copy.matrix_string_count;
        this.matrix_columns_count = copy.matrix_columns_count;
        this.matrix = copy.matrix;
        this.basic_coefficients = copy.basic_coefficients;
    }

    public int getMatrix_string_count() {
        return matrix_string_count;
    }

    public int getMatrix_columns_count() {
        return matrix_columns_count;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public String getBasic_coefficients() {
        return basic_coefficients;
    }

    public void setMatrix_string_count(int matrix_string_count) {
        this.matrix_string_count = matrix_string_count;
    }

    public void setMatrix_columns_count(int matrix_columns_count) {
        this.matrix_columns_count = matrix_columns_count;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public void setBasic_coefficients(String basic_coefficients) {
        this.basic_coefficients = basic_coefficients;
    }

    public void matrix_output(){
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++){
                if (j == matrix[i].length-1)
                {
                    System.out.print("| " + matrix[i][j]);
                }
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void method_of_Gauss(){
        if(matrix_string_count == matrix_columns_count){
            for(int k = 0; k < matrix_string_count; k++)
            {
                double[] main_string = null;
                double main_element = matrix[k][k];
                for (int l = 0; l < matrix[0].length; l++)
                {
                    matrix[k][l] = matrix[k][l] / main_element;
                }
                main_string = matrix[k];
                for(int i = 0; i < matrix_string_count; i++)
                {
                    if(i != k)
                    {
                        for (int j = 0; j < matrix[0].length; j++)
                        {
                            matrix[i][j] = matrix[i][j] - matrix[i][k] * main_string[j];
                        }
                    }
                }
            }
        }
        else{
            for(int k = 0; k < matrix_string_count; k++)
            {
                String[] temp = basic_coefficients.split(",");
                int[] bc_list = new int[temp.length];
                for(int t = 0; t < temp.length; t++){
                    bc_list[t] = Integer.parseInt(temp[t]);
                }
                swap_Column(bc_list);
                double[] main_string = null;
                double main_element = matrix[k][k];
                for (int l = 0; l < matrix[0].length; l++)
                {
                    matrix[k][l] = matrix[k][l] / main_element;
                }
                main_string = matrix[k];
                for(int i = 0; i < matrix_string_count; i++)
                {
                    if(i != k)
                    {
                        for (int j = 0; j < matrix[0].length; j++)
                        {
                            matrix[i][j] = matrix[i][j] - matrix[i][k] * main_string[j];
                        }
                    }
                }
            }

        }
    }

    public void swap_Column(int[] bc_list){
        for(int l = 0; l < bc_list.length; l++){
            double[] temp = new double[matrix_string_count];
            for(int i = 0; i < matrix_string_count; i++)
            {
                temp[i] = matrix[i][bc_list[l]];
                matrix[i][bc_list[l]] = matrix[i][l];
                matrix[i][l] = temp[i];
            }
        }
    }
}
