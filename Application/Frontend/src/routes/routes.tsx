import { createBrowserRouter } from "react-router-dom"
import ListCarteiras from "../components/carteiras/ListCarteiras"
import Content from "../components/layout/Content"

export const routes = createBrowserRouter([
    {
        path: "/investments",
        element: <Content/>,
        children:[
            {path: "/investments", element: <ListCarteiras/>}
        ]
    }
])