import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class AdvancedMySQLDiag {
    public static void main(String[] args) {
        String[] testCases = {
                // 基础连接测试
                "jdbc:mysql://server.hydbb.lz-0315.com:3306/moviesdata?useSSL=false&serverTimezone=Asia/Shanghai",

                // 带超时参数测试
                "jdbc:mysql://server.hydbb.lz-0315.com:3306/moviesdata?connectTimeout=3000&socketTimeout=3000",

                // IP直连测试
                "jdbc:mysql://149.88.64.236:3306/moviesdata"
        };

        for (String url : testCases) {
            testConnection(url, "moviesdata", "moviesdata");
        }
    }

    private static void testConnection(String url, String user, String pwd) {
        System.out.println("🚀 测试连接: " + url);
        try (Connection conn = DriverManager.getConnection(url, user, pwd)) {
            System.out.println("✅ 连接成功！");
            // 验证基础查询
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT 1");
                System.out.println("🔍 简单查询结果: " + (rs.next() ? rs.getInt(1) : "无结果"));
            }
        } catch (SQLException e) {
            System.out.println("❌ 连接失败：");
            e.printStackTrace();
        }
    }
}