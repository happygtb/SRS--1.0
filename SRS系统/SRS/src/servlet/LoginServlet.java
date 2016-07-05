package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Professor;
import model.ProfessorWithPassword;
import model.Student;
import model.StudentWithPassword;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("username");
		Student student = null;
		Professor professor = null;
		boolean isValidated = false;
		String pwd = request.getParameter("password");
		String auto = request.getParameter("check");
		int role = Integer.parseInt(request.getParameter("role"));
		if (role == 1) {
			UserService us = new UserService();
			StudentWithPassword sp = us.getStudentWithPassword(userName);
			student = sp.getStudent();
			isValidated = sp.validatePassword(pwd);
		               } else if (role == 2) {
		                 	UserService us = new UserService();
			                ProfessorWithPassword pp = us.getProfessorWithPassword(userName);
			                professor = pp.getProfessor();
		                	isValidated = pp.validatePassword(pwd);
		               } else {
			                isValidated = userName.equals("admin") && pwd.equals("admin");
		   }

		if (isValidated) {
			HttpSession session = request.getSession();
			session.setAttribute("role", role);
			if (role == 1) {
				session.setAttribute("Student", student);
			} else if (role == 2) {
				session.setAttribute("Professor", professor);
			} else {
				session.setAttribute("Admin", 1);
			}
			session.setAttribute("isLogined", 1);
			//Cookie
			if (auto != null && auto.equals("on")) {
				Cookie user = new Cookie("username", userName);
				user.setMaxAge(5 * 60 * 60);
				Cookie roleId = new Cookie("role", String.valueOf(role));
				roleId.setMaxAge(5 * 60 * 60);
				response.addCookie(user);
				response.addCookie(roleId);
			} else {
				Cookie cookie = new Cookie("username", null);
				cookie.setMaxAge(0);
			}
			response.sendRedirect("htm/SRS.html");
		} else {
			//session
			HttpSession session = request.getSession();
			session = request.getSession();
			session.setAttribute("isLogined", 0);
			response.sendRedirect("login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
