package br.com.cartao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FinanceiroDoCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public void adicionaPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void pagarPedido(Pedido pedido, ClienteFinal cliente){
		pedido.setStatusPagamento(StatusPagamento.PAGO);
		
	}

}
