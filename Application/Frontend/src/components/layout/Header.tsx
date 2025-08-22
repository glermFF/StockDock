import '../styles/Header.css';

function Header() {
  const userName = 'Usuário';
  const userRole = 'Investidor';

  const toggleSidebar = () => {
    document.body.classList.toggle('sidebar-open');
  };

  const getInitial = (name?: string) =>
    (name || 'U').trim().charAt(0).toUpperCase();

  return (
    <div>
      {/* gradiente para o logo */}
      <svg width="0" height="0" className="sr-only" aria-hidden="true">
        <linearGradient id="mi-accent-grad" x1="0" y1="0" x2="1" y2="1">
          <stop offset="0%" stopColor="var(--mi-green)" />
          <stop offset="100%" stopColor="var(--mi-teal)" />
        </linearGradient>
      </svg>

      <header className="header-container">
        <div className="header-side-bar">
          <button
            className="menu-button"
            onClick={toggleSidebar}
            aria-label="Abrir menu de navegação"
            type="button"
          >
            <div className="side-button-menu" aria-hidden="true" />
          </button>

          <div className="brand">
            <div className="brand-logo" aria-hidden="true">
              <svg viewBox="0 0 24 24">
                <circle cx="12" cy="12" r="10" className="brand-ring" />
                <path d="M6 14l3-3 2.5 2.5L17 8" className="brand-trend" />
              </svg>
            </div>
            <h1 className="brand-name">StockDock</h1>
          </div>
        </div>

        <div className="header-content">{/* espaço p/ busca/ações */}</div>

        <div className="header-profile">
          <div className="header-profile-content">
            <span className="profile-name">{userName}</span>
            <span className="profile-type">{userRole}</span>
          </div>
          <button className="profile-avatar" aria-label="Abrir perfil">
            {getInitial(userName)}
          </button>
        </div>
      </header>
    </div>
  );
}

export default Header;
