import React from 'react';
import PropTypes from 'prop-types';
import './Calendar.css';

function Calendar(props) {
    return (
        <div>
            <button>
                Зачувај
            </button>
            <button>
                Откажи
            </button>
        </div>
    );
}


Calendar.propTypes = {};

Calendar.defaultProps = {};

export default Calendar;
