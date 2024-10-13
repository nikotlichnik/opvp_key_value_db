import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {
        try {
            Logger logger = LoggerFactory.getLogger(Main.class);

            // Создаем многотабличную базу данных
            IDatabase db = new Database();

            // Создаем таблицы
            db.createTable("Users");
            db.createTable("Products");

            // Работаем с таблицей Users
            ITable usersTable = db.getTable("Users");
            usersTable.put("Alice", "25");
            usersTable.put("Bob", "30");

            // Работаем с таблицей Products
            ITable productsTable = db.getTable("Products");
            productsTable.put("Laptop", "1000");
            productsTable.put("Phone", "500");

            // Сохраняем базу данных на диск
            Path path = Paths.get("src/database.ser");
            db.saveToFile(path);

            // Очищаем данные в памяти
            db = new Database();
            logger.info("База данных очищена из памяти.");

            // Загружаем базу данных с диска
            db.loadFromFile(path);
            logger.info("База данных загружена с диска.");

            // Проверяем данные после загрузки
            logger.info("Users: Alice = {}", db.getTable("Users").get("Alice"));
            logger.info("Products: Laptop = {}", db.getTable("Products").get("Laptop"));

        } catch (Exception e) {
            // Выводим более информативное сообщение об ошибке
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
