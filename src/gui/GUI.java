package gui;

import guardado.threads.AnimalThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private JLabel[] labels;
    private JButton inicio;
    private JButton regreso;
    private String[] nombres = {"canguro","tortuga","dragon"};

    public GUI(){
        super ("Carrera de animales");
        initialComponents();
    }


    public void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        labels= new JLabel[3];
        inicio= new JButton("inicio");
        regreso= new JButton("regreso");
        Container container= getContentPane();

        //Agregando a nuestros participantes
        for (int i=0;i<3;i++){

            labels[i]=new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
            labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(labels[i]);

        }
        

        inicio.setBounds(10,0,100,30);
        regreso.setBounds(120,0,100,30);
        container.add(inicio);
        container.add(regreso);

        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread canguro = new AnimalThread("canguro",labels[0].getX(),
                        labels[0].getY(),510,labels[0]);

                AnimalThread tortuga= new AnimalThread("tortuga",labels[1].getX(),
                        labels[1].getY(),510,labels[1]);

                AnimalThread dragon= new AnimalThread("dragon",labels[2].getX(),
                        labels[2].getY(),510,labels[2]);

                canguro.start();
                tortuga.start();
                dragon.start();

            }
        });
        
        regreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread canguro = new AnimalThread("canguro",labels[0].getX(),
                        labels[0].getY(),0,labels[0]);

                AnimalThread tortuga= new AnimalThread("tortuga",labels[1].getX(),
                        labels[1].getY(),0,labels[1]);

                AnimalThread dragon= new AnimalThread("dragon",labels[2].getX(),
                        labels[2].getY(),0,labels[2]);

                canguro.start();
                tortuga.start();
                dragon.start();

            }
        });
        setSize(700,650);
    }


    public static void main(String args[]){

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
