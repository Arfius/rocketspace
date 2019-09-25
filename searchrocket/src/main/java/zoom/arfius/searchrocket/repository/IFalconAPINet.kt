package zoom.arfius.searchrocket.repository

import io.reactivex.Flowable
import zoom.arfius.searchrocket.model.ApiClasses

interface IFalconAPINet {

    fun search(query:String): Flowable<List<ApiClasses.Rocket>>
    fun search(iService: IService, query:String)

}