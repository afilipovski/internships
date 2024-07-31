import React, {useContext} from 'react';
import PropTypes from 'prop-types';
import './Navbar.css';
import Logo from '../assets/io.svg';
import Pfp from '../assets/Pfp.jpg'; // Placeholder image; this can be replaced with a user profile picture if available
import LogoutSVG from '../assets/logout.svg';
import { useNavigate } from "react-router-dom";
import {GlobalContext} from "../Context/Context";

function Navbar({ setAuthToken}) {
    const navigate = useNavigate();
    const { user, setUser } = useContext(GlobalContext);

    const handleLogout = () => {
        // Clear state
        setAuthToken('');

        // Clear localStorage
        localStorage.removeItem('authToken');
        setUser(null)

        // Redirect to login page or home
        window.location.href = '/login'; // or use navigate('/login') if using useNavigate
    };
    return (
        <div className="Navbar h-[7vh] py-2 flex justify-between px-4 shadow-xl w-full overflow-hidden">
            <div className="flex flex-col justify-center">
                <img className="h-[5vh]" src={Logo} alt="Logo" />
            </div>
            <div className="flex">
                { user &&  (user.role==="student" ?
                    <div className="flex flex-col justify-center">
                            <div className="flex rounded-xl border-2 border-black h-[6vh] text-[12px] md:text-md">
                         <div className="flex p-[10px] gap-0">

                            <h1 className="font-bold mx-0 md:mx-2 w-fit my-auto">{user.name}</h1>
                                <h1 className="font-bold mx-0 md:mx-2 w-fit my-auto">{user.lastName}</h1>
                             <h1 className="mx-0 md:mx-2 w-fit my-auto">({user.index})</h1>
                         </div>
                            </div>
                    </div>
                        :
                    <div className="flex flex-col justify-center">
                        <div className="flex rounded-xl border-2 border-black h-[6vh] text-[12px] md:text-md">
                            <div className="flex p-[10px]">
                                <h1 className="font-bold mx-0 md:mx-2 w-fit my-auto">{user.name}</h1>
                        </div>
                        <img src={Pfp} className="hidden rounded-lg h-11 w-11" alt="Profile" />
                    </div>
                </div>)}
                <div className="flex flex-col justify-center ml-2 md:ml-4" onClick={handleLogout}>
                    <img className="bg-red h-[5.5vh] w-[5.5vh] rounded-lg p-[14px]" src={LogoutSVG} alt="Logout" />
                </div>
            </div>
        </div>
    );
}


Navbar.defaultProps = {};

export default Navbar;
