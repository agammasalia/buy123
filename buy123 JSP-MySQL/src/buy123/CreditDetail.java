package buy123;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreditDetail")
public class CreditDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name, card, security, expiration, searchQuery, insertQuery, updateQuery, userid, productid;
	Connection con;
	Statement statement;
	ResultSet rs;
	int stock;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name");
		card = request.getParameter("card");
		security = request.getParameter("security");
		expiration = request.getParameter("expiration");
		HttpSession session = request.getSession(true);
		userid = (String) session.getAttribute("UserID");
		productid = (String) session.getAttribute("ProductID");
		if(checkForInventory()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buy123", "root", "");
				statement = con.createStatement();
				Calendar calendar = Calendar.getInstance();
				java.sql.Date currentDate = new java.sql.Date(calendar.getTime().getTime());
				insertQuery = "INSERT INTO `orders` (`userid`, `productid`, `orderdate`, `orderstate`) VALUES ('" + userid + "', '" + productid + "', '" + currentDate + "', 'Pending')";
				statement.executeUpdate(insertQuery);
				stock--;
				updateQuery = "UPDATE `inventory` SET `stock`='" + stock + "' WHERE `productid`='" + productid + "'";
				statement.executeUpdate(updateQuery);
				response.sendRedirect("ThankYouForm.jsp");
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("OutOfInventory.jsp");
		}
	}

	public boolean checkForInventory() {
		boolean retVal = false;
		try {
			searchQuery = "SELECT * FROM `inventory` WHERE `productid`='" + productid + "';";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buy123", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(searchQuery);
			while(rs.next()) {
				stock = rs.getInt("stock");
			}
			if(stock > 0)
				retVal = true;
			else
				retVal = false;
			} catch(Exception e) {
				e.printStackTrace();
			}
		return retVal;
	}
}