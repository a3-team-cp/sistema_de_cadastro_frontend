package emitir.relatorio;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import controlador.RelatorioControlador;
import dto.Resposta;
import modelo.Relatorio;

import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Formulário responsável pela emissão de relatórios em formato PDF.
 *
 * <p>
 * Esta interface permite ao usuário gerar relatórios das movimentações do
 * sistema, convertendo os dados em um documento PDF estruturado com tabela
 * formatada.</p>
 *
 * <p>
 * Utiliza a biblioteca iText para geração do PDF e segue um padrão pré-definido
 * de layout com cabeçalho e tabela de dados.</p>
 */
public class EmitirRelatorio extends javax.swing.JFrame {

    /**
     * Controlador responsável pelas operações de relatório.
     *
     * <p>
     * Utilizado para obter os dados necessários para geração do relatório a
     * partir do servidor.</p>
     */
    private final RelatorioControlador controlador = new RelatorioControlador();

    /**
     * Processa a solicitação de emissão de relatório quando o botão é acionado.
     *
     * <p>
     * Recupera os dados do servidor através do controlador, valida a presença
     * de dados e inicia a geração do arquivo PDF.</p>
     *
     * @param evt evento de ação do botão
     */
    private void btnEmitirActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Resposta<?> resposta = controlador.listarRelatorio();

            if (!"sucesso".equalsIgnoreCase(resposta.getStatus())) {
                JOptionPane.showMessageDialog(this, "Erro: " + resposta.getMensagem());
                return;
            }

            @SuppressWarnings("unchecked")
            List<Relatorio> relatorios = (List<Relatorio>) resposta.getDados();

            if (relatorios == null || relatorios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum dado disponível para gerar o relatório.");
                return;
            }

            gerarPDF(relatorios);
            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + e.getMessage());
        }
    }

    /**
     * Gera o arquivo PDF contendo o relatório de movimentações.
     *
     * <p>
     * Cria um documento PDF com cabeçalho centralizado e tabela contendo todas
     * as movimentações do sistema, organizadas em colunas específicas.</p>
     *
     * @param relatorios lista de registros de relatório a serem incluídos no
     * PDF
     * @throws Exception se ocorrer erro durante a geração do PDF
     */
    private void gerarPDF(List<Relatorio> relatorios) throws Exception {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));
        document.open();

        // Cabeçalho
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Paragraph titulo = new Paragraph("Relatório de Movimentações\n\n", fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);

        // Tabela
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        table.addCell("ID");
        table.addCell("Data");
        table.addCell("Produto");
        table.addCell("Quantidade");
        table.addCell("Movimentação");
        table.addCell("Status");

        for (Relatorio r : relatorios) {
            table.addCell(String.valueOf(r.getId()));
            table.addCell(String.valueOf(r.getData()));
            table.addCell(String.valueOf(r.getNomeProduto()));
            table.addCell(String.valueOf(r.getQuantidade()));
            table.addCell(String.valueOf(r.getMovimentacao()));
            table.addCell(String.valueOf(r.getStatus()));
        }

        document.add(table);
        document.close();
    }
}
