import HttpClient from './HttpClient';

const CONTROLLER_PATH = '/internship-supervisors';

class InternshipSupervisorRepository {

  async createInternshipSupervisor(companyId, email, fullName) {
    const response = await HttpClient.post(`${CONTROLLER_PATH}/create`, null, {
      params: { companyId, email, fullName },
    });
    return response.data;
  }

  async getInternshipSupervisor(id) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/${id}`);
    return response.data;
  }

  async approveInternship(id, internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/approve/${id}/${internshipId}`);
  }

  async revokeApprovalInternship(id, internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/revoke-approval/${id}/${internshipId}`);
  }

  async assignInternship(id, internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/assign/${id}/${internshipId}`);
  }

  async getAllInternshipSupervisors() {
    const response = await HttpClient.get(CONTROLLER_PATH);
    return response.data;
  }

  async updateInternshipSupervisor(supervisor) {
    await HttpClient.put(`${CONTROLLER_PATH}/update`, supervisor);
  }
}

export default new InternshipSupervisorRepository();
