package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class finance_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    // Database credentials
    String url = "jdbc:mysql://localhost:3306/finance-tracker";
    String username = "root";
    String password = "admin";

    String currentUser = (String) session.getAttribute("username"); // Simulate user session
    if (currentUser == null) {
        response.sendRedirect("finace.jsp"); // Redirect user to login if not logged in
    }

    String userFullName = "";
    try {
        // Establish connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        // Query user information
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, currentUser);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            userFullName = rs.getString("full_name");
        }

        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>User Dashboard</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background: #f4f4f4;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h1 {\n");
      out.write("            margin: 0;\n");
      out.write("            font-size: 24px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            padding: 20px;\n");
      out.write("            max-width: 800px;\n");
      out.write("            margin: 20px auto;\n");
      out.write("            background-color: white;\n");
      out.write("            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .welcome-section {\n");
      out.write("            margin: 10px 0;\n");
      out.write("            font-size: 18px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin: 20px 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: left;\n");
      out.write("            border: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #007bff;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        footer {\n");
      out.write("            margin: 20px 0;\n");
      out.write("            text-align: center;\n");
      out.write("            color: gray;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logout {\n");
      out.write("            margin: 10px 0;\n");
      out.write("            padding: 10px 15px;\n");
      out.write("            background-color: red;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            text-align: center;\n");
      out.write("            display: block;\n");
      out.write("            width: 100px;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logout:hover {\n");
      out.write("            background-color: darkred;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Welcome to the User Dashboard</h1>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"welcome-section\">\n");
      out.write("            <p>Hello, <strong>");
      out.print( userFullName );
      out.write("</strong>. Welcome back!</p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"user-data\">\n");
      out.write("            <h3>Your Account Information</h3>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Username</th>\n");
      out.write("                    <td>");
      out.print( currentUser );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Full Name</th>\n");
      out.write("                    <td>");
      out.print( userFullName );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"user-transactions\">\n");
      out.write("            <h3>Your Recent Transactions</h3>\n");
      out.write("            ");

                // Fetch transactions related to the user
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, username, password);

                    String transactionQuery = "SELECT * FROM transactions WHERE username = ?";
                    PreparedStatement stmtTrans = connection.prepareStatement(transactionQuery);
                    stmtTrans.setString(1, currentUser);
                    ResultSet rsTrans = stmtTrans.executeQuery();
            
      out.write("\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Date</th>\n");
      out.write("                    <th>Category</th>\n");
      out.write("                    <th>Amount</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    while (rsTrans.next()) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rsTrans.getDate("date") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rsTrans.getString("category") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rsTrans.getDouble("amount") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rsTrans.getString("description") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <a href=\"logout.jsp\" class=\"logout\">Logout</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; Finance Tracker 2023</p>\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
