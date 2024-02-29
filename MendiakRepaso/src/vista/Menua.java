package vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import db.MendiaDao;
import modeloa.Mendia;
import modeloa.MendiaZerrenda;

public class Menua {

	public static void main(String[] args) {

		menua();

	}

	public static void menua() {

		Scanner sc = new Scanner(System.in);
		int aukera = -1;
		MendiaZerrenda mendiZerrenda = new MendiaZerrenda();

		do {
			System.out.println("1. Cargar montes (txt)\r\n" + "2. Cargar montes (bd)\r\n" + "3. Añadir monte\r\n"
					+ "4. Mostrar montes\r\n" + "5. Mostrar monte por nombre\r\n" + "6. Eliminar monte\r\n"
					+ "7. Guardar montes (bd)\n" + "0. Salir ");

			aukera = balidatuZenbakia(sc, "Sartu aukera (0-7), 0 EXIT", 0, 7, sc);
			switch (aukera) {
			case 1:
				txt(mendiZerrenda);
				break;
			case 2:
				datubasea(mendiZerrenda);
				break;
			case 3:
				gehitu(sc, mendiZerrenda);
				break;
			case 4:
				agendaPantailaratu(mendiZerrenda);

				break;
			case 5:
				System.out.println(mendiZerrenda);
				bilatuIzena(sc, mendiZerrenda);
				break;
			case 6:
				ezabatu(sc, mendiZerrenda);

				break;
			case 7:
				gordeDB(mendiZerrenda);
				break;
			}
		} while (aukera != 0);

	}

	public static void txt(MendiaZerrenda mendiZerrenda) {
		int index = 0; // Índice para seguir la posición actual del arreglo

		try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/Mendiak.txt")))) {
			String line;

			while ((line = reader.readLine()) != null) {
				if (!line.isEmpty()) {
					if (line.startsWith("Nombre:")) {
						// Creamos un nuevo objeto Mendia
						Mendia mendia = new Mendia();

						// Leemos cada línea y asignamos directamente los valores correspondientes a los
						// campos de Mendia
						mendia.setNombre(extractValue(line));
						line = reader.readLine();
						mendia.setProvincia(extractValue(line));
						line = reader.readLine();
						mendia.setAltura(extractValue(line));
						line = reader.readLine();
						mendia.setCoordenadas(extractValue(line));
						line = reader.readLine();
						mendia.setMacizo(extractValue(line));
						line = reader.readLine();
						mendia.setRuta(extractValue(line));

						// Almacenamos el objeto Mendia en el arreglo
						mendiZerrenda.gehitu(mendia);

						// Imprimimos el objeto Mendia
						System.out.println(mendia.toString());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para extraer el valor de una línea en el formato "Campo: Valor"
	private static String extractValue(String line) {
		return line.substring(line.indexOf(":") + 1).trim();
	}

	public static void gehitu(Scanner sc, MendiaZerrenda mendiZerrenda) {

		System.out.println("Sartu Nombre");
		String Nombre = sc.nextLine();
		System.out.println("Sartu Provincia");
		String Provincia = sc.nextLine();
		System.out.println("Sartu Altura");
		String Altura = sc.nextLine();
		System.out.println("Sartu Coordenadas");
		String Coordenadas = sc.nextLine();
		System.out.println("Sartu Macizo");
		String Macizo = sc.nextLine();
		System.out.println("Sartu Ruta");
		String Ruta = sc.nextLine();

		Mendia mendia = new Mendia(Nombre, Provincia, Altura, Coordenadas, Macizo, Ruta);
		mendiZerrenda.gehitu(mendia);
	}

	public static void gehitu2(Scanner sc, MendiaZerrenda mendiZerrenda) {

		Mendia mendia = new Mendia();

		System.out.println("Sartu Nombre");
		mendia.setNombre(sc.nextLine());
		System.out.println("Sartu Provincia");
		mendia.setProvincia(sc.nextLine());
		System.out.println("Sartu Altura");
		mendia.setAltura(sc.nextLine());
		System.out.println("Sartu Coordenadas");
		mendia.setCoordenadas(sc.nextLine());
		System.out.println("Sartu Macizo");
		mendia.setMacizo(sc.nextLine());
		System.out.println("Sartu Ruta");
		mendia.setRuta(sc.nextLine());
		mendiZerrenda.gehitu(mendia);

	}

	public static void ezabatu(Scanner sc, MendiaZerrenda mendiZerrenda) {

		System.out.println("Sartu Nombre");
		String Nombre = sc.nextLine();
		mendiZerrenda.ezabatu(Nombre);

	}

	public static void bilatuIzena(Scanner sc, MendiaZerrenda mendiZerrenda) {

		// TODO Auto-generated method stub
		System.out.println("Sartu Nombre");
		String Nombre = sc.nextLine();
		int posizioa = mendiZerrenda.bilatuNombre(Nombre);
		if (posizioa != -1)
			System.out.println(mendiZerrenda.eskuratu(posizioa).toString());
		else
			System.out.println("Ez dago liburu hori");

	}

	public static void agendaPantailaratu(MendiaZerrenda mendiZerrenda) {

		System.out.println("Listado de montes");
		System.out
				.println("-------------------------------------------------------------------------------------------");
		System.out.println("nombre \t  provincia \t  altura \t  coordenadas \t  macizo \t ruta \n");
		System.out
				.println("-------------------------------------------------------------------------------------------");

		System.out.println(mendiZerrenda.mendiZerrendaArgitaratu());

	}

	public static void datubasea(MendiaZerrenda mendiZerrenda) {

		MendiaDao mendiDao = new MendiaDao();

		Mendia[] mendiArray = mendiDao.getAllObjetuak();

		// Agregar los objetos Mendia obtenidos de la base de datos al MendiaZerrenda
		for (Mendia mendia : mendiArray) {
			mendiZerrenda.gehitu(mendia);
		}

		// Imprimir los objetos Mendia almacenados en el MendiaZerrenda
		for (int i = 0; i < mendiZerrenda.sartuta; i++) {
			System.out.println(mendiZerrenda.eskuratu(i).toString());
		}
	}

	public static void gordeDB(MendiaZerrenda mendiZerrenda) {

		MendiaDao mendiDao = new MendiaDao();


		Mendia[] mendiArray = mendiDao.getAllObjetuak();

		MendiaDao mendiDaoDelete = new MendiaDao();
		
		mendiDaoDelete.deleTaula();

		for (int i = 0; i < mendiZerrenda.sartuta ; i++) {
			MendiaDao mendiDaoInsert = new MendiaDao();
			//para que no se cierre la conexion
			
			
			mendiDaoInsert.insertMendia(mendiArray[i]);
		}
		
		

	}

	private static int balidatuZenbakia(Scanner sc, String string, int min, int max, Scanner sc2) {
		// TODO Auto-generated method stub
		int aukera = -1;
		boolean error = true;
		do {
			System.out.println(string);
			String textua = sc.nextLine();
			try {
				aukera = Integer.valueOf(textua);
				if (aukera >= min && aukera <= max)
					error = false;

			} catch (Exception ex) {
				error = true;
			}
		} while (error);
		return aukera;
	}

}
