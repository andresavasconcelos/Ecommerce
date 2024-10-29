package br.com.truedev.ecommerce.model;

import br.com.truedev.ecommerce.model.Produto;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_variante_produto")
public class Variante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variante")
    private Integer id;

    @Column(name = "nome_variante", length = 45, nullable = false)
    private String nome;

    @Column(name = "descricao_variante", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "link_foto", length = 255)
    private String linkFoto;

    @ManyToOne
    @JoinColumn(name = "tbl_produto_id_produto")
    private Produto produto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
