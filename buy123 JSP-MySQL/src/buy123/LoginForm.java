package buy123;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	String searchQuery = "";
	String userid, password, collection, _id;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			userid = request.getParameter("userid");
			password = request.getParameter("password");
			collection = request.getParameter("collection");
			_id = request.getParameter("_id");
			searchQuery = "select * from users where username='" + userid + "' AND password=SHA1('" + password + "');";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buy123", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(searchQuery);
			boolean isEmpty = rs.next();
			if (!isEmpty) {
				response.sendRedirect("LoginFailed.jsp");
			} else if (isEmpty) {
				HttpSession session = request.getSession(true);
				session.setAttribute("FirstName", rs.getString("firstname"));
				session.setAttribute("LastName", rs.getString("lastname"));
				session.setAttribute("Collection", collection);
				session.setAttribute("ProductID", _id);
				session.setAttribute("UserID", userid);
				int stock=0;
				searchQuery = "SELECT * FROM `inventory` WHERE `productid`='"+ _id+"';";
				rs = stmt.executeQuery(searchQuery);
				while(rs.next()){
					stock = rs.getInt("stock");
				}
				session.setAttribute("Stock", stock);
				MongoClient mongoClient = new MongoClient("localhost", 27017);
				DB db = mongoClient.getDB("buy123");
				DBCollection table = db.getCollection(collection);
				BasicDBObject searchMongo = new BasicDBObject();
				searchMongo.put("_id", new ObjectId(_id));
				DBCursor cursor = table.find(searchMongo);
		        while (cursor.hasNext()) {
		        	DBObject a = cursor.next();
//		        	System.out.println(a);
//		        	System.out.println(a.keySet());
		        	session.setAttribute("Brand", a.get("Brand"));
		        	session.setAttribute("Model", a.get("Model"));
		        	session.setAttribute("Price", a.get("Price"));
//					session.setAttribute("Keys", a.keySet());
//					session.setAttribute("Product", a);
				}
				response.sendRedirect("ProductDetail.jsp");
			}
		} catch (Exception e) {
			System.out.println("SQLException occured: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
