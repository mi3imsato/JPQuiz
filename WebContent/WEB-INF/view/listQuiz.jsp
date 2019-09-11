<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<title>出題内容管理</title>
</head>
<body>
<h1>出題内容一覧</h1>
<p><a href="logout">ログアウト</a></p>
<table border="1">
	<tr>
		<th>ID</th>
		<th>質問（日本語）</th>
		<th>選択肢1（英語）</th>
		<th>選択肢2（英語）</th>
		<th>選択肢3（英語）</th>
		<th>解答</th>
		<th>解説（英語）</th>
		<th>登録日</th>
		<th>登録者</th>
	</tr>
	<c:forEach items="${quizList}" var="quiz">
	<tr>
		<td><c:out value="${quiz.id}" /></td>
		<td><c:out value="${quiz.question}" /></td>
		<td><c:out value="${quiz.option1}" /></td>
		<td><c:out value="${quiz.option2}" /></td>
		<td><c:out value="${quiz.option3}" /></td>
		<td><c:out value="${quiz.answer}" /></td>
		<td><c:out value="${quiz.explanation}" /></td>
		<td><c:out value="${quiz.created}" /></td>
		<td><c:out value="${quiz.name}" /></td>
	</tr>
	</c:forEach>
	</table>

<p>
	<a href="addQuiz">出題内容の追加</a>
</body>
</html>