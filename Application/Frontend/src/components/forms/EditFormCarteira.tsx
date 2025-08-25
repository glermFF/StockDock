import { useState } from "react";
import api from "../../services/api";
import "../styles/EditFormCarteira.css"

export interface IAsset {
  name: string;
  type: string;
  quantity: number;
  purchasedPrice: number;
}

export interface IPortfolio {
  id: string;
  walletName: string;
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
  const [saving, setSaving] = useState(false);

  const removeAssetLocally = (index: number) => {
    setAssets(prev => prev.filter((_, i) => i !== index));
  };

  const handleSave = async () => {
    setSaving(true);
    try {
      
      const payload = {
        id: wallet.id,
        walletName: name,
        asset: assets,
      };
      
      const resp = await api("/api/investments/update-wallet", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(payload),
      });

      const updated: IPortfolio = resp && resp.id ? resp : { ...wallet, walletName: name, asset: assets };
      onSaved(updated);
    } catch (err) {
      console.error("Erro ao salvar carteira:", err);
      window.alert("Falha ao salvar. Veja o console para mais detalhes.");
    } finally {
      setSaving(false);
    }
  };

 return (
    <div className="modal">
      <div className="modal-content">
        <h3>Editar Carteira</h3>
        <label>
          Nome
          <input value={name} onChange={(e) => setName(e.target.value)} />
        </label>

        <h4>Ativos</h4>
        <ul className="assets-list">
          {assets.map((a, i) => (
            <li key={i} className="asset-row">
              <span>{a.name} ({a.type}) — {a.quantity} — {a.purchasedPrice}</span>
              <button type="button" onClick={() => removeAssetLocally(i)}>Remover</button>
            </li>
          ))}
          {assets.length === 0 && <li>Nenhum ativo</li>}
        </ul>

        <div className="modal-actions">
          <button type="button" onClick={onClose} disabled={saving}>Cancelar</button>
          <button type="button" onClick={handleSave} disabled={saving}>
            {saving ? "Salvando..." : "Salvar"}
          </button>
        </div>
      </div>
    </div>
  );
}

export default EditFormCarteira