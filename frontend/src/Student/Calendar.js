import React, { useContext, useEffect, useState } from 'react';
import './Calendar.css';
import InternshipRepository from "../repository/InternshipRepository";
import { useNavigate } from "react-router-dom";
import { GlobalContext } from "../Context/Context";
import { useLocation } from 'react-router-dom';
import InternshipWeekRepository from "../repository/InternshipWeekRepository";
import StudentRepository from "../repository/StudentRepository";
import { PDFDownloadLink, Document, Page, Text, View, StyleSheet,Font } from '@react-pdf/renderer';
import RobotoRegular from './fonts/Roboto-Regular.ttf';
import RobotoBold from './fonts/Roboto-Bold.ttf';
Font.register({
    family: 'Roboto',
    fonts: [
        { src: RobotoRegular, fontWeight: 'normal' },
        { src: RobotoBold, fontWeight: 'bold' },
    ],
});
const styles = StyleSheet.create({
    page: {
        padding: 20,
        fontFamily: 'Roboto',
    },
    header: {
        marginBottom: 20,
        fontSize: 12,
    },
    section: {
        marginBottom: 15,
        fontSize: 12,
    },
    title: {
        fontSize: 20,
        fontWeight:"bold",
        textAlign: 'center',
        marginBottom: 30,
    },
    weekTitle: {
        fontSize: 14,
        marginBottom: 5,
        fontWeight: 'bold'
    },
    description: {
        fontSize: 12,
        marginBottom: 8,
    },
    label: {
        fontWeight: 'bold',
    },
    underline: {
        textDecoration: 'underline',
    },
    spacing: {
        marginBottom: 10,
    },
});

const PDFDocument = ({ internship }) => (
    <Document>
        <Page style={styles.page}>
            <Text style={styles.title}>Student Internship calendar</Text>

            <View style={styles.header}>
                <View style={{ flexDirection: 'row' }}>
                    <Text style={{ fontWeight: 'bold' }}>Name and surname: </Text>
                    <Text style={{ fontWeight: 'normal' }}>
                        {internship?.student.name} {internship?.student.lastName}
                    </Text>
                </View>
                <View style={{ flexDirection: 'row' }}>
                    <Text style={{ fontWeight: 'bold' }}>Student index: </Text>
                    <Text style={{ fontWeight: 'normal' }}>{internship?.student.index}</Text>
                </View>
                <View style={{ flexDirection: 'row' }}>
                    <Text style={{ fontWeight: 'bold' }}>Date: </Text>
                    <Text style={{ fontWeight: 'normal' }}>
                    {internship?.journal?.length > 0 && (
                        <>
                            {new Date(internship.journal[0].startDate).toLocaleDateString('en-GB')} –{' '}
                            {new Date(internship.journal[internship.journal.length - 1].endDate).toLocaleDateString('en-GB')}
                        </>
                    )}
                    </Text>
                </View>
                <View style={{ flexDirection: 'row' }}>
                    <Text style={{ fontWeight: 'bold' }}>Company: </Text>
                    <Text style={{ fontWeight: 'normal' }}>
                    {internship?.posting.company.name}
                    </Text>
                </View>
            </View>

            <View style={styles.section}>
                <Text style={{ fontWeight: 'bold' }}>Supervisor:</Text>
                <Text style={styles.spacing}>_______________</Text>
            </View>

            {internship && internship.journal.map((week, index) => (
                <View key={week.id} style={styles.section}>
                    <Text style={styles.weekTitle}>
                        Week {index + 1} ({new Date(week.startDate).toLocaleDateString()} – {new Date(week.endDate).toLocaleDateString()}):
                    </Text>
                    {week.description ? (
                        week.description.split(/\n+/)
                            .filter(line => line.trim() !== "")
                            .map((line, lineIndex) => (
                                <Text key={lineIndex} style={styles.description}>
                                    - {line.trim()}
                                </Text>
                            ))
                    ) : (
                        <Text style={styles.description}>No description available</Text>
                    )}              </View>
            ))}
        </Page>
    </Document>
);

function Calendar(props) {
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

    const addweek = () => {
        setWeek(null);
        setWeekdesc("");
        setStartDate("");
        setEndDate("");
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

    const addWeek = async () => {
        try {
            await InternshipWeekRepository.createInternshipWeekWithInternship(startDate, endDate, internshipId, weekdesc);
            // Reload internship to reflect the new week
            loadInternship();
        } catch (error) {
            console.error('Failed to add internship week', error);
        }
    };
    const studentApprove = async () => {
        try {
            await StudentRepository.approveInternship(index,internshipId);
            // Reload internship to reflect the new week
            loadInternship();
        } catch (error) {
            console.error('Failed to add internship week', error);
        }
    };
    const revokeApproval = async () => {
        try {
            await StudentRepository.revokeApprovalInternship(index,internshipId);
            // Reload internship to reflect the new week
            loadInternship();
        } catch (error) {
            console.error('Failed to add internship week', error);
        }
    };
    const editWeek = async (id) => {
        try {
            await InternshipWeekRepository.updateInternshipWeek(id, startDate, endDate, internshipId, weekdesc);
            // Reload internship to reflect the edited week
            loadInternship();
        } catch (error) {
            console.error('Failed to edit internship week', error);
        }
    };
    const deleteInternship = async () => {
        try {
            const data = await InternshipRepository.deleteInternship(internship.id).then(()=>{
                nav("/")
            });
        } catch (error) {
            console.error('Failed to load postings', error);
        }
    };
    const deleteWeek = async (id) => {
        try {
            await InternshipWeekRepository.deleteInternshipWeek(id);
            setWeek(null);
            // Reload internship to reflect the deleted week
            loadInternship();
        } catch (error) {
            console.error('Failed to delete internship week', error);
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
                        <input id="startDate" onChange={(e) => setStartDate(e.target.value)} className="m-2" type="date" name="startDate" value={startDate} /><br />
                        <label htmlFor="endDate" className="m-2">End Date:</label>
                        <input id="endDate" onChange={(e) => setEndDate(e.target.value)} className="m-2" type="date" name="endDate" value={endDate} />
                    </div>
                    <textarea placeholder="Внесете дневник за неделата." onChange={(e) => setWeekdesc(e.target.value)} className="h-[30vh] p-2 my-4 rounded-xl" value={weekdesc} />
                    <div className="text-white flex justify-end">
                        {week && internship.status==="ONGOING" && <button className="bg-red px-4 py-2 rounded-xl mr-2" onClick={() => deleteWeek(week.id)}>
                            Избриши
                        </button>}
                        {!week ?
                            <button className="bg-finkiO px-4 py-2 rounded-xl" onClick={addWeek}>
                                Зачувај
                            </button>
                            :
                            <button className="bg-finkiO px-4 py-2 rounded-xl" onClick={() => editWeek(week.id)}>
                                Зачувај
                            </button>}

                    </div>
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
                    {internship && internship.status==="ONGOING" && <button className="bg-finkiO text-white p-3 rounded-xl mx-2" onClick={studentApprove}>
                        Approve
                    </button>}
                    {internship && internship.status==="PENDING_COMPANY_REVIEW" && <button className="bg-red text-white p-3 rounded-xl mx-2" onClick={revokeApproval}>
                        Revoke Approval
                    </button>}
                    {internship && internship.status==="ONGOING" && <button className="bg-red text-white p-3 rounded-xl mx-2"  onClick={deleteInternship}>
                        Delete
                    </button>}
                    {internship && internship.status==="DEPOSITED" && (
                        <button className="bg-green text-white p-3 rounded-xl mx-2">
                        <PDFDownloadLink
                            document={<PDFDocument internship={internship} />}
                            fileName="internship_calendar.pdf"
                        >
                            {({ loading }) => (loading ? 'Loading document...' : 'Download PDF')}
                        </PDFDownloadLink>
                        </button>
                    )}
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
                {internship && internship.status === "ONGOING" && <div
                    className="flex justify-center flex-col shadow-xl rounded-xl p-4 h-[30vh] min-h-auto lg:h-auto cardWeek"
                    onClick={addweek}>
                    <div className="flex justify-center items-center mx-auto h-[17vh]">
                        <div className="rounded-full bg-[#2A93D1] p-4 flex justify-center w-[6vw] h-[6vw]">
                            <div className="flex flex-col justify-center text-center">
                                <button className="text-[#f8f8f8] font-bold text-2xl h-fit justify-center ">+
                                </button>
                            </div>
                        </div>
                    </div>
                </div>}
            </div>
        </div>
    );
}

Calendar.propTypes = {};

Calendar.defaultProps = {};

export default Calendar;
