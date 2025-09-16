import { useState } from "react";
import Computadores from "./pages/Computadores";
import Perifericos from "./pages/Perifericos";

export default function App() {
  const [page, setPage] = useState("computadores");

  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <header className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Gerenciador de Computadores e Periféricos</h1>
        <div className="space-x-2">
          <button 
            onClick={() => setPage("computadores")} 
            className={`px-4 py-2 rounded ${page === "computadores" ? "bg-blue-600 text-white" : "bg-gray-200"}`}>
            Computadores
          </button>
          <button 
            onClick={() => setPage("perifericos")} 
            className={`px-4 py-2 rounded ${page === "perifericos" ? "bg-blue-600 text-white" : "bg-gray-200"}`}>
            Periféricos
          </button>
        </div>
      </header>

      {page === "computadores" ? <Computadores /> : <Perifericos />}
    </div>
  );
}
