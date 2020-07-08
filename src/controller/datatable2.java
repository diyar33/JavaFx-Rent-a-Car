package controller;

public class datatable2 {
	
	private String marka;
	private int sira;
	private String model;
	private String yil;
	private String yakit;
	private String fiyat;
	private String motor;
	private String tarih;
	private String gun;
	

	public datatable2(String marka,int sira,String model,String yil,String gun,String yakit,String fiyat,String motor,String tarih) {
		this.fiyat=fiyat;
		this.marka=marka;
		this.model=model;
		this.motor=motor;
		this.tarih=tarih;
		this.gun=gun;
		this.sira=sira;
		this.yakit=yakit;
		this.yil=yil;
	
	}
	public String getTarih() {
		return tarih;
	}

	public String getGun() {
		return gun;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public void setGun(String gun) {
		this.gun = gun;
	}

	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public int getSira() {
		return sira;
	}
	public void setSira(int sira) {
		this.sira = sira;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYil() {
		return yil;
	}
	public void setYil(String yil) {
		this.yil = yil;
	}

	public String getYakit() {
		return yakit;
	}
	public void setYakit(String yakit) {
		this.yakit = yakit;
	}
	public String getFiyat() {
		return fiyat;
	}
	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	
	
	


}
