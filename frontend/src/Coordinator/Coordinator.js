import React from 'react';
import PropTypes from 'prop-types';
import './Coordinator.css';
import CoordinatorCard from "../CoordinatorCard/CoordinatorCard";


function Coordinator(props) {
    return (
        <div class="pt-4 px-4">
            <div class="flex flex-col lg:flex-row justify-between">
                <div class="basis-1/3 text-white mb-4">
                    <button class="w-[49%] py-2 bg-finkiO rounded-xl mr-[2%]">Тековни</button>
                    <button class="w-[49%] py-2 bg-lightgray text-gray rounded-xl">Заверени</button>
                </div>
                <input class="basis-1/3 bg-lightgray px-4 py-2 text-gray placeholder-gray mb-4 rounded-xl" type="text" placeholder="Пребарување.."/>
            </div>
            <div>
                <CoordinatorCard/>
                <CoordinatorCard/>
                <CoordinatorCard/>
                <CoordinatorCard/>
                <CoordinatorCard/>
                <CoordinatorCard/>
                <CoordinatorCard/>
            </div>
        </div>
    );
}


Coordinator.propTypes = {};

Coordinator.defaultProps = {};

export default Coordinator;
