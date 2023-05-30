<%@page import="servlet.TweetController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Tweet"%>
<!-- 最初に遷移するページ。ツイートボタン（授業の戻るボタンを改造するだけ）
と、ツイートの一覧の閲覧をできるようにする。 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スタートページ</title>
</head>
<body>
<h1>ようこそ</h1>
<!--<form action="コントローラのURL" method="get">-->
 <form action="/twitter_app/TweetController">
 <a href="/twitter_app/TweetController?action=done">ツイートする</a>
</form>
</body>
</html>