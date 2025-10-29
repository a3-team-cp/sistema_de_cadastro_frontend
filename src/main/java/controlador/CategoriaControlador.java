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

    public Resposta<?> criarCategoria(Categoria categoria) {
        return servico.criarCategoria(categoria);
    }

    public Resposta<?> atualizarCategoria(Categoria categoria) {
        return servico.atualizarCategoria(categoria);
    }

    public Resposta<?> deletarCategoria(Integer id) {
        return servico.deletarCategoria(id);
    }

    public Resposta<?> encontrarCategoria(Categoria categoria) {
        return servico.encontrarCategoria(categoria);
    }

    public Resposta<?> listarCategoria() {
        return servico.listarCategoria();
    }
}