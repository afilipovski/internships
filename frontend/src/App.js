import React, { useState, useEffect, useContext } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Navbar from './Navbar/Navbar';
import InternCard from './Student/InternCard';
import Calendar from './Student/Calendar';
import Supervisor from './Supervisor/Supervisor';
import Login from './Login/Login';
import { GlobalContext } from "./Context/Context";
import CreateInternship from "./CreateInternship/CreateInternship";
import SupervisorCalendar from "./Supervisor/SupervisorCalendar";
import Profesor from "./Profesor/Profesor";
import ProfessorCalendar from "./Profesor/ProfessorCalendar"; // Correct import

function App() {
    const [authToken, setAuthToken] = useState(localStorage.getItem('authToken') || '');
    const { user, setUser } = useContext(GlobalContext);

    useEffect(() => {
        if (authToken) {
            localStorage.setItem('authToken', authToken);
        } else {
            localStorage.removeItem('authToken');
            setUser(null)
        }
        console.log(user);
    }, [authToken, user]);

    return (
        <Router>
            <Navbar setAuthToken={setAuthToken} />
            <Routes>
                <Route
                    path="/"
                    element={
                        user && user.role ? (
                            user.role === 'student' ? (
                                <InternCard />
                            ) : user.role === 'supervisor' ? (
                                <Supervisor />
                            ) : user.role === 'professor' ? (
                                <Profesor />
                            ) : (
                                <Navigate to="/login" />
                            )
                        ) : (
                            <Navigate to="/login" />
                        )
                    }
                />
                <Route
                    path="/login"
                    element={<Login setAuthToken={setAuthToken} />}
                />

                <Route
                    path="/calendar"
                    element={user ? <Calendar /> : <Navigate to="/login" />}
                />
                <Route
                    path="/supervisor-calendar"
                    element={user ? <SupervisorCalendar /> : <Navigate to="/login" />}
                />
                <Route
                    path="/coordinator-calendar"
                    element={user ? <ProfessorCalendar /> : <Navigate to="/login" />}
                />
                <Route
                    path="/create"
                    element={user ? <CreateInternship /> : <Navigate to="/login" />}
                />
            </Routes>
        </Router>
    );
}

export default App;
