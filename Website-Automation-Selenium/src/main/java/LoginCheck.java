
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("user-email");
		String password = request.getParameter("user-pwd");
		DAO dao = new DAO();
		try {
			if (!dao.validateLogin(email, password)) {
				String errorMessage = "Invalid email or password. Please try again.";
				response.sendRedirect("login.html?error=" + errorMessage);
			} else {
				response.sendRedirect("dashboard.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
