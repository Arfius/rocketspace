package zoom.arfius.searchrocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_search.*
import zoom.arfius.searchrocket.model.ApiClasses
import zoom.arfius.searchrocket.presenter.IMainPresenter
import zoom.arfius.searchrocket.presenter.MainPresenter

class Search : AppCompatActivity() , IMainPresenter {

    var presenterImplementation: MainPresenter? = null
    var mAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)


        recycleView.layoutManager= LinearLayoutManager(this) as RecyclerView.LayoutManager?

        recycleView.setHasFixedSize(true)
        recycleView.setItemAnimator(DefaultItemAnimator())
        recycleView.setFitsSystemWindows(true)

        presenterImplementation = MainPresenter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchView = menu?.findItem(R.id.app_bar_search)?.actionView as SearchView


        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    if (query.isNotEmpty()) {
                        presenterImplementation!!.getRocketList(query)
                        spinner.visibility = View.VISIBLE
                    }
                }
                return false
            }



        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun showSpinner() {
        recycleView.setVisibility(View.GONE)
        spinner.visibility = View.VISIBLE
        textSpinner.visibility = View.GONE

    }

    override fun hideSpinner() {
        recycleView.setVisibility(View.VISIBLE)
        spinner.visibility = View.GONE
        textSpinner.visibility = View.GONE
    }

    override fun hideSpinnerWithError(Error: String) {
        recycleView.setVisibility(View.GONE)
        spinner.visibility = View.GONE
        textSpinner.text=Error
        textSpinner.visibility = View.VISIBLE
    }

    override fun updateAdapter(list: List<ApiClasses.Rocket>) {
        mAdapter = MainAdapter(list)
        recycleView.setAdapter(mAdapter);
    }
}
