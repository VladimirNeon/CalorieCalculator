import React from 'react';
import './Registration.css';

function Registration() {
    return (
        <div className="container">
            <h1>Регистрация</h1>
            <div className="form-container">
                <form>
                    <input type="text" placeholder="Имя пользователя" required />
                    <input type="email" placeholder="Email" required />
                    <input type="password" placeholder="Пароль" required />
                    <button type="submit">Регистрация</button>
                </form>
            </div>
            <div className="login-footer">
                <p>Уже есть аккаунт? <a href="/login">Вход здесь</a></p>
            </div>
        </div>
    );
}

export default Registration;