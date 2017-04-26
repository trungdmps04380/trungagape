<%@ page pageEncoding="utf-8"%>
<div class="form-group">
    <h1>LOGIN</h1>
    ${message}
    <form action="home/login.htm" method="post">
        <div class="form-group">
            <label>Username</label>
            <input name="username" class="form-control"/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input name="password" class="form-control"/>
        </div>

        <div class="form-group">
            <button class="btn btn-default">Login</button>
        </div>
    </form>
</div>

