import React, { useContext, useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";
import { GlobalContext } from "../Context/Context";
import InternshipRepository from "../repository/InternshipRepository";
import check from "../assets/check.svg";
import testLogo from "../assets/image1.png";
import './InternCard.css';

const InternCard = () => {
    const nav = useNavigate();
    const { user } = useContext(GlobalContext);
    const [internships, setInternships] = useState([]);

    const loadInternships = async () => {
        if (!user.index) return;

        try {
            const data = await InternshipRepository.getInternshipsByStudentIndex(user.index);
            setInternships(data);
        } catch (error) {
            console.error('Failed to load internships', error);
        }
    };
    const createInternship = async () => {

       nav("/create")
    };
    const openCalendar = (internshipId) => {
        nav("/calendar", { state: { index: user.index, internshipId: internshipId } });
    };
    useEffect(() => {
        loadInternships();
        console.log(internships);
    }, []);

    return (
        <div className="flex flex-col justify-center h-full">
            <div className="p-4 flex justify-start">
                    <button className="bg-finkiO px-8 py-4 rounded-xl text-white font-bold text-lg lg:text-xl" onClick={createInternship}>
                        Add new internship
                    </button>
            </div>
            {internships &&
                internships.map((internship) => (
                    <div key={internship.id} className="flex flex-col lg:flex-row rounded-[40px] shadowCard w-full lg:w-8/12 mx-auto mt-8">
                        <div className="basis-1/4 rounded-tl-[40px] rounded-bl-[40px] flex justify-center overflow-hidden bgLogoImage" style={{ backgroundImage: `url(${testLogo})` }}>
                            <div className="flex flex-col justify-center h-full w-full bgLogoBlur">
                                <div className="flex justify-center">
                                    <img className="rounded-[30px] m-8 lg:m-0 w-2/12 lg:w-6/12 h-auto" src={testLogo} alt="Logo" />
                                </div>
                            </div>
                        </div>

                        <div className="basis-3/4 flex flex-col p-8">
                            <div className="flex justify-between">
                                <div className="flex flex-col">
                                    <h1 className="font-bold text-xl lg:text-4xl">{internship.posting.position}</h1>
                                    <h3 className="text-md lg:text-2xl font-thin">{internship.posting.company.name}</h3>
                                </div>
                                <div className="flex justify-center">
                                    <div className="flex flex-col justify-center">
                                        <h1 className="bg-offblack text-white w-fit p-2 px-4 text-lg md:text-2xl font-bold h-fit rounded-xl">{internship.journal.length}</h1>
                                    </div>
                                    <div className="flex flex-col justify-center">
                                        <h1 className="text-offblack w-fit px-2 text-md md:text-xl font-bold h-fit">од {internship.posting.plannedWeeks} недели</h1>
                                    </div>
                                </div>
                            </div>
                            <div className='flex mt-4 flex-wrap circles'>
                                {internship.journal.map((journalWeek) => (
                                    <img
                                        key={journalWeek.id}
                                        className={`rounded-full ${internship.status === "DEPOSITED" ? 'bg-green' : 'bg-gray'} md:p-4 w-[12%]`}
                                        src={check}
                                        alt="Check"
                                    />
                                ))}
                            </div>
                            <div className="flex flex-col-reverse lg:flex-row justify-between rounded-xl shadow-xl shadowCard mt-4">
                                <div className="flex justify-evenly w-full p-4 lg:p-0">
                                    <div className="flex flex-col justify-center">
                                        <div className="rounded-full w-[20px] h-[20px] bg-red"></div>
                                    </div>
                                    <div className="flex flex-col justify-center">
                                        <h1 className="ml-4 text-sm lg:text-2xl">{internship.status}</h1>
                                    </div>
                                </div>
                                <button onClick={() => openCalendar(internship.id)} className="bg-finkiO px-8 py-4 rounded-xl text-white font-bold text-lg lg:text-2xl">Дневник</button>
                            </div>
                        </div>
                    </div>
                ))}
        </div>
    );
};

export default InternCard;
