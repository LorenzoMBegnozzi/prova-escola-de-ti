import { useEffect, useState } from "react";
import api from "../api";

export default function ComputadorForm({ onSaved, editando, limparEdicao }) {
  const [nome, setNome] = useState("");
  const [cor, setCor] = useState("");
  const [data, setData] = useState("");

  useEffect(() => {
    if (editando) {
      setNome(editando.nome);
      setCor(editando.cor);
      setData(editando.data);
    }
  }, [editando]);

  async function salvar(e) {
    e.preventDefault();
    if (editando) {
      await api.put(`/computadores/${editando.id}`, { nome, cor, data });
      limparEdicao();
    } else {
      await api.post("/computadores", { nome, cor, data });
    }
    setNome("");
    setCor("");
    setData("");
    onSaved();
  }

  return (
    <form onSubmit={salvar} className="bg-white p-4 rounded shadow space-y-2 mb-4">
      <input
        type="text" placeholder="Nome" value={nome}
        onChange={(e) => setNome(e.target.value)}
        className="border p-2 rounded w-full" />
      <input
        type="text" placeholder="Cor" value={cor}
        onChange={(e) => setCor(e.target.value)}
        className="border p-2 rounded w-full" />
      <input
        type="date" value={data}
        onChange={(e) => setData(e.target.value)}
        className="border p-2 rounded w-full" />
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
