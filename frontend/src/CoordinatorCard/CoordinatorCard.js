import React from 'react';
import PropTypes from 'prop-types';
import './CoordinatorCard.css';


function CoordinatorCard(props) {
    return (
                <div class="flex flex-col lg:flex-row justify-between bg-lightgray text-offblack rounded-xl p-1 card mb-2">
                    <div class="flex p-3 infoIntern flex-col lg:flex-row">
                        <h1 class="mx-2 my-2 lg:my-0">Vasil Strezov</h1>
                        <h1 class="mx-2 my-2 lg:my-0">213178</h1>
                        <h1 class="mx-2 my-2 lg:my-0">CodeChem</h1>
                        <h1 class="mx-2 my-2 lg:my-0">Praksa za kodiranje i ucenje ucenje ;D</h1>
                    </div>
                    <div class="flex justify-between p-3 lg:p-0">
                        <div class="flex border-2 border-gray rounded-lg mr-2">
                            <h1 class="p-2 text-gray">Заверена</h1>
                            <div class="flex flex-col justify-center">
                                <input type="checkbox" class="mx-2 checkbox"/>
                            </div>
                        </div>
                        <button class="rounded-lg h-max w-auto bg-finkiO p-3 text-white">Промени</button>
                    </div>
                </div>
    );
}


CoordinatorCard.propTypes = {};

CoordinatorCard.defaultProps = {};

export default CoordinatorCard;
