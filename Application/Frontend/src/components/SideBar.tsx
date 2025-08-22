import './styles/SideBar.css';

function SideBar() {
  const close = () => document.body.classList.remove('sidebar-open');

  return (
    <>
      <div className="sidebar-dim" onClick={close} />
      <aside className="sidebar">
        <div className="sidebar-scroller">
          <h2 className="nav-title">Navegação</h2>

          <nav className="nav-list">
            <button className="nav-item active">
              <span className="nav-ico">📂</span>
              <span>Carteira</span>
            </button>
            <button className="nav-item">
              <span className="nav-ico">📈</span>
              <span>Mercado</span>
            </button>
            <button className="nav-item">
              <span className="nav-ico">⚙️</span>
              <span>Configurações</span>
            </button>
          </nav>
        </div>
      </aside>
    </>
  );
}

export default SideBar;
