package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Quiz;

public class QuizDaoImpl implements QuizDao {

	private DataSource ds;

	public QuizDaoImpl(DataSource ds) {
		this.ds = ds;
	}



	@Override
	public List<Quiz> findAll() throws Exception {
		List<Quiz> quizList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			String sql = "SELECT * FROM quizzes";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				quizList.add(mapToQuiz(rs));
			}
		}catch (Exception e) {
			throw e;
		}
		return quizList;
	}

	@Override
	public Quiz findById(Integer id) throws Exception {
		return null;
	}

	@Override
	public void insert(Quiz quiz) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		try(Connection con = ds.getConnection()){
			String sql = "INSERT INTO quizzes (question, option1, option2,option3,answer,explanation,created,name)VALUES(?, ?, ?, ?, ?, ?,NOW(),?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, quiz.getQuestion());
			stmt.setString(2, quiz.getOption1());
			stmt.setString(3, quiz.getOption2());
			stmt.setString(4, quiz.getOption3());
			stmt.setObject(5, quiz.getAnswer(), Types.INTEGER);
			stmt.setString(6, quiz.getExplanation());
			stmt.setString(7, quiz.getName());
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;

		}
	}

	@Override
	public void update(Quiz quiz) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Quiz quiz) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Quiz mapToQuiz(ResultSet rs) throws Exception{
		Quiz quiz = new Quiz();
		quiz.setId((Integer) rs.getObject("id"));
		quiz.setQuestion(rs.getString("question"));
		quiz.setOption1(rs.getString("option1"));
		quiz.setOption2(rs.getString("option2"));
		quiz.setOption3(rs.getString("option3"));
		quiz.setAnswer((Integer)rs.getObject("answer"));
		quiz.setExplanation(rs.getString("explanation"));
		quiz.setCreated(rs.getTimestamp("created"));
		quiz.setName(rs.getString("name"));
		return quiz;

	}

}
