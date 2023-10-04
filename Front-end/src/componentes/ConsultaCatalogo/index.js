import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import ConverteBase64ToImage from "./ConverteBase64ToImage";
import "./styles.css";

const ConsultaCatalogo = () => {
  const [produtos, setProdutos] = useState([]);
  const [erro, setErro] = useState(null);
  useEffect(() => {
    const consulta = async () => {
      try {
        const resposta = await fetch("http://localhost:8080/api/v1/produtos");
        if (!resposta.ok) {
          throw new Error();
        }
        const dados = await resposta.json(); //retorna um array de objetos json
        //apresenta os dados na console como um string json
        console.log(JSON.stringify(dados));
        //carrega os dados na variavel produto
        setProdutos(dados);
      } catch (error) {
        setErro(error.message);
      }
    };
    consulta();
  }, []);
  if (erro)
    return (
      <>
        <h3>Consulta Catalogo </h3>
        <p>Erro na consulta: {erro}</p>
      </>
    );
  return (
    <div>
      <h3>Consulta Catalogo</h3>
      <table id="produtos">
        <thead>
          <tr>
            <th>ID</th>
            <th>Descrição</th>
            <th>Categoria</th>
            <th>Quantidade</th>
            <th>Valor Unitário</th>
            <th>Valor Total</th>
            <th>Imagem</th>
          </tr>
        </thead>
        <tbody>
          {produtos.map((produto) => (
            <tr key={produto.id}>
              <td>{produto.id}</td>
              <td>{produto.descricao}</td>
              <td>{produto.categoria}</td>
              <td>{produto.quantidadeU}</td>
              <td>{produto.valUnitario}</td>
              <td>{produto.valTotal}</td>
              <td>
                <img src = {ConverteBase64ToImage(produto.imagem)}
                alt = "Imagem"
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
export default ConsultaCatalogo;
