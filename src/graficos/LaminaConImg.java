package graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LaminaConImg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoConImg miMarco=new MarcoConImg();
		
		miMarco.setVisible(true);
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoConImg extends JFrame{
	
	public MarcoConImg() {
		
		setTitle("Marco con Imagen");
		
		setBounds(750,300,500,400);
		
		LaminaConImagen miLamina=new LaminaConImagen();
		
		add(miLamina);
	}
}

class LaminaConImagen extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
//		File miimagen=new File("src/graficos/icono.jpg");
		
		try {
		imagen=ImageIO.read(new File("src/graficos/icoeno.jpg"));
		}
		catch (IOException e) {
			System.out.println("La imagen no se encuentra");
		}
		
		g.drawImage(imagen, 5, 5, null);
	}
	
	private Image imagen;
	
}
