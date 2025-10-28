/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dto.Resposta;
import modelo.Categoria;
import servico.CategoriaServico;

/**
 *
 * @author diego
 */
public class CategoriaControlador {
    
    private final CategoriaServico servico = new CategoriaServico();

    public void criarCategoria(Categoria categoria) {
        Resposta<?> resposta = servico.criar(categoria);
        System.out.println(resposta.getMensagem());
    }
    
    
}
