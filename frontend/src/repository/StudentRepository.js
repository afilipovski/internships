import HttpClient from './HttpClient';

const CONTROLLER_PATH = '/students';

class StudentRepository {

  async getStudentByUserId(userId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/user/${userId}`);
    return response.data;
  }

  async getStudentByIndex(index) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/${index}`);
    return response.data;
  }

  async approveInternship(id, internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/${id}/approve-internship/${internshipId}`);
  }

  async revokeApprovalInternship(id, internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/${id}/revoke-internship-approval/${internshipId}`);
  }
}

export default new StudentRepository();
