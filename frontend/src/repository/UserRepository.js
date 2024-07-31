import {instance} from './HttpClient';
import HttpClient from './HttpClient'

class UserRepository {
    async getUserDetails() {
        const response = await HttpClient.get('/user');
        return response.data;
    }
}

export default new UserRepository();