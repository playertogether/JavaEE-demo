<%@ page language="java" pageEncoding="utf-8"%>
<html>
<head>
    <title>login</title>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">

</head>

<body>
<div>
    <p>Spring Security登录测试</p>
</div>

<div class="wrap" id="wrap">
    <form action="/j_spring_security_check" method="post">
        <!-- 输入框 -->
        <div>
            <input type="text"
                   placeholder="输入用户名"  name="username" value=""/>
        </div>
        <div>
            <input type="password"
                   placeholder="输入用户密码" name="password"/>
        </div>
        <div>
            <button id="loginButton" type="submit">登 录</button>
        </div>
    </form>
</div>
</body>
</html>