import axios from 'axios';

let token = '';

const setAuthToken = (newToken) => {
    token = newToken;
    instance.defaults.headers.common['Authorization'] = `Basic ${token}`;
    console.log("VLAGHA")
};

const instance = axios.create({
    baseURL: 'http://localhost:8084/api',
    headers: {
        'Content-Type': 'application/json', // Ensure Content-Type is set
        'Access-Control-Allow-Origin': '*'
    }
});

export { instance, setAuthToken };
