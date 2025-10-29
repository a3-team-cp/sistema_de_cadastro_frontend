package visao;

import com.fasterxml.jackson.databind.ObjectMapper;
import controlador.CategoriaControlador;
import dto.Resposta;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.enums.Embalagem;
import modelo.enums.Tamanho;
import util.TextoUtil;

public class FrmGerenciarCategoria extends javax.swing.JFrame {

    private CategoriaControlador categoriaControlador;
    
    private ObjectMapper mapper;

    private DefaultTableModel tabela;
    
    private Integer selectedId = null;
    private int selectedModelRow = -1;


    private Object[][] dados = new Object[0][0];

    private String[] colunas = {"ID", "Nome", "Tamanho", "Embalagem"};

    public FrmGerenciarCategoria() {
        initComponents();
        this.categoriaControlador = new CategoriaControlador();
        this.mapper = new ObjectMapper();
        tabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // ID não editável
            }
        };
        JTableCategoria.setModel(tabela);
        carregarCategoriasNaTela();
    }

    public static String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    private void carregarCategoriasNaTela() {
        Resposta<?> resposta = categoriaControlador.listarCategoria();

        Categoria[] categoriasArray = mapper.convertValue(resposta.getDados(), Categoria[].class);

        List<Categoria> categorias = Arrays.asList(categoriasArray);

        tabela.setRowCount(0);
        for (Categoria c : categorias) {
            tabela.addRow(new Object[]{c.getId(), c.getNome(), c.getTamanho(), c.getEmbalagem()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLGerenciamentoProdutos = new javax.swing.JLabel();
        JLNomeGerenciamentoC = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableCategoria = new javax.swing.JTable();
        JBAlterarGerenciamentoC = new javax.swing.JButton();
        JBExcluirGerenciamentoC = new javax.swing.JButton();
        JBVoltarCategoria = new javax.swing.JButton();
        CBBoxCatTipo = new javax.swing.JComboBox<>();
        JTFNomeDeCategoria = new javax.swing.JTextField();
        CBBoxCatTamanho = new javax.swing.JComboBox<>();
        BtnCriarCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Categoria");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLGerenciamentoProdutos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JLGerenciamentoProdutos.setText("Gerenciamento de Categorias");

        JLNomeGerenciamentoC.setText("Nome da Categoria:");

        JTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tamanho", "Embalagem"
            }
        ));
        JTableCategoria.getTableHeader().setReorderingAllowed(false);
        JTableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableCategoria);

        JBAlterarGerenciamentoC.setText("Alterar");
        JBAlterarGerenciamentoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarGerenciamentoCActionPerformed(evt);
            }
        });

        JBExcluirGerenciamentoC.setText("Excluir");
        JBExcluirGerenciamentoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirGerenciamentoCActionPerformed(evt);
            }
        });

        JBVoltarCategoria.setText("Voltar");
        JBVoltarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarCategoriaActionPerformed(evt);
            }
        });

        CBBoxCatTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lata", "Vidro", "Plástico" }));

        CBBoxCatTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequeno", "Médio", "Grande" }));

        BtnCriarCategoria.setText("Novo");
        BtnCriarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCriarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JLNomeGerenciamentoC, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLGerenciamentoProdutos)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTFNomeDeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnCriarCategoria)
                                        .addGap(18, 18, 18)
                                        .addComponent(JBAlterarGerenciamentoC)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBExcluirGerenciamentoC)
                                        .addGap(18, 18, 18)
                                        .addComponent(JBVoltarCategoria))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CBBoxCatTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(CBBoxCatTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(JLGerenciamentoProdutos)
                .addGap(146, 146, 146)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAlterarGerenciamentoC)
                    .addComponent(JBExcluirGerenciamentoC)
                    .addComponent(JBVoltarCategoria)
                    .addComponent(BtnCriarCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBBoxCatTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNomeGerenciamentoC)
                    .addComponent(JTFNomeDeCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBBoxCatTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregarCategoriasNaTela();
    }//GEN-LAST:event_formWindowOpened

    private void JBVoltarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarCategoriaActionPerformed
        FrmMenuPrincipal janela = new FrmMenuPrincipal();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBVoltarCategoriaActionPerformed

    private void JBAlterarGerenciamentoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarGerenciamentoCActionPerformed
        Integer linhaSelecionada = JTableCategoria.getSelectedRow();    
        int id = (Integer) JTableCategoria.getValueAt(linhaSelecionada, 0);
        
        
         String nome = JTFNomeDeCategoria.getText();
        
        String strTamanho = CBBoxCatTamanho.getSelectedItem().toString().toUpperCase();
        String tamanhoNormalizado = TextoUtil.removerAcentos(strTamanho);
        Tamanho tamanho = Tamanho.valueOf(tamanhoNormalizado);
        
        String strEmbalagem = CBBoxCatTipo.getSelectedItem().toString().toUpperCase();
        String embalagemNormalizado = TextoUtil.removerAcentos(strEmbalagem);
        Embalagem embalagem = Embalagem.valueOf(embalagemNormalizado);
        
        
        Categoria cat = new Categoria(id, nome, tamanho, embalagem);
        
        categoriaControlador.atualizarCategoria(cat);
        carregarCategoriasNaTela();  
    }//GEN-LAST:event_JBAlterarGerenciamentoCActionPerformed

    private void JTableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableCategoriaMouseClicked
             int linhaSelecionada = JTableCategoria.getSelectedRow();
    if (linhaSelecionada != -1) {
        // Pega os valores da linha
        String nome = JTableCategoria.getValueAt(linhaSelecionada, 1).toString();
        String tamanho = JTableCategoria.getValueAt(linhaSelecionada, 2).toString();
        String embalagem = JTableCategoria.getValueAt(linhaSelecionada, 3).toString();

        // Coloca no campo de texto
        JTFNomeDeCategoria.setText(nome);

        // Normaliza para comparação segura
        String tamanhoNorm = TextoUtil.normalizar(tamanho);
        String embalagemNorm = TextoUtil.normalizar(embalagem);

        // Seleciona o tamanho na comboBox
        for (int i = 0; i < CBBoxCatTamanho.getItemCount(); i++) {
            String itemNorm = TextoUtil.normalizar(CBBoxCatTamanho.getItemAt(i));
            if (itemNorm.equals(tamanhoNorm)) {
                CBBoxCatTamanho.setSelectedIndex(i);
                break;
            }
        }

        // Seleciona a embalagem na comboBox
        for (int i = 0; i < CBBoxCatTipo.getItemCount(); i++) {
            String itemNorm = TextoUtil.normalizar(CBBoxCatTipo.getItemAt(i));
            if (itemNorm.equals(embalagemNorm)) {
                CBBoxCatTipo.setSelectedIndex(i);
                break;
            }
        }
    }
             
    }//GEN-LAST:event_JTableCategoriaMouseClicked

    private void JBExcluirGerenciamentoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirGerenciamentoCActionPerformed

    }//GEN-LAST:event_JBExcluirGerenciamentoCActionPerformed

    private void BtnCriarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCriarCategoriaActionPerformed
        String nome = JTFNomeDeCategoria.getText();
        
        String strTamanho = CBBoxCatTamanho.getSelectedItem().toString().toUpperCase();
        String tamanhoNormalizado = TextoUtil.removerAcentos(strTamanho);
        Tamanho tamanho = Tamanho.valueOf(tamanhoNormalizado);
        
        String strEmbalagem = CBBoxCatTipo.getSelectedItem().toString().toUpperCase();
        String embalagemNormalizado = TextoUtil.removerAcentos(strEmbalagem);
        Embalagem embalagem = Embalagem.valueOf(embalagemNormalizado);
        
        
        Categoria cat = new Categoria(null, nome, tamanho, embalagem);
        categoriaControlador.criarCategoria(cat);
        carregarCategoriasNaTela();
    }//GEN-LAST:event_BtnCriarCategoriaActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCriarCategoria;
    private javax.swing.JComboBox<String> CBBoxCatTamanho;
    private javax.swing.JComboBox<String> CBBoxCatTipo;
    private javax.swing.JButton JBAlterarGerenciamentoC;
    private javax.swing.JButton JBExcluirGerenciamentoC;
    private javax.swing.JButton JBVoltarCategoria;
    private javax.swing.JLabel JLGerenciamentoProdutos;
    private javax.swing.JLabel JLNomeGerenciamentoC;
    private javax.swing.JTextField JTFNomeDeCategoria;
    private javax.swing.JTable JTableCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
