package br.com.truedev.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ususario")
    private Integer id;
    @Column(name = "nome_usuario", nullable = false, length = 45)
    private String nome;
    @Column(name = "login_usuario", nullable = false, length = 20)
    private String login;
    @Column(name = "senha_usuario", nullable = false, length = 100)
    private String senha;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
