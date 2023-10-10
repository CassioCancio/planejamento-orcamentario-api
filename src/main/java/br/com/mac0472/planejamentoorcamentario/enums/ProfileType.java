package br.com.mac0472.planejamentoorcamentario.enums;

public enum ProfileType {
    DECLARANT("declarant"),
    GRS("system_adm"),
    OTHER("other");
    
    private String type;
	
	ProfileType(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}