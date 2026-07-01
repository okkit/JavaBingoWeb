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
		// Anhand der Request-Parameter wird überprüft, was hier zu tun ist

		// Parameter für die Task-ID holen aus dem Request holen
		Object param = request.getParameter("task");

		// Wenn es diesen Parameter im Request gibt:
		if (param != null) {
			// Den Parameter müssen wird zum Integer parsen:
			// Beim Parsen kann eine Exception geworfen werden. Machen wir ein try-catch Blok
			try {
				int id = Integer.parseInt((String) param);
				
				// Und holen den entsprechenden Task mithilfe des DataManager-Interface:
				ExampleFormularDataManager mng = new ExampleFormularFakeManager();
				TaskBean task = mng.getTaskById(id);
				
				// Verpacken die Bean im Request
				request.getSession().setAttribute(Constants.ATTR_DATA, task);

				// und leiten die Anzeige zur ExampleFormual.jsp:
				request.getRequestDispatcher(Constants.JSP_FORMULAR).forward(request, response);
				
			} catch (NumberFormatException e) {
				// In diesem Fall bleiben wir bei der Anzeige der Liste
				request.getRequestDispatcher("TaskList.jsp").forward(request, response);
				// TODO eine entsprechende Meldung auf der JSP anzeigen
			}
		}
		//
		else { // Es gibt den Parameter für den Task nicht im Request gibt,
				// also es wird versucht zu speichern
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
