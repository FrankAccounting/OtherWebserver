import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;



@WebServlet(name = "ListServlet",
        urlPatterns = "/list")
public class OtherListServlet extends HttpServlet {
    private final String  USER = "root";
    private final String  PW = "root";
    private final String DATABASE_PATH = "/WEB-INF/lib/SavageWorlds";
    private final String DRIVER_NAME = "jdbc:derby:";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;


        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String path = getServletContext().getRealPath(DATABASE_PATH);
            conn = DriverManager.getConnection(DRIVER_NAME + path, USER, PW);
            //make statment
            stmt = conn.createStatement();

            rset =stmt.executeQuery("SELECT * FROM player_character");





            StringBuilder html = new StringBuilder("<html><body>");

            //ITR over DB call
            while (rset.next()) {
                //For each line in responce
                String name = rset.getString("character_nm");
                int id = rset.getInt("character_id");
                String align = rset.getString("align");
                String desc  = rset.getString("description");
                html.append("<li>").append(name+", ").append(id+", ").append(align+", ").append(desc+", ").append("</li>");
            }

            html.append("</body></html>");
            response.getWriter().print(html.toString());


        } catch (ClassNotFoundException | SQLException ex) {
            response.getWriter().print(ex.getMessage());
        }
         finally {
            DatabaseUtils.closeAll(conn,stmt,rset);
        }
    }


}
