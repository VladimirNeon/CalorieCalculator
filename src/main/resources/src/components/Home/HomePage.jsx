import React, { useState } from "react";
import "./HomePage.css";

const HomePage = () => {
    const [author, setAuthor] = useState("");

    return (
        <div className="home-container">
            <h1>Вітаємо у Калькуляторі Калорій!</h1>
            <p>
                Це веб-додаток для керування інформацією про інгредієнти, страви, меню та клієнтів.
                Ви можете переглядати, додавати, редагувати та видаляти дані, а також отримувати рекомендації
                відповідно до ваших потреб.
            </p>
            <div className="author-section">
                <h3>Автор програми</h3>
                <input
                    type="text"
                    placeholder="Введіть ім'я автора"
                    value={author}
                    onChange={(e) => setAuthor(e.target.value)}
                />
                {author && <p className="author-display">Автор: {author}</p>}
            </div>
        </div>
    );
};

export default HomePage;
