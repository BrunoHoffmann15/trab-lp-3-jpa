package Dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "venda")
public class Venda {
	private Long codVenda;
	private boolean gorgeta;
	private TipoPagamento tipoPagamento;
	private double valorTotal;
	private double desconto;
	private double valorTotalComDesconto;
	private Pedido pedido;
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	@Column(name = "cod_venda")
	public Long getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(Long codVenda) {
		this.codVenda = codVenda;
	}
	
	@Column(name = "gorgeta", nullable = false)
	public boolean isGorgeta() {
		return gorgeta;
	}
	public void setGorgeta(boolean gorgeta) {
		this.gorgeta = gorgeta;
	}
	
	@Column(name = "tipo_pagamento", nullable = false)
	@Enumerated(EnumType.STRING)
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	@Column(name = "valor_total", nullable = false)
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	@Column(name = "desconto", nullable = false)
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	@Column(name = "valor_total_com_desconto", nullable = false)
	public double getValorTotalComDesconto() {
		return valorTotalComDesconto;
	}
	public void setValorTotalComDesconto(double valorTotalComDesconto) {
		this.valorTotalComDesconto = valorTotalComDesconto;
	}
	@OneToOne
	@JoinColumn(name = "cod_pedido")
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
