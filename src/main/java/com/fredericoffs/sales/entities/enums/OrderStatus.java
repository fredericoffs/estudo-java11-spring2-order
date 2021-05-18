package com.fredericoffs.sales.entities.enums;

	/* passar explícitamente os códigos dos enums para facilitar 
	// caso haja manutenção futuramente não perca as referëncias
	// pois no banco irá gravar o código */

public enum OrderStatus {
	
	WAITING_PAYMENT(1), 
	PAID(2), 
	SHIPPED(3), 
	DELIVERED(4), 
	CANCELED(5);
	
	private int code;
	
	// Construtor private 
	private OrderStatus(int code) {
		this.code = code;
	}
	
	// método publico para retornar o code do tipo enumerado
	public int getCode() {
		return code;
	}
	
	// método estático (náo precisa instanciar) para converter o valor numerico em um tipo enumerado, 
	public static OrderStatus valueOf(int code) {
		
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid OrderStatus code.");
	}
	
}
