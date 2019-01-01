package googlemap.com.googlemap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gchandra on 14/4/17.
 */
public class ApiClient {

//    private static final String BASE_URL = ServerConstants.LOCAL_URL;
//    private static final String BASE_URL = ServerConstants.PRODUCTION_URL;
    private static final String BASE_URL = ServerConstants.STAGING_URL;
    private static ApiInterface apiInterface;

    public static ApiInterface getApiInterface() {

        if (apiInterface == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

//            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .connectTimeout(70000, TimeUnit.MILLISECONDS)
//                    .writeTimeout(10000, TimeUnit.MILLISECONDS)
//                    .readTimeout(70000, TimeUnit.MILLISECONDS)
//                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
//                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
