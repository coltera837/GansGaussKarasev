import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void data_processing(ArrayList<String> all_matrix_list, ArrayList<Matrix> matrixArrayList)
    {
        for(int k = 0; k < all_matrix_list.size(); k++){
            String[] aml_split = all_matrix_list.get(k).split(" ");
            String[] matrix_size = aml_split[0].split("x");
            int str_count = Integer.parseInt(matrix_size[0]);
            int col_count = Integer.parseInt(matrix_size[1]);
            String[] matrix_elements = aml_split[1].split("/");
            double[][] filled_matrix = new double[str_count][col_count+1];
            int c = 0;
            for(int i = 0; i < str_count; i++){
                for(int j = 0; j < col_count+1; j++)
                {
                    filled_matrix[i][j] = Double.parseDouble(matrix_elements[c]);
                    c++;
                }
            }
            Matrix matrix = new Matrix(str_count, col_count, filled_matrix, aml_split[2]);
            matrixArrayList.add(matrix);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Matrix> matrix_list = new ArrayList<>();
        ArrayList<String> all_matrix_data = new ArrayList<>();
        Scanner sc = new Scanner(new File("file_info.txt"));
        while (sc.hasNext()){
            String matrix_data = sc.nextLine();
            all_matrix_data.add(matrix_data);
        }
        data_processing(all_matrix_data, matrix_list);
        console_matrix_output(matrix_list);
    }

    public static void console_matrix_output(ArrayList<Matrix> matrices){
        for(int k = 0; k < matrices.size(); k++)
        {
            System.out.println("Матрица " + String.valueOf(k+1) + ":");
           matrices.get(k).matrix_output();
            System.out.println("Преобразование методом Гаусса:");
           matrices.get(k).method_of_Gauss();
           matrices.get(k).matrix_output();
        }
    }
}