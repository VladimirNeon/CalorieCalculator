import React, { useState, useEffect } from "react";
import { fetchIngredients, addIngredient, deleteIngredient } from "../api/api";
import "./IngredientsPage.css";

const IngredientsPage = () => {
    const [ingredients, setIngredients] = useState([]);
    const [newIngredient, setNewIngredient] = useState({ id: "", name: "", caloriesPerGram: "" });
    const [deleteId, setDeleteId] = useState("");

    // Завантаження інгредієнтів при першому рендері
    useEffect(() => {
        fetchIngredients().then(setIngredients);
    }, []);

    const handleInputChange = (e) => {
        const { name, value } = e.target;
        setNewIngredient((prev) => ({ ...prev, [name]: value }));
    };

    const handleAddIngredient = (e) => {
        e.preventDefault();
        addIngredient({
            ...newIngredient,
            caloriesPerGram: parseFloat(newIngredient.caloriesPerGram),
        }).then((data) => {
            setIngredients((prev) => [...prev, data]);
            setNewIngredient({ id: "", name: "", caloriesPerGram: "" });
        });
    };

    const handleDeleteIngredient = (e) => {
        e.preventDefault();
        deleteIngredient(deleteId).then(() => {
            setIngredients((prev) => prev.filter((ingredient) => ingredient.id !== parseInt(deleteId, 10)));
            setDeleteId("");
        });
    };

    return (
        <div className="container">
            <h2>Інгредієнти</h2>
            <table>
                <thead>
                <tr>
                    <th>ID інгредієнта</th>
                    <th>Назва інгредієнта</th>
                    <th>Калорійність (ккал/г)</th>
                </tr>
                </thead>
                <tbody>
                {ingredients.map((ingredient) => (
                    <tr key={ingredient.id}>
                        <td>{ingredient.id}</td>
                        <td>{ingredient.name}</td>
                        <td>{ingredient.caloriesPerGram}</td>
                    </tr>
                ))}
                </tbody>
            </table>
            <div className="form-section">
                <h3>Додати інгредієнт</h3>
                <form onSubmit={handleAddIngredient}>
                    <input
                        type="number"
                        name="id"
                        placeholder="ID Інгредієнта"
                        value={newIngredient.id}
                        onChange={handleInputChange}
                        required
                    />
                    <input
                        type="text"
                        name="name"
                        placeholder="Назва Інгредієнта"
                        value={newIngredient.name}
                        onChange={handleInputChange}
                        required
                    />
                    <input
                        type="number"
                        name="caloriesPerGram"
                        placeholder="Калорійність (ккал/г)"
                        step="0.01"
                        value={newIngredient.caloriesPerGram}
                        onChange={handleInputChange}
                        required
                    />
                    <button type="submit">Додати інгредієнт</button>
                </form>
            </div>
            <div className="form-section">
                <h3>Видалити інгредієнт</h3>
                <form onSubmit={handleDeleteIngredient}>
                    <input
                        type="number"
                        placeholder="ID Інгредієнта"
                        value={deleteId}
                        onChange={(e) => setDeleteId(e.target.value)}
                        required
                    />
                    <button type="submit">Видалити</button>
                </form>
            </div>
        </div>
    );
};

export default IngredientsPage;
