import React, { useState, useEffect } from 'react';
import './Clients.css';

function Clients() {
    const [clients, setClients] = useState([]);

    useEffect(() => {
        fetch('/clients')
            .then(response => response.json())
            .then(data => setClients(data));
    }, []);

    return (
        <div className="container">
            <h2>Клиенты</h2>
            <table id="clientsTable">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Улюблені інгредієнти</th>
                    <th>Алергия на ингредиенты</th>
                    <th>Дата до которой оплачен курс</th>
                    <th>Вес (кг)</th>
                    <th>Рост (см)</th>
                    <th>Возраст (годы)</th>
                    <th>Рекомендуемые калории</th>
                </tr>
                </thead>
                <tbody>
                {clients.map(client => (
                    <tr key={client.id}>
                        <td>{client.id}</td>
                        <td>{client.name}</td>
                        <td>
                            <ul>
                                {client.favoriteIngredients.map(ingredient =>
                                    <li key={ingredient}>{ingredient}</li>
                                )}
                            </ul>
                        </td>
                        <td>
                            <ul>
                                {client.allergyIngredients.map(ingredient =>
                                    <li key={ingredient}>{ingredient}</li>
                                )}
                            </ul>
                        </td>
                        <td>{client.subscriptionEndDate}</td>
                        <td>{client.weight}</td>
                        <td>{client.height}</td>
                        <td>{client.age}</td>
                        <td>{client.recommendedCalories.toFixed(2)}</td>
                    </tr>
                ))}
                </tbody>
            </table>
            {/* Добавьте формы тут при необходимости */}
            <a href="/public" className="back-link">Назад на главную</a>
        </div>
    );
}

export default Clients;