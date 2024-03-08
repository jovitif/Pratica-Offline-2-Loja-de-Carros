package controller;


public class Servidor {
	private int porta;
	private String ip;
	
	public Servidor(int porta, String ip) {
		setPorta(porta);
		setIp(ip);
	}
	
	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
		this.porta = porta;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
