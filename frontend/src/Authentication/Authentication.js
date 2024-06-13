import React from 'react';
import PropTypes from 'prop-types';
import './Authentication.css';
import {Link} from "react-router-dom";

function Authentication(pros) {
    return (
        <div class="h-[88vh] flex flex-col justify-center">
            <div class="rounded-[40px] shadowCard text-center w-full md:w-6/12 mx-auto py-16">
                <h1 class="m-16 text-4xl font-thin w-full mx-auto">Сервис за пракси</h1>
                <div class="m-8">
                    <Link class="bg-finkiO py-4 px-8 rounded-xl text-white text-2xl" to="https://cas.finki.ukim.mk/cas/logout?service=https%3A%2F%2Fcourses.finki.ukim.mk">Најава</Link>
                </div>
            </div>
        </div>
);
}

Authentication.propTypes = {};

Authentication.defaultProps = {};

export default Authentication;
