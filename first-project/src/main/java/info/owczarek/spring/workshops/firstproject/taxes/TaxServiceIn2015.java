package info.owczarek.spring.workshops.firstproject.taxes;

import info.owczarek.spring.workshops.firstproject.people.PersonsRepository;

public class TaxServiceIn2015 implements TaxService {
    private double flatTaxLevel;
    private PersonsRepository personsRepository;

    @Override
    public double getTax(long pesel) {
        return getPersonIncome(pesel) * getFlatTaxLevel();
    }

    private double getPersonIncome(long pesel) {
        return personsRepository.findOne(pesel).getIncome();
    }

    public double getFlatTaxLevel() {
        return flatTaxLevel;
    }

    public void setFlatTaxLevel(double flatTaxLevel) {
        this.flatTaxLevel = flatTaxLevel;
    }

    public void setPersonsRepository(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }
}
