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

@WebServlet(name = "searchServlet",
urlPatterns = "/search")
public class searchServlet extends HttpServlet {
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
//look a comment

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String path = getServletContext().getRealPath(DATABASE_PATH);
            conn = DriverManager.getConnection(DRIVER_NAME + path, USER, PW);

            pstmt = conn.prepareStatement("SELECT character_id FROM player_character WHERE character_nm = ?");

            String searchTerm = request.getParameter("searchTerm");
            pstmt.setString(1,searchTerm);
            rset = pstmt.executeQuery();
            StringBuilder html = new StringBuilder("<html><body>");

            while (rset.next()) {
                int id = rset.getInt("character_ID");
                html.append("<p>").append(id).append("</p>");
            }

            html.append("</body></html>");
            response.getWriter().print(html.toString());


        } catch (ClassNotFoundException | SQLException ex) {
            response.getWriter().print(ex.getMessage());
        }
        finally {
            DatabaseUtils.closeAll(conn,pstmt,rset);
        }
    }


}
