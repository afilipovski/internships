import axios from 'axios';

let token = '';

const setAuthToken = (newToken) => {
    token = newToken;
    instance.defaults.headers.common['Authorization'] = `Basic ${token}`;
};

const instance = axios.create({
    baseURL: process.env.BACKEND_BASE_URL ?? 'http://localhost:8080/api',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    }
});

export { instance, setAuthToken };
export default instance;