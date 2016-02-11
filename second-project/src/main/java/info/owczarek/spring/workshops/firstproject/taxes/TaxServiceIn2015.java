package info.owczarek.spring.workshops.firstproject.taxes;

import info.owczarek.spring.workshops.firstproject.people.PersonsRepository;

public class TaxServiceIn2015 implements TaxService {
    private TaxOfficeClient taxOfficeClient;
    private PersonsRepository personsRepository;

    @Override
    public double getTax(long pesel) {
        return getPersonIncome(pesel) * getFlatTaxLevel();
    }

    private double getPersonIncome(long pesel) {
        return personsRepository.findOne(pesel).getIncome();
    }

    private double getFlatTaxLevel() {
        return taxOfficeClient.getFlatTaxLevel();
    }

    public PersonsRepository getPersonsRepository() {
        return personsRepository;
    }

    public void setPersonsRepository(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public TaxOfficeClient getTaxOfficeClient() {
        return taxOfficeClient;
    }

    public void setTaxOfficeClient(TaxOfficeClient taxOfficeClient) {
        this.taxOfficeClient = taxOfficeClient;
    }


}
