import React from 'react';
import './Main.css';

function Main() {
    return (
        <div className="container">
            <h2>Главная страница</h2>
            <div className="links">
                <a href="/Clients/Clients" className="link">Клиенты</a>
                <a href="/dishes" className="link">Блюда</a>
                <a href="/ingredients" className="link">Ингредиенты</a>
            </div>
            <div className="footer">
                <p>Добро пожаловать в нашу систему управления данными!</p>
            </div>
        </div>
    );
}

export default Main;