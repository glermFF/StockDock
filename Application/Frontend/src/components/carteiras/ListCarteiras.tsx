import { useEffect, useMemo, useState } from "react";
import api from "../../services/api"
import "../styles/Carteiras.css"

export interface IAsset {
  name: string
  type: string
  quantity: number
  purchasedPrice: number
}

export interface IPortfolio {
  id: string;
  walletName: string;
  value: number;
  changePct: number;
  asset: IAsset[];
  updatedAt: string;
}

const toBRL = (n: number) =>
  new Intl.NumberFormat("pt-BR", { style: "currency", currency: "BRL" }).format(
    n || 0
  );

const percentual = (p: number) =>`${p >= 0 ? "+" : ""}${(p * 100).toFixed(1)}%`;

const Carteiras = () => {
  const [portfolios, setPortfolios] = useState<IPortfolio[]>([]);
  const [query, setQuery] = useState("");

  useEffect(() => {
        api("/api/investments/").then((response) => {
            console.log("API response:", response);
    
            let data = [];
            if (Array.isArray(response)) {
                data = response;
            } else if (Array.isArray(response?.data)) {
                data = response.data;
            }
            setPortfolios(data);

        }).catch(error => console.error(error))

    }, []);

  const filtered = useMemo(() =>
      portfolios.filter(
        (p) =>
          typeof p.walletName === "string" &&
          p.walletName.toLowerCase().includes(query.toLowerCase())
      ),
    [portfolios, query]
  );

  const totalValue = useMemo(() =>
      portfolios.reduce(
        (acc, p) =>
          acc +
          (Array.isArray(p.asset)
            ? p.asset.reduce((sum, a) => sum + (a.purchasedPrice || 0), 0)
            : 0),
        0), [portfolios]);

const getWalletChangePct = (wallet: IPortfolio) => {
    if (!Array.isArray(wallet.asset) || wallet.asset.length === 0) return 0;

    const totalInvestido = wallet.asset.reduce((sum, a) => sum + (a.purchasedPrice || 0), 0);
    const totalAtual = wallet.asset.reduce((sum, a) => sum + (a.purchasedPrice || 0), 0);
    
    if (totalInvestido === 0) return 0;
    return (totalAtual - totalInvestido) / totalInvestido;
  };

  const avgChange = useMemo(() => {
    if (!portfolios.length) return 0;
    const sum = portfolios.reduce((acc, p) => acc + (getWalletChangePct(p) || 0), 0);
    return sum / portfolios.length;
  }, [portfolios]);

  const getWalletTotal = (wallet: IPortfolio) => {
    if (!Array.isArray(wallet.asset)) return 0;
    return wallet.asset.reduce((sum, a) => sum + (a.purchasedPrice || 0), 0);
  };

  

  return (
    <div className="wallets-container app-container">
      <h2 className="wallets-title">Minhas Carteiras</h2>

      <div className="wallets-toolbar">
        <div className="wallets-search">
          
          <input
            type="text"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
            placeholder="Buscar carteiras ou ativos..."
          />
        </div>

        <button type="button" className="wallet-btn add"/** onClick={() => setShowForm(s => !s)} */>
          <span className="plus">+</span> Nova Carteira
        </button>
      </div>

      <div className="wallets-stats">
        <article className="stat-card">
          <span className="stat-label">Total de Carteiras</span>
          <h3 className="stat-value">{portfolios.length}</h3>
        </article>

        <article className="stat-card">
          <span className="stat-label">Valor Total</span>
          <h3 className="stat-value">{toBRL(totalValue)}</h3>
        </article>

        <article className="stat-card">
          <span className="stat-label">Variação Média</span>
          <h3
            className={`stat-value ${
              avgChange >= 0 ? "pos" : "neg"
            }`}
          >
            {percentual(avgChange)}
          </h3>
        </article>
      </div>

      <div className="wallets-grid">
        {filtered.map((w) => (
          <article key={w.id} className="wallet-card">
            <header className="wallet-card-head">
              <h4 className="wallet-name">{w.walletName}</h4>
              <span className="wallet-total">
                {toBRL(getWalletTotal(w))}
              </span>
            </header>
            <div className="wallet-assets">
              <span className="assets-label">
                Ativos ({w.asset?.length || 0})
              </span>
              <div className="assets-chips">
                {(w.asset || []).map((a, i) => (
                  <span key={i} className="asset-chip">
                    {a.name} ({a.type})
                  </span>
                ))}
              </div>
            </div>
          </article>
        ))}
      </div>
    </div>
  );
};

export default Carteiras;
