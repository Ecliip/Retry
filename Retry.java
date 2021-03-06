package com.lombok.demolombok;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemolombokApplication {

	public static void main(String[] args) {
		Circuit circuit = new Circuit(3, 2, 20, 10);
		String estado = circuito.getEstado();
		System.out.println(estado);
	}
}

class Circuit {
	int nOk; 
	int nErr; 
	int limiteErr;
	int nMaxIntentos;
	int nActualIntento;
	double result;
	
	public Circuit(int nOk, int nErr, int limiteErr, int nMaxIntentos) {
		this.nOk = nOk;
		this.nErr = nErr;
		this.limiteErr = limiteErr;
		this.nMaxIntentos = nMaxIntentos;
		this.nActualIntento = nOk + nErr;
	}
	
	public String getEstado() {
		result = nErr / nActualIntento * 100;
		if (result <= limiteErr) {
			return "Close";
		}
		
		String estado = "unknown";
			if (nActualIntento > nMaxIntentos) {
				estado = "OPEN";
			} else if (nActualIntento < nMaxIntentos) {
				estado = "HALF OPEN";
			}
		return estado;
	}
}

