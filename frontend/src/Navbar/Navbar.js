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
                    <div class="flex rounded-xl border-2 border-black h-[6vh] text-[12px] md:text-md">
                        <div class="flex p-[10px]">
                            <h1 class="font-bold mx-0 md:mx-2 w-fit my-auto">Лука Крстиќ</h1>
                            <h1 className="mx-0 md:mx-2 w-fit my-auto">(213257)</h1>
                        </div>
                        <img src={Pfp} class="hidden rounded-lg h-11 w-11"/>
                    </div>
                </div>
                <div class="flex flex-col justify-center ml-2 md:ml-4" onClick={()=> nav("/authenticate")}>
                    <img class="bg-red h-[5.5vh] w-[5.5vh] rounded-lg p-[14px]" src={LogoutSVG}/>
                </div>
            </div>

        </div>
    );
}

Navbar.propTypes = {};

Navbar.defaultProps = {};

export default Navbar;
