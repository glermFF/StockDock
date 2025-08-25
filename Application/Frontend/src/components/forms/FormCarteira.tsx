import { useState } from "react";
import api from "../../services/api";
import "../styles/FomrCarteira.css"

interface FormCarteiraProps {
  onClose: () => void;
  onCreated?: () => void;
}

function FormCarteira({ onClose, onCreated }: FormCarteiraProps) {
  const [walletName, setWalletName] = useState("");
  const [walletType, setWalletType] = useState("");
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const tiposCarteira = [
    { value: "", label: "Selecione o tipo" },
    { value: "CRIPTOS", label: "Criptomoedas" },
    { value: "ACOES", label: "Ações" },
    { value: "INVESTIMENTOS", label: "Investimentos" },
    { value: "PERSONALIZADA", label: "Personalizada" },
  ];

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    if (!walletName.trim()) {
      setError("Defina um nome para a carteira");
      return;
    }
    
    if (!walletType) {
      setError("Defina o tipo de investimento em foco");
      return;
    }

    setLoading(true);
    try {
     await api("/api/investments/invest-new-wallet", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ walletName, type: walletType }), // <-- aqui!
      });

      setWalletName("");
      setWalletType("");
      if (onCreated) onCreated();
      onClose();
    } catch (err: any) {
      setError(err.message || "Erro desconhecido.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="form-carteira-modal">
      <div className="form-carteira">
        <h3>Nova Carteira</h3>
        <form onSubmit={handleSubmit}>
          <div className="form-carteira-inputs">
            <label htmlFor="walletName">Nome da Carteira</label>
            <input
              id="walletName"
              type="text"
              value={walletName}
              onChange={e => setWalletName(e.target.value)}
              disabled={loading}
              autoFocus
            />
            <label htmlFor="walletType">Tipo</label>
            <select
              id="walletType"
              value={walletType}
              onChange={e => setWalletType(e.target.value)}
              disabled={loading}
            >
              {tiposCarteira.map(tipo => (
                <option key={tipo.value} value={tipo.value}>
                  {tipo.label}
                </option>
              ))}
            </select>
          </div>
          {error && <div className="form-error">{error}</div>}
          <div className="form-actions">
            <button type="button" onClick={onClose} disabled={loading}>
              Cancelar
            </button>
            <button type="submit" disabled={loading}>
              {loading ? "Salvando..." : "Salvar"}
            </button>
          </div>
        </form>
      </div>
      <div className="form-carteira-backdrop" onClick={onClose} />
    </div>
  );
}

export default FormCarteira;