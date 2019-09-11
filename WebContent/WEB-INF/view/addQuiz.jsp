<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>出題内容管理</title>
</head>
<body>
<h1>出題内容追加</h1>
<form action="" method="post">
	<table border="1">
		<tr>
			<th>質問</th>
			<td><textarea rows="4" cols="60" name="question" /></textarea></td>
		</tr>
		<tr>
			<th>選択肢1（英語）</th>
			<td><input type="text" name="option1" /></td>
		</tr>
		<tr>
			<th>選択肢2（英語）</th>
			<td><input type="text" name="option2" /></td>
		</tr>
		<tr>
			<th>選択肢3（英語）</th>
			<td><input type="text" name="option3" /></td>
		</tr>
		<tr>
			<th>解答</th>
			<td><input type="number" name="answer" /></td>
		</tr>
		<tr>
			<th>解説</th>
			<td><textarea rows="4" cols="60" name="explanation" /></textarea></td>
		</tr>
		<tr>
			<th>名前</th>
			<td><input type="text" name="name" /></td>
		</tr>
	</table>
	<p>
		<input type="submit" value="保存"/>
	</p>
</form>
</body>
</html>