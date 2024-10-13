public class Main {

    public static void main(String[] args) {
        try {
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
            db.saveToFile("/Users/andrei/Documents/ITMO/opvp_key_value_db/src/database.ser");

            // Очищаем данные в памяти
            db = new Database();
            System.out.println("База данных очищена из памяти.");

            // Загружаем базу данных с диска
            db.loadFromFile("/Users/andrei/Documents/ITMO/opvp_key_value_db/src/database.ser");
            System.out.println("База данных загружена с диска.");

            // Проверяем данные после загрузки
            System.out.println("Users: Alice = " + db.getTable("Users").get("Alice"));
            System.out.println("Products: Laptop = " + db.getTable("Products").get("Laptop"));

        } catch (Exception e) {
            // Выводим более информативное сообщение об ошибке
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
