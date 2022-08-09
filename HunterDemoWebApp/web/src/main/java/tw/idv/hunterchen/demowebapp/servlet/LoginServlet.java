package tw.idv.hunterchen.demowebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(LoginServlet.class.getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("登入驗證");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		String responseStr = "Welcome! " + account + ", your password is " + password;

		logger.info(responseStr);
		PrintWriter writer = response.getWriter();
		writer.append(responseStr);
	}

}
