package example.servlets;

import java.io.IOException;

import example.data.ExampleFormularDataManager;
import example.data.ExampleFormularFakeManager;
import example.data.beans.TaskBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation for handling of ExampleFormular
 */
@WebServlet("/example/ExampleFormular")
public class ExampleFormularServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String responseMessage = "";

		TaskBean bean = new TaskBean();
		bean.setTaskTitle(request.getParameter(Constants.PARAM_TITLE));
		bean.setTaskInfo(request.getParameter(Constants.PARAM_INFO));
		boolean done = request.getParameter(Constants.PARAM_DONE) != null;
		bean.setDone(done);

		ExampleFormularDataManager manager = new ExampleFormularFakeManager();
		responseMessage = manager.saveFormular(bean);

		request.getSession().setAttribute(Constants.ATTR_DATA, bean);

		request.setAttribute(Constants.ATTR_MSG, responseMessage);

		request.getRequestDispatcher(Constants.JSP_FORMULAR).forward(request, response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExampleFormularServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
