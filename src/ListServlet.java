import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
public class ListServlet extends HttpServlet {
    private  final String  USER = "root";
    private  final String  PW = "root";
    private final String DATABASE_PATH = "/WEB-INF/lib/SavageWorlds";
    private final String DRIVER_NAME = "jdbc:derby:";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;


        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String path = getServletContext().getRealPath(DATABASE_PATH);
            conn = DriverManager.getConnection(DRIVER_NAME + path, USER, PW);

            //SQL command to get all
            pstmt = conn.prepareStatement("SELECT * FROM player_character");
            //RUN command
            rset = pstmt.executeQuery();

            StringBuilder html = new StringBuilder("<html><body>");

            //ITR over DB call
            while (rset.next()) {
                //For each line in responce
                int id = rset.getInt("character_id");
                String align = rset.getString("align");
                String desc  = rset.getString("description");

                html.append("<li>").append(id+", ").append(align+", ").append(desc+", ").append("</li>");
            }

            html.append("</body></html>");
            response.getWriter().print(html.toString());


        } catch (ClassNotFoundException | SQLException ex) {
            response.getWriter().print(ex.getMessage());
        }

    }


}
