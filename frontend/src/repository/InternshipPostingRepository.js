import HttpClient from './HttpClient';

const CONTROLLER_PATH = '/internship-postings';

class InternshipPostingRepository {

  async getAllInternshipPostings() {
    const response = await HttpClient.get(CONTROLLER_PATH);
    return response.data;
  }
}

export default new InternshipPostingRepository();
