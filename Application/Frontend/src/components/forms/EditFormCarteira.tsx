import { useState } from "react";
import api from "../../services/api";
import "../styles/EditFormCarteira.css"

export interface IAsset {
  name: string;
  type: string;
  purchasedPrice: number;
}

export interface IPortfolio {
  id: string;
  walletName: string;
  type: string
  value?: number;
  changePct?: number;
  asset: IAsset[];
  updatedAt?: string;
}

type Props = {
  wallet: IPortfolio;
  onClose: () => void;
  onSaved: (updated: IPortfolio) => void;
};

function EditFormCarteira({ wallet, onClose, onSaved }: Props) {
  const [name, setName] = useState(wallet.walletName);
  const [assets, setAssets] = useState<IAsset[]>(wallet.asset || []);
  const [assetType, setAssetType] = useState("")
  const [saving, setSaving] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const tiposAtivos = [
    { value: "", label: "Selecione o tipo" },
    { value: "CRIPTOS", label: "Criptomoeda" },
    { value: "ACOES", label: "Ação" },
    { value: "FII", label: "FII" },
  ];

  const [newAsset, setNewAsset] = useState<IAsset>({ name: "", type: "", purchasedPrice: 0 });

  const removeAssetLocally = async (index: number) => {
    const assetToRemove = assets[index];
    try {
      await api("/api/assets/remove", {
        method: "DELETE",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(assetToRemove),
      });
      setAssets(prev => prev.filter((_, i) => i !== index));
    } catch (err) {
      setError("Erro ao remover ativo.");
      console.error(err);
    }
  };

  // Função para adicionar novo asset localmente
  const addAssetLocally = async () => {
    if (!newAsset.name.trim() || !newAsset.type.trim() || !newAsset.purchasedPrice) {
      setError("Preencha todos os campos do novo ativo.");
      return;
    }

    setError(null);

    const payload = {
      name: newAsset.name.trim(),
      type: newAsset.type.trim(),
      purchasedPrice: newAsset.purchasedPrice,
      quantity: 1,
      wallet: wallet.id,
    };

    try {
      const resp = await api("/api/assets/invest-new-asset", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });

      const assetCriado = resp && resp.name ? resp : payload;
      setAssets(prev => [...prev, assetCriado]);
      setNewAsset({ name: "", type: "", purchasedPrice: 0 });
    } catch (err) {
      setError("Erro ao adicionar ativo.");
      console.error(err);
    }
  };

  const handleSave = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    if (!name.trim()) {
      setError("Defina um nome para a carteira");
      return;
    }


    setSaving(true);
    try {
      const payload = {
        id: wallet.id,
        walletName: name.trim(),
        asset: assets,
      };

      const resp = await api("/api/investments/update-wallet", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });

      const updated: IPortfolio = resp && (resp as any).id ? (resp as IPortfolio) : { ...wallet, walletName: name.trim(), asset: assets };
      if (onSaved) onSaved(updated);
      onClose();
    } catch (err: any) {
      console.error("Erro ao salvar carteira:", err);
      setError(err?.message || "Erro desconhecido.");
    } finally {
      setSaving(false);
    }
  };
  
  return (
    <div className="modal">
      <div className="modal-content">
        <h3>Editar Carteira</h3>
        <form onSubmit={handleSave}>
          <label>
            <span>Nome</span>
            <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
          </label>

          {error && <div className="form-error" role="alert">{error}</div>}

          <h4>Ativos na Carteira</h4>
          <ul className="assets-list">
            {assets.map((a, i) => (
              <li key={i} className="asset-row">
                <span>{a.name} ({a.type}) — {a.purchasedPrice}</span>
                <button type="button" onClick={() => removeAssetLocally(i)}>Remover</button>
              </li>
            ))}
            {assets.length === 0 && <li>Nenhum ativo</li>}
          </ul>

          {/* Formulário para adicionar novo asset */}
          <h4>Adicionar Ativo</h4>
          <div className="add-asset-form">
            <input
              type="text"
              placeholder="Nome do ativo"
              value={newAsset.name}
              onChange={e => setNewAsset({ ...newAsset, name: e.target.value })}
            />
            <select
              value={newAsset.type}
              onChange={e => setNewAsset({ ...newAsset, type: e.target.value })}
            >
              {tiposAtivos.map(tipo => (
                <option key={tipo.value} value={tipo.value}>
                  {tipo.label}
                </option>
              ))}
            </select>
            <input
              type="number"
              placeholder="Preço de compra"
              value={newAsset.purchasedPrice || ""}
              onChange={e => setNewAsset({ ...newAsset, purchasedPrice: Number(e.target.value) })}
              min={0}
            />
            <button type="button" onClick={addAssetLocally}>Adicionar ativo</button>
          </div>

          <div className="modal-actions">
            <button type="button" onClick={onClose} disabled={saving}>Cancelar</button>
            <button type="submit" disabled={saving}>
              {saving ? "Salvando..." : "Salvar"}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default EditFormCarteira