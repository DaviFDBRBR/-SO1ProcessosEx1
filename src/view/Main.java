package view;

import java.util.Scanner;
import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc;
		RedesController redes = new RedesController();
		String so[] = System.getProperty("os.name").split(" ");

		do {
			System.out.print("1 - Ipconfig\n2 - Ping\n0 - Encerrar\n");
			opc = sc.nextInt();

			switch (opc) {
			case 1:
				redes.ip(so[0]);
				break;
			case 2:
				redes.ping(so[0]);
				break;
			case 0:
				//
				System.out.println("Programa encerrado!");
				break;
			default:
				System.out.println("Opção inválida");
			}

		} while (opc != 0);

		sc.close();
	}
}
