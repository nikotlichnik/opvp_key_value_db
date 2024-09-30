package src;

public interface DatabaseLevelFunctions {

    void createTable(String tableName);

    void dropTable(String tableName);

    Table getTable (String tableName);

}
