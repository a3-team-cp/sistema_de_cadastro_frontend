
package util;

import java.text.Normalizer;

/**
 *
 * @author diego
 */
public class TextoUtil {
    
    public static String removerAcentos(String texto) {
        if (texto == null) {
            return null;
        }
        
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        
        return normalizado.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
    
    public static String normalizar(String texto) {
    if (texto == null) return "";
    String semAcentos = Normalizer.normalize(texto, Normalizer.Form.NFD)
            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    return semAcentos.trim().toUpperCase();
}

    
}
