<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ツイートページ、ボタン。postで飛ばす。view部分。 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>	ツイートする</title>
</head>
<body>
<h1>ツイートする</h1>
<!-- actionでコントローラに飛ぶ -->
<!-- <form action="コントローラのURL" name="tweet" method="post">-->
<!-- ツイートするとコントローラのpostに入る -->
<form action="/twitter_app/TweetController" name="tweet" method="post">
<input type="text" name="tweet">
<input type="submit" value="ツイート">
</form>
</body>
</html>