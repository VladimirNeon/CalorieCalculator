import React from 'react';
import './Login.css';

function Login() {
    return (
        <div className="container">
            <h1>Вход</h1>
            <div className="form-container">
                <form>
                    <input type="text" placeholder="Имя пользователя" required />
                    <input type="password" placeholder="Пароль" required />
                    <button type="submit">Войти</button>
                </form>
            </div>
            <div className="login-footer">
                <p>Нет аккаунта? <a href="/registration">Регистрация</a></p>
            </div>
        </div>
    );
}

export default Login;