import java.io.Serializable;

public interface iDatabase extends Serializable {

    // Создание новой таблицы
    void createTable(String tableName);

    // Удаление таблицы
    void deleteTable(String tableName);

    // Проверка существования таблицы
    boolean containsTable(String tableName);

    // Получение таблицы по имени
    iTable getTable(String tableName);

    // Запись базы данных на диск
    void saveToFile(String filePath) throws Exception;

    // Загрузка базы данных с диска
    void loadFromFile(String filePath) throws Exception;
}
