package visao;

import com.fasterxml.jackson.databind.ObjectMapper;
import controlador.RegistroControlador;
import dto.Resposta;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelo.Registro;

/**
 * Formulário para visualização das movimentações de estoque do sistema.
 *
 * <p>
 * Esta interface exibe um histórico completo de todas as movimentações
 * realizadas no estoque, incluindo entradas, saídas e seus respectivos status,
 * permitindo o acompanhamento das operações realizadas.</p>
 *
 * <p>
 * Apresenta os dados em formato de tabela com informações detalhadas sobre cada
 * movimentação registrada no sistema.</p>
 */
public class FrmMovimentacao extends javax.swing.JFrame {

    /**
     * Controlador responsável pelas operações de registro.
     */
    private RegistroControlador registroControlador;

    /**
     * Modelo de dados para a tabela de movimentações.
     */
    private DefaultTableModel tabela;

    /**
     * Mapeador JSON para conversão de objetos.
     */
    private ObjectMapper mapper;

    /**
     * Dados iniciais da tabela.
     */
    private Object[][] dados = new Object[0][0];

    /**
     * Nomes das colunas da tabela de movimentações.
     */
    private String[] colunas = {"ID", "Data", "Produto_id", "Quntidade", "Movimentação", "Status_Estoque"};

    /**
     * Construtor que inicializa os componentes e configura a interface.
     */
    public FrmMovimentacao() {
        initComponents();
        this.registroControlador = new RegistroControlador();
        this.mapper = new ObjectMapper();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabela = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // ID não pode ser editado
            }
        };
        jTableRegistro.setModel(tabela);
        carregarRegistroNaTela();
    }

    /**
     * Carrega todos os registros de movimentação do servidor e exibe na tabela.
     *
     * <p>
     * Recupera a lista completa de movimentações através do controlador e
     * popula a tabela da interface gráfica com os dados obtidos.</p>
     *
     * <p>
     * <b>Processamento:</b></p>
     * <ul>
     * <li>Limpa a tabela atual</li>
     * <li>Busca registros do servidor</li>
     * <li>Converte os dados para objetos Registro</li>
     * <li>Popula a tabela com os dados formatados</li>
     * </ul>
     */
    private void carregarRegistroNaTela() {
        Resposta<?> resposta = registroControlador.listarRegistro();

        Registro[] registroArray = mapper.convertValue(resposta.getDados(), Registro[].class);

        List<Registro> registro = Arrays.asList(registroArray);

        tabela.setRowCount(0);
        for (Registro r : registro) {
            tabela.addRow(new Object[]{r.getId(), r.getData(), r.getProdutoId(), r.getQuantidade(), r.getMovimentacao(), r.getStatus()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLGerenciamentoProdutos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistro = new javax.swing.JTable();
        JBVoltarMovimentacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimentação de Estoque");
        setAlwaysOnTop(true);

        JLGerenciamentoProdutos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JLGerenciamentoProdutos.setText("Movimentação de Estoque");

        jTableRegistro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Produto_Id", "Qtd", "Movimentação", "Status_Estoque"
            }
        ));
        jTableRegistro.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableRegistro);

        JBVoltarMovimentacao.setText("Voltar");
        JBVoltarMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarMovimentacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(JLGerenciamentoProdutos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(JBVoltarMovimentacao)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(JLGerenciamentoProdutos)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBVoltarMovimentacao)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Retorna ao menu principal quando o botão Voltar é acionado.
     *
     * <p>
     * Fecha a janela atual de movimentações e retorna ao menu principal
     * da aplicação, permitindo ao usuário navegar para outras funcionalidades
     * do sistema.</p>
     *
     * @param evt evento de ação do botão
     */
    private void JBVoltarMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarMovimentacaoActionPerformed
        FrmMenuPrincipal janela = new FrmMenuPrincipal();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBVoltarMovimentacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBVoltarMovimentacao;
    private javax.swing.JLabel JLGerenciamentoProdutos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRegistro;
    // End of variables declaration//GEN-END:variables
}
