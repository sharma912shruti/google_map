package googlemap.com.googlemap;

import com.fretzealot.models.ArtistResponseModel;
import com.fretzealot.models.AutoSuggesionResponse;
import com.fretzealot.models.FullSearchResponse;
import com.fretzealot.models.LessonDataModel;
import com.fretzealot.models.NewChordsResponse;
import com.fretzealot.models.ProfileUpdateModel;
import com.fretzealot.models.SaveUserSettings;
import com.fretzealot.models.UserProfileModel;
import com.fretzealot.models.UserSettings;
import com.fretzealot.network.responseModels.BaseResponse;
import com.fretzealot.network.responseModels.ChordsResponse;
import com.fretzealot.network.responseModels.LoginResponse;
import com.fretzealot.network.responseModels.NotesResponse;
import com.fretzealot.network.responseModels.RatingResponse;
import com.fretzealot.network.responseModels.ScalesResponse;
import com.fretzealot.network.responseModels.SongsResponse;

import googlemap.com.googlemap.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by gchandra on 14/4/17.
 */
public interface ApiInterface {

    @POST("login/userLogin")
    Call<LoginResponse> login(@Header("Content-Type") String contentType, @Body String body);

}
