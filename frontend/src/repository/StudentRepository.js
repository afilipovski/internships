import {instance} from './HttpClient';

const CONTROLLER_PATH = '/students';

class StudentRepository {

  async getStudentByUserId(userId) {
    const response = await instance.get(`${CONTROLLER_PATH}/user/${userId}`);
    return response.data;
  }

  async getStudentByIndex(index) {
    const response = await instance.get(`${CONTROLLER_PATH}/${index}`);
    return response.data;
  }

  async approveInternship(index, internshipId) {
    await instance.put(`${CONTROLLER_PATH}/${index}/approve-internship/${internshipId}`);
  }

  async revokeApprovalInternship(index, internshipId) {
    await instance.put(`${CONTROLLER_PATH}/${index}/revoke-internship-approval/${internshipId}`);
  }
}

export default new StudentRepository();
