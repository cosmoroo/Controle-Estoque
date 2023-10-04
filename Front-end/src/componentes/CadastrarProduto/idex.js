import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Button, Container, Form, FormGroup, Input, Label } from "reactstrap";
import AppNavbar from "../AppNavbar";

const CadastrarProduto = () => {

    const navigate = useNavigate(); //navegar para a rota home
    const [descricao, setDescricao] = useState("");
    const [categoria, setCategoria] = useState("");
    const [quantidadeU, setQuantidadeU] = useState("");
    const [valUnitario, setValUnitario] = useState("");
    const [valTotal, setValTotal] = useState("");
    const [mensagem, setMensagem] = useState("");

    const handleCadastrarProduto = async () => {
        const produto = {
            descricao,
            categoria,
            quantidadeU: parseInt(quantidadeU, 0), // Converter quantidade para número inteiro
            valUnitario: parseFloat(valUnitario), // Converter Valor Unitario para número
            valTotal: parseFloat(valTotal) // Converter Valor Total para número
        };
        try {
            const resposta = await fetch("http://localhost:8080/api/v1/produtos", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(produto)
            });
            if (!resposta.ok) {
                throw new Error("Erro ao cadastrar o produto.");
            }
            setMensagem("Produto cadastrado com sucesso!");
        } catch (error) {
            setMensagem(
                "Erro ao cadastrar o produto. Verifique os dados informados."
            );
        }
    };
    const handleCancelar = () => {
        // Navegar para a rota "/home"
        navigate("/home");
    };
    const title = <h2>{"Cadastar Produto"}</h2>;
    return (
        <div>
            <AppNavbar />
            <Container>
                {title}
                <Form>
                    <FormGroup>
                        <Label for="descricao"> Descrição </Label>
                        <Input id="descricao" type="text" value={descricao} onChange={(e) => setDescricao(e.target.value)} />
                        <br />
                        <Label for="categoria">Categoria</Label>
                        <Input id="categoria" type="text" value={categoria} onChange={(e) => setCategoria(e.target.value)} />
                        <br />
                        <Label for="quantidade">Quantidade</Label>
                        <Input id="quantidade" type="text" value={quantidadeU} onChange={(e) => setQuantidadeU(e.target.value)} />
                        <br />
                        <Label for="valUnitario">Valor Unitário</Label>
                        <Input id="valUnitario" type="text" value={valUnitario} onChange={(e) => setValUnitario(e.target.value)} />
                        <br />
                        <Label for="valTotal">Valor Total</Label>
                        <Input id="valTotal" type="text" value={valTotal} onChange={(e) => setValTotal(e.target.value)} />
                        <br />

                        <Button color="primary" onClick={handleCadastrarProduto}>
                            Cadastrar Produto
                        </Button>{" "}
                        <Button color="secondary" onClick={handleCancelar}>
                            Voltar
                        </Button>{mensagem && <div>{mensagem}</div>}
                    </FormGroup>
                </Form>
            </Container>
        </div>
    )
};
export default CadastrarProduto;