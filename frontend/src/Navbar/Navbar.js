import React from 'react';
import PropTypes from 'prop-types';
import './Navbar.css';
import Logo from '../assets/io.svg'
import Pfp from '../assets/Pfp.jpg'
import LogoutSVG from '../assets/logout.svg'
import {useNavigate} from "react-router-dom";

function Navbar(props) {
    const nav = useNavigate();


    return(
        <div className="Navbar"
             class="h-[7vh] py-2 flex justify-between px-2 lg:px-16 shadow-xl w-full overflow-hidden">
            <div class="flex flex-col justify-center">
                <img class="h-[5vh]" src={Logo}/>
            </div>
            <div class="flex">
                <div class="flex flex-col justify-center">
                    <div class="flex rounded-xl border-2 border-black w-fit h-fit text-lg">
                        <div class="flex p-2">
                            <h1 class="font-bold mx-2 h-fit w-fit">Лука Крстиќ</h1>
                            <h1 className="mx-2 h-fit w-fit">(213257)</h1>
                        </div>
                        <img src={Pfp} class="h-11 rounded-lg w-11"/>
                    </div>
                </div>
                <div class="flex flex-col justify-center" onClick={()=> nav("/authenticate")}>
                    <img class="bg-red h-12 rounded-lg p-[12px] w-12 ml-4" src={LogoutSVG}/>
                </div>
            </div>

        </div>
    );
}

Navbar.propTypes = {};

Navbar.defaultProps = {};

export default Navbar;
