package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class RedesController {

	public RedesController() {
		super();
	}

	public void ip(String soNome) {
		String processo;
		String aux;
		
		if (soNome.equals("Windows")) {
			processo = "ipconfig";
			aux = "Adaptador";
		} else {
			processo = "ifconfig";
			aux = "flags";
		}

		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			while (linha != null) {
				if (linha.contains(aux)) {
					String g[] = linha.split(":");
					System.out.print(g[0] + ": ");
					
				} else if (linha.contains("IPv4")) {
					String v[] = linha.split(":");
					System.out.println(v[1].trim());

				}
				
				linha = buffer.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void ping(String soNome) {
		String processo;
		String aux;
		
		if (soNome.equals("Windows")) {
			processo = "ping -4 -n 10 www.uol.com.br";
			aux = "M";
		} else {
			processo = "ping -4 -c 10 www.uol.com.br";
			aux = "avg";
		}

		try {
			Process p = Runtime.getRuntime().exec(processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			StringBuffer b = new StringBuffer();
			while (linha != null) {
				if (linha.contains(aux) && soNome.contains("Windows")) {
					String v[] = linha.split("=");
					System.out.println("Média = " + v[v.length-1]);
					System.out.println("");
				} else if (linha.contains(aux) && soNome.contains("Linux")) {
					String v[] = linha.split("/");
					System.out.println("Média = " + v[4] + "ms");
					System.out.println("");
				}
				
				linha = buffer.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
