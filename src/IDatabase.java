import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;

public interface IDatabase extends Serializable {

    // Создание новой таблицы
    void createTable(String tableName);

    // Удаление таблицы
    void deleteTable(String tableName);

    // Проверка существования таблицы
    boolean containsTable(String tableName);

    // Получение таблицы по имени
    ITable getTable(String tableName);

    // Запись базы данных на диск
    void saveToFile(Path filePath) throws IOException;

    // Загрузка базы данных с диска
    void loadFromFile(Path filePath) throws IOException, ClassNotFoundException;
}
