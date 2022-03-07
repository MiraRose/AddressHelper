package AddressHelper;

import AddressHelper.Model.Address;
import com.google.common.net.UrlEscapers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AddressValidatorApi {

    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> retrieveResponse(Address address, String key) throws IOException, InterruptedException, URISyntaxException {

        String defaultCountryCode = "US";

        String url = "https://api.address-validator.net/api/verify?StreetAddress=" + address.getStreetAddress()
                + "&City=" + address.getCity()
                + "&PostalCode=" + address.getPostalCode()
                + "&CountryCode=" + defaultCountryCode
                + "&APIKey=" + key;

        String encodedUrlString = UrlEscapers.urlFragmentEscaper().escape(url);
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(encodedUrlString)).GET().build();
        return client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
