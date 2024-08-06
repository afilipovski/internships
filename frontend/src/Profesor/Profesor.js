import React, { useContext, useEffect, useState } from 'react';
import ProfessorCalendar from "./ProfessorCalendar";
import { useNavigate } from "react-router-dom";
import { GlobalContext } from "../Context/Context";
import InternshipRepository from "../repository/InternshipRepository";
import InternshipCoordinatorRepository from "../repository/InternshipCoordinatorRepository";
import ProfessorCard from "./ProfessorCard";

function Professor(props) {
    const nav = useNavigate();
    const { user } = useContext(GlobalContext);
    const [internships, setInternships] = useState([]);
    const [originalInternships, setOriginalInternships] = useState([]);
    const [coordinator, setCoordinator] = useState(null);

    const loadCoordinator = async () => {
        try {
            const data = await InternshipCoordinatorRepository.getInternshipCoordinator(user?.id);
            setCoordinator(data);
        } catch (error) {
            console.error('Failed to load coordinator', error);
        }
    };
    const optIn = async () => {
        try {
            await InternshipCoordinatorRepository.optIn();
        } catch (error) {
            console.error('Failed to load internships', error);
        }
    };
    const optOut = async () => {
        try {
            await InternshipCoordinatorRepository.optOut();
            setCoordinator(null);
        } catch (error) {
            console.error('Failed to load internships', error);
        }
    };
    const loadInternships = async () => {
        try {
            const depositedData = await InternshipRepository.getInternshipsByProfessorIdAndStatus(user?.id, "DEPOSITED");
            const pendingProfessorReviewData = await InternshipRepository.getInternshipsByProfessorIdAndStatus(user?.id, "PENDING_PROFFESSOR_REVIEW");
            const combinedData = [...depositedData, ...pendingProfessorReviewData];
            setInternships(combinedData);
            setOriginalInternships(combinedData);
        } catch (error) {
            console.error('Failed to load internships', error);
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
        loadCoordinator();
        loadInternships();
    }, []);

    return (
        <div className="pt-4 px-4">
            <div className="flex flex-col lg:flex-row justify-between">
                <div className="basis-1/3 text-white mb-4">
                    {coordinator && <button className="w-[49%] py-2 rounded-xl mr-[2%] bg-finkiO text-gray"
                                            onClick={optOut}>Opt out</button>
                    }
                    {!coordinator && <button className="w-[49%] py-2 rounded-xl mr-[2%] bg-finkiO text-gray"
                                             onClick={optIn}>Opt in</button>
                    }
                </div>
                <input
                    className="basis-1/3 bg-lightgray px-4 py-2 text-gray placeholder-gray mb-4 rounded-xl"
                    type="text"
                    placeholder="Пребарување.."
                    onChange={handleSearch}
                />
            </div>
            <div>
                {internships && internships.map((internship) => (
                    <ProfessorCard key={internship.id} internship={internship} />
                ))}
            </div>
        </div>
    );
}

Professor.propTypes = {};

Professor.defaultProps = {};

export default Professor;
