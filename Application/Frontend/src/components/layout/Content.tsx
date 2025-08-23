import { Outlet } from "react-router-dom"
import Header from "./Header"
import SideBar from "../SideBar"


function Content() {
    return(
        <div className='with-sticky-header'>
            <Header></Header>
            <SideBar></SideBar>
            <Outlet></Outlet>
        </div>
    )
}

export default Content