import React, {useContext, useState} from 'react';
import { useNavigate } from 'react-router-dom';
import { setAuthToken } from '../repository/HttpClient';
import { GlobalContext } from "../Context/Context";
import UserRepository from "../repository/UserRepository";

const Login = ({ setAuthToken: setAppAuthToken }) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const { user, setUser } = useContext(GlobalContext);
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        const token = btoa(`${username}:${password}`);
        setAuthToken(token);
        setAppAuthToken(token);
        try {
            const userData = await UserRepository.getUserDetails();
            if (userData.student) {
                setUser({
                    role: 'student',
                    name: userData.student.name,
                    lastName: userData.student.lastName,
                    parentName: userData.student.parentName,
                    id: userData.student.id,
                    index: userData.student.index,
                    email: '', // Add this if you have email information
                });

            } else if (userData.supervisor) {
                setUser({
                    role: 'supervisor',
                    name: userData.supervisor.fullName,
                    id: userData.supervisor.id,
                    email: '', // Add this if you have email information
                    lastName: '',
                    companyId:userData.supervisor.company?.id,
                    parentName: '',
                    index: '',
                });
            } else if (userData.professor) {
                setUser({
                    role: 'professor',
                    name: userData.professor.name,
                    id: userData.professor.id,
                    email: '',
                    lastName: '',
                    parentName: '',
                    index: '',
                });

            }

            navigate('/');
        } catch (error) {
            console.error('Authentication failed', error);
        }
    };

    return (
        <form onSubmit={handleLogin}>
            <input
                type="text"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                placeholder="Username"
                required
            />
            <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                placeholder="Password"
                required
            />
            <button type="submit">Login</button>
        </form>
    );
};

export default Login;
