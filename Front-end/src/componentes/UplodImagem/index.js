import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
const UploadImagem = () => {
    const [file, setFile] = useState(null);
    const [id, setId] = useState("");
    const navigate = useNavigate();
    const handleFileChange = (event) => {
        const selectedFile = event.target.files[0];
        setFile(selectedFile);
    };
    const handleIdChange = (event) => {
        setId(event.target.value);
    };
    const handleUpload = async () => {
        if (!file) {
            alert("Selecione um arquivo antes de enviar.");
            return;
        }
        if (!id) {
            alert("Informe um ID antes de enviar.");
            return;
        }
        const formData = new FormData();
        formData.append("id", id);
        formData.append("file", file);
        try {
            const response = await fetch(
                "http://localhost:8080/api/v1/produtos/imadb",
                {
                    method: "POST",
                    body: formData
                }
            );
            if (response.ok) {
                alert("Upload do arquivo concluído com sucesso!");
            } else {
                alert("Ocorreu um erro ao enviar o arquivo.");
            }
        } catch (error) {
            alert("Ocorreu um erro ao enviar o arquivo.");
        }
    };
    const handleVoltar = () => {
        // Navegar para a rota "/home"
        navigate("/home");
    };
    return (
        <div>
            <input type="file" accept=".jpg" onChange={handleFileChange} />
            <input
                type="text"
                value={id}
                onChange={handleIdChange}
                placeholder="Informe o ID"
            />
            <button onClick={handleUpload}>Enviar</button>
            <p></p>
            <button onClick={handleVoltar}>Voltar</button>
        </div>
    );
};
export default UploadImagem;