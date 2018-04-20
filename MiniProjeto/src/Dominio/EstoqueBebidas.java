package Dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "estoque_bebida")
public class EstoqueBebidas {
	private Long codBebidaEstoque;
	private int quantidade;
	private Bebida bebida;
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name = "cod_bebida_estoque")
	public Long getCodBebidaEstoque() {
		return codBebidaEstoque;
	}
	public void setCodBebidaEstoque(Long codBebida) {
		this.codBebidaEstoque = codBebida;
	}
	@Column(name = "quantidade", nullable = false)
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@OneToOne
	@JoinColumn(name = "cod_bebida")
	public Bebida getBebida() {
		return bebida;
	}
	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}
	
	
	
}
