package View;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Persistencia.JpaUtil;

public class Main {
	public static void main(String []args){
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		do{
			System.out.println("Menu: \n1- Garçom; \n2- Administrador; \n3- Controle de Estoque; \n4- Finalizar");
			x = scanner.nextInt();
			switch (x) {
				case 1: 
					Garcom.menuGarcom();
					break;
				case 2:
					Administrador.menuAdministrador();
					break;
				case 3:
					ControladorEstoque.menuControladorEstoque();
					break;
			}
		}while(x!=0);
		JpaUtil.close();
	}
}
