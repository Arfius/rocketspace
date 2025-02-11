package zoom.arfius.searchrocket.repository

import io.reactivex.Flowable
import zoom.arfius.searchrocket.model.ApiClasses
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import org.reactivestreams.Subscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



object FalconAPINet: IFalconAPINet {


    private val base_url = "https://api.spacexdata.com"


    val rf = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .build()

    private var falconAPI = rf.create(FalconAPIService::class.java)


    override
    fun search(query:String): Flowable<List<ApiClasses.Rocket>> = falconAPI.search(query)

    override
    fun search(iService: IService, query:String) {
        search(query).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            iService.onSuccess(it)
                        },
                        {
                            iService.onError(it.localizedMessage)
                        })
    }
}