package customtype;

import domainobjects.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry) {
        return new BillingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("email"),
                entry.get("company"),
                entry.get("country"),
                entry.get("city"),
                entry.get("Addressone"),
                entry.get("zip"),
                entry.get("Phone"));
    }
}
