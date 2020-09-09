package horario;

public class Horario {
	
	private int segundos;
	
	public Horario() {
		segundos = 0;
	}
	
	public Horario(int hora, int minuto, int segundo) {
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}
	
	public int getHora() {
		return converterTempo()[0];
	}
	
	public void setHora(int hora) {
		if(!(hora >= 0 && hora <= 23))
			throw new IllegalStateException("Hora inválida");
		segundos += hora * 3600;
	}
	
	public int getMinuto() {
		return converterTempo()[1];
	}
	
	public void setMinuto(int minuto) {
		if(!(minuto >= 0 && minuto <= 59)) {
			throw new IllegalStateException("Minuto inválido");
		}
		segundos += minuto * 60;
	}
	
	public int getSegundo() {
		return converterTempo()[2];
	}
	
	public void setSegundo(int segundo) {
		if(!(segundo >= 0 && segundo <= 59)) {
			throw new IllegalStateException("Segundo inválido");
		}
		segundos += segundo;
	}
	
	public void incrementaSegundo() {
		if(ehUltimoSegundo()) {
			segundos = 0;
		}
		else
			segundos++;
	}
	
	public void incrementaMinuto() {
		if(getMinuto() == 59) {
			segundos -= 60 * 59;
			incrementaHora();
		}
		else
			segundos += 60;
	}
	
	public void incrementaHora() {
		if(getHora() == 23)
			segundos -= 3600 * 23;
		else
			segundos += 3600;
	}
	
	private boolean ehUltimoSegundo() {
		int ultimoSegundo = 86399;
		if(segundos == ultimoSegundo)
			return true;
		return false;
	}

	private int[] converterTempo() {
		int hora = this.segundos / 3600;
		int minuto = (this.segundos - 3600 * hora) / 60;
		int segundos = this.segundos - (3600 * hora) - (60 * minuto);
		
		int[] horario = {hora, minuto, segundos};
		
		return horario;
	}
	
	@Override
	public String toString() {
		int[] horario = converterTempo();
		return String.format("%02d:%02d:%02d", horario[0], horario[1], horario[2]);
	}
	
}
