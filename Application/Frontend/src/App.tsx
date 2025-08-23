import { RouterProvider } from 'react-router-dom'
import { routes } from './routes/routes'
import './App.css'

function App() {

  return (
    <>
    <div>
      <RouterProvider router={routes}/>
    </div>
    </>
  )
}

export default App
