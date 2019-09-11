package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.QuizDao;
import domain.Quiz;

/**
 * Servlet implementation class AddQuizServlet
 */
@WebServlet("/addQuiz")
public class AddQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addQuiz.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question = request.getParameter("question");
		String option1 = request.getParameter("option1");
		String option2 = request.getParameter("option2");
		String option3 = request.getParameter("option3");
		Integer answer = Integer.parseInt(request.getParameter("answer"));
		String explanation = request.getParameter("explanation");
		String name = request.getParameter("name");

		Quiz quiz = new Quiz();
		quiz.setQuestion(question);
		quiz.setOption1(option1);
		quiz.setOption2(option2);
		quiz.setOption3(option3);
		quiz.setAnswer(answer);
		quiz.setExplanation(explanation);
		quiz.setName(name);
		try {
			QuizDao quizDao = DaoFactory.createQuizDao();
			quizDao.insert(quiz);
			request.getRequestDispatcher("/WEB-INF/view/addQuizDone.jsp")
			.forward(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
		}

	}

}
