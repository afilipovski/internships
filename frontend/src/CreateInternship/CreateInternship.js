import React, { useContext, useEffect, useState } from 'react';
import { useNavigate } from "react-router-dom";
import { GlobalContext } from "../Context/Context";
import InternshipPostingRepository from "../repository/InternshipPostingRepository";
import InternshipRepository from "../repository/InternshipRepository";
import { useLocation } from 'react-router-dom';

function CreateInternship(props) {
    const nav = useNavigate();
    const { user } = useContext(GlobalContext);
    const [selectedPosting, setSelectedPosting] = useState(null);
    const [postings, setPostings] = useState([]);
    const { userId, internshipId } = location.state || {}; // Default to empty object to avoid destructuring null/undefined

    const loadPostings = async () => {
        try {
            const data = await InternshipPostingRepository.getAllInternshipPostings();
            setPostings(data);
        } catch (error) {
            console.error('Failed to load postings', error);
        }
    };
    const addNewInternship = async () => {
        try {
            const data = await InternshipRepository.createInternship(user.index,selectedPosting.id).then(()=>{
                nav("/")
            });
        } catch (error) {
            console.error('Failed to load postings', error);
        }
    };
    useEffect(() => {
        loadPostings();
        console.log(postings);
    }, []);

    const handleChange = (event) => {
        const selected = postings.find(posting => posting.id === parseInt(event.target.value));
        setSelectedPosting(selected);
    };

    return (
        <div className="flex">
            <select onChange={handleChange} value={selectedPosting ? selectedPosting.id : ''}>
                <option value="" disabled>Select a posting</option>
                {postings.map(posting => (
                    <option key={posting.id} value={posting.id}>
                        {posting.position}
                    </option>
                ))}
            </select>
            <button onClick={addNewInternship}>
                Add internship
            </button>
        </div>
    );
}

export default CreateInternship;
