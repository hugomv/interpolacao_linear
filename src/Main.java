import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {


    //interpolação polinomial
    //entrada para digitar cinco pontos (pares ordenados)
    // cn neide p 289

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

//        Interpolacao interpolacao = new Interpolacao();
//        ArrayList<Double> arrayX = new ArrayList<Double>();
//        arrayX.add(0.1);
//        arrayX.add(0.6);
//        arrayX.add(0.8);
//
//        ArrayList<Double> arrayY = new ArrayList<>();
//        arrayY.add(1.221);
//        arrayY.add(3.32);
//        arrayY.add(4.953);
//
//        interpolacao.inserirPontos(arrayX,arrayY);
//        interpolacao.inserirX(0.2);
//        System.out.println(interpolacao.encontrarP());

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new JFrame("Interpolação Newton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Gui());
        frame.pack();
        frame.setVisible(true);

    }

}
