
package visao;

import com.fasterxml.jackson.databind.ObjectMapper;
import controlador.CategoriaControlador;
import controlador.ProdutoControlador;
import dto.Resposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.Produto;


public class FrmGerenciarProduto extends javax.swing.JFrame {

    private DefaultTableModel tabela;
    private ProdutoControlador produtoControlador;
    private CategoriaControlador categoriaControlador;
    private ObjectMapper mapper;
    private Map<String, Integer> categoriasMap;

    private Object[][] dados = new Object[0][0];

    private String[] colunas = {"ID", "Nome", "Preço", "Unidade", "Qtd Estoque", "Qtd Mínima", "Qtd Máxima", "Categoria"};

    public FrmGerenciarProduto() {
        initComponents();
        this.produtoControlador = new ProdutoControlador();
        this.categoriaControlador = new CategoriaControlador();
        this.mapper = new ObjectMapper();
        this.categoriasMap = new HashMap<>();
        carregarCategoriasNoComboBox();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        tabela = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // ID não pode ser editado
            }
        };
        JTableProdutos.setModel(tabela);
        carregarProdutosNaTela();
    }

    private void carregarCategoriasNoComboBox() {
        ComboBoxCategoria.removeAllItems();
        categoriasMap.clear();

        Resposta<?> resposta = categoriaControlador.listarCategoria();
        Categoria[] categoriasArray = mapper.convertValue(resposta.getDados(), Categoria[].class);

        for (Categoria cat : categoriasArray) {
            ComboBoxCategoria.addItem(cat.getNome());
            categoriasMap.put(cat.getNome(), cat.getId());
        }
    }

    private void carregarProdutosNaTela() {
        tabela.setRowCount(0);

        Resposta<?> resposta = produtoControlador.listarProduto();
        Produto[] produtosArray = mapper.convertValue(resposta.getDados(), Produto[].class);

        Resposta<?> respostaCat = categoriaControlador.listarCategoria();
        Categoria[] categoriasArray = mapper.convertValue(respostaCat.getDados(), Categoria[].class);

        Map<Integer, String> categoriasMapLocal = new HashMap<>();
        for (Categoria c : categoriasArray) {
            categoriasMapLocal.put(c.getId(), c.getNome());
        }

        for (Produto p : produtosArray) {
            if (p.getId() == null) {
                continue; // ignora produtos sem id
            }
            String nomeCategoria = categoriasMapLocal.get(p.getCategoriaId());
            tabela.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.getUnidade(),
                p.getQuantidade(),
                p.getQuantidadeMinima(),
                p.getQuantidadeMaxima(),
                nomeCategoria
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableProdutos = new javax.swing.JTable();
        JLNome = new javax.swing.JLabel();
        JLPrecoUnitario = new javax.swing.JLabel();
        JLUnidade = new javax.swing.JLabel();
        JLQtdEstoque = new javax.swing.JLabel();
        JLQtdMinima = new javax.swing.JLabel();
        JLQtdMaxima = new javax.swing.JLabel();
        JLGerenciamentoProdutos = new javax.swing.JLabel();
        JTFQtdEstoque = new javax.swing.JTextField();
        JTFQtdMinima = new javax.swing.JTextField();
        JTFQtdMaxima = new javax.swing.JTextField();
        JBNovoProduto = new javax.swing.JButton();
        JBAlterarProduto = new javax.swing.JButton();
        JBVoltarProduto = new javax.swing.JButton();
        ComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JBExcluirProduto = new javax.swing.JButton();
        jBEntrada = new javax.swing.JButton();
        jBSaida = new javax.swing.JButton();
        jTEntradaSaida = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFNomeProduto = new javax.swing.JTextField();
        JTFPrecoUnitario = new javax.swing.JTextField();
        ComboBoxUnidade = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Produtos");

        JTableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Preço", "Quantidade", "QtdMinima", "QtdMaxima", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableProdutos.setColumnSelectionAllowed(true);
        JTableProdutos.getTableHeader().setReorderingAllowed(false);
        JTableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableProdutos);
        JTableProdutos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JLNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JLNome.setText("Nome");

        JLPrecoUnitario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JLPrecoUnitario.setText("Preço Unitário");

        JLUnidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JLUnidade.setText("Unidade");

        JLQtdEstoque.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JLQtdEstoque.setText("Qtd. em Estoque");

        JLQtdMinima.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JLQtdMinima.setText("Qtd. Mínima");

        JLQtdMaxima.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JLQtdMaxima.setText("Qtd. Máxima");

        JLGerenciamentoProdutos.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JLGerenciamentoProdutos.setText("Gerenciamento de Produtos");

        JBNovoProduto.setText("Novo");
        JBNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBNovoProdutoActionPerformed(evt);
            }
        });

        JBAlterarProduto.setText("Alterar");
        JBAlterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarProdutoActionPerformed(evt);
            }
        });

        JBVoltarProduto.setText("Voltar");
        JBVoltarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarProdutoActionPerformed(evt);
            }
        });

        ComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Categoria:");

        JBExcluirProduto.setText("Excluir");
        JBExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirProdutoActionPerformed(evt);
            }
        });

        jBEntrada.setText("Entrada");
        jBEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntradaActionPerformed(evt);
            }
        });

        jBSaida.setText("Saida");
        jBSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaidaActionPerformed(evt);
            }
        });

        jLabel2.setText("Adição e subtração de produto");

        JTFNomeProduto.setVerifyInputWhenFocusTarget(false);

        ComboBoxUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KG", "g", "L", "ml" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLGerenciamentoProdutos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLPrecoUnitario)
                    .addComponent(JLNome)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLUnidade)
                            .addComponent(JLQtdMinima)
                            .addComponent(JLQtdMaxima)
                            .addComponent(JLQtdEstoque))
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JTFQtdEstoque, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFQtdMinima, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTFQtdMaxima)
                    .addComponent(ComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTFNomeProduto)
                    .addComponent(JTFPrecoUnitario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboBoxUnidade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTEntradaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jBSaida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(JBNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(JBAlterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(JBExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(JBVoltarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JLNome, JLPrecoUnitario, JLQtdEstoque, JLQtdMaxima, JLQtdMinima, JLUnidade});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JLGerenciamentoProdutos)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JLNome)
                            .addComponent(JTFNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLPrecoUnitario)
                                    .addComponent(JTFPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JLUnidade)
                                    .addComponent(ComboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jTEntradaSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLQtdEstoque)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSaida)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFQtdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLQtdMinima))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFQtdMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLQtdMaxima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBNovoProduto)
                    .addComponent(JBAlterarProduto)
                    .addComponent(JBExcluirProduto)
                    .addComponent(JBVoltarProduto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JBVoltarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarProdutoActionPerformed
        FrmMenuPrincipal janela = new FrmMenuPrincipal();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBVoltarProdutoActionPerformed


    private void JBNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBNovoProdutoActionPerformed
        String nome = JTFNomeProduto.getText().trim();
        Double precoUni = Double.valueOf(JTFPrecoUnitario.getText().trim());
        String unidade = (String) ComboBoxUnidade.getSelectedItem();
        Integer estoque = Integer.valueOf(JTFQtdEstoque.getText().trim());
        Integer minima = Integer.valueOf(JTFQtdMinima.getText().trim());
        Integer maxima = Integer.valueOf(JTFQtdMaxima.getText().trim());

        // Pega o id da categoria pelo nome selecionado
        String nomeCategoria = (String) ComboBoxCategoria.getSelectedItem();
        Integer categoriaId = categoriasMap.get(nomeCategoria);

        Produto produto = new Produto(null, nome, precoUni, unidade, categoriaId, estoque, minima, maxima);

        // Chama o controlador para criar o produto
        produtoControlador.criarProduto(produto);
        JTFNomeProduto.setText("");
        JTFPrecoUnitario.setText("");
        JTFQtdEstoque.setText("");
        JTFQtdMinima.setText("");
        JTFQtdMaxima.setText("");
        ComboBoxUnidade.setSelectedIndex(0);
        ComboBoxCategoria.setSelectedIndex(0);

    }//GEN-LAST:event_JBNovoProdutoActionPerformed


    private void JTableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableProdutosMouseClicked
        int linha = JTableProdutos.getSelectedRow();
    if (linha == -1) return;

    JTFNomeProduto.setText(JTableProdutos.getValueAt(linha, 1) != null ? JTableProdutos.getValueAt(linha, 1).toString() : "");
    JTFPrecoUnitario.setText(JTableProdutos.getValueAt(linha, 2) != null ? JTableProdutos.getValueAt(linha, 2).toString() : "");
    ComboBoxUnidade.setSelectedItem(JTableProdutos.getValueAt(linha, 3) != null ? JTableProdutos.getValueAt(linha, 3).toString() : "");
    JTFQtdEstoque.setText(JTableProdutos.getValueAt(linha, 4) != null ? JTableProdutos.getValueAt(linha, 4).toString() : "");
    JTFQtdMinima.setText(JTableProdutos.getValueAt(linha, 5) != null ? JTableProdutos.getValueAt(linha, 5).toString() : "");
    JTFQtdMaxima.setText(JTableProdutos.getValueAt(linha, 6) != null ? JTableProdutos.getValueAt(linha, 6).toString() : "");
    ComboBoxCategoria.setSelectedItem(JTableProdutos.getValueAt(linha, 7) != null ? JTableProdutos.getValueAt(linha, 7).toString() : "");

    }//GEN-LAST:event_JTableProdutosMouseClicked


    private void JBAlterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarProdutoActionPerformed
        int linha = JTableProdutos.getSelectedRow();
    if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um produto para alterar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validação dos campos numéricos
    double preco;
    int qtdEstoque, qtdMin, qtdMax;

    try {
        preco = Double.parseDouble(JTFPrecoUnitario.getText());
        qtdEstoque = Integer.parseInt(JTFQtdEstoque.getText());
        qtdMin = Integer.parseInt(JTFQtdMinima.getText());
        qtdMax = Integer.parseInt(JTFQtdMaxima.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Valores numéricos inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Atualiza os valores na tabela
    JTableProdutos.setValueAt(JTFNomeProduto.getText(), linha, 1);
    JTableProdutos.setValueAt(preco, linha, 2);
    JTableProdutos.setValueAt(ComboBoxUnidade.getSelectedItem().toString(), linha, 3);
    JTableProdutos.setValueAt(qtdEstoque, linha, 4);
    JTableProdutos.setValueAt(qtdMin, linha, 5);
    JTableProdutos.setValueAt(qtdMax, linha, 6);
    JTableProdutos.setValueAt(ComboBoxCategoria.getSelectedItem().toString(), linha, 7);

    JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_JBAlterarProdutoActionPerformed


    private void JBExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirProdutoActionPerformed
        int linha = JTableProdutos.getSelectedRow();
        if (linha >= 0) {
            Integer id = (Integer) JTableProdutos.getValueAt(linha, 0);
            categoriaControlador.deletarCategoria(id);
            carregarProdutosNaTela();
        }
    }//GEN-LAST:event_JBExcluirProdutoActionPerformed


    private void jBEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntradaActionPerformed

    }//GEN-LAST:event_jBEntradaActionPerformed


    private void jBSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaidaActionPerformed

    }//GEN-LAST:event_jBSaidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCategoria;
    private javax.swing.JComboBox<String> ComboBoxUnidade;
    private javax.swing.JButton JBAlterarProduto;
    private javax.swing.JButton JBExcluirProduto;
    private javax.swing.JButton JBNovoProduto;
    private javax.swing.JButton JBVoltarProduto;
    private javax.swing.JLabel JLGerenciamentoProdutos;
    private javax.swing.JLabel JLNome;
    private javax.swing.JLabel JLPrecoUnitario;
    private javax.swing.JLabel JLQtdEstoque;
    private javax.swing.JLabel JLQtdMaxima;
    private javax.swing.JLabel JLQtdMinima;
    private javax.swing.JLabel JLUnidade;
    private javax.swing.JTextField JTFNomeProduto;
    private javax.swing.JTextField JTFPrecoUnitario;
    private javax.swing.JTextField JTFQtdEstoque;
    private javax.swing.JTextField JTFQtdMaxima;
    private javax.swing.JTextField JTFQtdMinima;
    private javax.swing.JTable JTableProdutos;
    private javax.swing.JButton jBEntrada;
    private javax.swing.JButton jBSaida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTEntradaSaida;
    // End of variables declaration//GEN-END:variables
}
