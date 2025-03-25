package util;

import annotations.Tabela;
import annotations.Coluna;
import java.lang.reflect.Field;

public class SQLGenerator {
    public static String generateSelectSQL(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Tabela.class)) {
            throw new RuntimeException("A classe " + clazz.getName() + " não possui a anotação @Tabela");
        }

        Tabela tabela = clazz.getAnnotation(Tabela.class);
        String tableName = tabela.nome();
        StringBuilder sql = new StringBuilder("SELECT ");

        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Coluna.class)) {
                if (!first) {
                    sql.append(", ");
                }
                Coluna coluna = field.getAnnotation(Coluna.class);
                sql.append(coluna.nome());
                first = false;
            }
        }
        sql.append(" FROM ").append(tableName);
        return sql.toString();
    }
}
