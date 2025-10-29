package controlador;

import dto.Resposta;
import modelo.Categoria;
import servico.CategoriaServico;

/**
 *
 * @author Lorenzo Bruscato
 */
public class CategoriaControlador {

    private final CategoriaServico servico = new CategoriaServico();

    public void criarCategoria(Categoria categoria) {
        Resposta<?> resposta = servico.criarCategoria(categoria);
        System.out.println(resposta.getMensagem());
    }

    public void atualizarCategoria(Categoria categoria) {
        Resposta<?> resposta = servico.atualizarCategoria(categoria);
        System.out.println(resposta.getMensagem());
    }

    public void deletarCategoria(Integer id) {
        Resposta<?> resposta = servico.deletarCategoria(id);
        System.out.println(resposta.getMensagem());
    }

    public void encontrarCategoria(Categoria categoria) {
        Resposta<?> resposta = servico.encontrarCategoria(categoria);
        System.out.println(resposta.getMensagem());
    }

    public void listarCategoria() {
        Resposta<?> resposta = servico.listarCategoria();
        System.out.println(resposta.getMensagem());
    }
}
