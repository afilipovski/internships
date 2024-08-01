import React, {useContext, useEffect} from 'react';
import PropTypes from 'prop-types';
import './CoordinatorCard.css';
import InternshipRepository from "../repository/InternshipRepository";
import InternshipCoordinatorRepository from "../repository/InternshipCoordinatorRepository";
import InternshipSupervisorRepository from "../repository/InternshipSupervisorRepository";
import {GlobalContext} from "../Context/Context";

function CoordinatorCard({ internship, SetTekovni }) {
    const { user } = useContext(GlobalContext);


    const assignInternship = async () => {
        try {
            console.log("VLAGA")
            await InternshipSupervisorRepository.assignInternship(user.id,internship.id);
            console.log(internship.supervisor?.id+"eve go")
            SetTekovni(false)
            // Call onAssign to update the parent component
        } catch (error) {
            console.error('Failed to assign coordinator', error);
        }
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
                {internship?.supervisor?.id ? (
                    <button className="rounded-lg h-max w-auto bg-finkiO p-3 text-white">Details</button>
                ) : (
                    <button className="rounded-lg h-max w-auto bg-finkiO p-3 text-white" onClick={assignInternship}>
                        Assign
                    </button>
                )}
            </div>
        </div>
    );
}


CoordinatorCard.defaultProps = {};

export default CoordinatorCard;
