package visao;

/**
 * Classe que representa a tela principal do sistema de controle de estoque.
 * Serve como ponto de entrada para todas as funcionalidades do sistema através
 * de botões e um menu de navegação.
 *
 * <p>
 * Esta interface centraliza o acesso a todos os módulos do sistema, permitindo
 * navegação intuitiva entre as diferentes funcionalidades de gestão de
 * produtos, categorias, preços e relatórios.</p>
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Construtor que inicializa os componentes da interface principal.
     */
    public FrmMenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLMenuPrincipal = new javax.swing.JLabel();
        JBGerenciarCategorias = new javax.swing.JButton();
        JBReajustarPrecos = new javax.swing.JButton();
        JBSair = new javax.swing.JButton();
        JBGerenciarProdutos = new javax.swing.JButton();
        JBEmitirRelatorios = new javax.swing.JButton();
        jBMovimentacao = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuGerenciarProdutos = new javax.swing.JMenuItem();
        jMenuGerenciarCategorias = new javax.swing.JMenuItem();
        jMenuReajustarPrecos = new javax.swing.JMenuItem();
        jMenuEmitirRelatorios = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de Estoque - Menu Principal");

        JLMenuPrincipal.setBackground(new java.awt.Color(153, 153, 153));
        JLMenuPrincipal.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JLMenuPrincipal.setText("Menu Principal");
        JLMenuPrincipal.setAlignmentY(0.0F);

        JBGerenciarCategorias.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JBGerenciarCategorias.setText("Gerenciar Categorias");
        JBGerenciarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGerenciarCategoriasActionPerformed(evt);
            }
        });

        JBReajustarPrecos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JBReajustarPrecos.setText("Reajustar Preços");
        JBReajustarPrecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBReajustarPrecosActionPerformed(evt);
            }
        });

        JBSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JBSair.setText("Sair");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });

        JBGerenciarProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JBGerenciarProdutos.setText("Gerenciar Produtos");
        JBGerenciarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGerenciarProdutosActionPerformed(evt);
            }
        });

        JBEmitirRelatorios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JBEmitirRelatorios.setText("Emitir Relatórios");
        JBEmitirRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmitirRelatoriosActionPerformed(evt);
            }
        });

        jBMovimentacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jBMovimentacao.setText("Movimentação");
        jBMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMovimentacaoActionPerformed(evt);
            }
        });

        jMenuBar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuArquivo.setText("Arquivo");

        jMenuGerenciarProdutos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, 0));
        jMenuGerenciarProdutos.setText("Gerenciar Produtos");
        jMenuGerenciarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciarProdutosActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuGerenciarProdutos);

        jMenuGerenciarCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, 0));
        jMenuGerenciarCategorias.setText("Gerenciar Categorias");
        jMenuGerenciarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciarCategoriasActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuGerenciarCategorias);

        jMenuReajustarPrecos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, 0));
        jMenuReajustarPrecos.setText("Reajustar Preços");
        jMenuReajustarPrecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReajustarPrecosActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuReajustarPrecos);

        jMenuEmitirRelatorios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, 0));
        jMenuEmitirRelatorios.setText("Emitir Relatórios");
        jMenuArquivo.add(jMenuEmitirRelatorios);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, 0));
        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItem1);

        jMenuBar.add(jMenuArquivo);

        jMenuSobre.setText("Sobre");
        jMenuBar.add(jMenuSobre);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(JLMenuPrincipal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(JBGerenciarProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBReajustarPrecos, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jBMovimentacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBGerenciarCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JBEmitirRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(JLMenuPrincipal)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGerenciarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBGerenciarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBReajustarPrecos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBEmitirRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBSair, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBMovimentacao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Encerra a aplicação quando o botão Sair é acionado.
     *
     * <p>
     * Finaliza completamente a execução do sistema de controle de estoque,
     * liberando todos os recursos alocados.</p>
     *
     * @param evt evento de ação do botão
     */
    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JBSairActionPerformed

    /**
     * Abre o formulário de gerenciamento de produtos.
     *
     * <p>
     * Navega para a tela de gerenciamento de produtos onde o usuário pode
     * realizar operações CRUD (criar, ler, atualizar, deletar) sobre os
     * produtos do sistema.</p>
     *
     * @param evt evento de ação do botão
     */
    private void JBGerenciarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGerenciarProdutosActionPerformed
        FrmGerenciarProduto janela = new FrmGerenciarProduto();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBGerenciarProdutosActionPerformed

    /**
     * Abre o formulário de emissão de relatórios através do menu.
     *
     * <p>
     * Navega para a tela de emissão de relatórios através do menu Arquivo,
     * proporcionando acesso alternativo à funcionalidade.</p>
     *
     * @param evt evento de ação do item de menu
     */
    private void JBEmitirRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEmitirRelatoriosActionPerformed
        FrmEmitirRelatorio janela = new FrmEmitirRelatorio();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBEmitirRelatoriosActionPerformed

    /**
     * Abre o formulário de gerenciamento de categorias.
     *
     * <p>
     * Navega para a tela de gerenciamento de categorias onde o usuário pode
     * realizar operações CRUD sobre as categorias de produtos.</p>
     *
     * @param evt evento de ação do botão
     */
    private void JBGerenciarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGerenciarCategoriasActionPerformed
        FrmGerenciarCategoria janela = new FrmGerenciarCategoria();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBGerenciarCategoriasActionPerformed

    /**
     * Abre o formulário de gerenciamento de categorias através do menu.
     *
     * <p>
     * Navega para a tela de gerenciamento de categorias através do menu
     * Arquivo, proporcionando acesso alternativo à funcionalidade.</p>
     *
     * @param evt evento de ação do item de menu
     */
    private void jMenuGerenciarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciarCategoriasActionPerformed
        FrmGerenciarCategoria janela = new FrmGerenciarCategoria();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuGerenciarCategoriasActionPerformed

    /**
     * Abre o formulário de gerenciamento de produtos através do menu.
     *
     * <p>
     * Navega para a tela de gerenciamento de produtos através do menu Arquivo,
     * proporcionando acesso alternativo à funcionalidade.</p>
     *
     * @param evt evento de ação do item de menu
     */
    private void jMenuGerenciarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciarProdutosActionPerformed
        // Instancia a tela de cadastro de aluno
        FrmGerenciarProduto objeto = new FrmGerenciarProduto();
        objeto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuGerenciarProdutosActionPerformed

    /**
     * Abre o formulário de reajuste de preços.
     *
     * <p>
     * Navega para a tela de reajuste de preços onde o usuário pode aplicar
     * percentuais de aumento ou redução nos preços dos produtos.</p>
     *
     * @param evt evento de ação do botão
     */
    private void JBReajustarPrecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBReajustarPrecosActionPerformed
        FrmReajustarPreco janela = new FrmReajustarPreco();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBReajustarPrecosActionPerformed

    /**
     * Encerra a aplicação através do menu.
     *
     * <p>
     * Finaliza completamente a execução do sistema através da opção de menu
     * Arquivo → Sair.</p>
     *
     * @param evt evento de ação do item de menu
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Abre o formulário de reajuste de preços através do menu.
     *
     * <p>
     * Navega para a tela de reajuste de preços através do menu Arquivo,
     * proporcionando acesso alternativo à funcionalidade.</p>
     *
     * @param evt evento de ação do item de menu
     */
    private void jMenuReajustarPrecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReajustarPrecosActionPerformed
        FrmReajustarPreco janela = new FrmReajustarPreco();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuReajustarPrecosActionPerformed

    /**
     * Abre o formulário de movimentação de estoque.
     *
     * <p>
     * Navega para a tela de movimentação de estoque onde o usuário pode
     * registrar entradas e saídas de produtos do estoque.</p>
     *
     * @param evt evento de ação do botão
     */
    private void jBMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMovimentacaoActionPerformed
        FrmMovimentacao janela = new FrmMovimentacao();
        janela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBMovimentacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEmitirRelatorios;
    private javax.swing.JButton JBGerenciarCategorias;
    private javax.swing.JButton JBGerenciarProdutos;
    private javax.swing.JButton JBReajustarPrecos;
    private javax.swing.JButton JBSair;
    private javax.swing.JLabel JLMenuPrincipal;
    private javax.swing.JButton jBMovimentacao;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuEmitirRelatorios;
    private javax.swing.JMenuItem jMenuGerenciarCategorias;
    private javax.swing.JMenuItem jMenuGerenciarProdutos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuReajustarPrecos;
    private javax.swing.JMenu jMenuSobre;
    // End of variables declaration//GEN-END:variables
}
