import './App.css'
import Header from './components/layout/Header'
import SideBar from './components/SideBar'

function App() {

  return (
    <>
    <div className='with-sticky-header'>
      <Header></Header>
      <SideBar></SideBar>
    </div>
    </>
  )
}

export default App
