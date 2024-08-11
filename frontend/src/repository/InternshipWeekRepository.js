import {instance} from './HttpClient';
import HttpClient from './HttpClient'


const CONTROLLER_PATH = '/internship-weeks';

class InternshipWeekRepository {

  async getInternshipWeek(id) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/${id}`);
    return response.data;
  }

  async createInternshipWeek(startDate, endDate) {
    const response = await HttpClient.post(`${CONTROLLER_PATH}/create`, null, {
      params: { startDate, endDate },
    });
    return response.data;
  }

  async createInternshipWeekWithInternship(startDate, endDate, internshipId, description) {
    const response = await HttpClient.post(`${CONTROLLER_PATH}/create-with-internship`, null, {
      params: { startDate, endDate, internshipId, description },
    });
    return response.data;
  }

  async updateInternshipWeek(id, startDate, endDate, internshipId, description) {
    const response = await HttpClient.put(`${CONTROLLER_PATH}/${id}`, null, {
      params: { startDate, endDate, internshipId, description },
    });
    return response.data;
  }

  async updateWeekDescription(id, description) {
    const response = await HttpClient.put(`${CONTROLLER_PATH}/${id}/update-description`, null, {
      params: { description },
    });
    return response.data;
  }

  async deleteInternshipWeek(id) {
    const response = await HttpClient.delete(`${CONTROLLER_PATH}/${id}`);
    return response.data;
  }
}

export default new InternshipWeekRepository();
