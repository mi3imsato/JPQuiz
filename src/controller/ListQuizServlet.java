package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.QuizDao;
import domain.Quiz;

/**
 * Servlet implementation class ListQuizServlet
 */
@WebServlet("/listQuiz")
public class ListQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListQuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			QuizDao quizDao = DaoFactory.createQuizDao();
			List<Quiz> quizList = quizDao.findAll();
			request.setAttribute("quizList", quizList);
			request.getRequestDispatcher("/WEB-INF/view/listQuiz.jsp")
			.forward(request, response);
			}catch(Exception e) {
				throw new ServletException(e);

			}
		}

	}