import Home from "./Home";
import "./styles.css"
import "bootstrap/dist/css/bootstrap.min.css";
import ConsultaCatalogo from "./componentes/ConsultaCatalogo";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
const App = () => {
  return (
    <Router>
      <Routes>
        <Route index element={<Home />} />
        <Route path="/home" element={<Home/>}/>
        <Route path="/produtos/catalogo" element={<ConsultaCatalogo/>}/>
      </Routes>
    </Router>
  );
};
export default App;