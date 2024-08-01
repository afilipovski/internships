import React, { useContext, useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import './Coordinator.css';
import CoordinatorCard from "../CoordinatorCard/CoordinatorCard";
import { useNavigate } from "react-router-dom";
import { GlobalContext } from "../Context/Context";
import InternshipRepository from "../repository/InternshipRepository";

function Coordinator(props) {
    const nav = useNavigate();
    const { user } = useContext(GlobalContext);
    const [internships, setInternships] = useState([]);
    const [tekovni, SetTekovni] = useState(true);
    const loadTekovni =  () => {
        SetTekovni(false)
    };
    const loadInternships = async () => {
        if(tekovni)
        {
            try {
                const data = await InternshipRepository.getInternshipsByCompanyIdAndSupervisorIdIsNull(user?.companyId);
                setInternships(data);
                console.log(internships)
            } catch (error) {
                console.error('Failed to load internships', error);
            }
        }
        else{
            try {
                const pendingReviewData = await InternshipRepository.getInternshipsBySupervisorIdAndStatus(user?.id, "PENDING_COMPANY_REVIEW");
                const ongoingData = await InternshipRepository.getInternshipsBySupervisorIdAndStatus(user?.id, "ONGOING");
                const pendingProfessorReviewData = await InternshipRepository.getInternshipsBySupervisorIdAndStatus(user?.id, "PENDING_PROFFESSOR_REVIEW");
                const combinedData = [...pendingReviewData, ...ongoingData,...pendingProfessorReviewData];
                setInternships(combinedData);
                console.log(internships)
            } catch (error) {
                console.error('Failed to load internships', error);
            }
        }
    };

    useEffect(() => {
        console.log("vlaga")
        loadInternships();
    }, [tekovni]);

    return (
        <div className="pt-4 px-4">
            <div className="flex flex-col lg:flex-row justify-between">
                <div className="basis-1/3 text-white mb-4">
                    <button className="w-[49%] py-2 bg-finkiO rounded-xl mr-[2%]" onClick={() => SetTekovni(true)}>Тековни</button>
                    <button className="w-[49%] py-2 bg-lightgray text-gray rounded-xl" onClick={() => SetTekovni(false)}>Заверени</button>
                </div>
                <input className="basis-1/3 bg-lightgray px-4 py-2 text-gray placeholder-gray mb-4 rounded-xl" type="text" placeholder="Пребарување.." />
            </div>
            <div>
                {internships && internships.map((internship) => (
                    <CoordinatorCard key={internship.id} internship={internship} SetTekovni={SetTekovni} />
                ))}
            </div>
        </div>
    );
}

Coordinator.propTypes = {};

Coordinator.defaultProps = {};

export default Coordinator;