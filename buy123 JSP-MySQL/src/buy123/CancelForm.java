package buy123;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CancelForm")
public class CancelForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	Statement statement;
	ResultSet rs;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session= request.getSession(); 
			String productid = (String) session.getAttribute("ProductID");
			int stock = (Integer) session.getAttribute("Stock");
			stock++;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buy123", "root", "");
			statement = con.createStatement();
			String updateQuery = "UPDATE `inventory` SET `stock`='" + stock + "' WHERE `productid`='" + productid + "'";
			statement.executeUpdate(updateQuery);
			
			String selectQuery = "select * from orders";
     		Statement stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery(selectQuery);
            boolean isEmpty = rs1.last();
            if (!isEmpty) {
            } 
            else if (isEmpty) {
            	int id = rs1.getInt("id");
    			String deleteQuery = "DELETE FROM `orders` WHERE `id`='"+ id +"'";
    			statement.executeUpdate(deleteQuery);
    			response.sendRedirect("CancelOrder.jsp");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
