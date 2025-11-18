package visao;

import com.itextpdf.text.BaseColor;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import modelo.Relatorio;
import servico.RelatorioServico;

/**
 * Formulário para emissão de relatórios em formato PDF.
 *
 * <p>
 * Esta interface permite ao usuário selecionar o tipo de relatório, escolher o
 * local de salvamento e gerar documentos PDF formatados com os dados de
 * movimentação do sistema.</p>
 *
 * <p>
 * Utiliza a biblioteca iText para geração de PDFs com layout profissional
 * incluindo tabelas formatadas, cabeçalhos e totais.</p>
 */
public class FrmEmitirRelatorio extends javax.swing.JFrame {

    /**
     * Caminho do arquivo selecionado para salvamento do relatório.
     *
     * <p>
     * Armazena o caminho completo (incluindo nome do arquivo e extensão .pdf)
     * onde o relatório será salvo. O valor é definido através do diálogo de
     * seleção de arquivo.</p>
     */
    private String caminhoArquivoSelecionado = null;

    /**
     * Construtor que inicializa os componentes da interface.
     */
    public FrmEmitirRelatorio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ComboBoxArquivo = new javax.swing.JComboBox<>();
        JBVoltar = new javax.swing.JButton();
        JBEmitir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JBSalvarcomo = new javax.swing.JButton();
        JTFCaminhoArquivo = new javax.swing.JTextField();
        ComboBoxRelatorio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emitir Relatórios");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Emitir Relatórios");

        ComboBoxArquivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ComboBoxArquivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDF" }));

        JBVoltar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JBVoltar.setText("Voltar");
        JBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVoltarActionPerformed(evt);
            }
        });

        JBEmitir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JBEmitir.setText("Emitir");
        JBEmitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmitirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tipo de relatório");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Tipo de arquivo");

        JBSalvarcomo.setText("Selecione o destino...");
        JBSalvarcomo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSalvarcomoActionPerformed(evt);
            }
        });

        ComboBoxRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Relatório De Movimentação" }));
        ComboBoxRelatorio.setPreferredSize(new java.awt.Dimension(323, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(JBSalvarcomo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTFCaminhoArquivo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ComboBoxRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBoxArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(17, 17, 17)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JBEmitir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBVoltar)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(JBSalvarcomo)
                .addGap(18, 18, 18)
                .addComponent(JTFCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBVoltar)
                    .addComponent(JBEmitir))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Retorna ao menu principal quando o botão Voltar é acionado.
     *
     * @param evt evento de ação do botão
     */
    private void JBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVoltarActionPerformed
        FrmMenuPrincipal janela = new FrmMenuPrincipal();
        janela.setVisible(true);
        this.dispose();    }//GEN-LAST:event_JBVoltarActionPerformed

    /**
     * Processa a emissão do relatório quando o botão Emitir é acionado.
     *
     * <p>
     * Recupera os dados do servidor através do RelatorioServico, converte os
     * dados para objetos Relatorio e gera o arquivo PDF no local selecionado
     * pelo usuário.</p>
     *
     * <p>
     * <b>Fluxo de execução:</b></p>
     * <ol>
     * <li>Valida se um local de salvamento foi selecionado</li>
     * <li>Recupera dados do relatório do servidor</li>
     * <li>Converte os dados para objetos Relatorio</li>
     * <li>Chama o método de geração do PDF</li>
     * <li>Exibe feedback sobre o resultado da operação</li>
     * </ol>
     *
     * <p>
     * <b>Tratamento de erros:</b></p>
     * <ul>
     * <li>Local de salvamento não selecionado</li>
     * <li>Erro na comunicação com o servidor</li>
     * <li>Falha na conversão dos dados</li>
     * <li>Erro na geração do arquivo PDF</li>
     * </ul>
     *
     * @param evt evento de ação do botão
     */
    private void JBEmitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEmitirActionPerformed
        if (caminhoArquivoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Você precisa selecionar onde salvar o arquivo (clique em 'Salvar como').");
            return;
        }

        try {
            RelatorioServico servico = new RelatorioServico();
            var resposta = servico.listarRelatorio();

            if (!"sucesso".equalsIgnoreCase(resposta.getStatus())) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar relatórios: " + resposta.getMensagem());
                return;
            }

            List<?> dados = (List<?>) resposta.getDados();
            List<Relatorio> relatorios = new java.util.ArrayList<>();

            for (Object obj : dados) {
                if (obj instanceof java.util.Map) {
                    java.util.Map<?, ?> map = (java.util.Map<?, ?>) obj;

                    Relatorio r = new Relatorio();
                    r.setId(((Number) map.get("id")).intValue());
                    r.setProdutoId(((Number) map.get("produtoId")).intValue());
                    r.setNomeProduto((String) map.get("nomeProduto"));
                    r.setQuantidade(((Number) map.get("quantidade")).intValue());
                    r.setMovimentacao((String) map.get("movimentacao"));
                    r.setStatus((String) map.get("status"));

                    Object dataObj = map.get("data");
                    if (dataObj != null) {
                        try {
                            long timestamp = Long.parseLong(dataObj.toString());
                            r.setData(new java.util.Date(timestamp));
                        } catch (NumberFormatException ex) {
                            r.setData(null); // caso ocorra erro
                        }
                    }

                    relatorios.add(r);
                }
            }

            gerarPdf(relatorios, caminhoArquivoSelecionado);
            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso em:\n" + caminhoArquivoSelecionado);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + e.getMessage());
        }

    }//GEN-LAST:event_JBEmitirActionPerformed

    /**
     * Abre diálogo para seleção do local de salvamento do arquivo PDF.
     *
     * <p>
     * Exibe um seletor de arquivos nativo do sistema operacional para que o
     * usuário possa escolher o diretório e nome do arquivo onde o relatório
     * será salvo.</p>
     *
     * <p>
     * <b>Funcionalidades:</b></p>
     * <ul>
     * <li>Filtra apenas arquivos PDF</li>
     * <li>Adiciona automaticamente extensão .pdf se não informada</li>
     * <li>Atualiza o campo de texto com o caminho selecionado</li>
     * </ul>
     *
     * @param evt evento de ação do botão
     */
    private void JBSalvarcomoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSalvarcomoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar como");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos PDF", "pdf"));

        int resultado = fileChooser.showSaveDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            caminhoArquivoSelecionado = arquivo.getAbsolutePath();

            if (!caminhoArquivoSelecionado.toLowerCase().endsWith(".pdf")) {
                caminhoArquivoSelecionado += ".pdf";
            }

            JTFCaminhoArquivo.setText(caminhoArquivoSelecionado);
        }
    }//GEN-LAST:event_JBSalvarcomoActionPerformed

    /**
     * Gera o arquivo PDF com os dados do relatório formatados.
     *
     * <p>
     * Cria um documento PDF profissional com cabeçalho, tabela de dados e
     * rodapé contendo o total de registros. A tabela inclui formatação com
     * cores e alinhamentos específicos para melhor legibilidade.</p>
     *
     * @param relatorios lista de registros a serem incluídos no relatório
     * @param caminhoArquivo caminho completo onde o arquivo será salvo
     */
    private void gerarPdf(List<Relatorio> relatorios, String caminhoArquivo) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(caminhoArquivo));
            document.open();

            // ====== Título ======
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph titulo = new Paragraph("RELATÓRIO DE MOVIMENTAÇÕES", tituloFont);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(titulo);

            // Data de geração
            Font dataFont = new Font(Font.FontFamily.HELVETICA, 10);
            Paragraph dataGeracao = new Paragraph("Gerado em: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()), dataFont);
            dataGeracao.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(dataGeracao);

            document.add(new Paragraph(" ")); // Espaço

            // ====== Tabela ======
            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{1f, 2f, 3f, 1.5f, 2f, 2f});

            // Cabeçalho com cor
            Font cabecalhoFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            String[] cabecalho = {"ID", "Data/Hora", "Produto", "Quantidade", "Movimentação", "Status"};
            for (String col : cabecalho) {
                PdfPCell cell = new PdfPCell(new Paragraph(col, cabecalhoFont));
                cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                cell.setBackgroundColor(new BaseColor(220, 220, 220)); // Cinza mais escuro
                cell.setPadding(5);
                table.addCell(cell);
            }

            // Dados da tabela
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Font dadosFont = new Font(Font.FontFamily.HELVETICA, 9);

            for (Relatorio r : relatorios) {
                PdfPCell idCell = new PdfPCell(new Paragraph(String.valueOf(r.getId()), dadosFont));
                idCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                idCell.setPadding(4);
                table.addCell(idCell);

                PdfPCell dataCell = new PdfPCell(new Paragraph(sdf.format(r.getData()), dadosFont));
                dataCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                dataCell.setPadding(4);
                table.addCell(dataCell);

                PdfPCell produtoCell = new PdfPCell(new Paragraph(r.getNomeProduto(), dadosFont));
                produtoCell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
                produtoCell.setPadding(4);
                table.addCell(produtoCell);

                PdfPCell qtdCell = new PdfPCell(new Paragraph(String.valueOf(r.getQuantidade()), dadosFont));
                qtdCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                qtdCell.setPadding(4);
                table.addCell(qtdCell);

                PdfPCell movCell = new PdfPCell(new Paragraph(r.getMovimentacao(), dadosFont));
                movCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                movCell.setPadding(4);
                table.addCell(movCell);

                PdfPCell statusCell = new PdfPCell(new Paragraph(r.getStatus(), dadosFont));
                statusCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
                statusCell.setPadding(4);
                table.addCell(statusCell);
            }

            document.add(table);

            // Total de registros
            Font totalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Paragraph total = new Paragraph("Total de registros: " + relatorios.size(), totalFont);
            total.setAlignment(Paragraph.ALIGN_LEFT);
            document.add(new Paragraph(" "));
            document.add(total);

            document.close();
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar PDF: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxArquivo;
    private javax.swing.JComboBox<String> ComboBoxRelatorio;
    private javax.swing.JButton JBEmitir;
    private javax.swing.JButton JBSalvarcomo;
    private javax.swing.JButton JBVoltar;
    private javax.swing.JTextField JTFCaminhoArquivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
