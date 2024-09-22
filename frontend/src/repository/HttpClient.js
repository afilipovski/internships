import axios from 'axios';

let token = '';

const setAuthToken = (newToken) => {
    token = newToken;
    localStorage.setItem("basicAuthToken", `Basic ${token}`);
};

const httpInstance = axios.create({
    baseURL: process.env.BACKEND_BASE_URL ?? 'http://localhost:8084/api',
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*'
    }
});

const setAuthHeader = () => {
    httpInstance.defaults.headers.common['Authorization'] = localStorage.getItem("basicAuthToken");
};

const request = async (method, ...args) => {
    setAuthHeader();
    return await httpInstance[method](...args);
};

const instance = {
    instance: httpInstance,
    get: (...args) => request('get', ...args),
    post: (...args) => request('post', ...args),
    put: (...args) => request('put', ...args),
    delete: (...args) => request('delete', ...args),
    patch: (...args) => request('patch', ...args),
    head: (...args) => request('head', ...args),
    options: (...args) => request('options', ...args),
};

export { instance, setAuthToken };
export default instance;