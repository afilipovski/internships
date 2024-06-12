import React from 'react';
import PropTypes from 'prop-types';
import './Authentication.css';
import {Link} from "react-router-dom";

function Authentication(pros) {
    return (
  <div>
    <Link to="https://cas.finki.ukim.mk/cas/logout?service=https%3A%2F%2Fcourses.finki.ukim.mk">Најава</Link>
  </div>
);
}

Authentication.propTypes = {};

Authentication.defaultProps = {};

export default Authentication;
