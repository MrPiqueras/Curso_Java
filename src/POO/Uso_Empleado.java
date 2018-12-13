package POO;

import java.util.*;

public class Uso_Empleado {

	public static void main(String[] args) {
		
		Jefatura jefe_RRHH=new Jefatura("Juan",55000,2006,9,25);
		
		jefe_RRHH.setIncentivo(2570);
		
		Empleado[] misEmpleados=new Empleado[6];
		
		misEmpleados[0]=new Empleado("Ana",30000,2000,7,7);
		misEmpleados[1]=new Empleado("Calos",50000,1995,6,15);
		misEmpleados[2]=new Empleado("Paco",25000,2005,9,25);
		misEmpleados[3]=new Empleado("Antonio",47500,2009,11,9);
		misEmpleados[4]=jefe_RRHH;	
		misEmpleados[5]=new Jefatura("María",95000,1999,5,26);
		
		Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
		
		jefa_Finanzas.setIncentivo(55000);
		
		Empleado director_comercial=new Jefatura("Sandra", 85000,2012,05,05);	
		
		Comparable ejemplo=new Empleado("Elisabeth", 95000,2011,06,07);
		
		if (director_comercial instanceof Empleado) {
			
			System.out.println("Es de tipo Jefatura");
		}
		
		if (ejemplo instanceof Comparable) {
			
			System.out.println("Implementa la interfar comparable");
		}
		
		System.out.println(jefa_Finanzas.tomar_decisiones("Dar mas dias de vacaciones a los empleados"));
		
		System.out.println("El jefe " + jefa_Finanzas.getNombre() + " tiene un bonus de: " + jefa_Finanzas.establece_bonus(500));
		
		System.out.println(misEmpleados[3].getNombre() + " tiene un bonus de: " + misEmpleados[3].establece_bonus(200));
		
		for(Empleado e:misEmpleados) {
			e.subeSueldo(5);
		}
		
		Arrays.sort(misEmpleados);
		
		for(Empleado e:misEmpleados) {
			System.out.println("Nombre: " + e.getNombre() + " Sueldo: " + e.getSuedo()
			+ " Fecha de Alta: " + e.getFechaContrato());
		}
	

	}

}

class Empleado implements Comparable,Trabajadores{
	
	public Empleado(String nom,double sue,int year, int month, int day) {
		
		nombre=nom;
		sueldo=sue;
		GregorianCalendar calendario=new GregorianCalendar(year,month,day);
		altaContrato=calendario.getTime();
		
		++IdSiguiente;
		Id=IdSiguiente;
		
	}
	
	public double establece_bonus(double gratificacion) {
		
		return Trabajadores.bonus_base+gratificacion;
		
	}
	
	public int compareTo(Object miObjeto) {
		
		Empleado otroEmpleado=(Empleado) miObjeto;
		if (this.Id <otroEmpleado.Id) {
			
			return -1;
		}
		
		if (this.Id > otroEmpleado.Id) {
			
			return 1;
			
		}
		
		return 0;
	}
	
	public String getNombre() { //getter
		
		return nombre + " Id: " + Id;
		
	}
	
	public double getSuedo() {
		
		return sueldo;
				
	}
	
	public Date getFechaContrato() {
		
		return altaContrato;
		
	}
	
	public void subeSueldo(double porcentaje) {
		
		double aumento=sueldo*porcentaje/100;
		
		sueldo+=aumento;
		
	}
	
	
	private String nombre;
	private double sueldo;
	
	private Date altaContrato;
	
	private  int Id;
	private static int IdSiguiente;
	
	
}

class Jefatura extends Empleado implements Jefes{
	
	public Jefatura(String nom, double sue, int year, int month, int day) {
		
		super(nom,sue,year,month,day);
		

	}
	
	public double establece_bonus(double gratificacion) {
		
		double prima=2000;
		
		return Trabajadores.bonus_base + gratificacion + prima;
		
	}
	
	public String tomar_decisiones(String decision) {
		
		return "Un miembro de la direccion a tomado la decisión: " + decision;
				
	}
	
	public void setIncentivo(double b) {
		
		incentivo=b;
	}
	
	public double getSueldo() {
		
		double sueldoJefe=super.getSuedo();
		
		return sueldoJefe + incentivo;
	}
	
	private double incentivo;
}
