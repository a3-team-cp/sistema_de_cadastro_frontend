/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author diego
 */
public class Requisicao<T> {
    
    private String acao;
    private String entidade;
    private T dados;
    
    public Requisicao() {
    }
    
     public Requisicao(String acao, String entidade, T dados) {
        this.acao = acao;
        this.entidade = entidade;
        this.dados = dados;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }
    
}
