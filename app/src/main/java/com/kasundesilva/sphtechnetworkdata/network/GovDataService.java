package com.kasundesilva.sphtechnetworkdata.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GovDataService {

    String BASE_URL = "https://data.gov.sg/api/";

    @GET("action/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
    Call<UsageDataPojo> getUsageData();

}
