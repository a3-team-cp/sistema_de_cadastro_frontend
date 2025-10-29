    package servico;

    import dto.Requisicao;
    import dto.Resposta;
    import modelo.Categoria;
    import modelo.enums.Acao;
    import modelo.enums.Entidade;
    import socket.ClientSocket;

    /**
     *
     * @author Lorenzo Bruscato
     */
    public class CategoriaServico {

        private Categoria categotia;

        public Resposta<?> criarCategoria(Categoria categoria) {
        Requisicao<Categoria> req = new Requisicao<>(Acao.CRIAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> atualizarCategoria(Categoria categoria) {
        Requisicao<Categoria> req = new Requisicao<>(Acao.ATUALIZAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> deletarCategoria(Integer id) {
        Categoria categoria = new Categoria(id, null, null, null);
        Requisicao<Categoria> req = new Requisicao<>(Acao.DELETAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> encontrarCategoria(Categoria categoria) {
        Requisicao<Categoria> req = new Requisicao<>(Acao.ENCONTRAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }

    public Resposta<?> listarCategoria() {
        Requisicao<Void> req = new Requisicao<>(Acao.LISTAR, Entidade.CATEGORIA, null);
        return ClientSocket.enviarRequisicao(req);
    }
}