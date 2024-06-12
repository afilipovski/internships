import React from 'react';
import PropTypes from 'prop-types';
import './Navbar.css';
import Logo from '../assets/io.svg'
import Pfp from '../assets/Pfp.jpg'
import LogoutSVG from '../assets/logout.svg'

const Navbar = () => (
  <div className="Navbar" class="h-[8vh] p-4 flex justify-between px-2 lg:px-16 shadow-xl w-full overflow-hidden">
      <img class="h-[5vh]" src={Logo}/>
      <div class="flex">
          <div class="flex rounded-xl border-2 border-black w-fit h-fit text-xl">
              <div class="flex p-2">
                  <h1 class="font-bold mx-2 h-fit w-fit">Лука Крстиќ</h1>
                  <h1 className="mx-2 h-fit w-fit">(213257)</h1>
              </div>
              <img src={Pfp} class="h-11 rounded-lg w-11"/>
          </div>
          <div>
            <img class="bg-red h-12 rounded-lg p-[12px] w-12 ml-4" src={LogoutSVG}/>
          </div>
      </div>

  </div>
);

Navbar.propTypes = {};

Navbar.defaultProps = {};

export default Navbar;
