package Dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "pedido")
public class Pedido {
	private Long codPedido;
	private String mesa;
	private Cliente cliente;
	private ArrayList<Bebida> bebidas;
	private ArrayList<Prato> pratos;
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name = "cod_pedido")
	public Long getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(Long codPedido) {
		this.codPedido = codPedido;
	}
	@Column(name = "mesa", nullable = false)
	public String getMesa() {
		return mesa;
	}
	public void setMesa(String mesa) {
		this.mesa = mesa;
	}
	@ManyToOne
	@JoinColumn(name = "cod_cliente")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@ManyToMany
	@JoinTable(name = "pedido_bebidas",
	joinColumns = @JoinColumn(name = "cod_pedido"),
	inverseJoinColumns = @JoinColumn(name = "cod_bebida"))
	public List<Bebida> getBebidas() {
		return bebidas;
	}
	public void setBebidas(ArrayList<Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	@ManyToMany
	@JoinTable(name = "pedido_prato",
	joinColumns = @JoinColumn(name = "cod_pedido"),
	inverseJoinColumns = @JoinColumn(name = "cod_prato"))
	public List<Prato> getPratos() {
		return pratos;
	}
	public void setPratos(ArrayList<Prato> pratos) {
		this.pratos = pratos;
	}
	
	
}
