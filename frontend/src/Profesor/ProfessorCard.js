import React, {useContext} from 'react';
import {GlobalContext} from "../Context/Context";
import {useNavigate} from "react-router-dom";
import InternshipSupervisorRepository from "../repository/InternshipSupervisorRepository";

function ProfessorCard({ internship }) {
    const { user } = useContext(GlobalContext);
    const nav = useNavigate();
    const openCalendar = (internshipId) => {
        nav("/coordinator-calendar", { state: { index: internship?.student?.index, internshipId: internship.id } });
    };

    return (
        <div className="flex flex-col lg:flex-row justify-between bg-lightgray text-offblack rounded-xl p-1 card mb-2">
            <div className="flex p-3 infoIntern flex-col lg:flex-row">
                <h1 className="mx-2 my-2 lg:my-0">{internship?.student.name} {internship?.student.lastName}</h1>
                <h1 className="mx-2 my-2 lg:my-0">{internship?.student.index}</h1>
                <h1 className="mx-2 my-2 lg:my-0">{internship?.posting.company.name}</h1>
                <h1 className="mx-2 my-2 lg:my-0">{internship.status}</h1>
            </div>
            <div className="flex justify-between p-3 lg:p-0">
                <button className="rounded-lg h-max w-auto bg-finkiO p-3 text-white" onClick={() => openCalendar(internship.id)}>Details</button>
            </div>
        </div>
    );
}

export default ProfessorCard;