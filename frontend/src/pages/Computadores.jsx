import { useEffect, useState } from "react";
import api from "../api";
import ComputadorForm from "../components/ComputadorForm";

export default function Computadores() {
    const [computadores, setComputadores] = useState([]);
    const [loading, setLoading] = useState(true);
    const [editando, setEditando] = useState(null);

    async function carregar() {
        setLoading(true);
        const res = await api.get("/computadores");
        setComputadores(res.data);
        setLoading(false);
    }

    async function excluir(id) {
        await api.delete(`/computadores/${id}`);
        carregar();
    }

    function editar(c) {
        setEditando(c);
    }

    useEffect(() => {
        carregar();
    }, []);

    return (
        <div>
            <h2 className="text-xl font-semibold mb-4">Computadores</h2>
            <ComputadorForm onSaved={carregar} editando={editando} limparEdicao={() => setEditando(null)} />
            {loading ? <p>Carregando...</p> : (
                <ul className="space-y-2 mt-4">
                    {computadores.map(c => (
                        <li key={c.id} className="p-4 bg-white shadow rounded flex justify-between items-center">
                            <div>
                                <p><b>{c.nome}</b> - {c.cor} ({c.data})</p>
                            </div>
                            <div className="space-x-2">
                                <button
                                    onClick={() => editar(c)}
                                    className="bg-yellow-500 text-white px-3 py-1 rounded">
                                    Editar
                                </button>
                                <button
                                    onClick={() => excluir(c.id)}
                                    className="bg-red-500 text-white px-3 py-1 rounded">
                                    Excluir
                                </button>
                            </div>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}
