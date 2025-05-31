package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    // Dados de conexão com o banco
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_pessoas";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    // Método para conectar ao banco
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Método main para teste da conexão
    public static void main() {
        Connection conn = conectar();

        if (conn != null) {
            System.out.println("✅ Conexão com o banco de dados realizada com sucesso!");
            try {
                conn.close(); // Boa prática: fechar a conexão após o teste
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        } else {
            System.out.println("❌ Falha ao conectar com o banco de dados.");
        }
    }
}
