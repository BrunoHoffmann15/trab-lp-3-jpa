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
@Table(name = "estoque_prato")
public class EstoquePrato {
	private Long codEstoquePrato;
	private int quantidade;
	private Prato prato;
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name = "cod_prato_estoque")
	public Long getCodEstoquePrato() {
		return codEstoquePrato;
	}
	public void setCodEstoquePrato(Long codEstoquePrato) {
		this.codEstoquePrato = codEstoquePrato;
	}
	@Column(name = "quantidade", nullable = false)
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@OneToOne
	@JoinColumn(name = "cod_prato")
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
}
