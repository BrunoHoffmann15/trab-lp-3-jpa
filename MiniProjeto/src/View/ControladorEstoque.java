package View;

import java.util.List;
import java.util.Scanner;

import Controller.BebidaController;
import Controller.EstoqueBebidaController;
import Controller.EstoquePratoController;
import Controller.PratoController;
import Dominio.Bebida;
import Dominio.EstoqueBebidas;
import Dominio.EstoquePrato;
import Dominio.Prato;

public class ControladorEstoque {
	private static Scanner scanner = new Scanner(System.in);
	public static void menuControladorEstoque(){
		int menu = 0;
		do{
			System.out.println("Menu Controle de Estoque \n1- Adicionar Bebida \n2- Aumentar Estoque Bebida \n3- Alterar o preço da bebida\n4- Inventário bebida"
					+ "\n5- Adicionar Prato \n6- Aumentar Estoque Prato \n7- Alterar o preço do prato \n8- Inventário prato \n9- Ir para menu inicial");
			menu = scanner.nextInt();
			switch (menu){
				case 1:
					adicionarNovaBebida();
					break;
				case 2:
					aumentarEstoqueDeBedida();
					break;
				case 3:
					aumentarPrecoBebida();
					break;
				case 4:
					inventarioBebida();
					break;
				case 5:
					adicionarPrato();
					break;
				case 6:
					aumentarEstoquePrato();
					break;
				case 7: 
					aumentarPrecoPrato();
					break;
				case 8:
					inventarioPrato();
					break;
			}
		}while(menu != 9);
	}
	private static void adicionarNovaBebida(){
		BebidaController bedidaController = new BebidaController();
		Bebida bebida = new Bebida();
		EstoqueBebidas estoqueBebida = new EstoqueBebidas();
		try{			
			System.out.println("Digite o nome da Bebida");
			bebida.setNome(scanner.next());
			System.out.println("Digite o valor da bebida");
			double valor = scanner.nextDouble();
			bebida.setValor(valor);
			System.out.println("Digite a quantidade atual da bebida");
			estoqueBebida.setQuantidade(scanner.nextInt());
			bedidaController.adicionarBebida(bebida, estoqueBebida);
			System.out.println("Bebida Adicionada com sucesso");
		}catch(Exception e){
			System.out.println("Ocorreu um erro");
		}
	}
	private static void aumentarEstoqueDeBedida(){
		System.out.println("Bebidas: ");
		EstoqueBebidaController estoqueBebidasController = new EstoqueBebidaController();
		List<EstoqueBebidas> estoqueBebidas = estoqueBebidasController.listarTodos();
		if(estoqueBebidas.isEmpty()){
			System.out.println("Você não possui nenhuma bebida");
		}else{
			for(EstoqueBebidas estoque : estoqueBebidas){
				System.out.println("Id: "+estoque.getCodBebidaEstoque()+", Nome: "+estoque.getBebida().getNome() +", quantidade: "+estoque.getQuantidade());
			}
			try{
				System.out.println("\n\nQual o id da bebida?");
				EstoqueBebidas estoque = estoqueBebidasController.getOne(scanner.nextLong());
				System.out.println("Quantas unidades deseja aumentar?");
				estoqueBebidasController.atualizar(estoque, scanner.nextInt());
				System.out.println("Estoque aumentado com sucesso");
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
			}
		}
	}
	private static void aumentarPrecoBebida(){
		System.out.println("Bebidas: ");
		BebidaController bebidaController = new BebidaController();
		List<Bebida> bebidas = bebidaController.listarTodos(); 
		if(bebidas.isEmpty()){
			System.out.println("Você não possui nenhuma bebida");
		}else{
			for(Bebida bebida : bebidas){
				System.out.println("Id: "+bebida.getCodBebida()+", Nome: "+bebida.getNome()+", Valor: R$"+bebida.getValor());
			}
			try{
				System.out.println("Digite o id da bebida");
				Bebida bebida = bebidaController.getOneById(scanner.nextLong());
				System.out.println("Digite quanto você deseja adicionar ou remover do valor: ");
				bebidaController.atualizar(bebida, scanner.nextDouble());
				System.out.println("Valor alterado com sucesso.");
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
			}
		}
	}
	private static void inventarioBebida(){
		System.out.println("Inventário: ");
		EstoqueBebidaController estoqueBebidasController = new EstoqueBebidaController();
		List<EstoqueBebidas> estoqueBebidas = estoqueBebidasController.listarTodos();
		if(estoqueBebidas.isEmpty()){
			System.out.println("Você não possui nenhuma bebida");
		}else{
			for(EstoqueBebidas estoque : estoqueBebidas){
				System.out.println("Id: "+estoque.getCodBebidaEstoque()+", Nome: "+estoque.getBebida().getNome() +", quantidade: "+estoque.getQuantidade()+ ", Valor Total: R$"+(estoque.getBebida().getValor()*estoque.getQuantidade()));
			}
			System.out.println("Total: R$"+estoqueBebidasController.getInventarioBebida(estoqueBebidas));
		}
	}
	private static void adicionarPrato(){
		PratoController pratoController = new PratoController();
		Prato prato = new Prato();
		EstoquePrato estoquePrato = new EstoquePrato();
		try{			
			System.out.println("Digite o nome do Prato");
			prato.setNome(scanner.next());
			System.out.println("Digite o valor do prato");
			double valor = scanner.nextDouble();
			prato.setValor(valor);
			System.out.println("Digite uma descrição do prato: ");
			prato.setDescricao(scanner.next());
			System.out.println("Digite a quantidade atual do prato");
			estoquePrato.setQuantidade(scanner.nextInt());
			pratoController.adicionarBebida(prato, estoquePrato);
			System.out.println("Prato Adicionada com sucesso");
		}catch(Exception e){
			System.out.println("Ocorreu um erro");
		}
	}
	private static void aumentarEstoquePrato(){
		System.out.println("Pratos: ");
		EstoquePratoController estoquePratoController = new EstoquePratoController();
		List<EstoquePrato> estoquePratos = estoquePratoController.listarTodos();
		if(estoquePratos.isEmpty()){
			System.out.println("Você não possui nenhum prato");
		}else{
			for(EstoquePrato estoque : estoquePratos){
				System.out.println("Id: "+estoque.getCodEstoquePrato()+", Nome: "+estoque.getPrato().getNome() +", quantidade: "+estoque.getQuantidade());
			}
			try{
				System.out.println("\n\nQual o id da prato?");
				EstoquePrato estoque = estoquePratoController.getOne(scanner.nextLong());
				System.out.println("Quantas unidades deseja aumentar?");
				estoquePratoController.atualizar(estoque, scanner.nextInt());
				System.out.println("Estoque aumentado com sucesso");
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
			}
		}
	}
	private static void aumentarPrecoPrato(){
		System.out.println("Bebidas: ");
		PratoController pratoController = new PratoController();
		List<Prato> pratos = pratoController.listarTodos(); 
		if(pratos.isEmpty()){
			System.out.println("Você não possui nenhum prato");
		}else{
			for(Prato prato : pratos){
				System.out.println("Id: "+prato.getCodPrato()+", Nome: "+prato.getNome()+", Valor: R$"+prato.getValor());
			}
			try{
				System.out.println("Digite o id do prato");
				Prato prato = pratoController.getOneById(scanner.nextLong());
				System.out.println("Digite quanto você deseja adicionar ou remover do valor: ");
				pratoController.atualizar(prato, scanner.nextDouble());
				System.out.println("Valor alterado com sucesso.");
			}catch(Exception e){
				System.out.println("Ocorreu um erro");
			}
		}
	}
	private static void inventarioPrato(){
		System.out.println("Inventário: ");
		EstoquePratoController estoquePratoController = new EstoquePratoController();
		List<EstoquePrato> estoquePrato = estoquePratoController.listarTodos();
		if(estoquePrato.isEmpty()){
			System.out.println("Você não possui nenhuma bebida");
		}else{
			for(EstoquePrato estoque : estoquePrato){
				System.out.println("Id: "+estoque.getCodEstoquePrato()+", Nome: "+estoque.getPrato().getNome() +", quantidade: "+estoque.getQuantidade()+ ", Valor Total: R$"+(estoque.getPrato().getValor()*estoque.getQuantidade()));
			}
			System.out.println("Total: R$"+estoquePratoController.getInventarioPrato(estoquePrato));
		}
	}
}
