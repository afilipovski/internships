import React, { useState, useEffect, useContext } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Navbar from './Navbar/Navbar';
import InternCard from './InternCard/InternCard';
import Authentication from './Authentication/Authentication';
import Calendar from './Calendar/Calendar';
import Coordinator from './Coordinator/Coordinator';
import CoordinatorDetails from './CoordinatorDetails/CoordinatorDetails';
import Login from './Login/Login';
import { GlobalContext } from "./Context/Context";
import CreateInternship from "./CreateInternship/CreateInternship"; // Correct import

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
                    element={user && user.role ? (user.role === 'student' ? <InternCard /> : <Coordinator />) : <Navigate to="/login" />}
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
                    path="/create"
                    element={user ? <CreateInternship /> : <Navigate to="/login" />}
                />
                <Route
                    path="/coordinator"
                    element={user ? <Coordinator /> : <Navigate to="/login" />}
                />
                <Route
                    path="/coordinatorDetails"
                    element={user ? <CoordinatorDetails /> : <Navigate to="/login" />}
                />
            </Routes>
        </Router>
    );
}

export default App;
