import java.util.ArrayList;
import java.util.List;

public class Interpolacao {



    double x1, x2, x3, x4, x5;
    List<Double> valoresX = new ArrayList<>();
    List<Double> valoresY = new ArrayList<>();
    double y1, y2, y3, y4, y5;

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
     * Encontrar Li(x)
     * @param i
     * @return
     */
    public double encontrarL(int i){

        double numerador = 1;
        double denominador = 1;

        for(int j = 0; j<valoresX.size();j++){
            if(i!=j) {
                //produtório do numerador
                numerador *= x - valoresX.get(j);

                //produtório do denominador
                denominador *= valoresX.get(i) - valoresX.get(j);
            }
        }

        return numerador / denominador;

    }

    /**
     * itera sobre i e encontra P(x)
     * @return valor de P(x)
     */
    public double encontrarP(){
        double valorP = 0;

        //multiplicar Li por f(x)
        for(int i = 0;i<valoresX.size();i++){
            valorP += valoresY.get(i) * encontrarL(i);
        }

        return valorP;
    }
}
