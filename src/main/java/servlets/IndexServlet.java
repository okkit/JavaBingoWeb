package servlets;

import java.io.IOException;

import data.FakeDataManager;
import data.QuizDataManager;
import data.beans.Quiz;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuizDataManager mng = new FakeDataManager();
//		String input = request.getParameter("textInput");
		
		Quiz q = mng.getQuiz();
		System.out.println(q.getQuestions().get(0).getText());
//		// Die Erste Frage wird in die Session als Attribute gespeichert
		request.getSession().setAttribute("quiz", mng.getQuiz());		
		response.sendRedirect("Question.jsp");

	}

}
