package zoom.arfius.rocketspace.repository

import io.reactivex.Flowable
import zoom.arfius.rocketspace.model.ApiClasses
import retrofit2.http.GET
import retrofit2.http.Query

interface FalconAPIService {

        @GET("/v3/launches")
        fun search(@Query("rocket_id") order: String): Flowable<List<ApiClasses.Rocket>>

}