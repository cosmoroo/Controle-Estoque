import Home from "./Home";
import "./styles.css";
import ConsultaCatalogo from "./componentes/ConsultaCatalogo";
import CadastrarProduto from "./componentes/CadastrarProduto/idex";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import UploadImagem from "./componentes/UplodImagem";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route index element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/produtos/catalogo" element={<ConsultaCatalogo />} />
        <Route path="/produtos/cadastrar" element={<CadastrarProduto />} />
        <Route path="/produtos/upload" element={<UploadImagem />} />
      </Routes>
    </Router>
  );
};
export default App;