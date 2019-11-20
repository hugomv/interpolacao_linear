import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.*;

public class FormaNewton {


    double x1, x2, x3, x4, x5;
    List<Double> valoresX = new ArrayList<>();
    List<Double> valoresY = new ArrayList<>();
    double y1, y2, y3, y4, y5;

    Map<String,Double> tabela = new HashMap<>();
    double x;

    /**
     * Informa os pontos necessários para montar a interpolação
     *
     */
    public void inserirPontos(ArrayList<Double> valoresX, ArrayList<Double> valoresY){
        this.valoresX = valoresX;
        this.valoresY = valoresY;

    }

    /**
     * Informar o valor de x para encontrar y
     * @param x
     */
    public void inserirX(double x){
        this.x = x;
    }

    /**
     * Calcular b(x)
     */
//    public double calcularB(int[] m) {
//
//
//        if (m.length == 2) {
//            tabela.put(m[0] + " " + m[1], (valoresY.get(m[1]) - valoresY.get(m[0])) / (valoresX.get(m[1]) - valoresX.get(m[0])));
//        } else if(m.length > 2){
//
//        }
//
//    }

    public double calcularB(int i, int j) {

        if(tabela.get(i + j + "")!=null){
            return tabela.get(i + j + "");
        }
        if (abs(i - j)==1) {
            double resultado = valoresY.get(j) - valoresY.get(i) / (valoresX.get(j) - valoresX.get(i));
            tabela.put(i + j + "",resultado);
            System.out.println(i + " " + j + " " + resultado);
            return resultado;
        } else{
            double resultado = (calcularB(i,j-1) - calcularB(i+1,j)) / (valoresX.get(j) - valoresX.get(i));
            tabela.put(i + j + "",resultado);
            System.out.println(i + " " + j + " " + resultado);
            return resultado;
        }

    }

    private String printArray(int[] m){

        StringBuilder sb = new StringBuilder();
        for(int i : m){
            sb.append(i + " ");
        }
        return sb.toString();
    }

    public Double encontrarP1(){
        double soma = valoresY.get(0);
            for(int i = 1;i<valoresX.size();i++){
                soma += multiplicarX(0,i)*calcularB(0,i);
            }
        return soma;
    }

    public Double encontrarP(){
        double y[][]=new double[10][10];

        for(int i = 0;i<valoresY.size();i++){
            y[i][0] = valoresY.get(i);
        }

        calcularTabela(y,valoresX.size());
        printDiffTable(y,valoresX.size());
        return aplicarFormula(y,valoresX.size());
    }

    public Double multiplicarX(int i, int j){
        double multiplicador = 1;

        for(int k = i; k<j;k++){
            multiplicador *= x * valoresX.get(k);
        }
        return multiplicador;
    }

    public double multiplicar(int i)
    {
        double pro = 1;
        for (int j = 0; j < i; j++) {
            pro = pro * (x - valoresX.get(j));
        }
        return pro;
    }

    public void calcularTabela(double y[][], int n)
    {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1]
                        [i - 1]) / (valoresX.get(j) - valoresX.get(i + j));
            }
        }
    }

    public double aplicarFormula(double y[][], int n)
    {
        double sum = y[0][0];

        for (int i = 1; i < n; i++) {
            sum = sum + (multiplicar(i) * y[0][i]);
        }
        return sum;
    }

    static void printDiffTable(double y[][],int n)
    {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                String str1 = df.format(y[i][j]);
                System.out.print(str1+"\t ");
            }
            System.out.println("");
        }
    }
}



