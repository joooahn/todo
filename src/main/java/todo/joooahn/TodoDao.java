package todo.joooahn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private static String dburl = "jdbc:mysql://localhost:3306/connectdb?useSSL=false";
    private static String dbUser = "joooahn";
    private static String dbpasswd = "1234";

    public List<TodoDto> getTodo() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TodoDto> ret = new ArrayList<TodoDto>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
            String sql = "SELECT * FROM todo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TodoDto tmp = new TodoDto();
                tmp.id = rs.getLong("id");
                tmp.name = rs.getString("name");
                tmp.regDate = rs.getString("regdate");
                tmp.sequence = rs.getInt("sequence");
                tmp.title = rs.getString("title");
                tmp.Type = rs.getString("type");

                //System.out.println(tmp.toString());
                ret.add(tmp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }

    public int addTodo(TodoDto todo) {
        int insertCount = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "INSERT INTO todo (title, name, sequence) VALUES ( ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, todo.getTitle());
            ps.setString(2, todo.getName());
            ps.setInt(3, todo.getSequence());

            insertCount = ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return insertCount;
    }

    public int updateTodo(String type, long id){

        int updateCount = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName( "com.mysql.jdbc.Driver" );

            conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );

            String sql = "update todo set type = ? where id = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, type);
            ps.setLong(2, id);

            updateCount = ps.executeUpdate();

        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                }catch(Exception ex) {}
            } // if

            if(conn != null) {
                try {
                    conn.close();
                }catch(Exception ex) {}
            } // if
        } // finally

        return updateCount;
    }
}

