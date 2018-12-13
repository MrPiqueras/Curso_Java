package POO;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class temp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Reloj miReloj=new Reloj(3000,true);
		
		miReloj.enMarcha();
		
		JOptionPane.showMessageDialog(null, "Aceptar para terminar");
		
		System.exit(0);
		

	}

}

class Reloj {
	
	public Reloj(int intervalo,boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
		
		
	}
	
	public void enMarcha() {
		
		class DameLaHora2 implements ActionListener{
			
			public void actionPerformed(ActionEvent evento) {
				
				Date ahora=new Date();
				
				System.out.println("Te pongo la hora cada 3 seg");
				
				if(sonido) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener oyente=new DameLaHora2();
		
		Timer mitemporizador=new Timer(intervalo,oyente);
		
		mitemporizador.start();
	}	
	
	private int intervalo;
	private boolean sonido;

}
