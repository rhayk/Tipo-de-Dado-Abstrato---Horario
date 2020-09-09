package teste;

import horario.Horario;

public class Teste {
	
	public static void main(String[] args) {
		Horario horario = new Horario();
		
		for(int i = 0; i <= 2000; i++) {
			System.out.println(horario);
			horario.incrementaMinuto();
		}
		
	}

}
