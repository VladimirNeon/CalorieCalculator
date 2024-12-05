import React, { useState, useEffect } from 'react';
import './Menu.css';

function Menu() {
    const [menuItems, setMenuItems] = useState([]);

    useEffect(() => {
        fetch('/menu')
            .then(response => response.json())
            .then(data => setMenuItems(data));
    }, []);

    return (
        <div className="container">
            <h2>Меню</h2>
            <ul className="menu-list">
                {menuItems.map(item => (
                    <li key={item.id} className="menu-item">
                        <h3>{item.name}</h3>
                        <p>{item.description}</p>
                        <p>Цена: {item.price} грн</p>
                    </li>
                ))}
            </ul>
            {/* Додатковий контент */}
            <a href="/" className="back-link">Назад на головну</a>
        </div>
    );
}

export default Menu;