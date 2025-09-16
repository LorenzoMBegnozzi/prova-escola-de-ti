import { useEffect, useState } from "react";
import api from "../api";
import PerifericoForm from "../components/PerifericoForm";

export default function Perifericos() {
  const [perifericos, setPerifericos] = useState([]);
  const [editando, setEditando] = useState(null);

  async function carregar() {
    const res = await api.get("/perifericos");
    setPerifericos(res.data);
  }

  async function excluir(id) {
    await api.delete(`/perifericos/${id}`);
    carregar();
  }

  function editar(p) {
    setEditando(p);
  }

  useEffect(() => {
    carregar();
  }, []);

  return (
    <div>
      <h2 className="text-xl font-semibold mb-4">Periféricos</h2>
      <PerifericoForm onSaved={carregar} editando={editando} limparEdicao={() => setEditando(null)} />
      <ul className="space-y-2 mt-4">
        {perifericos.map(p => (
          <li key={p.id} className="p-4 bg-white shadow rounded flex justify-between items-center">
            <div>
              <p><b>{p.nome}</b> → Computador: {p.computadorNome || "Nenhum"}</p>
            </div>
            <div className="space-x-2">
              <button 
                onClick={() => editar(p)} 
                className="bg-yellow-500 text-white px-3 py-1 rounded">
                Editar
              </button>
              <button 
                onClick={() => excluir(p.id)} 
                className="bg-red-500 text-white px-3 py-1 rounded">
                Excluir
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}
