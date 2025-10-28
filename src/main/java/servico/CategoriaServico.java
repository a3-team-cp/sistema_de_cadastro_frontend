    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package servico;

    import dto.Requisicao;
    import dto.Resposta;
    import modelo.Categoria;
    import modelo.enums.Acao;
    import modelo.enums.Entidade;
    import socket.ClientSocket;

    /**
     *
     * @author diego
     */
    public class CategoriaServico {

        private Categoria categotia;

       public Resposta<?> criar(Categoria categoria) {
        Requisicao<Categoria> req = new Requisicao<>(Acao.CRIAR, Entidade.CATEGORIA, categoria);
        return ClientSocket.enviarRequisicao(req);
    }
}
