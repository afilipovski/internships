import HttpClient from './HttpClient'

const CONTROLLER_PATH = '/companies';

class CompanyRepository {
  
  async getAllCompanies() {
    const response = await HttpClient.get(CONTROLLER_PATH);
    return response.data;
  }

  async getCompanyById(id) {
    const response = await HttpClient.get(`${CONTROLLER_PATH}/${id}`);
    return response.data;
  }

  async saveCompany({
    id,
    name,
    phone,
    email,
    companyDescription,
    websiteUrl,
    logoImage,
    banner,
    active,
  }) {
    const formData = new FormData();
    formData.append('id', id);
    formData.append('name', name);
    formData.append('phone', phone);
    formData.append('email', email);
    formData.append('companyDescription', companyDescription);
    formData.append('websiteUrl', websiteUrl);
    formData.append('logoImage', logoImage);
    formData.append('banner', banner);
    formData.append('active', active);
    
    await HttpClient.post(CONTROLLER_PATH, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
  }

  async editCompany({
    id,
    name,
    phone,
    email,
    companyDescription,
    websiteUrl,
    logoImage,
    banner,
    active,
  }) {
    const formData = new FormData();
    formData.append('name', name);
    formData.append('phone', phone);
    formData.append('email', email);
    formData.append('companyDescription', companyDescription);
    formData.append('websiteUrl', websiteUrl);
    formData.append('logoImage', logoImage);
    formData.append('banner', banner);
    formData.append('active', active);
    
    await HttpClient.put(`${CONTROLLER_PATH}/${id}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
  }

}

export default new CompanyRepository();
