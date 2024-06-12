import React from 'react';
import PropTypes from 'prop-types';
import './Coordinator.css';


function Coordinator(props) {
    return (
        <div>
            <button>
                Тековни
            </button>
            <button>
                Заверени
            </button>
            <input type="text" placeholder="Пребарување.."/>
        </div>
    );
}


Coordinator.propTypes = {};

Coordinator.defaultProps = {};

export default Coordinator;
