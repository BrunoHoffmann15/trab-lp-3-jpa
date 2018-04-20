package Persistencia;

import javax.persistence.Persistence;

public class CriadorTabela {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("Restaurante");
	}
}