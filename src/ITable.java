import java.io.Serializable;

public interface ITable extends Serializable {

    // Добавление или обновление значения по ключу
    void put(String key, String value);

    // Получение значения по ключу
    String get(String key);

    // Удаление значения по ключу
    void delete(String key);

    // Проверка существования ключа
    boolean containsKey(String key);
}
