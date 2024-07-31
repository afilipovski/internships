import {instance} from './HttpClient';
import HttpClient from './HttpClient'

const CONTROLLER_PATH = '/internships';

class InternshipRepository {
  
  async createInternship(studentId, postingId) {
    const response = await HttpClient.post(CONTROLLER_PATH, null, {
      params: { studentId, postingId },
    });
    return response.data;
  }

  async deleteInternship(id) {
    const response = await HttpClient.delete(`${CONTROLLER_PATH}/${id}`);
    return response.data;
  }

  async getInternshipsByStudentIndex(studentIndex) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/student/${studentIndex}`);
    return response.data;
  }

  async getInternshipsBySupervisorId(supervisorId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/supervisor/${supervisorId}`);
    return response.data;
  }

  async getInternshipsByProfessorId(professorId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/professor/${professorId}`);
    return response.data;
  }

  async getInternshipsByStudentIdAndStatus(studentId, status) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/student/${studentId}/status/${status}`);
    return response.data;
  }

  async getInternshipsBySupervisorIdAndStatus(supervisorId, status) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/supervisor/${supervisorId}/status/${status}`);
    return response.data;
  }

  async getInternshipsBySupervisorIdOrderByStatus(supervisorId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/supervisor/${supervisorId}/order-by-status`);
    return response.data;
  }

  async getInternshipsByProfessorIdAndStatus(professorId, status) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/professor/${professorId}/status/${status}`);
    return response.data;
  }

  async getInternshipById(id) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/${id}`);
    return response.data;
  }

  async addInternshipWeek(id, weekId) {
    const response = await HttpClient.post(`${CONTROLLER_PATH}/${id}/weeks/${weekId}`);
    return response.data;
  }

  async getInternshipsByCompanyId(companyId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/company/${companyId}`);
    return response.data;
  }

  async getInternshipsByCompanyIdAndStatus(companyId, status) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/company/${companyId}/status/${status}`);
    return response.data;
  }

  async getInternshipsByCompanyIdAndSupervisorIdNot(companyId, supervisorId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/company/${companyId}/supervisor/not/${supervisorId}`);
    return response.data;
  }

  async getInternshipsByCompanyIdAndSupervisorIdIsNull(companyId) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/company/${companyId}/supervisor/null`);
    return response.data;
  }
}

export default new InternshipRepository();
