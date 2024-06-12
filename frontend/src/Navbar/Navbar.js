import React from 'react';
import PropTypes from 'prop-types';
import './Navbar.css';
import Logo from '../assets/io.svg'
import Pfp from '../assets/Pfp.jpg'

const Navbar = () => (
  <div className="Navbar" class="h-[8vh] p-4 flex justify-between mx-2 lg:mx-16">
      <img class="h-[5vh]" src={Logo}/>
      <div class="flex justify-content-evenly rounded-xl border-2 border-black w-fit p-4 text-xl">
        <h1 class="font-bold mx-2">Лука Крстиќ</h1>
        <h1 className="mx-2">(213257)</h1>
        <img src={Pfp}/>
      </div>
  </div>
);

Navbar.propTypes = {};

Navbar.defaultProps = {};

export default Navbar;
