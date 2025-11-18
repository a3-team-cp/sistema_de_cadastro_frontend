package util;

import java.text.Normalizer;

/**
 * Utilitário para manipulação e normalização de textos.
 *
 * <p>
 * Esta classe fornece métodos estáticos para operações comuns em strings, como
 * remoção de acentos, normalização de casos e tratamento de valores nulos.</p>
 *
 * <p>
 * Utiliza a classe Normalizer do Java para processamento de caracteres Unicode
 * e normalização de textos.</p>
 */
public class TextoUtil {

    /**
     * Remove todos os acentos e diacríticos de uma string.
     *
     * @param texto string de entrada que pode conter caracteres acentuados
     * @return string sem acentos, ou null se a entrada for null
     */
    public static String removerAcentos(String texto) {
        if (texto == null) {
            return null;
        }

        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);

        return normalizado.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    /**
     * Normaliza uma string removendo acentos, espaços extras e convertendo para
     * maiúsculas.
     *
     * @param texto string a ser normalizada
     * @return string normalizada sem acentos, em maiúsculas e sem espaços
     * extras, ou string vazia se a entrada for null
     */
    public static String normalizar(String texto) {
        if (texto == null) {
            return "";
        }
        String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return semAcentos.trim().toUpperCase();
    }

}
