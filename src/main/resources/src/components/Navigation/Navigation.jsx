import React from "react";
import { NavLink } from "react-router-dom";
import "./Navigation.css";

const Navigation = () => {
    return (
        <nav className="navigation">
            <ul>
                <li>
                    <NavLink to="/" className={({ isActive }) => (isActive ? "active" : "")}>
                        Головна
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/ingredients" className={({ isActive }) => (isActive ? "active" : "")}>
                        Інгредієнти
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/dishes" className={({ isActive }) => (isActive ? "active" : "")}>
                        Страви
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/menus" className={({ isActive }) => (isActive ? "active" : "")}>
                        Меню
                    </NavLink>
                </li>
                <li>
                    <NavLink to="/clients" className={({ isActive }) => (isActive ? "active" : "")}>
                        Клієнти
                    </NavLink>
                </li>
            </ul>
        </nav>
    );
};

export default Navigation;
