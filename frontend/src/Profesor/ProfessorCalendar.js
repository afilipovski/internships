import React, {useContext, useEffect, useState} from 'react';
import {useLocation, useNavigate} from "react-router-dom";
import {GlobalContext} from "../Context/Context";
import InternshipWeekRepository from "../repository/InternshipWeekRepository";
import InternshipRepository from "../repository/InternshipRepository";
import InternshipSupervisorRepository from "../repository/InternshipSupervisorRepository";
import InternshipCoordinatorRepository from "../repository/InternshipCoordinatorRepository";

function ProfessorCalendar(props) {
    const loc = useLocation();
    const nav = useNavigate();
    const { user } = useContext(GlobalContext);
    const [internship, setInternship] = useState(null);
    const [week, setWeek] = useState(null);
    const [weekdesc, setWeekdesc] = useState("");
    const [startDate, setStartDate] = useState("");
    const [endDate, setEndDate] = useState("");
    const { index, internshipId } = loc.state || {}; // Default to empty object to avoid destructuring null/undefined

    const formatDate = (dateString) => {
        const options = { day: 'numeric', month: 'short' };
        const date = new Date(dateString);
        return date.toLocaleDateString('en-GB', options);
    };

    const handleWeek = async (id) => {
        try {
            const data = await InternshipWeekRepository.getInternshipWeek(id);
            setWeek(data);
            setWeekdesc(data.description);
            setStartDate(data.startDate);
            setEndDate(data.endDate);
        } catch (error) {
            console.error('Failed to load internship week', error);
        }
    };

    const loadInternship = async () => {
        try {
            const data = await InternshipRepository.getInternshipById(internshipId);
            setInternship(data)
            console.log(internshipId)
        } catch (error) {
            console.error('Failed to load internships', error);
        }
    };

    const coordinatorApprove = async () => {
        try {
            await InternshipCoordinatorRepository.approveInternship(user.id,internshipId);
            loadInternship();
        } catch (error) {
            console.error('Failed to add internship week', error);
        }
    };


    useEffect(() => {
        loadInternship();
        console.log(internship);
    }, []);

    return (
        <div className="md:h-[93vh] w-full flex flex-col lg:flex-row">
            <div className="md:basis-1/3 lg:basis-1/4 flex flex-col justify-start px-4 py-4 shadowCard h-max">
                <h1 className="w-full basis-1/8 p-2 text-center font-thin text-4xl mb-4 mt-4">Дневник</h1>
                <div className="basis-2/3 w-full p-4 shadowCard rounded-xl flex flex-col justify-between">
                    <div className="">
                        {week ? <h1 className="text-offblack font-bold text-2xl">{formatDate(week.startDate)}</h1> :
                            <h1 className="text-offblack font-bold text-2xl">No week</h1>}
                        {week ? <h4 className="text-sm text-gray">{formatDate(week.startDate)} - {formatDate(week.endDate)}</h4> :
                            <h4 className="text-sm text-gray">No week</h4>}
                        <label htmlFor="startDate" className="m-2">Start Date:</label>
                        <input id="startDate" disabled onChange={(e) => setStartDate(e.target.value)} className="m-2" type="date" name="startDate" value={startDate} /><br />
                        <label htmlFor="endDate" className="m-2">End Date:</label>
                        <input id="endDate" disabled onChange={(e) => setEndDate(e.target.value)} className="m-2" type="date" name="endDate" value={endDate} />
                    </div>
                    <textarea disabled placeholder="Внесете дневник за неделата." onChange={(e) => setWeekdesc(e.target.value)} className="h-[30vh] p-2 my-4 rounded-xl" value={weekdesc} />

                </div>
                <div className="flex flex-row">
                    <div className="flex justify-center flex-row">
                        <h1 className="w-full flex-basis-12.5 p-1 text-center font-bold text-base mb-1 mt-1">Supervisor:</h1>
                        {internship?.supervisor ? <h1 className="w-full flex-basis-12.5 p-1 text-center font-thin text-base mb-1 mt-1">{internship.supervisor.fullName}</h1>
                            : <h1 className="w-full flex-basis-12.5 p-1 text-center font-thin text-base mb-1 mt-1">TBD</h1>}
                    </div>
                    <div className="flex justify-center flex-row">
                        <h1 className="w-full flex-basis-12.5 p-1 text-center font-bold text-base mb-1 mt-1">Profesor:</h1>
                        {internship?.professor ? <h1 className="w-full flex-basis-12.5 p-1 text-center font-thin text-base mb-1 mt-1">{internship.professor.name}</h1>
                            : <h1 className="w-full flex-basis-12.5 p-1 text-center font-thin text-base mb-1 mt-1">TBD</h1>}                    </div>
                </div>
                <div className="flex justify-center flex-row">
                    {internship && internship.status==="PENDING_PROFFESSOR_REVIEW" && <button className="bg-finkiO text-white p-3 rounded-xl mx-2" onClick={coordinatorApprove}>
                        Approve
                    </button>}
                </div>
            </div>
            <div className="md:basis-2/3 h-max lg:basis-3/4 p-8 w-full lg:w-fit mx-auto grid grid-cols-1 lg:grid-cols-4 gap-4">
                {internship && internship.journal.map((journalweek, i) => (
                    <div key={journalweek.id} className="flex flex-col shadowCard rounded-xl p-4 h-[30vh] lg:h-auto cardWeek" onClick={() => handleWeek(journalweek.id)}>
                        <div className="flex justify-between">
                            {internship.status !== "DEPOSITED" ? <div className="rounded-full bg-gray p-4 flex justify-center w-[3.5vw] h-[3.5vw]">
                                <div className="flex flex-col justify-center">
                                    <h1 className="text-[#f8f8f8] font-bold w-fit h-fit">{i + 1}</h1>
                                </div>
                            </div> : <div className="rounded-full bg-green p-4 flex justify-center w-[3.5vw] h-[3.5vw]">
                                <div className="flex flex-col justify-center">
                                    <h1 className="text-[#f8f8f8] font-bold w-fit h-fit">{i + 1}</h1>
                                </div>
                            </div>}
                            <div className="flex flex-col justify-center">
                                <h1 className="w-fit font-bold text-offblack">{formatDate(journalweek.startDate)} - {formatDate(journalweek.endDate)}</h1>
                            </div>
                        </div>
                        {journalweek ? <textarea className="rounded-xl mt-4 h-[17vh] cardTextArea p-2 text-sm" value={journalweek.description}></textarea> : <textarea className="rounded-xl mt-4 h-[17vh] cardTextArea p-2 text-sm" disabled value="DABSHDSAHBJ"></textarea>}
                    </div>
                ))}
            </div>
        </div>
    );
}

export default ProfessorCalendar;