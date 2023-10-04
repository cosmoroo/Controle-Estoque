import React from "react";
import "./componentes/Home/styles.css";
import AppNavbar from "./componentes/AppNavbar";
import { Link } from "react-router-dom";
const Home = () => {
    return (
        <div>
            <AppNavbar />
            {/* Outros componentes e rotas */}
            <Link to="/produtos/catalogo">Consulta catalogo de produtos</Link>
            <p></p>
            <Link to="/produtos/cadastrar">Cadastrar produto</Link>
            <p></p>
            <Link to="/produtos/upload">Upload</Link>
        </div>
    );
};
export default Home;