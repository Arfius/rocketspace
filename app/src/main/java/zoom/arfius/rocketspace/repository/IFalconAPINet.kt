package zoom.arfius.rocketspace.repository

import io.reactivex.Flowable
import zoom.arfius.rocketspace.model.ApiClasses

interface IFalconAPINet {

    fun search(query:String): Flowable<List<ApiClasses.Rocket>>
    fun search(iService:IService,query:String)

}