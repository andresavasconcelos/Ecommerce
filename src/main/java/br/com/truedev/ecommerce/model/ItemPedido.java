package br.com.truedev.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Var;

@Entity
@Table(name  = "tbl_itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq")
    private Integer numSeq;

    @Column(name = "valor_unitario")
    private Double valorUnitario;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "valor_total")
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "tbl_pedido_numero_pedido")
    @JsonIgnoreProperties("itens")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "tbl_variante_produto_id_variante")
    private Variante variante;

    public Integer getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(Integer numSeq) {
        this.numSeq = numSeq;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Variante getVariante() {
        return variante;
    }

    public void setVariante(Variante variante) {
        this.variante = variante;
    }
}
