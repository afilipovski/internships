import React from 'react';
import PropTypes from 'prop-types';
import './InternCard.css';
import {useNavigate} from "react-router-dom";

const InternCard = () => {
const nav = useNavigate();

return (
    <button onClick={() => nav("/calendar")}>
        Дневник
    </button>
    )
}


InternCard.propTypes = {};

InternCard.defaultProps = {};

export default InternCard;
