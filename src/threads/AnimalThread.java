package guardado.threads;

import javax.swing.*;

public class AnimalThread extends Thread {

    private String nombre;
    private int limite;
    private JLabel animal;
    private int x;
    private int y;

    public AnimalThread(){}

    public AnimalThread(String nombre, int x, int y, int limite, JLabel animal){

        this.nombre=nombre;
        this.x=x;
        this.y=y;
        this.limite=limite;
        this.animal=animal;
    }

    public String getNombre() {return nombre;}

    public int getLimite() {return limite;}

    public JLabel getAnimal() {return animal;}

    public int getX() {return x;}

    public int getY() {return y;}

    @Override
    public void run(){
        if(this.limite!=0){

            for (int i=x;i<this.limite;i+=10) {

                System.out.println(this.nombre + " avanza");
                this.animal.setLocation(i, y);

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.nombre+" has llegado a la meta");
        }else{
            for (int i=x;i>this.limite;i-=10) {

                System.out.println(this.nombre + " regresa");
                this.animal.setLocation(i, y);

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        yield();
    }

}
