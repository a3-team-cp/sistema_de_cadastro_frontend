
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

    
}
