package info.owczarek.spring.workshops.firstproject.taxes;

public class TaxOfficeClient {
    private static TaxOfficeClient client;

    private TaxOfficeClient() {
    }

    public static TaxOfficeClient getInstance() {
        if (client == null) {
            client = new TaxOfficeClient();
        }
        return client;
    }

    public double getFlatTaxLevel() {
        return 0.19;
    }
}
