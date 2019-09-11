package dao;

import java.util.List;

import domain.Quiz;

public interface QuizDao {

	List<Quiz> findAll() throws Exception;

	Quiz findById(Integer id) throws Exception;

	void insert (Quiz quiz) throws Exception;

	void update (Quiz quiz) throws Exception;

	void delete (Quiz quiz) throws Exception;

}
