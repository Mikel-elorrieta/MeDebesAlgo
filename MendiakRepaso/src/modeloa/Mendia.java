package modeloa;

public class Mendia {

	private String nombre;
	private String provincia;
	private String altura;
	private String coordenadas;
	private String macizo;
	private String ruta;

	// --------------------Konstruktorea--------------------//

	public Mendia(String nombre, String provincia, String altura, String coordenadas, String macizo, String ruta) {
		
		this.nombre = nombre;
		this.provincia = provincia;
		this.altura = altura;
		this.coordenadas = coordenadas;
		this.macizo = macizo;
		this.ruta = ruta;
		
	}
	public Mendia(){
		
	}

	public Mendia(String[] MendiaTXT) {
	    this.nombre = MendiaTXT[0];
	    this.provincia = MendiaTXT[1];
	    this.altura = MendiaTXT[2];
	    this.coordenadas = MendiaTXT[3];
	    this.macizo = MendiaTXT[4];
	    // Comprobar si hay una ruta disponible antes de asignarla
	    if (MendiaTXT.length > 5) {
	        this.ruta = MendiaTXT[5];
	    } else {
	        this.ruta = "Ez dauka rutarik";
	    }
	}

	
	// --------------------Konstruktorea--------------------//

	
	// --------------------GET--------------------//

	public String getNombre() {
		return nombre;
	}

	public String getProvincia() {
		return provincia;
	}
	public String getAltura() {
		return altura;
	}
	public String getCoordenadas() {
		return coordenadas;
	}

	public String getMacizo() {
		return macizo;
	}
	public String getRuta() {
		return ruta;
	}
	// --------------------GET--------------------//

	// --------------------SET--------------------//

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	

	public void setAltura(String altura) {
		this.altura = altura;
	}

	
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}


	public void setMacizo(String macizo) {
		this.macizo = macizo;
	}

	

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	// --------------------SET--------------------//
	
	

	@Override
	public String toString() {
		
		return "Mendia [nombre=" + nombre + ", provincia=" + provincia + ", altura=" + altura + ", coordenadas="
				+ coordenadas + ", macizo=" + macizo + ", ruta=" + ruta + "]";
	}
	
	 public String toTabString() {
	        return nombre + "          \t" + provincia + "          \t" + altura + "          \t" + coordenadas + "          \t" + macizo + "          \t" + ruta + "          \n";
	    }
	
	
	

}
