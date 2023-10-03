import React from "react";
import "./componentes/Home/styles.css";
import AppNavbar from "./componentes/AppNavbar";
import { Link } from "react-router-dom";
const Home = () => {
    return (
        <div>
            <AppNavbar />
            {/* Outros componentes e rotas */}
            <Link to="/produtos/catalogo"><button>Consultar catalogo de produtos</button></Link>
        </div>
    );
};
export default Home;