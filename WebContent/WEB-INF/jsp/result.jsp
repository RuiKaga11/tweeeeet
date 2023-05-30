<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Tweet" %>
<% Tweet tweet = (Tweet) session.getAttribute("tweet");%>
<!-- ツイート一覧をこのページに表示 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイート一覧</title>
</head>
<body>
<h1>ツイート一覧</h1>
<a href="/twitter_app/TweetController?action=done">続けてツイートする</a>
<p><%= tweet.getTweet() %></p>
</body>
</html>