import {instance} from './HttpClient';

class UserRepository {
    async getUserDetails() {
        const response = await instance.get('/user');
        return response.data;
    }
}

export default new UserRepository();