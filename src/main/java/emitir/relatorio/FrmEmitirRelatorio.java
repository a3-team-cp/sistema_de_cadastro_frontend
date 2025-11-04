package emitir.relatorio;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import controlador.RelatorioControlador;
import dto.Resposta;
import modelo.Relatorio;

import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

public class FrmEmitirRelatorio extends javax.swing.JFrame {

    private final RelatorioControlador controlador = new RelatorioControlador();

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
