package modeloa;

public class MendiaZerrenda {

	private Mendia[] mendiZerrenda;
	public int sartuta;

	public MendiaZerrenda() {

		mendiZerrenda = new Mendia[20];
		sartuta = 0;

	}

	public void gehitu(Mendia mendia) {

		if (!beteta()) {
			mendiZerrenda[sartuta] = mendia;
			sartuta++;

		}

	}

	public boolean beteta() {
		boolean bete = false;
		if (this.sartuta == 20) {
			bete = true;
		}
		return bete;
	}

	public String mendiZerrendaArgitaratu() {
		String texto = "";
		for (int i = 0; i < this.sartuta; i++) {
			texto += mendiZerrenda[i].toTabString();
		}
		return texto;
	}
	

//	public void kenduMendiaIzena(String Nombre) {
//	    boolean eginda = false;
//	    int pos = 0;
//	    for (int i = 0; i < this.sartuta && !eginda; i++) {
//	        if (mendiZerrenda[i].getNombre().equalsIgnoreCase(Nombre)) {
//	            pos = i;
//	            eginda = true;
//	        }
//	    }
//
//	    if (eginda) {
//	        for (int i = pos; i < this.sartuta - 1; i++) {
//	            mendiZerrenda[i] = mendiZerrenda[i + 1];
//	        }
//	        mendiZerrenda[sartuta - 1] = null; // Establecer el último elemento como null
//	        sartuta--; // Reducir el tamaño de la lista
//	        System.out.println("Monte " + Nombre + " eliminado correctamente.");
//	    } else {
//	        System.out.println("No se encontró el monte con el nombre " + Nombre);
//	    }
//	}

	
	
//	public void kenduMendiaIzena(String Nombre) {
//        boolean eginda = false;
//        System.out.println("i");
//        for (int i = 0; i < this.sartuta && eginda == false; i++) {
//            System.out.println(mendiZerrenda[i].getNombre());
//            if (mendiZerrenda[i].getNombre().equals(Nombre)) {
//                System.out.println(i);
//                eginda = kenduMendia(i);
//            }
//        }
//
//    }
//	
//	
//    public boolean kenduMendia(int pos) {
//        boolean eginda = false;
//        if (pos <= this.sartuta) {
//            for (int i = pos; i < this.sartuta; i++) {
//            	mendiZerrenda[i] = mendiZerrenda[i + 1];
//            }
//            eginda = true;
//            sartuta--;
//        }
//        return eginda;
//    }
	
	
	
	public boolean ezabatu(String Nombre) {
		int pos = this.bilatuNombre(Nombre);
		boolean ezabatuta = false;
		if (pos < this.sartuta && pos >= 0) {

			// MUEVE EL NULL AL FINAL
			for (int i = pos; i < this.sartuta && ezabatuta == false; i++) {
				mendiZerrenda[i] = mendiZerrenda[i + 1];
			}
			this.sartuta--;
			ezabatuta = true;
		
		System.out.println("ezabatuta " + pos +  this.sartuta);

		}else {
			System.out.println("error " + this.sartuta);
		}

		return ezabatuta;
	}

	public int bilatuNombre(String Nombre) {
		int pos = 0;

		while (pos < this.sartuta && !mendiZerrenda[pos].getNombre().equalsIgnoreCase(Nombre)) {
			pos++;
		}
		if (pos == this.sartuta) {
			pos = -1;
		}
		return pos;
	}
	
	public Mendia eskuratu(int i) {
		Mendia mendia = null;
		if (i >= 0 && i < this.sartuta)
			mendia = mendiZerrenda[i];
		else
			System.out.println("Ez da aurkitu");
		return mendia;
	}


}
