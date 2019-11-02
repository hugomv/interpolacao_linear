public class Main {


    //interpolação polinomial
    //entrada para digitar cinco pontos (pares ordenados)
    // cn neide p 289

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    float x1, x2, x3, x4, x5;
    float y1, y2, y3, y4, y5;

    float x;

    /**
     * Informa os pontos necessários para montar a interpolação
     * @param x1
     * @param x2
     * @param x3
     * @param x4
     * @param x5
     * @param y1
     * @param y2
     * @param y3
     * @param y4
     * @param y5
     */
    public void inserirPontos(float x1, float x2, float x3, float x4, float x5, float y1, float y2, float y3, float y4, float y5){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
        this.y5 = y5;

    }

    /**
     * Informar o valor de x para encontrar y
     * @param x
     */
    public void inserirX(float x){
        this.x = x;
    }

    /**
     * Encontrar Li(x)
     * @param i
     * @return
     */
    public float encontrarL(int i){
        float arrayX[] = {x1,x2,x3,x4,x5};
        float arrayY[] = {y1,y2,y3,y4,y5};


        for(int k = 0; k<5;k++){
            
        }
    }
}
