import { useState, useEffect } from "react";
import api from "../api";

export default function PerifericoForm({ onSaved, editando, limparEdicao }) {
    const [nome, setNome] = useState("");
    const [computadorId, setComputadorId] = useState("");
    const [computadores, setComputadores] = useState([]);

    useEffect(() => {
        api.get("/computadores").then(res => setComputadores(res.data));
    }, []);

    useEffect(() => {
        if (editando) {
            setNome(editando.nome);
            setComputadorId(editando.computadorId || "");
        }
    }, [editando]);

    async function salvar(e) {
        e.preventDefault();
        if (editando) {
            await api.put(`/perifericos/${editando.id}`, { nome, computadorId });
            limparEdicao();
        } else {
            await api.post("/perifericos", { nome, computadorId });
        }
        setNome("");
        setComputadorId("");
        onSaved();
    }

    return (
        <form onSubmit={salvar} className="bg-white p-4 rounded shadow space-y-2 mb-4">
            <input
                type="text" placeholder="Nome do periferico" value={nome}
                onChange={(e) => setNome(e.target.value)}
                className="border p-2 rounded w-full" />

            <select
                value={computadorId}
                onChange={(e) => setComputadorId(e.target.value)}
                className="border p-2 rounded w-full">
                <option value="">Selecione um computador</option>
                {computadores.map(c => (
                    <option key={c.id} value={c.id}>{c.nome}</option>
                ))}
            </select>

            <button className={`px-4 py-2 rounded ${editando ? "bg-yellow-600" : "bg-blue-600"} text-white`}>
                {editando ? "Atualizar" : "Salvar"}
            </button>
            {editando && (
                <button type="button" onClick={limparEdicao} className="ml-2 px-4 py-2 bg-gray-400 text-white rounded">
                    Cancelar
                </button>
            )}
        </form>
    );
}
