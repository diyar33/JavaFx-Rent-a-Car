package controller;

public class datatable {
	
	private String marka;
	private int sira;
	private String model;
	private String yil;
	private String segment;
	private String yakit;
	private String fiyat;
	private String motor;
	private int id;

	public datatable(String marka,int sira,String model,String yil,String segment,String yakit,String fiyat,String motor,int id) {
		this.fiyat=fiyat;
		this.marka=marka;
		this.model=model;
		this.motor=motor;
		this.segment=segment;
		this.sira=sira;
		this.yakit=yakit;
		this.yil=yil;
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
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
