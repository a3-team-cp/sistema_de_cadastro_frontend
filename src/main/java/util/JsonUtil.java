package util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utilitário para conversão entre objetos Java e formato JSON.
 *
 * <p>
 * Esta classe fornece métodos estáticos para serialização e desserialização de
 * objetos utilizando a biblioteca Jackson, com tratamento de exceções
 * unificado.</p>
 *
 * <p>
 * Utiliza um ObjectMapper singleton compartilhado para melhor performance e
 * consistência nas configurações de serialização.</p>
 */
public class JsonUtil {

    /**
     * Instância compartilhada do ObjectMapper para serialização JSON.
     *
     * <p>
     * Esta instância é thread-safe e reutilizada por todas as operações de
     * conversão da aplicação.</p>
     */
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Construtor privado para impedir instanciação da classe.
     *
     * <p>
     * Esta classe é um utilitário com métodos estáticos e não deve ser
     * instanciada.</p>
     */
    private JsonUtil() {
        // Impede instanciação
    }

    /**
     * Converte uma string JSON em um objeto Java do tipo especificado.
     *
     * @param <T> tipo do objeto a ser desserializado
     * @param json string contendo a representação JSON do objeto
     * @param clazz classe do objeto a ser desserializado
     * @return objeto Java desserializado a partir do JSON
     * @throws RuntimeException se ocorrer erro durante a desserialização
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter JSON para objeto", e);
        }
    }

    /**
     * Converte um objeto Java em sua representação JSON como string.
     *
     * @param obj objeto Java a ser serializado
     * @return string contendo a representação JSON do objeto
     * @throws RuntimeException se ocorrer erro durante a serialização
     */
    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter objeto para JSON", e);
        }
    }

}
