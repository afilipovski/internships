import React, { useContext, useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import './Supervisor.css';
import SupervisorCard from "./SupervisorCard";
import { useNavigate } from "react-router-dom";
import { GlobalContext } from "../Context/Context";
import InternshipRepository from "../repository/InternshipRepository";

function Supervisor(props) {
    const nav = useNavigate();
    const { user } = useContext(GlobalContext);
    const [internships, setInternships] = useState([]);
    const [originalInternships, setOriginalInternships] = useState([]);
    const [tekovni, setTekovni] = useState(true);

    const loadInternships = async () => {
        if (tekovni) {
            try {
                const data = await InternshipRepository.getInternshipsByCompanyIdAndSupervisorIdIsNull(user?.companyId);
                setInternships(data);
                setOriginalInternships(data); // Store the original list
            } catch (error) {
                console.error('Failed to load internships', error);
            }
        } else {
            try {
                const pendingReviewData = await InternshipRepository.getInternshipsBySupervisorIdAndStatus(user?.id, "PENDING_COMPANY_REVIEW");
                const ongoingData = await InternshipRepository.getInternshipsBySupervisorIdAndStatus(user?.id, "ONGOING");
                const pendingProfessorReviewData = await InternshipRepository.getInternshipsBySupervisorIdAndStatus(user?.id, "PENDING_PROFFESSOR_REVIEW");
                const combinedData = [...pendingReviewData, ...ongoingData, ...pendingProfessorReviewData];
                setInternships(combinedData);
                setOriginalInternships(combinedData); // Store the original list
            } catch (error) {
                console.error('Failed to load internships', error);
            }
        }
    };

    const handleSearch = (e) => {
        const searchTerm = e.target.value.toUpperCase();
        if (searchTerm === '') {
            setInternships(originalInternships); // Reset to the original list when the input is cleared
        } else {
            const filteredInternships = originalInternships.filter((item) =>
                item?.student.index.toUpperCase().includes(searchTerm)
            );
            setInternships(filteredInternships);
        }
    };

    useEffect(() => {
        loadInternships();
    }, [tekovni]);

    return (
        <div className="pt-4 px-4">
            <div className="flex flex-col lg:flex-row justify-between">
                <div className="basis-1/3 text-white mb-4">
                    <button className={`w-[49%] py-2 rounded-xl mr-[2%] ${tekovni ? 'bg-finkiO' : 'bg-lightgray text-gray'}`} onClick={() => setTekovni(true)}>Тековни</button>
                    <button className={`w-[49%] py-2 rounded-xl ${!tekovni ? 'bg-finkiO' : 'bg-lightgray text-gray'}`} onClick={() => setTekovni(false)}>Заверени</button>
                </div>
                <input className="basis-1/3 bg-lightgray px-4 py-2 text-gray placeholder-gray mb-4 rounded-xl" type="text" placeholder="Пребарување.." onChange={handleSearch} />
            </div>
            <div>
                {internships && internships.map((internship) => (
                    <SupervisorCard key={internship.id} internship={internship} SetTekovni={setTekovni} />
                ))}
            </div>
        </div>
    );
}

Supervisor.propTypes = {};

Supervisor.defaultProps = {};

export default Supervisor;
