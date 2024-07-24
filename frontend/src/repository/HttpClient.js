import axios from "axios";

const username = 'riste.stojanov';
const password = 'SystemPass';
const token = btoa(`${username}:${password}`);

const instance = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Authorization': `Basic ${token}`
    }
});

export default instance;