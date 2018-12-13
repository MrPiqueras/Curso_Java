package graficos;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Prueba_Dibujo {
	
	public static void main(String[] args) {
		
		MarcoConDibujos miMarco=new MarcoConDibujos();
		
		miMarco.setVisible(true);
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}

class MarcoConDibujos extends JFrame{
	
	public MarcoConDibujos() {
		
		setTitle("Prueba de Dibujo");
		
		setSize(600, 500);
		
		LaminaConFiguras miLamina=new LaminaConFiguras();
		add(miLamina);
		
		
		
	}
}

class LaminaConFiguras extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		//g.drawRect(50, 50, 250, 250);
		
		//g.drawLine(50, 50, 75, 100);
		
//		g.drawArc(x, y, width, height, startAngle, arcAngle);
		
		Graphics2D g2=(Graphics2D) g;
		
//		DIBUJO UN RECTANGULO
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		
		g2.setPaint(Color.CYAN);
		
//		g2.draw(rectangulo);
		
		g2.fill(rectangulo);
		
//		DIBUJO UNA ELIPSE		
		
		Ellipse2D elipse=new Ellipse2D.Double();
		
		elipse.setFrame(rectangulo);
		
		g2.setPaint(new Color(255,140,0));
		
//		g2.draw(elipse);
		
		g2.fill(elipse);
		
//		DIBUJO UNA LINEA instancio directamente
		
		g2.draw(new Line2D.Double(100, 100, 300, 250));
		
//		DIBUJO UN CIRCULO
		
		double centroX=rectangulo.getCenterX();
		double centroY=rectangulo.getCenterY();
		double radio=150;
		
		Ellipse2D circulo=new Ellipse2D.Double();
		
		circulo.setFrameFromCenter(centroX, centroY, centroX + radio, centroY + radio);
		
		g2.draw(circulo);
	}
}