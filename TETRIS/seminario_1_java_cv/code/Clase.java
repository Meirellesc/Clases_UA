import java.util.*;
import java.util.ArrayList;
import prog3.ejemplos.Ejemplo;

public class Clase {
	// 4
	private int campo1; 
	private float campo2; 
	
	public Clase(int v) {
		campo1 = v; 
	}
	
	public int getCampo1() { 
		return campo1;
	} 
	
	// 5
	public final int KN=10;
	private static int contador=1;
	public static final int KNN=10;
	public static void incrementaContador () {
  		contador++;
	}	
	
	// 14
	public boolean equals(Object obj) {
	  if (obj == null) return false;
	  
	  if (this == obj) return true;
	  
	  if ( !(obj instanceof Clase) ) 
	    return false;
	    
	  Clase r = (Clase) obj;
	  
	    if ( (this.campo1 == r.campo1)
	    && (this.campo2 == r.campo2) )
	    	return true;
	    else
	    	return false;
	}
	
	public String toString() {
	  return "campo1="+campo1+"; campo2="+campo2;
	}
	
	// 6
	public static final void main(String[] args) throws Exception {
	
		// 8
		System.out.println("-- 8 --");
		System.out.print("Cadena"); // no imprime retorno de carro 
		System.out.println(10+3); // imprime retorno de carro al final
		System.err.println("Ha ocurrido un error...");

		float a = 10.3f;
		double b = 10.3;
		char c = 'a';
		boolean d = true; // o false

		System.in.read();
		// 10
		System.out.println("-- 10 --");
		Integer a2;
		a2 = new Integer(29);
		int x = a2.intValue(); // x será 29		
		System.out.println("Tipos escalares:");
		System.out.println(a2); 
		System.out.println(x); 
		
		System.in.read();
		// 11
		System.out.println("-- 11 --");
		Integer a3 = new Integer(10); 
		a3 = new Integer(12);
		Integer b3 = a3;
		System.out.println(a3); 
		System.out.println(b3); 
		

		Object obj = new Integer(10); // Ok 
		obj = new Clase(2); // Ok
		System.out.println(obj); 
		
		System.in.read();
		// 12
		System.out.println("-- 12 --");
		if (obj instanceof Integer)
			System.out.println("Integer"); 
		else
			System.out.println("Clase"); 
				
		int x2 = 10;
		float f = (float) x2;				
			System.out.println(x2); 
			System.out.println(f); 
		
		Object cualquiera = new Clase(3);
		Clase obj2 = (Clase) cualquiera;
			System.out.println(cualquiera); 
			System.out.println(obj2); 

		System.in.read();
		// 13
		System.out.println("-- 13 --");
		Integer a4 = new Integer(13); 
		Integer b4 = a4;
			System.out.println(a4 == b4); 
		b4 = new Integer(13);
			System.out.println(a4 == b4); 
			System.out.println(a4.equals(b4)); 

		System.in.read();
		// 15
		System.out.println("-- 15 -- Boxing/Unboxing");
		Integer b15 = 3;
		Integer b15_2 = new Integer(3);
			System.out.println(b15); 
			System.out.println(b15_2); 
		
		int x15 = new Integer(100);
		int x15_2 = (new Integer(100)).intValue();
			System.out.println(x15); 
			System.out.println(x15_2); 
		
		System.in.read();
		// 17
/*		System.out.println("-- 17 -- Excepciones");
		Integer a17=null, b17=null;
		if (a17.equals(b17)) {
			// este if lanza la excepción NullPointerException 
		}
*/			
		// ArrayIndexOutOfBoundsException
/*		int [] v = new int[10];
		v[20] = 3;
*/		

		System.in.read();
		// 18
		System.out.println("-- 18 -- Cadenas");
		String s1 = new String("HOLA");		
		String s2 = "HOLA";
			System.out.println(s1 == s2); 
			System.out.println(s1.equals(s2)); 
		Float f2 = new Float(20); 
		String s3 = f2.toString();
			System.out.println(f2); 
			System.out.println(s3); 

		System.in.read();
		// 19
		System.out.println("-- 19 -- Concatenacion");
		int i19=100;
			System.out.println("El valor de i es = " + i19);

		String s19 = new String("El valor de i es = ");
		String s29 = new Integer(i19).toString();
		String s39 = s19.concat(s29); // que crea un objeto nuevo
			System.out.println(s39);

		StringBuilder sb = new StringBuilder(); 
		sb.append("El valor de i es = "); 
		sb.append(i19);
		sb.toString(); // objeto String
			System.out.println(sb.toString());

		System.in.read();
		// 20
		System.out.println("-- 20 -- Arrays");
		Integer [] v; // v es un puntero a null
		v = new Integer[100];
		// v.length es la longitud reservada para el array
		for (int i=0; i<v.length; i++) {
			v[i] = new Integer(0);
			// ó v[i] = 0 (equivalente por el boxing)
		}
			System.out.println(v);
			System.out.println(v[0]);
		
		int [] origen = new int []{1,2,3,4,5};
		int [] destino = new int[origen.length]; 
		System.arraycopy(origen, 0, destino, 0, origen.length);	  
		for (int i=0; i<destino.length; i++) {
			System.out.println(destino[i]);
		}
		
		System.in.read();
		// 24
		System.out.println("-- 24 -- API Java");

		ArrayList v24 = new ArrayList();
		v24.add(87); // esto internamente hace v.add(new Integer(87)) 
		v24.add(22); // hace más grande el vector
		Integer a24 = (Integer)v24.get(0); // necesito hacer cast
			System.out.println(v24);
			System.out.println(a24);
			System.out.println(v24.get(1));

		
		System.in.read();
		// 25
		System.out.println("-- 25 -- API Java - Vectores");

		ArrayList<Integer> v25 = new ArrayList<Integer>();
		v25.add(87); // esto internamente hace v.add(new Integer(87)) 
		Integer a25 = v25.get(0); // no necesitamos hacer cast 
		System.out.println(v25.size()); // size() devuelve el tamaño		
		
		
		System.in.read();
		// 26
		System.out.println("-- 26 -- Control de flujo");

		List<String> l = Arrays.asList("Azul", "Verde", "Rojo");
		for (int i=0; i<l.size(); i++) { 
			System.out.println(l.get(i));
		}
		for (String color: l) {
			System.out.println(color); // imprime un color por línea
		}
		// usando iteradores
		Iterator<String> iterador = l.iterator(); 
		while (iterador.hasNext()) {
			String color = iterador.next();
			System.out.println(color); // imprime un color por línea 
		}
	}
	
} // ¡sin punto y coma!