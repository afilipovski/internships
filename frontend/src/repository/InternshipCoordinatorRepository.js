import HttpClient from './HttpClient';

const CONTROLLER_PATH = '/internship-coordinators';

class InternshipCoordinatorRepository {

  async createInternshipCoordinator(professorId) {
    const response = await HttpClient.post(`${CONTROLLER_PATH}/create`, null, {
      params: { professorId },
    });
    return response.data;
  }

  async deleteInternshipCoordinator(professorId) {
    const response = await HttpClient.delete(`${CONTROLLER_PATH}/delete/${professorId}`);
    return response.data;
  }

  async getInternshipCoordinator(professorId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/${professorId}`);
    return response.data;
  }

  async approveInternship(professorId, internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/approve/${professorId}/${internshipId}`);
  }

  async revokeApprovalInternship(professorId, internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/revoke-approval/${professorId}/${internshipId}`);
  }

  async assignRandomCoordinator(internshipId) {
    await HttpClient.put(`${CONTROLLER_PATH}/assign-random/${internshipId}`);
  }
}

export default new InternshipCoordinatorRepository();
