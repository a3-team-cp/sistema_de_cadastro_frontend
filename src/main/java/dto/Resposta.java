/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author diego
 */
public class Resposta<T> {
    
    private String status;
    private String mensagem;
    private T dados;

    public Resposta(String status, String mensagem, T dados) {
        this.status = status;
        this.mensagem = mensagem;
        this.dados = dados;
    }
    
    public String getStatus() {
        return status; 
    }
    
    public String getMensagem() {
        return mensagem; 
    }
    
    public T getDados() { 
        return dados;
    }    
}
